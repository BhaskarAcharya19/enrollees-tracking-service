package com.healthcare.enrolleestracking.controller;

import com.healthcare.enrolleestracking.model.Dependent;
import com.healthcare.enrolleestracking.model.Enrollee;
import com.healthcare.enrolleestracking.service.DependentService;
import com.healthcare.enrolleestracking.service.DependentServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.healthcare.enrolleestracking.util.EnrollmentUtils.BASE_PATH_V1;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(BASE_PATH_V1 + "/enrollee")
public class DependentController {

    @Autowired
    private final DependentService dependentService;


    @PostMapping("/{enrolleeId}/dependents")
    @ResponseStatus(HttpStatus.CREATED)
    public Enrollee addDependents(@PathVariable Long enrolleeId,
                                  @RequestBody List<Dependent> dependents) {
        log.info("DependentController::addDependents enrolleId={}", enrolleeId);

        return dependentService.add(enrolleeId, dependents);
    }

    @PutMapping("/{enrolleeId}/dependents/{dependentId}")
    public Dependent modifyDependent(@PathVariable("enrolleeId") Long enrolleeId,
                                     @PathVariable("dependentId") Long dependentId,
                                     @RequestBody Dependent dependent) {
        log.info("DependentController::modifyDependent enrolleeId={}, dependentId={}", enrolleeId, dependentId);

        return dependentService.update(dependentId, dependent);
    }

    @DeleteMapping("/{enrolleeId}/dependents/{dependentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeDependent(@PathVariable("enrolleeId") Long enrolleeId,
                                @PathVariable("dependentId") Long dependentId) {
        log.info("DependentController::removeDependent enrolleeId={}, dependentId={}", enrolleeId, dependentId);

        dependentService.delete(enrolleeId, dependentId);
    }
}
