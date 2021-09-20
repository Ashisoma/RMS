package com.example.ashisoma.repository;

import com.example.ashisoma.domain.Tenants;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TenantsRepository extends JpaRepository<Tenants, Long> {

    // find by id
    // count

}