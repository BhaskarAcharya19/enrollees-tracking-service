package com.healthcare.enrolleestracking.repository;

import com.healthcare.enrolleestracking.model.Enrollee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrolleeRepository extends JpaRepository<Enrollee, Long> {
}
