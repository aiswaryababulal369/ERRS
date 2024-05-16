package com.bytes.errs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class ErrsApplication {
	public static void main(String[] args) {
		SpringApplication.run(ErrsApplication.class, args);
	}

}


