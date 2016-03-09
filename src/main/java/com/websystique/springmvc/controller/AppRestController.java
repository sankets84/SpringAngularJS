package com.websystique.springmvc.controller;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.websystique.springmvc.model.Company;
import com.websystique.springmvc.service.CompanyService;
 
@RestController
public class AppRestController {
 
    @Autowired
    CompanyService companyService;  //Service which will do all data retrieval/manipulation work
 
    
    //-------------------Retrieve All Companies--------------------------------------------------------
     
    @RequestMapping(value = "/allcompany/", method = RequestMethod.GET)
    public ResponseEntity<List<Company>> listAllUsers() {
        List<Company> users = companyService.findAllCompany();
        if(users.isEmpty()){
            return new ResponseEntity<List<Company>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Company>>(users, HttpStatus.OK);
    }
 
 
    
    //-------------------Retrieve Single Company--------------------------------------------------------
     
    @RequestMapping(value = "/company/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Company> getUser(@PathVariable("id") long id) {
        System.out.println("Fetching User with id " + id);
        Company user = companyService.findById(id);
        if (user == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<Company>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Company>(user, HttpStatus.OK);
    }
 
     
     
    //-------------------Create a Company--------------------------------------------------------
     
    @RequestMapping(value = "/company/", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody Company user,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating User " + user.getName());
 

        companyService.saveCompany(user);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
 
    
     
    //------------------- Update a Company --------------------------------------------------------
     
    @RequestMapping(value = "/company/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Company> updateUser(@PathVariable("id") long id, @RequestBody Company user) {
        System.out.println("Updating User " + id);
         
        Company cData = companyService.findById(id);
         
        if (cData==null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<Company>(HttpStatus.NOT_FOUND);
        }
 
        cData.setName(user.getName());
        cData.setAddress(user.getAddress());
        cData.setEmail(user.getEmail());
        cData.setPhoneNumber(user.getPhoneNumber());
        cData.setCity(user.getCity());
        cData.setCountry(user.getCountry());
        cData.setOwners(user.getOwners());
         
        companyService.updateCompany(cData);
        return new ResponseEntity<Company>(cData, HttpStatus.OK);
    }
 
}