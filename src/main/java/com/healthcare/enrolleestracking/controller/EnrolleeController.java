package com.healthcare.enrolleestracking.controller;

import com.healthcare.enrolleestracking.model.Enrollee;
import com.healthcare.enrolleestracking.service.EnrolleeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static com.healthcare.enrolleestracking.util.EnrollmentUtils.BASE_PATH_V1;

@RestController
@Slf4j
@RequestMapping(BASE_PATH_V1 + "/enrollee")
@RequiredArgsConstructor
public class EnrolleeController {

    @Autowired
    private final EnrolleeService enrolleeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Enrollee addEnrollee(@RequestBody Enrollee enrollee) {
        log.info("EnrolleeController::addEnrollee");

        return enrolleeService.save(enrollee);
    }

    @GetMapping("/{id}")
    public Enrollee getEnrollee(@PathVariable Long id) {
        log.info("EnrolleeController::getEnrollee id={}", id);

        return enrolleeService.get(id);
    }

    @PutMapping("/{id}")
    public Enrollee modifyEnrollee(@PathVariable Long id, @RequestBody Enrollee enrollee) {
        log.info("EnrolleeController::modifyEnrollee id={}", id);

        return enrolleeService.update(id, enrollee);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeEnrolle(@PathVariable Long id) {
        log.info("EnrolleeController::removeEnrolle id={}", id);

        enrolleeService.delete(id);
    }
}
