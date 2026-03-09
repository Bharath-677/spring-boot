package com.tejait.batch15.service;

import com.tejait.batch15.model.Transaction;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface TransactionService {

    void uploadCsv(Integer appId, MultipartFile file);

    void saveAll(Integer appId, List<Transaction> list);

    List<Transaction> getAllByAppId(Integer appId);
}