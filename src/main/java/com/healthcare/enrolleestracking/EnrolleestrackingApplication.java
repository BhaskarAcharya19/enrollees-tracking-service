package com.healthcare.enrolleestracking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.time.ZoneOffset;
import java.util.TimeZone;

@SpringBootApplication
public class EnrolleestrackingApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnrolleestrackingApplication.class, args);
	}

	@PostConstruct
	public void init() {
		TimeZone.setDefault(TimeZone.getTimeZone(ZoneOffset.UTC));
	}

}
