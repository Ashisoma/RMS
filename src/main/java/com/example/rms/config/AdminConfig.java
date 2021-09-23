package com.example.rms.config;

import com.example.rms.domain.Admin;
import com.example.rms.repository.AdminRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class AdminConfig {
    @Bean
    CommandLineRunner runner(AdminRepository adminRepository){
        return args -> {
            Admin landlord1 = new Admin("Peter","Muturi", 3242199,"yeye@gmail.com", "1234", LocalDate.of(1998, 4, 24)
                    ,true,"male");
            adminRepository.save(landlord1);
        };
    }
}
