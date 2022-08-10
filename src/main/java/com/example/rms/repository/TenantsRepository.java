package com.example.rms.repository;

import com.example.rms.domain.Tenants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TenantsRepository extends JpaRepository<Tenants, Long> {
    @Query("select t from Tenants t where upper(t.l_name) like upper(?1) and upper(t.l_name) like upper(?2)")
    List<Tenants> findByL_nameLikeIgnoreCaseAndL_nameLikeIgnoreCaseAllIgnoreCase(String l_name, String l_name1);

    // find by id
    // count

}