package com.tejait.batch15.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name="loans_b15")
@Entity
public class Loans {


   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int appId;
   private String fname;
   private  String lname;
   private String customerName;
   private  String mailId;
   private long mobile;
   private String city;
}
