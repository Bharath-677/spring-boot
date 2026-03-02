package com.tejait.batch15.controller;

import com.tejait.batch15.model.CompanyDetails;
import com.tejait.batch15.service.CompanyAddressService;
import com.tejait.batch15.service.CompanyDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@AllArgsConstructor
@RestController
@RequestMapping("loans")
public class CompanyDetailsController {

    CompanyDetailsService service;

    @PostMapping("savecompanyDetails")
    public ResponseEntity<CompanyDetails> savecompanyDetails(@RequestBody CompanyDetails companyDetails){
       CompanyDetails cpd= service.savecompanyDetails(companyDetails);
        return new ResponseEntity<>(cpd, HttpStatus.CREATED);
    }

}
