package com.tejait.batch15.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tejait.batch15.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	
	
	public List<Employee> findByDept(String dept);
	
	public List<Employee> findByFname(String fname);
	
	
	public List<Employee> findByFnameAndLname(String fname,String lname);
	 
	
	@Query("select e from Employee e") //jpa queries work on entities
	public List<Employee> getall();
	 
	@Query(value = "select * from employee_15",nativeQuery = true)  //sql queries work on tables
	public List<Employee> getallemps();
	 
	@Query("select e from Employee e where e.fname=?1 and e.lname=?2")
	public List<Employee> findByFirstNameLastName(String firstname,String lastname);
	 
	@Query("select e from Employee e where e.fname=:Firstname and e.lname=:lastname ")
	public List<Employee> fibdByFirstNameAndLastNameData(@Param("Firstname") String fname, @Param("lastname") String lname );
	 
	@Query("select distinct(e.dept) from Employee e ")
	public List<String> findDistinctByDepartment();
	 
	@Query("select e from Employee e where concat(e.fname,e.lname,e.fullname,e.dept,e.empCode,e.age,e.salary) like %?1%")
	public List<Employee> searchEmployee(String searchterm);
	
	//--------------------------------- search filters starts -------------------------------
	public List<Employee> findByEmpCodeStartingWith(String empCode);
	
	
	public List<Employee> findByEmpCodeEndingWith(String empCode);
	
	public List<Employee> findByEmpCodeContaining(String empCode);
	
	public List<Employee> findByEmpCodeNotContaining(String empCode);
	
	public List<Employee> findByEmpCode(String empCode);  //equals
	
	public List<Employee> findByEmpCodeNot(String empCode);  //notequals
	
	
    public List<Employee> findByLnameOrFname(String lname, String fname);
	
	public List<Employee>findByAgeLessThan(int age);
	
	public List<Employee> findByAgeLessThanEqual(Integer age);
	
    public List<Employee> findByAgeGreaterThan(Integer age);
 
	public List<Employee> findByAgeGreaterThanEqual (Integer age);
}
