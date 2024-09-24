package com.example.college_backend.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "college")
public class College {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String courseName;
    private String durationOfCourse;

    @Enumerated(EnumType.STRING)
    private AccommodationType accommodation;

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

    public AccommodationType getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(AccommodationType accommodation) {
        this.accommodation = accommodation;
    }

    public String getAccommodationFee() {
        return accommodationFee;
    }

    public void setAccommodationFee(String accommodationFee) {
        this.accommodationFee = accommodationFee;
    }

    public List<CourseFee> getCourseFees() {
        return courseFees;
    }

    public void setCourseFees(List<CourseFee> courseFees) {
        this.courseFees = courseFees;
    }
}

enum AccommodationType {
    AC, NON_AC
}
}
