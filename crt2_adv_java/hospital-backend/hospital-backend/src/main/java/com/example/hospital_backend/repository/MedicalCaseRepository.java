package com.example.hospital_backend.repository;

import com.example.hospital_backend.entity.MedicalCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalCaseRepository extends JpaRepository<MedicalCase, Integer> {
}