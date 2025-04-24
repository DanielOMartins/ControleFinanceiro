package com.control.finance;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FinanceApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.load();
		System.setProperty("MONGO_PASSWORD", dotenv.get("MONGO_PASSWORD"));
		SpringApplication.run(FinanceApplication.class, args);
	}

}
