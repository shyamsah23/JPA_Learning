package com.Learner.hospitalManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class HospitalManagementApplication {

	public static void main(String[] args) {

		SpringApplication.run(HospitalManagementApplication.class, args);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String rawPassword = "Anant";
		String hashed = encoder.encode(rawPassword);
		System.out.println("Hashed password: " + hashed);
	}

}
