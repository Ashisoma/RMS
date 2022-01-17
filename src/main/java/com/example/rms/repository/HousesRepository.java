package com.example.rms.repository;

import com.example.rms.domain.Admin;
import com.example.rms.domain.Houses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface HousesRepository extends JpaRepository<Houses, Long> {


    @Query("select h from Houses h where h.rent <= ?1")
    List<Houses> searchQueryByRent(Float rent);

    @Query("select h from Houses h where h.isOccupied = true")
    List<Houses> findAllOccupiedHouses();

    @Query("select h from Houses h where h.isOccupied = false")
    List<Houses> findTheVacantHouses();

}