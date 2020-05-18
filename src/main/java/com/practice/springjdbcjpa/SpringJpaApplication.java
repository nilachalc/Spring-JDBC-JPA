package com.practice.springjdbcjpa;

import java.sql.Timestamp;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import com.practice.bean.Person;
import com.practice.springjpa.repository.PersonJpaRepository;

@SpringBootApplication
@ComponentScan(basePackages = "com.practice")
@EntityScan("com.practice.bean")
public class SpringJpaApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PersonJpaRepository personJpaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		logger.info("New Person: ");
		System.out.println(personJpaRepository.save(new Person("Suparna", "Rathtala", new Timestamp(new Date().getTime()))));
		
		logger.info("Updated Person: ");
		System.out.println(personJpaRepository.update(new Person(2,"Nilachal", "Rathtala", new Timestamp(new Date().getTime()))));
		
		logger.info("All the person details are as follows: "); 
		for (Person person : personJpaRepository.findAll()) {
			System.out.println(person); 
		}
		 
		logger.info("He/She is the Person: ");
		System.out.println(personJpaRepository.findById(2));
	}
}
