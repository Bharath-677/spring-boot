package com.tejait.batch15.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class CompanyDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private  int appId;
    private  String companyName;
    private String dateOfEstablish;
    private  String gstin;
    private  String companyPan;
    private  long turnover;

}
