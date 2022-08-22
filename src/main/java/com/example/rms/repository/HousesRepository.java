package com.example.rms.repository;

import com.example.rms.entity.Houses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HousesRepository extends JpaRepository<Houses, Long> {
}