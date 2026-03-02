package com.tejait.batch15.repository;

import com.tejait.batch15.model.CompanyAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyAddressRepository extends JpaRepository<CompanyAddress,Integer> {


   public CompanyAddress findByAppId(int appId);
}
