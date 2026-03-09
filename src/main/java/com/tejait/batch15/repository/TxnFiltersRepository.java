package com.tejait.batch15.repository;

import com.tejait.batch15.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface TxnFiltersRepository extends JpaRepository<Transaction, Integer> {

    @Query("SELECT t FROM Transaction t WHERE t.appId = :appId AND LOWER(t.instrument) IN (:instruments) AND t.transactionStatus IN (:statuses)")
    List<Transaction> findByAppIdAndInstrumentAndStatus(
            @Param("appId") Integer appId,
            @Param("instruments") List<String> instruments,
            @Param("statuses") List<String> statuses
    );

    @Query("SELECT t FROM Transaction t WHERE t.appId = :appId AND LOWER(t.instrument) IN (:instruments)")
    List<Transaction> findByAppIdAndInstrument(
            @Param("appId") Integer appId,
            @Param("instruments") List<String> instruments
    );

    List<Transaction> findByAppIdAndTransactionStatusIn(
            Integer appId,
            List<String> statuses
    );

    List<Transaction> findByAppId(Integer appId);
}