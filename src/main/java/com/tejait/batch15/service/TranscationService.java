package com.tejait.batch15.service;

import org.springframework.web.multipart.MultipartFile;

public interface TransactionsService {

    String uploadCSV(MultipartFile file);
}