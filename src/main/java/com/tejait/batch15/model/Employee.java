package com.tejait.batch15.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

//@Data
@Table(name="employee_b15")
@Entity   //it is created tables in database
public class Employee {

	@Id   //primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
	private int id;
	// @Column(name="first_name")    // it will creat the names in db your requirement
	private String fname;
	private String lname;
	private String fullname;
	private String dept;
	private int age;
	private long salary;
	private String empCode;








}
