package com.example.rms.repository;

import com.example.rms.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    @Query("SELECT a FROM Admin a WHERE a.email=?1" )
    Optional<Admin> findByEmail(String email);

    @Query("SELECT a FROM Admin a WHERE a.nationalId=?1" )
    Optional<Admin> findByNationalId(Integer nationalId);


}