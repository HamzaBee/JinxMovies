package com.jinxMovies.JinxMovies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.jinxMovies.JinxMovies")
@SpringBootApplication
public class JinxMoviesApplication {

	public static void main(String[] args) {
		SpringApplication.run(JinxMoviesApplication.class, args);
	}

}
