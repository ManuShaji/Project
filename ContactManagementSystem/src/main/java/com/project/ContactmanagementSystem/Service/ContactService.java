package com.project.ContactmanagementSystem.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.project.ContactmanagementSystem.Repository.ContactRepository;
import com.project.ContactmanagementSystem.bean.Person;

@Service
public class ContactService {
	@Autowired
private ContactRepository contactrepository;

public Person retrieve(Integer id){
    return contactrepository.findById(id).get();
}
public boolean value(Integer id) {
	boolean person = contactrepository.existsById(id);
return person;
	
}
public Person save(Person person){
    return contactrepository.save(person);
}
public List<Person> getAll(){
	return contactrepository.findAll();
}
public List<Person> getByname(String name){
	return contactrepository.findByName(name);
}
}
