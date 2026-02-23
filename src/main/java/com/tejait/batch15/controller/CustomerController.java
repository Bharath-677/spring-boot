package com.tejait.batch15.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tejait.batch15.dto.CustomerProductsRequest;
import com.tejait.batch15.model.Customer;
import com.tejait.batch15.service.CustomerDataService;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@RestController
@RequestMapping("/customer")
public class CustomerController {
	
   
	CustomerDataService service;
	
	@PostMapping("save")
	public ResponseEntity<Customer> savecustomer(@RequestBody Customer customer ){
		 Customer savedcustomer=service.saveCustomer(customer);
		
		return new ResponseEntity<>(savedcustomer,HttpStatus.CREATED);
		
	}
	@PostMapping("mapproductsToCustomer")
	public ResponseEntity<Customer> mapProductsToCustomer(@RequestBody CustomerProductsRequest request){
		
		Customer customer=service.mapProductsToCustomer(request);
		
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}
	
	@GetMapping("getcustomerid/{id}")
	public ResponseEntity<Customer> getByid(@PathVariable Integer id){
		Optional<Customer> cust=service.getcustomerid(id);
		return new ResponseEntity<Customer>(cust.get(), HttpStatus.OK);
		
		
	}
	
}
