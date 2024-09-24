package com.example.college_backend.repo;

import com.example.college_backend.model.CourseFee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseFeeRepository extends JpaRepository<CourseFee,Long> {
}
