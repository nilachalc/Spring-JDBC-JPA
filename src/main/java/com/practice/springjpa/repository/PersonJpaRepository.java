package com.practice.springjpa.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.practice.bean.Person;

@Repository
@Transactional
public class PersonJpaRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	public List<Person> findAll() {
		TypedQuery<Person> typedQuery = entityManager.createNamedQuery("findAllPerson", Person.class);
		return typedQuery.getResultList();
	}
	
	public Person findById(Integer id) {
		return entityManager.find(Person.class, id);
	}
	
	public Person save(Person person) {
		return entityManager.merge(person);
	}
	
	public Person update(Person person) {
		return entityManager.merge(person);
	}
}
