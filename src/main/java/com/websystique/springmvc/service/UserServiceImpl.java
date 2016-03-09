package com.websystique.springmvc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.model.Company;

@Service("userService")
@Transactional
public class UserServiceImpl implements CompanyService{
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<Company> users;
	
	static{
		users= populateDummyCompany();
	}

	public List<Company> findAllCompany() {
		return users;
	}
	
	public Company findById(long id) {
		for(Company user : users){
			if(user.getId() == id){
				return user;
			}
		}
		return null;
	}
	
	public void saveCompany(Company user) {
		user.setId(counter.incrementAndGet());
		users.add(user);
	}

	public void updateCompany(Company user) {
		int index = users.indexOf(user);
		users.set(index, user);
	}

	private static List<Company> populateDummyCompany(){
		List<Company> users = new ArrayList<Company>();

		users.add(new Company(counter.incrementAndGet(),"Company1", "Address1", "City1","Country1","company1@city1.com","+91 - 9900990027","Owner1,Owner2"));
		users.add(new Company(counter.incrementAndGet(),"Company1", "Address1", "City1","Country1","company1@city1.com","+91 - 9900990027","Owner3,Owner4"));
		users.add(new Company(counter.incrementAndGet(),"Company1", "Address1", "City1","Country1","Owner7,Owner9"));
		return users;
	}

	public Company findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
