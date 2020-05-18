package com.practice.springjdbc.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.practice.bean.Person;

@Repository
public class PersonJDBCRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Person> findAll() {
		return jdbcTemplate.query("SELECT * FROM person", new BeanPropertyRowMapper(Person.class));
	}
	
	public Person findById(Integer id) {
		return (Person)jdbcTemplate.queryForObject("SELECT * FROM person WHERE id = ?", new Object[] {id}, new RowMapper<Person>() {

			@Override
			public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
				Person person = new Person();
				person.setId(rs.getInt(1));
				person.setName(rs.getString(2));
				person.setLocation(rs.getString(3));
				person.setBirthDay(rs.getTimestamp(4));
				return person;
			}
			
		});
	}
}
