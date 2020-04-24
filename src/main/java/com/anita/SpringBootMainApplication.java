package com.anita;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.retry.annotation.EnableRetry;

import com.anita.dao.UserDao;
import com.anita.dto.UserDTO;
import com.anita.entity.UserEntity;

@EnableRetry
@SpringBootApplication
public class SpringBootMainApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMainApplication.class, args);
	}
	
}