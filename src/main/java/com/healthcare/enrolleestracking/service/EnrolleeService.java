package com.healthcare.enrolleestracking.service;

import com.healthcare.enrolleestracking.model.Enrollee;

public interface EnrolleeService {
    public Enrollee get(Long id);
    public Enrollee save(Enrollee enrollee);
    public Enrollee update(Long id, Enrollee enrollee);
    public void delete(Long id);
}
