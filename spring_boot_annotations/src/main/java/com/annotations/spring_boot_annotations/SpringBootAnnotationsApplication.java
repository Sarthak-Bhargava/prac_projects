package com.annotations.spring_boot_annotations;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import mypack.Dog;

@SpringBootApplication
public class SpringBootAnnotationsApplication implements CommandLineRunner {
	
	@Autowired
	private Student student;
	@Autowired
	private Date date;
	
	@Autowired
	private Emp emp;
	
	@Autowired
	private Dog dog;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAnnotationsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Creating student object");
		this.student.studying();
		this.emp.whatsYourName();
		this.dog.eating();
		
		
	}

}
