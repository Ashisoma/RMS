package com.example.rms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.sql.Timestamp;

@EnableSwagger2
@SpringBootApplication
public class RentalManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentalManagementSystemApplication.class, args);

		System.out.println("Getting on the other side...");

	}

}
