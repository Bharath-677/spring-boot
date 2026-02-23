package com.tejait.batch15.serviceimpl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.tejait.batch15.service.CustomerService;

@Service("Retail")
// @Primary
public class RetailCustomerImpl implements CustomerService {

	@Override
	public String getcustomerType() {
		
		return "Retail customer";
	}

}
