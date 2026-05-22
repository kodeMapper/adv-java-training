package com.example.hospital_backend.service;

import com.example.hospital_backend.entity.Doctor;
import java.util.List;

public interface DoctorService {
    Doctor saveDoctor(Doctor doctor);
    List<Doctor> getAllDoctors();
    Doctor getDoctorById(int id);
    Doctor updateDoctor(int id, Doctor doctor);
    void deleteDoctor(int id);
}