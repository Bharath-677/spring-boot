package com.tejait.batch15.controller;

import com.tejait.batch15.model.CompanyAddress;
import com.tejait.batch15.service.CompanyAddressService;
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
public class CompanyAddressController {

    CompanyAddressService service;

    @PostMapping("savecompanyAdd")
    public ResponseEntity<CompanyAddress> savecompanyAdd(@RequestBody CompanyAddress companyAddress){
      CompanyAddress cpa=service.savecompanyAdd(companyAddress);
        return new ResponseEntity<>(cpa, HttpStatus.CREATED);
    }
}
