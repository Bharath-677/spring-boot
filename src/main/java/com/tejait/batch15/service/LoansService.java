package com.tejait.batch15.service;

import com.tejait.batch15.model.BusinessProduct;
import com.tejait.batch15.model.CompanyAddress;
import com.tejait.batch15.model.CompanyDetails;
import com.tejait.batch15.model.Loans;

import java.util.List;
import java.util.Optional;

public interface LoansService {
    Loans saveLoans(Loans loans);

    List<Loans> getAll();


    BusinessProduct getByAppId(Integer appId);

    CompanyDetails getByCompanyAppId(Integer appId);


    CompanyAddress getByCompanyAddId(Integer appId);
}
