package com.example.hospital_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "patient")
@Data
public class Patient {

    @Id
    @Column(name = "patient_id")
    private int patientId;

    @Column(name = "patient_name", nullable = false)
    private String patientName;

    @Column(name = "age", nullable = false)
    private int age;

    @ManyToOne
    @JoinColumn(name = "assigned_doctor_id")
    private Doctor assignedDoctor;

    @Column(name = "assigned_nurse")
    private String assignedNurse;

    @Column(name = "ward")
    private String ward;

    @Column(name = "bed_no")
    private int bedNo;

    @ElementCollection
    @CollectionTable(
            name = "patient_diseases",
            joinColumns = @JoinColumn(name = "patient_id")
    )
    @Column(name = "disease_name")
    private List<String> diseases = new ArrayList<>();
}