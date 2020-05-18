package com.practice.springjdbcjpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.practice.bean.Person;
import com.practice.springjdbc.repository.PersonJDBCRepository;

//@SpringBootApplication
//@ComponentScan(basePackages = "com.practice.springjdbc")
public class SpringJdbcApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PersonJDBCRepository personJDBCRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All the person details are as follows: "); 
		for (Person person : personJDBCRepository.findAll()) {
			System.out.println(person);
		}
		logger.info("He/She is the Person: ");
		System.out.println(personJDBCRepository.findById(10001));
	}
}
