package com.example.hospital_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "medical_case")
@Data
public class MedicalCase {

    @Id
    @Column(name = "case_id")
    private int caseId;

    @Column(name = "status", nullable = false)
    private String status;
}