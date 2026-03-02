package com.tejait.batch15.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class BusinessProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int Id;
    private  int appId;
    private  String purposeOfLoan;
    private  String natureOfBusiness;
    private  int tenure;
    private  long loanAmount;
}
