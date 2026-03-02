package com.tejait.batch15.repository;


import com.tejait.batch15.model.Employee;
import com.tejait.batch15.repository.EmployeeRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.persistence.autoconfigure.EntityScan;

import java.util.Optional;

@DataJpaTest
@EntityScan(basePackageClasses = Employee.class)
public class EmployeeRepositoryTests {

    @Autowired
    EmployeeRepository repository;



    @Test
    void givenEmp_whenSaveEmp_thenReturnSavedEmp(){

        Employee givenEmp=Employee.builder()
                // .id(1)
                .fname("Bharat")
                .lname("p")
                .fullname("Bharat p")
                .age(22)
                .dept("java")
                .salary(100000L).empCode("ja123va")
                .build();

        Employee  savedEmp=repository.save(givenEmp);
        Assertions.assertThat(savedEmp).isNotNull();
        Assertions.assertThat(savedEmp.getId()).isPositive();
        Assertions.assertThat(savedEmp.getAge()).isGreaterThan(18);
        Assertions.assertThat(savedEmp.getDept()).isEqualTo("java");
        Assertions.assertThat(savedEmp.getFullname()).isEqualTo("Bharat p");
        Assertions.assertThat(savedEmp).hasFieldOrProperty("empCode");
        Assertions.assertThat(savedEmp).hasFieldOrPropertyWithValue("fullname","Bharat p");
        Assertions.assertThat(savedEmp).hasNoNullFieldsOrProperties();


    }
@Test
    void givenId_whenFindById_getIdObject(){
       Employee givenEmp=Employee.builder()
                .fname("Bharat")
                .lname("p")
                .fullname("Bharat p")
                .age(22)
                .dept("java")
                .salary(100000L).empCode("ja123va")
                .build();


   Employee savedEmp= repository.save(givenEmp);
        Optional<Employee> employee= repository.findById(savedEmp.getId());

        Assertions.assertThat(employee.get()).isNotNull();

    }



}
