package br.com.ovort;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MovieControlApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieControlApiApplication.class, args);
	}

}
