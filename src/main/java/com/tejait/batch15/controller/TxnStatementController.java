package com.tejait.batch15.controller;


import com.tejait.batch15.model.Transaction;


import com.tejait.batch15.serviceimpl.TxnStatementServiceImpl;




import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/loans")

public class TxnStatementController {



    private final TxnStatementServiceImpl service;

    public TxnStatementController(TxnStatementServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/fetchtransactions/{appId}")

    public List<Transaction> fetchTransactions(

            @PathVariable Integer appId,

            @RequestParam String duration) {

        return service.getTransactions(appId, duration);

    }

}
