package com.hong.dwh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class HongDataWarehouseApplication {

	public static void main(String[] args) {
		SpringApplication.run(HongDataWarehouseApplication.class, args);
	}

}
