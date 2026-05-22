package com.example.hospital_backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "doctor")
@Data
@EqualsAndHashCode(callSuper = true)
public class Doctor extends Staff {

    @Column(name = "specialization", nullable = false)
    private String specialization;
}