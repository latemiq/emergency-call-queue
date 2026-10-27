package com.github.latemiq.ecq;

import org.springframework.boot.SpringApplication;

public class TestEmergencyCallQueueApplication {

	public static void main(String[] args) {
		SpringApplication.from(EmergencyCallQueueApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
