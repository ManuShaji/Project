package com.project.ContactmanagementSystem.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Entity
@Table(name = "Person")
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
	
	@NotNull(message = "username should not be null")
private String name;
	
	@Pattern(regexp = "^\\d{10}$",message="invalid phone number format")
private String mobile;
public Person() {
	super();
}
public Person(Integer id, String name, String mobile) {
	super();
	this.id = id;
	this.name = name;
	this.mobile = mobile;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getMobile() {
	return mobile;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}
@Override
public String toString() {
	return "Person [id=" + id + ", name=" + name + ", mobile=" + mobile + "]";
}

}
