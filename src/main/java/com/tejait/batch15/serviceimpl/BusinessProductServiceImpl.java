package com.tejait.batch15.serviceimpl;

import com.tejait.batch15.model.BusinessProduct;
import com.tejait.batch15.repository.BusinessProductRepository;
import com.tejait.batch15.service.BusinessProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class BusinessProductServiceImpl implements BusinessProductService {

    BusinessProductRepository repository;

    @Override
    public BusinessProduct savebusinessProducts(BusinessProduct businessProduct) {

        return repository.save(businessProduct);
    }


}
