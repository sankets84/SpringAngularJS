package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.Company;

public interface CompanyService {
	
	Company findById(long id);
	
	Company findByName(String name);
	
	void saveCompany(Company user);
	
	void updateCompany(Company user);
	
	List<Company> findAllCompany(); 
}
