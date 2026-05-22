package com.example.hospital_backend.controller;

import com.example.hospital_backend.entity.MedicalCase;
import com.example.hospital_backend.service.MedicalCaseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medical-cases")
public class MedicalCaseController {

    private final MedicalCaseService medicalCaseService;

    public MedicalCaseController(MedicalCaseService medicalCaseService) {
        this.medicalCaseService = medicalCaseService;
    }

    @PostMapping
    public MedicalCase createCase(@RequestBody MedicalCase medicalCase) {
        return medicalCaseService.saveCase(medicalCase);
    }

    @GetMapping
    public List<MedicalCase> getAllCases() {
        return medicalCaseService.getAllCases();
    }

    @GetMapping("/{id}")
    public MedicalCase getCaseById(@PathVariable int id) {
        return medicalCaseService.getCaseById(id);
    }

    @PutMapping("/{id}")
    public MedicalCase updateCase(@PathVariable int id, @RequestBody MedicalCase medicalCase) {
        return medicalCaseService.updateCase(id, medicalCase);
    }

    @DeleteMapping("/{id}")
    public String deleteCase(@PathVariable int id) {
        medicalCaseService.deleteCase(id);
        return "Case deleted successfully";
    }
}