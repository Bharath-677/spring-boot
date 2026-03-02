package com.tejait.batch15.controller;

import com.tejait.batch15.model.CompanyAddress;
import com.tejait.batch15.model.CompanyDetails;
import com.tejait.batch15.service.CompanyAddressService;
import com.tejait.batch15.service.CompanyDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("loans")
public class CompanyDetailsController {


    private CompanyDetailsService service;

    @RequestMapping(
            value = "saveCompanyDetails/{appId}",
            method = {RequestMethod.POST, RequestMethod.PUT}
    )
    public ResponseEntity<CompanyDetails> saveCompanyDetails(
            @PathVariable int appId,
            @RequestBody CompanyDetails details) {

        // Bind appId from URL
        details.setAppId(appId);

        CompanyDetails companyDetails =
                service.saveCompanyDetails(details);

        // UPDATE case
        if (details.getId() != 0) {
            return new ResponseEntity<>(companyDetails, HttpStatus.OK);
        }

        // SAVE case
        return new ResponseEntity<>(companyDetails, HttpStatus.CREATED);
    }
}