package com.example.hospital_backend.service;

import com.example.hospital_backend.entity.MedicalCase;
import java.util.List;

public interface MedicalCaseService {
    MedicalCase saveCase(MedicalCase medicalCase);
    List<MedicalCase> getAllCases();
    MedicalCase getCaseById(int id);
    MedicalCase updateCase(int id, MedicalCase medicalCase);
    void deleteCase(int id);
}