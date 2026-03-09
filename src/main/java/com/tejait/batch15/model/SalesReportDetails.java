package com.tejait.batch15.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SalesReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer appId;

    private LocalDate date;

    private String orderNo;

    @Column(unique = true)
    private String invoiceNo;

    private String partyName;

    private String partyPhoneNo;

    private BigDecimal totalAmount;

    private BigDecimal receivedPaidAmount;

    private BigDecimal balanceAmount;
}