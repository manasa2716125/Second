package com.jwt.model;

import javax.persistence.Column;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Login {
	
	
	@NotEmpty
	//@NotEmpty(message="Name must be above 3 Characters")
	@Column(name="name")
	// @Size(min=3,message="Name must be above 3 Characters")
	private String name;
	@NotEmpty
	//@NotEmpty(message="Name must be above 3 Characters")
	@Column(name="name")
	// @Size(min=5,message="Name must be above 5 Characters")
	private String password;

	
     
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

	@Override
	public String toString() {
		return "Login [name=" + name + ", password=" + password + "]";
	}
	
}
