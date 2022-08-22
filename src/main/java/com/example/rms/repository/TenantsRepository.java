package com.example.rms.repository;

import com.example.rms.entity.Tenants;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TenantsRepository extends JpaRepository<Tenants, Long> {

    // find by id
    // count

}