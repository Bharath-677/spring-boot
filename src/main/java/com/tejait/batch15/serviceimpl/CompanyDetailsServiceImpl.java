package com.tejait.batch15.serviceimpl;

import com.tejait.batch15.model.CompanyDetails;
import com.tejait.batch15.repository.CompanyDetailsRepository;
import com.tejait.batch15.service.CompanyDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CompanyDetailsServiceImpl implements CompanyDetailsService {
    CompanyDetailsRepository repository;

    @Override
    public CompanyDetails savecompanyDetails(CompanyDetails companyDetails) {
        return repository.save(companyDetails);
    }
}
