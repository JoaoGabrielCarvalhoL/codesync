package br.com.codesync;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CodesyncApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodesyncApplication.class, args);
	}

}
