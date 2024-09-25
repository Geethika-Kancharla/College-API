package com.example.college_backend.service;

import com.example.college_backend.model.College;
import com.example.college_backend.model.CourseFee;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface CollegeService {

    List<College> findAllColleges();
    void saveCollegeWithFees(College college, CourseFee courseFee);
}
