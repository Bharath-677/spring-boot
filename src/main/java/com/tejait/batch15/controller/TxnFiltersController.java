package com.tejait.batch15.controller;

import com.tejait.batch15.model.Transaction;
import com.tejait.batch15.service.TxnFiltersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loans")
@RequiredArgsConstructor
public class TxnFiltersController {

    private final TxnFiltersService service;

    @GetMapping("/filtertransactions/{appId}")
    public List<Transaction> filterTransactions(
            @PathVariable Integer appId,
            @RequestParam(required = false) String statusOrInstrument,
            @RequestParam(required = false) List<String> statusOrInstrumentTypesList) {

        if ("instrument".equalsIgnoreCase(statusOrInstrument)) {
            return service.filterTransactions(appId, statusOrInstrumentTypesList, null);
        }
        else if ("status".equalsIgnoreCase(statusOrInstrument)) {
            return service.filterTransactions(appId, null, statusOrInstrumentTypesList);
        }

        return service.filterTransactions(appId, null, null);
    }
}