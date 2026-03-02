package com.tejait.batch15.controller;

import com.tejait.batch15.model.BusinessProduct;
import com.tejait.batch15.service.BusinessProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("loans")
public class BusinessProductController {

    private BusinessProductService service;

    @RequestMapping(
            value = "saveProductDetails/{appId}",
            method = {RequestMethod.POST, RequestMethod.PUT}
    )
    public ResponseEntity<BusinessProduct> saveBusinessProduct(
            @PathVariable int appId,
            @RequestBody BusinessProduct product) {

        // bind appId from URL
        product.setAppId(appId);

        BusinessProduct businessProduct =
                service.saveBusinessProduct(product);

        // UPDATE case
        if (product.getId() != 0) {
            return new ResponseEntity<>(businessProduct, HttpStatus.OK);
        }

        // SAVE case
        return new ResponseEntity<>(businessProduct, HttpStatus.CREATED);
    }
}