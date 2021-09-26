package com.example.rms.services;

import com.example.rms.domain.Admin;
import com.example.rms.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
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
        adminByNatId = adminRepository.findByNationalId(admin.getNationalId());
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

    @Transactional
    public void updateStudent(Long adminId, String fname, String lname, String email, String gender, Integer nationalId, String password) {
        Admin admin = adminRepository.findById(adminId).orElseThrow( () ->
                new IllegalStateException("Admin with id :" + adminId + "does not exist"));
        if (fname != null && fname.length()>0 && !Objects.equals(admin.getF_name(), fname))
        {
            admin.setF_name(fname);
        }
        if (lname != null && lname.length()>0 && !Objects.equals(admin.getS_name(), lname))
        {
            admin.setS_name(lname);
        }
        if (gender != null && gender.length()>0 && !Objects.equals(admin.getGender(), gender))
        {
            admin.setGender(gender);
        }

        if (email != null && email.length()>0 && !Objects.equals(admin.getEmail(),email)){
            Optional<Admin> adminOptional = adminRepository.findByEmail(email);
            if (adminOptional.isPresent()){
                throw new IllegalStateException("Email is taken");
            }
            admin.setEmail(email);
        }
        if (nationalId != null && nationalId > 0 && !Objects.equals(admin.getNationalId(),nationalId)){
            Optional<Admin> adminOptional2 = adminRepository.findByEmail(email);
            if (adminOptional2.isPresent()){
                throw new IllegalStateException("National id already exists");
            }
            admin.setNationalId(nationalId);
        }
        if (password != null && password.length()>0 && !Objects.equals(admin.getPassword(),password)){
            Optional<Admin> adminOptional3 = adminRepository.findByEmail(email);
            if (adminOptional3.isPresent()){
                throw new IllegalStateException("New password can not be same as old password");
            }
            admin.setPassword(password);
        }
    }

        // DELETE
        public void deleteAdminById(Long adminId){
            boolean admin_exists = adminRepository.existsById(adminId);
            if(!admin_exists){
                throw new IllegalStateException("Admin with id "+ adminId + " does not exist");
            }
            adminRepository.deleteById(adminId);
        }

}
