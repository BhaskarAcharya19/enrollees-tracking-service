package com.healthcare.enrolleestracking.repository;

import com.healthcare.enrolleestracking.model.Dependent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DependentRepository extends JpaRepository<Dependent, Long> {
}
