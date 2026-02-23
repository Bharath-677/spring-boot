package com.tejait.batch15.serviceimpl;


import org.springframework.stereotype.Service;

import com.tejait.batch15.service.CustomerService;


@Service("Business")
public class BusinessCustomerImpl implements CustomerService {

	@Override
	public String getcustomerType() {
		
		return "Business Customer";
	}

}
