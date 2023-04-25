package com.smart.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="admins")
public class Admins {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="mobileno",unique = true)
	private String mobileno;
	
	@Column(name="password")
	private String password;
	
	@Column(name="usertype")
	private String usertype;
	
	//Default constructor
	public Admins(){}

	//parameterized constructor
	/*
	 * public Admins(String name, String mobileno, String password, String usertype)
	 * {
	 * 
	 * this.name = name; this.mobileno = mobileno; this.password = password;
	 * this.usertype = usertype; }
	 */
	//Generated getters and setters
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

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	@Override
	public String toString() {
		return "Admins [id=" + id + ", name=" + name + ", mobileno=" + mobileno + ", password=" + password
				+ ", usertype=" + usertype + "]";
	}

	
}
