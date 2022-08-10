package com.example.rms.web;

import com.example.rms.domain.Admin;
import com.example.rms.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/rms/admin")
public class AdminController {


    public final AdminService adminService;
    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }


    @GetMapping
    public List<Admin> findAllCustomers(){
        return adminService.getAllAdmins();
    }

    @GetMapping(path = "/adminId/{natId}")
    public Optional<Admin> findAdminByNationalId(@PathVariable("natId") Integer natId){
        return adminService.getAdminByNationalId(natId);
    }

    @GetMapping(path = "/adminEmail/{email}")
    public Optional<Admin> findAdminByEmail(@PathVariable("email") String email){
        return adminService.getAdminByEmail(email);
    }

    //POST
    @PostMapping(path = "/registerAdmin")
    public void registerNewAdmin(@RequestBody Admin admin){
        adminService.addNewAdmin(admin);
    }

    //UPDATE
    @PutMapping(path = "/updateAdmin/{adminId}")
    public void updateAdmin(@PathVariable("adminId")Long adminId,
                            @RequestParam(required = false)String fname,
                            @RequestParam(required = false)String lname,
                            @RequestParam(required = false)String email,
                            @RequestParam(required = false)String gender,
                            @RequestParam(required = false)Integer nationalId,
                            @RequestParam(required = false) String password){
        // you can't update the admin coz the columns are nullable  = fa;se
        adminService.updateAdmin(adminId,fname,lname,email,gender,nationalId,password);
    }

    // DELETE
    @DeleteMapping(path = "/deleteAdmin/{adminId}")
    public void deleteAdminById(@PathVariable ("adminId") Long adminId){
        adminService.deleteAdminById(adminId);
    }
}
