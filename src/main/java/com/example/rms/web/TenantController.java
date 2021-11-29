package com.example.rms.web;

import com.example.rms.domain.Tenants;
import com.example.rms.services.TenantsService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/tenant")
public class TenantController {

    private final TenantsService service;

    public TenantController(TenantsService service) {
        this.service = service;
    }

    @GetMapping
    public List<Tenants> getAllAdmins(){
        return service.getAll();
    }

    @GetMapping(path = "/getById{id}")
    public Optional<Tenants> getTenantById(Long id){
        return  service.getTenantById(id);
    }

    @PostMapping(path = "/registerTenant")
    public void addNewTenant(@RequestBody Tenants tenants){
        service.addNewTenant(tenants);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteTenant(@PathVariable("id") Long id){
        service.deleteTenantById(id);
    }

    @PutMapping(path = "/updateTenant/{id}")
    public void updateTenant(
            @PathVariable("id") Long id,
            @RequestParam String f_name,
            @RequestParam String l_name,
            @RequestParam  Integer phone_number,
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam LocalDate signUpDate,
            @RequestParam int emailConfirmed,
            @RequestParam String gender){
        service.updateTenant(id,f_name,l_name,phone_number,email,password,signUpDate,emailConfirmed,gender);
    }

}
