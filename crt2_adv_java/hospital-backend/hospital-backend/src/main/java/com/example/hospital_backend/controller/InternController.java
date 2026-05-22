package com.example.hospital_backend.controller;

import com.example.hospital_backend.entity.Intern;
import com.example.hospital_backend.service.InternService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/interns")
public class InternController {

    private final InternService internService;

    public InternController(InternService internService) {
        this.internService = internService;
    }

    @PostMapping
    public Intern createIntern(@RequestBody Intern intern) {
        return internService.saveIntern(intern);
    }

    @GetMapping
    public List<Intern> getAllInterns() {
        return internService.getAllInterns();
    }

    @GetMapping("/{id}")
    public Intern getInternById(@PathVariable int id) {
        return internService.getInternById(id);
    }

    @PutMapping("/{id}")
    public Intern updateIntern(@PathVariable int id, @RequestBody Intern intern) {
        return internService.updateIntern(id, intern);
    }

    @DeleteMapping("/{id}")
    public String deleteIntern(@PathVariable int id) {
        internService.deleteIntern(id);
        return "Intern deleted successfully";
    }
}