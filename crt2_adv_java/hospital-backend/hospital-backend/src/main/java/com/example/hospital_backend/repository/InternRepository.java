package com.example.hospital_backend.repository;

import com.example.hospital_backend.entity.Intern;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InternRepository extends JpaRepository<Intern, Integer> {
}