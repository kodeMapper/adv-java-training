package com.example.hospital_backend.service.impl;

import com.example.hospital_backend.entity.Doctor;
import com.example.hospital_backend.repository.DoctorRepository;
import com.example.hospital_backend.service.DoctorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor getDoctorById(int id) {
        return doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found with id: " + id));
    }

    @Override
    public Doctor updateDoctor(int id, Doctor doctor) {
        Doctor existing = getDoctorById(id);
        existing.setName(doctor.getName());
        existing.setDepartment(doctor.getDepartment());
        existing.setSpecialization(doctor.getSpecialization());
        return doctorRepository.save(existing);
    }

    @Override
    public void deleteDoctor(int id) {
        doctorRepository.deleteById(id);
    }
}