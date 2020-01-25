package com.pyt.handbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "com.*" })
public class HandbookApplication {

	public static void main(String[] args) {
		SpringApplication.run(HandbookApplication.class, args);
	}

}
