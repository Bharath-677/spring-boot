package com.tejait.batch15.serviceimpl;

import com.tejait.batch15.model.CompanyAddress;
import com.tejait.batch15.repository.CompanyAddressRepository;
import com.tejait.batch15.service.CompanyAddressService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class CompanyAddressServiceImpl implements CompanyAddressService {
    CompanyAddressRepository repository;

    @Override
    public CompanyAddress savecompanyAdd(CompanyAddress companyAddress) {
        return repository.save(companyAddress);
    }
}
