package com.rms.service;

import javax.validation.Valid;
import com.rms.entity.House;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

public interface HouseService {
    House createHouse(@Valid @RequestBody House house);

    Page<House> getHouses(Optional<Integer> page, Optional<String> sortBy);

    House getHouseDetails(@PathVariable("id") final Long id);

    void deleteHouse(@PathVariable("id") final Long id);
}
