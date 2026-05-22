package com.example.hospital_backend.service.impl;

import com.example.hospital_backend.entity.Intern;
import com.example.hospital_backend.repository.InternRepository;
import com.example.hospital_backend.service.InternService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InternServiceImpl implements InternService {

    private final InternRepository internRepository;

    public InternServiceImpl(InternRepository internRepository) {
        this.internRepository = internRepository;
    }

    @Override
    public Intern saveIntern(Intern intern) {
        return internRepository.save(intern);
    }

    @Override
    public List<Intern> getAllInterns() {
        return internRepository.findAll();
    }

    @Override
    public Intern getInternById(int id) {
        return internRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Intern not found with id: " + id));
    }

    @Override
    public Intern updateIntern(int id, Intern intern) {
        Intern existing = getInternById(id);
        existing.setName(intern.getName());
        existing.setDepartment(intern.getDepartment());
        existing.setSpecialization(intern.getSpecialization());
        existing.setDuration(intern.getDuration());
        return internRepository.save(existing);
    }

    @Override
    public void deleteIntern(int id) {
        internRepository.deleteById(id);
    }
}