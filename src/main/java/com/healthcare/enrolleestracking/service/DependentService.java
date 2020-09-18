package com.healthcare.enrolleestracking.service;

import com.healthcare.enrolleestracking.model.Dependent;
import com.healthcare.enrolleestracking.model.Enrollee;

import java.util.List;

public interface DependentService {

    public Enrollee add(Long enrolleId, List<Dependent> dependentList);

    public Dependent update(Long id, Dependent dependent);

    public void delete(Long enrolleId, Long dependentId);
}
