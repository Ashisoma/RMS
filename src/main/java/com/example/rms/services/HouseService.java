package com.example.rms.services;

import com.example.rms.repository.HousesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HouseService {

    @Autowired
    private final HousesRepository housesRepository;

    public HouseService(HousesRepository housesRepository) {
        this.housesRepository = housesRepository;
    }

    // GET FUNCTIONS
        // BY ID
        // BY RENT
        // GET VACANT HOUSES
        // GET TAKEN HOUSES

    //POST FUNCTIONS
      // ADD A HOUSE

      // UPDATE A HOUSE
}
