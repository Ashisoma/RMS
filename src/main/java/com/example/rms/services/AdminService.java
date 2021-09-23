package com.example.rms.services;

import com.example.rms.domain.Admin;
import com.example.rms.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    public final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }
    // GET
    // BY NAT ID
    public Optional<Admin> getAdminByNationalId(Integer natId){
        return adminRepository.findByNationalId(natId);
    }
    // BY EMAIL
    public Optional<Admin> getAdminByEmail(String email){
        return adminRepository.findByEmail(email);
    }
    // all admins
    public List<Admin> getAllAdmins(){
        return adminRepository.findAll();
    }

    // ADD
    // AN ADMIN
    public void addNewAdmin(Admin admin) {

        Optional<Admin> adminByNatId, adminByNatId2;
        adminByNatId = adminRepository.findByNationalId(admin.getNational_id());
        adminByNatId2 = adminRepository.findByEmail(admin.getEmail());

        if(adminByNatId.isPresent()){
            throw new IllegalStateException("National id already exists");
        }

        if(adminByNatId2.isPresent()){
            throw new IllegalStateException("Email already exists");
        }
        adminRepository.save(admin);

    }
    // UPDATE

    // DELETE
    public void deleteAdmin(Admin admin){
        adminRepository.delete(admin);
    }

}
