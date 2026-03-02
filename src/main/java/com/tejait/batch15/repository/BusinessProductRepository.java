package com.tejait.batch15.repository;

import com.tejait.batch15.model.BusinessProduct;
import com.tejait.batch15.model.CompanyDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusinessProductRepository extends JpaRepository<BusinessProduct,Integer> {


   public BusinessProduct findByAppId(int appId);


}
