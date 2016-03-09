package com.websystique.springmvc.model;

import java.util.List;

public class Company {

	private long id;
	
	private String name;
	
	private String address;
	
	private String email;
	
	private String city;
	
	private String country;
	
	private String phoneNumber;
	
	private String owners;
		
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getOwners() {
		return owners;
	}

	public void setOwners(String owners) {
		this.owners = owners;
	}

	public Company(){
		id=0;
	}
	
	public Company(long id, String name, String address, String city, String country,
			String owners) {
		super();
		this.id = id;
		this.address = address;
		this.name = name;
		this.city = city;
		this.country = country;
		this.owners = owners;
	}

	public Company(long id, String name, String address, String city, String country, String email,
			String phoneNumber, String owners) {
		super();
		this.id = id;
		this.address = address;
		this.email = email;
		this.name = name;
		this.city = city;
		this.country = country;
		this.phoneNumber = phoneNumber;
		this.owners = owners;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Company))
			return false;
		Company other = (Company) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", address=" + address
				+ ", email=" + email + "]";
	}
	

	
}
