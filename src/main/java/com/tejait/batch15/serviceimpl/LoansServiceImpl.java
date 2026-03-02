package com.tejait.batch15.serviceimpl;


import com.tejait.batch15.model.BusinessProduct;
import com.tejait.batch15.model.CompanyAddress;
import com.tejait.batch15.model.CompanyDetails;
import com.tejait.batch15.model.Loans;
import com.tejait.batch15.repository.BusinessProductRepository;
import com.tejait.batch15.repository.CompanyAddressRepository;
import com.tejait.batch15.repository.CompanyDetailsRepository;
import com.tejait.batch15.repository.LoansRepository;
import com.tejait.batch15.service.LoansService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LoansServiceImpl implements LoansService {

     LoansRepository repository;

     BusinessProductRepository businessProductRepository;

     CompanyDetailsRepository companyDetailsRepository;

     CompanyAddressRepository companyAddressRepository;

    @Override
    public Loans saveLoans(Loans loans) {

       loans.setCustomerName(loans.getFname().concat(" "+loans.getLname()));

        return repository.save(loans);
    }

    @Override
    public List<Loans> getAll() {

        return repository.findAll();
    }

    @Override
    public BusinessProduct getByAppId(Integer appId) {
        return businessProductRepository.findByAppId(appId);
    }

    @Override
    public CompanyDetails getByCompanyAppId(Integer appId) {
        return companyDetailsRepository.findByAppId(appId);
    }

    @Override
    public CompanyAddress getByCompanyAddId(Integer appId) {
        return companyAddressRepository.findByAppId(appId);
    }


}