package com.aec.demo;

import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableScheduling
public class Application {

	public static void main(String[] args)  throws SQLException{
		SpringApplication.run(Application.class, args);
		
	}

}
