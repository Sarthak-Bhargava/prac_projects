package com.annotations.spring_boot_annotations;

import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


// this is the configuration class which is returning bean
@Configuration
@ComponentScan(basePackages = {"mypack"})
public class MyConfig {

	// this getStudent() is returning object from student class
	@Bean
	public Student getStudent( ) {
		return new Student();
	}
	
	@Bean
	public Date getDate( ) {
		System.out.println("Creating new date");
		return new Date();
	}
}
