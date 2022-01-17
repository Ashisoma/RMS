package com.example.rms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Timestamp;

@SpringBootApplication
public class RentalManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentalManagementSystemApplication.class, args);

		System.out.println("Getting on the other side...");

	}

}
