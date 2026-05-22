package com.example.hospital_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "staff")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public abstract class Staff {

    @Id
    @Column(name = "staff_id")
    protected int id;

    @Column(name = "name", nullable = false)
    protected String name;

    @Column(name = "department", nullable = false)
    protected String department;
}