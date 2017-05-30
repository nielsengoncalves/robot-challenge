package com.nasa.robots;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class NasaRobotsApplication {

	public static void main(String[] args) {
		SpringApplication.run(NasaRobotsApplication.class, args);
	}
}
