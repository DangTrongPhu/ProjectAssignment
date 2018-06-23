package com.mkyong.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "name")
	private String name;
	
	@Column(name = "id_roles")
	private String id_roles;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "pass")
	private String pass;

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public String getId_roles() {
		return id_roles;
	}

	public void setId_roles(String id_roles) {
		this.id_roles = id_roles;
	}

	public User() {
	}

	public User(String name, String id_roles, String email, String pass) {
		super();
		this.name = name;
		this.id_roles = id_roles;
		this.email = email;
		this.pass = pass;
	}

	

	
	
	
}
