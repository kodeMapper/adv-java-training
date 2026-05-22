package com.example.hospital_backend.service;

import com.example.hospital_backend.entity.Patient;

import java.util.List;

public interface PatientService {
    Patient savePatient(Patient patient);
    List<Patient> getAllPatients();
    Patient getPatientById(int id);
    Patient updatePatient(int id, Patient patient);
    void deletePatient(int id);
}