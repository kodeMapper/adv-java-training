package com.example.hospital_backend.service.impl;

import com.example.hospital_backend.entity.MedicalCase;
import com.example.hospital_backend.repository.MedicalCaseRepository;
import com.example.hospital_backend.service.MedicalCaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalCaseServiceImpl implements MedicalCaseService {

    private final MedicalCaseRepository medicalCaseRepository;

    public MedicalCaseServiceImpl(MedicalCaseRepository medicalCaseRepository) {
        this.medicalCaseRepository = medicalCaseRepository;
    }

    @Override
    public MedicalCase saveCase(MedicalCase medicalCase) {
        return medicalCaseRepository.save(medicalCase);
    }

    @Override
    public List<MedicalCase> getAllCases() {
        return medicalCaseRepository.findAll();
    }

    @Override
    public MedicalCase getCaseById(int id) {
        return medicalCaseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Case not found with id: " + id));
    }

    @Override
    public MedicalCase updateCase(int id, MedicalCase medicalCase) {
        MedicalCase existing = getCaseById(id);
        existing.setStatus(medicalCase.getStatus());
        return medicalCaseRepository.save(existing);
    }

    @Override
    public void deleteCase(int id) {
        medicalCaseRepository.deleteById(id);
    }
}