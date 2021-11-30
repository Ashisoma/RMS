package com.example.rms.repository;

import com.example.rms.domain.Admin;
import com.example.rms.domain.Houses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface HousesRepository extends JpaRepository<Houses, Long> {
    @Query("SELECT * FROM Houses WHERE isOccupied=false" )
    List<Houses> findTheVacantHouses();

    @Query("SELECT * FROM Houses WHERE isOccupied=true" )
    List<Houses> findTheOccupiedHouses();

    @Query("SELECT * FROM Houses WHERE rent=?" )
    List<Houses> searchQueryByRent(String rent);
}