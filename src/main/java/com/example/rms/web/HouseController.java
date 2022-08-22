package com.example.rms.web;

import com.example.rms.entity.Houses;
import com.example.rms.services.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/rms/house")
public class HouseController {

    @Autowired
    private final HouseService service;

    public HouseController(HouseService service) {
        this.service = service;
    }

    @GetMapping
    public List<Houses> getAllHouses(){
        return service.getAllHouses();
    }

    @GetMapping(path = "/{id}")
    public Optional<Houses> getHouseById(@PathVariable("id") Long id){
        return service.findHouseById(id);
    }

    // this one might not work we'd have to turn the query from string to integer or float
    @GetMapping(path = "/rent/{rent}")
    public List<Houses> findByRent(@PathVariable("rent") Float rent){
        return service.findQueryRent(rent);
    }

    @GetMapping(path = "/vacant")
    public List<Houses> getVacant(){
        return service.getAllVacantHouses();
    }
    @GetMapping(path = "/occupied")
    public List<Houses> getOccupied(){
        return service.getTheOccupiedHouses();
    }

    // POST
    @PostMapping(path = "/add")
    public void addAHouse(@RequestBody Houses house){
        service.addAHouse(house);
    }

    //PUT
    @PutMapping(path = "/put/{id}")
    public  void editAHouse(@PathVariable("id") Long id,
                            @RequestParam (required = false)String houseNumber,
                            @RequestParam (required = false)String features,
                            @RequestParam (required = false)Float rent,
                            @RequestParam (required = false)boolean isOccupied){
        service.updateHouse(id,houseNumber,features,rent,isOccupied);
    }

    // RELATIONSHIPS
    @PutMapping(path = "/enrollAdmin/{adminId}/houses/{houseId}")
    public Houses addAdminToHouse(@PathVariable("adminId")Long adminId,
                                                        @PathVariable("houseId")Long houseId){
        Houses house = service.findHouseById(houseId).get();
        service.assignHouseToAdmin(adminId,houseId);
        return service.addAHouse(house);

    }

    @PutMapping(path = "/enrollTenant/{tenantId}/houses/{houseId}")
    public Houses addTenantToHouse(@PathVariable("tenantId")Long tenantId,
                                  @PathVariable("houseId")Long houseId){
        Houses house = service.findHouseById(houseId).get();
        service.assignHouseToTenant(tenantId,houseId);
        return service.addAHouse(house);

    }
}
