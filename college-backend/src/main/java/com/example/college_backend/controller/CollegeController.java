package com.example.college_backend.controller;

import com.example.college_backend.model.College;
import com.example.college_backend.model.CourseFee;
import com.example.college_backend.service.CollegeService;
import com.example.college_backend.dto.CollegeDetailsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Controller
@CrossOrigin(origins = "http://localhost:3000")
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

        // Convert the single course fee in DTO to a CourseFee entity
        CourseFee courseFee = new CourseFee(collegeDetailsDTO.getCourseFees(), college);

        // Save the College and CourseFee
        collegeService.saveCollegeWithFees(college, courseFee);

        return ResponseEntity.ok("College and associated course fee created successfully.");
    }


    @GetMapping("/details")
    public ResponseEntity<List<CollegeDetailsDto>> getAllColleges() {
        // Fetch all colleges
        List<College> colleges = collegeService.findAllColleges();

        // Convert list of College entities to list of CollegeDetailsDto
        List<CollegeDetailsDto> collegeDetailsDtos = colleges.stream().map(college -> {
            CollegeDetailsDto collegeDetailsDto = new CollegeDetailsDto();
            collegeDetailsDto.setCollegeName(college.getName());
            collegeDetailsDto.setCourseName(college.getCourseName());
            collegeDetailsDto.setDurationOfCourse(college.getDurationOfCourse());
            collegeDetailsDto.setAccommodation(college.getAccommodation());
            collegeDetailsDto.setAccommodationFee(college.getAccommodationFee());

            // Map CourseFee to the DTO (assuming only one fee per college)
            if (!college.getCourseFees().isEmpty()) {
                String courseFee = college.getCourseFees().get(0).getFee();  // Get the single fee
                collegeDetailsDto.setCourseFees(courseFee);
            }

            return collegeDetailsDto;
        }).collect(Collectors.toList());

        // Return the list of CollegeDetailsDto
        return new ResponseEntity<>(collegeDetailsDtos, HttpStatus.OK);
    }








}
