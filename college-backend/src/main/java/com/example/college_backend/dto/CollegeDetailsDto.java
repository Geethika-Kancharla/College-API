package com.example.college_backend.dto;

public class CollegeDetailsDto {

    private String collegeName;
    private String courseName;
    private String courseFees;  // Changed to String
    private String durationOfCourse;
    private String accommodation;
    private String accommodationFee;

    // Getters and Setters
    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseFees() {  // Now returns String
        return courseFees;
    }

    public void setCourseFees(String courseFees) {  // Now accepts String
        this.courseFees = courseFees;
    }

    public String getDurationOfCourse() {
        return durationOfCourse;
    }

    public void setDurationOfCourse(String durationOfCourse) {
        this.durationOfCourse = durationOfCourse;
    }

    public String getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(String accommodation) {
        this.accommodation = accommodation;
    }

    public String getAccommodationFee() {
        return accommodationFee;
    }

    public void setAccommodationFee(String accommodationFee) {
        this.accommodationFee = accommodationFee;
    }
}
