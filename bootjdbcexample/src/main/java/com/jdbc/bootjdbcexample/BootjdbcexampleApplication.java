package com.jdbc.bootjdbcexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jdbc.bootjdbcexample.dao.UserDao;

@SpringBootApplication
public class BootjdbcexampleApplication  implements CommandLineRunner {

	@Autowired
	private UserDao userDao;
	public static void main(String[] args) {
		SpringApplication.run(BootjdbcexampleApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		System.out.println(this.userDao.createTable());
		
	}

}
