package com.example.rms.services;

import com.example.rms.domain.Admin;
import com.example.rms.domain.Houses;
import com.example.rms.domain.Tenants;
import com.example.rms.repository.TenantsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TenantsService {
    
    @Autowired
    private final TenantsRepository tenantsRepository;

    public TenantsService(TenantsRepository tenantsRepository) {
        this.tenantsRepository = tenantsRepository;
    }
    
    public List<Tenants> getAll(){
        return tenantsRepository.findAll();
    }

    public Optional<Tenants> findTenantById(Long id){
        return tenantsRepository.findById(id);
    }
    public void addNewTenant(Tenants tenants){
         Optional <Tenants>tenant = tenantsRepository.findById(tenants.getId());
        if (tenant.isPresent()){
            throw new IllegalStateException("The tenant already exists");
        }
        else {
            tenantsRepository.save(tenants);
        }
    }

    public void deleteTenantById(Long tenantId) {
        boolean exists = tenantsRepository.existsById(tenantId);
        if (!exists){
            throw new IllegalStateException("Student id: " + tenantId + "does not exist!");
        }
        tenantsRepository.deleteById(tenantId);
    }

    @Transactional
    public void updateTenant(Long tenantId, String f_name, String l_name, Integer phone_number, String email, String password, LocalDate signUpDate,  String gender) {
        Tenants tenant = tenantsRepository.findById(tenantId).orElseThrow( () ->
                new IllegalStateException("Tenant with id :" + tenantId + "does not exist"));
        if (f_name != null && f_name.length()>0 && !Objects.equals(tenant.getF_name(),f_name))
        {
            tenant.setF_name(f_name);
        }
        if (l_name != null && l_name.length()>0 && !Objects.equals(tenant.getL_name(),l_name)) {
            tenant.setF_name(l_name);
        }
        if (phone_number != null && phone_number>0 && !Objects.equals(tenant.getPhone_number(),phone_number))
        {
            tenant.setPhone_number(phone_number);
        }
        if (email != null && email.length()>0 && !Objects.equals(tenant.getEmail(),email)) {
            tenant.setEmail(email);
        }
        if(password != null && password.length()>0 && !Objects.equals(tenant.getPassword(),password)) {
            tenant.setPassword(password);
        }
        if(signUpDate != null  && !Objects.equals(tenant.getSignUpDate(),signUpDate)) {
            tenant.setSignUpDate(signUpDate);
        }
        if(gender != null && gender.length()>0 && !Objects.equals(tenant.getGender(),gender)) {
            tenant.setGender(gender);
        }


    }
}
