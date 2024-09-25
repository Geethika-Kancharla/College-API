package com.example.college_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "course_fee")
public class CourseFee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fee;  // Changed to String

    // Many-to-one relationship with the College entity
    @ManyToOne
    @JoinColumn(name = "college_id", nullable = false)
    private College college;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public CourseFee() {
    }

    public CourseFee(String fee, College college) {  // Now takes String fee
        this.fee = fee;
        this.college = college;
    }

    public CourseFee(Long id, String fee, College college) {  // Updated constructor
        this.id = id;
        this.fee = fee;
        this.college = college;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFee() {  // Returns String
        return fee;
    }

    public void setFee(String fee) {  // Accepts String
        this.fee = fee;
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }
}
