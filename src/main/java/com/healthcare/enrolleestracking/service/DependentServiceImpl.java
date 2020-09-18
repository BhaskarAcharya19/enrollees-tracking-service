package com.healthcare.enrolleestracking.service;

import com.healthcare.enrolleestracking.model.Dependent;
import com.healthcare.enrolleestracking.model.Enrollee;
import com.healthcare.enrolleestracking.repository.DependentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.healthcare.enrolleestracking.util.EnrollmentUtils.NOT_FOUND_EXCEPTION_FX;
import static com.healthcare.enrolleestracking.util.EnrollmentUtils.RESOURCE_DEPENDENT;

@Service
@Slf4j
@RequiredArgsConstructor
public class DependentServiceImpl implements DependentService{
    private final EnrolleeService enrolleeService;
    private final DependentRepository dependentRepository;

    public Enrollee add(Long enrolleId, List<Dependent> dependentList){
        Enrollee enrollee = enrolleeService.get(enrolleId);
        List<Dependent> dependents = new ArrayList<>();
        enrollee.addDependent(dependentList);
        for (Dependent dependent : dependentList){
            dependent.setEnrollee(enrollee);
            dependents.add(dependent);
        }
        dependentRepository.saveAll(dependents);
        log.debug("Added dependents with enrolledId={}", enrolleId);
        return enrollee;
    }
    public Dependent update(Long id, Dependent dependent) {
        Dependent dbDependent = dependentRepository.findById(id)
                .orElseThrow(() -> NOT_FOUND_EXCEPTION_FX.apply(RESOURCE_DEPENDENT, id));

        dbDependent.replace(dependent);
        log.debug("Updating dependent with id={}", id);

        return dependentRepository.save(dbDependent);
    }

    public void delete(Long enrolleId, Long dependentId) {
        Enrollee enrollee = enrolleeService.get(enrolleId);

        Dependent dependent = enrollee.getDependentList()
                .stream()
                .filter(dep -> dep.getId().equals(dependentId))
                .findFirst()
                .orElseThrow(() -> NOT_FOUND_EXCEPTION_FX.apply(RESOURCE_DEPENDENT, dependentId));

        enrollee.removeDependent(dependent);
        enrolleeService.save(enrollee);
        log.debug("Deleted dependent with id={}", dependentId);
    }
}
