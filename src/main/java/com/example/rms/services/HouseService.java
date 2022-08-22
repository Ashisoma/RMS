package com.example.rms.services;

import com.example.rms.entity.Houses;
import com.example.rms.repository.HousesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HouseService {

    @Autowired
    private final HousesRepository housesRepository;

    public HouseService(HousesRepository housesRepository) {
        this.housesRepository = housesRepository;
    }

    // GET FUNCTIONS
        // BY ID
    public Optional<Houses> findAdminById(Long id){
        return housesRepository.findById(id);
    }
        // BY RENT

        // GET VACANT HOUSES
        // GET TAKEN HOUSES

    //POST FUNCTIONS
      // ADD A HOUSE

      // UPDATE A HOUSE
}
