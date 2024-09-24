package com.example.college_backend.controller;

import com.example.college_backend.model.College;
import com.example.college_backend.model.CourseFee;
import com.example.college_backend.service.CollegeService;
import com.example.college_backend.dto.CollegeDetailsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Controller
public class CollegeController {

    @Autowired
    private CollegeService collegeService;


    @PostMapping("/create")
    public ResponseEntity<String> createCollege(@RequestBody CollegeDetailsDto collegeDetailsDTO) {
        // Map DTO to College entity
        College college = new College();
        college.setName(collegeDetailsDTO.getCollegeName());
        college.setCourseName(collegeDetailsDTO.getCourseName());
        college.setDurationOfCourse(collegeDetailsDTO.getDurationOfCourse());
        college.setAccommodation(collegeDetailsDTO.getAccommodation());
        college.setAccommodationFee(collegeDetailsDTO.getAccommodationFee());

        // Convert the list of fees in DTO to CourseFee entities
        List<CourseFee> courseFees = collegeDetailsDTO.getCourseFees()
                .stream()
                .map(fee -> new CourseFee(fee, college))
                .collect(Collectors.toList());

        // Save the College and CourseFees
        collegeService.saveCollegeWithFees(college, courseFees);

        return ResponseEntity.ok("College and associated course fees created successfully.");
    }






}
