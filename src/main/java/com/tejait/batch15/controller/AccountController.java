package com.tejait.batch15.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tejait.batch15.dto.AccountCustomerDto;
import com.tejait.batch15.dto.AccountResponseDto;
import com.tejait.batch15.model.Account;
import com.tejait.batch15.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	AccountService service;
	
	@PostMapping("/saveAccount")
	public ResponseEntity<Account> saveAccount(@RequestBody Account acc){
		Account savedAcc=service.saveAccount(acc);
		
		return new ResponseEntity<Account>(savedAcc, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Account> getByAccountDtls(@PathVariable Long id){
		Account acc=service.getByAccountId(id);
		return new ResponseEntity<Account>(acc,HttpStatus.OK);
		
		}
	
	@GetMapping("getByAccId/{id}")
	public ResponseEntity<AccountResponseDto> giveResponseAccountInfo(@PathVariable Long id){
		AccountResponseDto dto=service.getByCustomerInfoByAccountId(id);
		
		return new ResponseEntity<AccountResponseDto>(dto, HttpStatus.OK);
			
	} 
	
	@GetMapping("getByCustomerAccId/{id}")
	public ResponseEntity<AccountCustomerDto> giveCustomerAccountInfo(@PathVariable Long id){
		AccountCustomerDto Acdto=service.getByCustomerAccountDtlsId(id);
		
		return new ResponseEntity<AccountCustomerDto>(Acdto, HttpStatus.OK);
		
		
	}
	

}
