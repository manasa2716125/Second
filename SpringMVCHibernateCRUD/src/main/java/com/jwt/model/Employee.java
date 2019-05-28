package com.jwt.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "EMP_TBL1")
public class Employee implements Serializable {

	private static final long serialVersionUID = -3465813074586302847L;

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	@NotEmpty
	
     @Size(min=3,max=10)
	 @Column(name = "name")
	
	private String name;
	
	
	@NotEmpty
	
	 @Column(name = "password")
     @Size(min=5,max=15)
	private String password;
	
	
	@NotEmpty
	
	 @Column(name = "email")
	@Size(min=8,max=20)
	private String email;
	
	
	@NotEmpty
	 
	@DateTimeFormat(pattern="MM/dd/yyyy")
	
	 @Column(name = "dataOfBirth")
	
	private String dateOfBirth;
	
	

	 @Column(name = "country")
	@Size(min=3,max=9)
	private String country;
	
	
	
	
	
	 @Column(name = "gender")
	//@Size(min=3,max=9)
	private String gender;
	
	@NotEmpty
	
	 @Column(name = "age")
	@Range(min=18,max=70)
	private String age;
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

	
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	
	
}