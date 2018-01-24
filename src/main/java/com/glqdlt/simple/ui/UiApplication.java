package com.glqdlt.simple.ui;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:config.properties")
@SpringBootApplication
public class UiApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(UiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
