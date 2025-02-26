package com.example.college_backend.controller;

import com.example.college_backend.model.College;
import com.example.college_backend.model.CourseFee;
import com.example.college_backend.service.CollegeService;
import com.example.college_backend.dto.CollegeDetailsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Collections;
import java.util.Map;

@RestController
@CrossOrigin(
    origins = {"https://college-api-theta.vercel.app/", "http://localhost:3000"},
    methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS},
    allowedHeaders = "*"
)
@RequestMapping("/api")
public class CollegeController {

    @Autowired
    private CollegeService collegeService;

    @PostMapping("/create")
    public ResponseEntity<?> createCollege(@RequestBody CollegeDetailsDto collegeDetailsDTO) {
        try {
            College college = new College();
            college.setName(collegeDetailsDTO.getCollegeName());
            college.setCourseName(collegeDetailsDTO.getCourseName());
            college.setDurationOfCourse(collegeDetailsDTO.getDurationOfCourse());
            college.setAccommodation(collegeDetailsDTO.getAccommodation());
            college.setAccommodationFee(collegeDetailsDTO.getAccommodationFee());

            CourseFee courseFee = new CourseFee(collegeDetailsDTO.getCourseFees(), college);
            collegeService.saveCollegeWithFees(college, courseFee);

            return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(Map.of("message", "College and associated course fee created successfully"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Map.of("error", e.getMessage()));
        }
    }

    @GetMapping("/details")
    public ResponseEntity<List<CollegeDetailsDto>> getAllColleges() {
        try {
            List<College> colleges = collegeService.findAllColleges();
            List<CollegeDetailsDto> collegeDetailsDtos = colleges.stream().map(college -> {
                CollegeDetailsDto dto = new CollegeDetailsDto();
                dto.setCollegeName(college.getName());
                dto.setCourseName(college.getCourseName());
                dto.setDurationOfCourse(college.getDurationOfCourse());
                dto.setAccommodation(college.getAccommodation());
                dto.setAccommodationFee(college.getAccommodationFee());

                if (!college.getCourseFees().isEmpty()) {
                    dto.setCourseFees(college.getCourseFees().get(0).getFee());
                }
                return dto;
            }).collect(Collectors.toList());

            return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(collegeDetailsDtos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Collections.emptyList());
        }
    }
}
