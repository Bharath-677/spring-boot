package com.tejait.batch15.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 🔹 Added appId
    private Integer appId;

    private LocalDate txnDate;

    private String activity;

    private String instrument;

    @Column(unique = true)
    private String txnId;

    private String comment;

    private Double debitAmt;

    private Double creditAmt;

    private String txnBreakup;

    private String txnStatus;
}