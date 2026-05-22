package com.example.hospital_backend.repository;

import com.example.hospital_backend.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff, Integer> {
}