package com.tejait.batch15.controller;

import com.tejait.batch15.model.BusinessProduct;
import com.tejait.batch15.model.CompanyAddress;
import com.tejait.batch15.model.CompanyDetails;
import com.tejait.batch15.model.Loans;
import com.tejait.batch15.service.LoansService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("loans")
public class LoansController {

    LoansService service;





    @PostMapping("applyLoan")
    public ResponseEntity<Loans> saveLoans(@RequestBody Loans loans){
        Loans savedLoans=service.saveLoans(loans);
        return new ResponseEntity<>(savedLoans, HttpStatus.CREATED);
    }
    @GetMapping("loanTaskboard")
    public ResponseEntity<List<Loans>> getAll(){
        List<Loans> list=service.getAll();
        return new ResponseEntity<List<Loans>>(list,HttpStatus.OK);
        }

    @GetMapping("getProductDetails/{appId}")
    public ResponseEntity<BusinessProduct> getById(@PathVariable Integer appId){
        return ResponseEntity.ok(service.getByAppId(appId));


    }

@GetMapping("getCompanyDetails/{appId}")
    public ResponseEntity<CompanyDetails> getByCompanyId(@PathVariable Integer appId){

        return ResponseEntity.ok(service.getByCompanyAppId(appId));
    }

    @GetMapping("getCompanyAddress/{appId}")
   public ResponseEntity<CompanyAddress> getByCompanyAddId(@PathVariable Integer appId){
        return ResponseEntity.ok(service.getByCompanyAddId(appId));

}

}
