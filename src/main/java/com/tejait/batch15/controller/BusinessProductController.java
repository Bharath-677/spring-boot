package com.tejait.batch15.controller;

import com.tejait.batch15.model.BusinessProduct;
import com.tejait.batch15.service.BusinessProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("loans")
public class BusinessProductController {


    BusinessProductService service;



    @PostMapping("saveProductDetails")
    public ResponseEntity<BusinessProduct> savebussinesProduct(@RequestBody BusinessProduct businessProduct){
        BusinessProduct savedbp=service.savebusinessProducts(businessProduct);
        return  new ResponseEntity<>(savedbp, HttpStatus.CREATED);

    }

}
