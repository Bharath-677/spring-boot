package com.tejait.batch15.model;



import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class AssuranceDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Integer appId;

    private String ename;
    private String nationality;
    private Integer age;

    private String mail;
    private String gender;
}
