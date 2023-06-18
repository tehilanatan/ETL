package com.example.restservice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Lob
	@Column(name = "FIRSTNAME", columnDefinition = "TEXT")
 	private String firstName;
	@Column(name = "LASTNAME", columnDefinition = "TEXT")
	private String lastName;

	
	@Override
	public String toString() {
		return String.format(
				"Person[id=%d, firstName='%s', lastName='%s']",
				id, firstName, lastName);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public Person() {
		
	}


}
