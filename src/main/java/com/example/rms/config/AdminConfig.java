package com.example.rms.config;

import com.example.rms.domain.Admin;
import com.example.rms.repository.AdminRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class AdminConfig {

    @Bean
    CommandLineRunner runner(AdminRepository adminRepository){
        return args -> {
            // this is just some data I wanted to use on the db rather than have an empty table. The db is empty and
            // this is like cache data
            Admin landlord1 = new Admin("Peter",
                    "Muturi",
                    3242199,
                    "yeye@gmail.com",
                    "1234",
                    LocalDate.of(1998, 4, 24),
                    true,
                    "male");
            Admin Cornel = new Admin(
                    "Cornel",
                    "John",
                    328347,
                    "cj@gmail.com",
                    "baibv232",
                    LocalDate.of(2001, 1, 7),
                    true,
                    "Male");
            Admin Phillip = new Admin(
                    "Phillip",
                    "Huyu",
                    328847,
                    "ph@gmail.com",
                    "baibv232",
                    LocalDate.of(1999, 12,25),
                    true,
                    "Male");
//            adminRepository.saveAll(
//                    List.of(landlord1,Cornel,Phillip)
//            );
        };
    }
}
