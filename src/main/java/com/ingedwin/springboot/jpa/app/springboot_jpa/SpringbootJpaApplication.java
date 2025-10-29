package com.ingedwin.springboot.jpa.app.springboot_jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ingedwin.springboot.jpa.app.springboot_jpa.entities.Person;
import com.ingedwin.springboot.jpa.app.springboot_jpa.repositories.PersonRepository;

@SpringBootApplication
public class SpringbootJpaApplication implements CommandLineRunner {

	@Autowired
	private PersonRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Person> personList = (List<Person>) personRepository.findAll();
		personList.stream().forEach(person -> {
			System.out.println(person+"");
		});
	}

}
