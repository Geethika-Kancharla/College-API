package com.example.college_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "course_fee")

public class CourseFee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double fee;

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

    public CourseFee(Double fee, College college) {
        this.fee = fee;
        this.college = college;
    }

    public CourseFee(Long id, Double fee, College college) {
        this.id = id;
        this.fee = fee;
        this.college = college;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }
}
