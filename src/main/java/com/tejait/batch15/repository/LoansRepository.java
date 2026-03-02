package com.tejait.batch15.repository;

import com.tejait.batch15.model.Loans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoansRepository  extends JpaRepository<Loans,Integer> {


    Loans findByAppId(int appId);
}




