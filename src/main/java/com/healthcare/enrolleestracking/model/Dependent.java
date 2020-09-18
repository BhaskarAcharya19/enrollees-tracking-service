package com.healthcare.enrolleestracking.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Optional;

@Table
@Entity(name = "Dependent")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Dependent implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate dateOfBirth;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Enrollee enrollee;

    public Optional<Dependent> replace(Dependent nextDependent){
        return Optional.ofNullable(nextDependent)
                .map(dependent -> {
                    this.name=dependent.name;
                    this.dateOfBirth=dependent.dateOfBirth;
                    this.enrollee=dependent.enrollee;
                    return this;
                });
    }
}
