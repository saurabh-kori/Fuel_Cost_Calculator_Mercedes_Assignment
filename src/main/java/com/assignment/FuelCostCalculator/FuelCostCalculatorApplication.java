package com.assignment.FuelCostCalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FuelCostCalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(FuelCostCalculatorApplication.class, args);
	}

	

}
