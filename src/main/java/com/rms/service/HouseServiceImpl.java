package com.rms.service;

import com.rms.domain.House;
import com.rms.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    HouseRepository houseRepository;
    @Override
    public House createHouse(House house) {
        return houseRepository.save(house);
    }

    @Override
    public Page<House> getHouses(Optional<Integer> page, Optional<String> sortBy) {
        return houseRepository.findAll(
                PageRequest.of(
                        page.orElse(0),
                        1,
                        Sort.Direction.ASC,sortBy.orElse("id")
                )
        );
    }

    @Override
    public House getHouseDetails(Long id) {
        return houseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("House", "id", id));
    }

    @Override
    public void deleteHouse(Long id) {
        houseRepository.deleteById(id);
    }
    //all implementation business logic
}
