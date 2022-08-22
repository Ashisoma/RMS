package com.example.rms.services;

import com.example.rms.entity.Admin;
import com.example.rms.entity.Houses;
import com.example.rms.entity.Tenants;
import com.example.rms.repository.AdminRepository;
import com.example.rms.repository.HousesRepository;
import com.example.rms.repository.TenantsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class HouseService {

    @Autowired
    private final HousesRepository housesRepository;
    private final AdminRepository adminRepository;
    private final TenantsRepository tenantsRepository;

    public HouseService(HousesRepository housesRepository, AdminRepository adminRepository, TenantsRepository tenantsRepository) {
        this.housesRepository = housesRepository;
        this.adminRepository = adminRepository;
        this.tenantsRepository = tenantsRepository;
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
    public List<Houses> findQueryRent(Float rent){
        return housesRepository.searchQueryByRent(rent);
    }
    //TODO SORT BY RENT
        // GET VACANT HOUSES
        public List<Houses> getAllVacantHouses(){
        return  housesRepository.findTheVacantHouses();
        }
        // GET TAKEN HOUSES
        public List<Houses> getTheOccupiedHouses(){
            return  housesRepository.findAllOccupiedHouses();
        }
      //POST FUNCTIONS
      // ADD A HOUSE
    public Houses addAHouse(Houses houses){
        return housesRepository.save(houses);
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


    @Transactional
    public void assignHouseToAdmin(Long aminId, Long houseId){
        Houses house = housesRepository.findById(houseId).get();
        Admin admin = adminRepository.findById(aminId).get();
        boolean adminExists = adminRepository.existsById(aminId);
        boolean houseExists = housesRepository.existsById(houseId);
        if (!adminExists && !houseExists){
            throw  new IllegalStateException("Admin with id :"+ aminId +" and house id:"+ houseId +" cant be enrolled. Error enrolling admin");
        }else {
            house.enrollAdmin(admin);
        }
    }

    @Transactional
    public void assignHouseToTenant(Long tenantId, Long houseId){
        Houses house = housesRepository.findById(houseId).get();
        Tenants tenant = tenantsRepository.findById(tenantId).get();
        boolean tenantExists = tenantsRepository.existsById(tenantId);
        boolean houseExists = housesRepository.existsById(houseId);
        if (!tenantExists && !houseExists){
            throw  new IllegalStateException("Tenant with id :"+ tenantId +" and house id:"+ houseId +" cant be enrolled. Error enrolling admin");
        }else {
            house.addTenant(tenant);
        }
    }
}
