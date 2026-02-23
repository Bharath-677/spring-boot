package com.tejait.batch15.service;



import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.tejait.batch15.model.Employee;


public interface EmployeeService {
	
	public Employee saveEmployee(Employee emp);

	public void deleteEmployee(Integer id);

	public Optional<Employee> getById(Integer id);

	public List<Employee> getAllEmps();

	public boolean existsById(Integer id);

	public Page<Employee> getPaginationDate(int pageNum, int pagesize);

	public List<Employee> getBysortingData(String property, String orderType);

	public List<Employee> findByDept(String dept);

	public List<Employee> findByfname(String fname);

	public List<Employee> findByfnameAndlname(String fname, String lname);

	

	public List<String> getdistinctByDept();

	public List<Employee> getsearchemployee(String searchterm);

	public List<Employee> searchFilters(String filterType, String empCode);
	

	public List<Employee> findByLastNameOrFirstName(String lname, String fname);

	public List<Employee> findByAgeLessThan(int age);

	public List<Employee> findByAgeLessThanEqual(int age);

	public List<Employee> findByAgeGreaterThan(int age);

	



	

	

	



	

}
