package com.tejait.batch15.service;

import com.tejait.batch15.model.Transaction;
import java.util.List;

public interface TxnFiltersService {

    List<Transaction> filterTransactions(
            Integer appId,
            List<String> instruments,
            List<String> statuses);
}