package com.example.hospital_backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "intern")
@Data
@EqualsAndHashCode(callSuper = true)
public class Intern extends Doctor {

    @Column(name = "duration_months", nullable = false)
    private int duration;
}