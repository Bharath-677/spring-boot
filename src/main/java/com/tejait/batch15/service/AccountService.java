package com.tejait.batch15.service;

import com.tejait.batch15.dto.AccountCustomerDto;
import com.tejait.batch15.model.Account;


public interface AccountService {

public	Account saveAccount(Account acc);

public Account getByAccountId(Long id);

public com.tejait.batch15.dto.AccountResponseDto getByCustomerInfoByAccountId(Long id);

public AccountCustomerDto getByCustomerAccountDtlsId(Long id); 
	
	
	


}
