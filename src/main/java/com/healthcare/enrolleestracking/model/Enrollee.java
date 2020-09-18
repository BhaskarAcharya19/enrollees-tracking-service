package com.healthcare.enrolleestracking.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Enrollee")
@Table
public class Enrollee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    private Boolean activationStatus;

    @NotNull
    private LocalDate dateOfBirth;

    private String phoneNumber;

    @OneToMany(
            mappedBy = "enrollee",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Dependent> dependentList = new ArrayList<>();

    public Optional<Enrollee> replace(Enrollee nextEnrollee){
      return Optional.ofNullable(nextEnrollee)
             .map(enrollee -> {
                 this.name=enrollee.name;
                 this.dateOfBirth=enrollee.dateOfBirth;
                 this.activationStatus = enrollee.activationStatus;
                 this.phoneNumber = enrollee.phoneNumber;
                 this.dependentList.clear();
                 this.addDependent(enrollee.getDependentList());
                 return this;
             });
    }
    public void addDependent(List<Dependent>dependents){
        dependents.forEach(this::addDependent);
    }
    public void addDependent(Dependent dependent){
        Optional.ofNullable(dependent)
                .ifPresent(dependents->{
                    this.dependentList.add(dependents);
                });
    }
    public void removeDependent(Dependent dependent){
        Optional.ofNullable(dependent)
                .ifPresent(dependents->{
                    this.dependentList.remove(dependents);
                    dependents.setEnrollee(null);
                });
    }
}
