package com.example.rms.services;

import com.example.rms.domain.Houses;
import com.example.rms.repository.HousesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class HouseService {

    @Autowired
    private final HousesRepository housesRepository;

    public HouseService(HousesRepository housesRepository) {
        this.housesRepository = housesRepository;
    }

    // GET FUNCTIONS
    // GET ALL HOUSES DATA
    public List<Houses> getAllHouses(){
        return housesRepository.findAll();
    }
        // BY ID
    public Optional<Houses> findHouseById(Long id){
        return housesRepository.findById(id);
    }
        // BY RENT
    public List<Houses> findQueryRent(String rent){
        return housesRepository.searchQueryByRent(rent);
    }
    //TODO SORT BY RENT
        // GET VACANT HOUSES
        public List<Houses> getAllVacantHouses(){
        return  housesRepository.findTheVacantHouses();
        }
        // GET TAKEN HOUSES
        public List<Houses> getTheOccupiedHouses(){
            return  housesRepository.findTheOccupiedHouses();
        }
      //POST FUNCTIONS
      // ADD A HOUSE
    public  void  addAHouse(Houses houses){
        housesRepository.save(houses);
    }

      // UPDATE A HOUSE
      public void updateHouse(Long id, String houseNumber, String features, Float rent, boolean isOccupied) {
          Houses house = housesRepository.findById(id).orElseThrow(() ->
                  new IllegalStateException("Student with id :" + id + "does not exist"));
          if (houseNumber != null && houseNumber.length() > 0 && !Objects.equals(house.getHouseNumber(), houseNumber)) {
              house.setHouseNumber(houseNumber);
          }
          if (features != null && features.length() > 0 && !Objects.equals(house.getFeatures(), features)) {
              house.setFeatures(features);
          }
          if (rent != null && rent>0 && !Objects.equals(house.getRent(),rent))
          {
              house.setRent(rent);
          }
          if ( !Objects.equals(house.isOccupied(),isOccupied))
          {
              house.setOccupied(isOccupied);
          }
      }
}
