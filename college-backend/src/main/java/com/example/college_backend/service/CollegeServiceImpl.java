package com.example.college_backend.service;

import com.example.college_backend.model.College;
import com.example.college_backend.model.CourseFee;
import com.example.college_backend.repo.CollegeRepository;
import com.example.college_backend.repo.CourseFeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeServiceImpl implements CollegeService{
    @Autowired
    private CollegeRepository collegeRepository;

    @Autowired
    private CourseFeeRepository courseFeeRepository;

    @Override
    public List<College> findAllColleges() {
        return collegeRepository.findAll();
    }

    public void saveCollegeWithFees(College college, CourseFee courseFee) {
        // Save the college
        College savedCollege = collegeRepository.save(college);

        // Set the associated college for the course fee
        courseFee.setCollege(savedCollege);

        // Save the course fee
        courseFeeRepository.save(courseFee);
    }
}