package com.practice.bean;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "findAllPerson", query = "select p from Person p")
public class Person {

	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String location;
	
	@Column(name = "birthdate")
	private Timestamp birthDay;
	
	public Person() { }
	
	public Person(String name, String location, Timestamp birthDay) {
		this.name = name;
		this.location = location;
		this.birthDay = birthDay;
	}
	
	public Person(Integer id, String name, String location, Timestamp birthDay) {
		this.id = id;
		this.name = name;
		this.location = location;
		this.birthDay = birthDay;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Timestamp getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Timestamp birthDay) {
		this.birthDay = birthDay;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", location=" + location + ", birthDay=" + birthDay + "]";
	}
}
