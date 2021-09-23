package com.example.rms.web;

import com.example.rms.domain.Admin;
import com.example.rms.repository.AdminRepository;
import com.example.rms.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/admin")
public class AdminController {

    @Autowired
    AdminRepository adminRepository;
    AdminService adminService;


    @RequestMapping
    public List<Admin> findAllCustomers(){
        return adminService.getAllAdmins();
    }
}
