package com.tejait.batch15.serviceimpl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.tejait.batch15.dto.AccountCustomerDto;
import com.tejait.batch15.dto.AccountResponseDto;
import com.tejait.batch15.model.Account;
import com.tejait.batch15.repository.AccountRepository;
import com.tejait.batch15.service.AccountService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {

	// @Autowired
	AccountRepository repository;
	
	@Override
	public Account saveAccount(Account acc) {
		acc.setCreatedDate(LocalDateTime.now());
		acc.setUpdatedDate(LocalDateTime.now());
		return repository.save(acc) ;
	}

	@Override
	public Account getByAccountId(Long id) {
		
		return repository.findById(id).get();
	}

	@Override
	public AccountResponseDto getByCustomerInfoByAccountId(Long id) {
		
		Account acc=repository.findById(id).get();
		System.out.println("Account info"+acc);
		
		AccountResponseDto dto=new AccountResponseDto();
		                    dto.setAccountId(acc.getAccountId());
		                    dto.setAccountType(acc.getAccountType());
		                    dto.setHolderName(acc.getHolderName());
		                    dto.setIfsc(acc.getIfsc());
		                    dto.setKycStatus(acc.getKycStatus());
		                    
		return dto;
	}

	@Override
	public AccountCustomerDto getByCustomerAccountDtlsId(Long id) {
		
	Account acc1=repository.findById(id).get();
		System.out.println("Customer Info"+acc1);
		
		AccountCustomerDto cdto=new AccountCustomerDto();
		
		             cdto.setAccountId(acc1.getAccountId());
		             cdto.setAccountNum(acc1.getAccountNum());
		             cdto.setBalance(acc1.getBalance());
		return cdto;
	}
	

		
	

}
