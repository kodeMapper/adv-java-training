package com.example.hospital_backend.service;

import com.example.hospital_backend.entity.Intern;
import java.util.List;

public interface InternService {
    Intern saveIntern(Intern intern);
    List<Intern> getAllInterns();
    Intern getInternById(int id);
    Intern updateIntern(int id, Intern intern);
    void deleteIntern(int id);
}