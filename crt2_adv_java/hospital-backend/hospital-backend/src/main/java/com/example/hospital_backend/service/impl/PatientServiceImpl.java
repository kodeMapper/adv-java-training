package com.example.hospital_backend.service.impl;

import com.example.hospital_backend.entity.Patient;
import com.example.hospital_backend.repository.PatientRepository;
import com.example.hospital_backend.service.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(int id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));
    }

    @Override
    public Patient updatePatient(int id, Patient patient) {
        Patient existing = getPatientById(id);

        existing.setPatientName(patient.getPatientName());
        existing.setAge(patient.getAge());
        existing.setAssignedDoctor(patient.getAssignedDoctor());
        existing.setAssignedNurse(patient.getAssignedNurse());
        existing.setWard(patient.getWard());
        existing.setBedNo(patient.getBedNo());
        existing.setDiseases(patient.getDiseases());

        return patientRepository.save(existing);
    }

    @Override
    public void deletePatient(int id) {
        patientRepository.deleteById(id);
    }
}