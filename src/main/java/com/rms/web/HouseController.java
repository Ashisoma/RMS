package com.rms.web;


import com.rms.domain.House;
import com.rms.service.HouseService;
import com.rms.service.HouseServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(path = "/houses", produces = MediaType.APPLICATION_JSON_VALUE)
public class HouseController {
    private final HouseService houseService;

    public HouseController(HouseServiceImpl houseService) {
        this.houseService = houseService;
    }
    @GetMapping
    Page<House> getHouses(Optional<Integer> page, Optional<String> sortBy){
        return  houseService.getHouses(page, sortBy);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    House createHouse(@Valid @RequestBody House house) {
        return houseService.createHouse(house);
    }

    @GetMapping("{id}")
    House getHouseDetails(@PathVariable("id") final Long id) {
        return houseService.getHouseDetails(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    void deleteHouse(@PathVariable("id") final Long id) {
        houseService.deleteHouse(id);
    }
}
