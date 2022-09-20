package com.project.ContactmanagementSystem;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.annotation.Rollback;
import org.springframework.test.annotation.Rollback;

import com.project.ContactmanagementSystem.Repository.ContactRepository;
import com.project.ContactmanagementSystem.bean.Person;
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ContactControllerTest {
	@Autowired
private ContactRepository repo;
	@Test
@Rollback(false)
	@Order(1)
	public void testSave() {
		Person person = new Person(9,"manu","9664455338");
		Person save = repo.save(person);
		assertNotNull(save);
	}
	@Test
	@Rollback(false)
	@Order(2)
	public void testGetById() {
		int id =9;
		Person person =  repo.findById(id).get();
		assertThat(person.getId()).isEqualTo(id);
	
		
	}
}
