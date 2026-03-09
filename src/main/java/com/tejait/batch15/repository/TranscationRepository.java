package com.tejait.batch15.repository;

import com.tejait.batch15.model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionsRepository extends JpaRepository<Transactions, Long> {

    boolean existsByTxnId(String txnId);
}