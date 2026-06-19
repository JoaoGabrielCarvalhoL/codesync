package br.com.codesync;

import org.springframework.boot.SpringApplication;

public class TestCodesyncApplication {

	public static void main(String[] args) {
		SpringApplication.from(CodesyncApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
