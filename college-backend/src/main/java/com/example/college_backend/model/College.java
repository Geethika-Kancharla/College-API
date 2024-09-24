package com.example.college_backend.model;

import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "college")
public class College {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String courseName;
    private String durationOfCourse;

    private String accommodation;

    private String accommodationFee;

    // Relationship to map the course fee (OneToMany relationship)
    @OneToMany(mappedBy = "college", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CourseFee> courseFees;

    // Getters and Setters
    public Long getId() {
        return id;
    }



    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDurationOfCourse() {
        return durationOfCourse;
    }

    public void setDurationOfCourse(String durationOfCourse) {
        this.durationOfCourse = durationOfCourse;
    }



    public String getAccommodation() {
        return durationOfCourse;
    }

    public void setAccommodation(String durationOfCourse) {
        this.durationOfCourse = durationOfCourse;
    }




    public String getAccommodationFee() {
        return accommodationFee;
    }


    public College() {
    }

    public void setAccommodationFee(String accommodationFee) {
        this.accommodationFee = accommodationFee;
    }

    public College(Long id, String name, String courseName, String durationOfCourse, String accommodation, String accommodationFee, List<CourseFee> courseFees) {
        this.id = id;
        this.name = name;
        this.courseName = courseName;
        this.durationOfCourse = durationOfCourse;
        this.accommodation = accommodation;
        this.accommodationFee = accommodationFee;
        this.courseFees = courseFees;
    }

    public List<CourseFee> getCourseFees() {
        return courseFees;
    }

    public void setCourseFees(List<CourseFee> courseFees) {
        this.courseFees = courseFees;
    }
}

