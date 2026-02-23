package com.tejait.batch15.serviceimpl;


import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.SortComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.tejait.batch15.constants.SearchFilter;
import com.tejait.batch15.model.Employee;
import com.tejait.batch15.repository.EmployeeRepository;
import com.tejait.batch15.service.EmployeeService;

import lombok.AllArgsConstructor;
 
@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
	
	//@Autowired
	EmployeeRepository repository;
 
	@Override
	public Employee saveEmployee(Employee emp) {
		
		String fname=emp.getFname();
		String lname=emp.getLname();
		emp.setFullname(fname.concat(" "+lname));
	Employee saveEmp=repository.save(emp);
		
		return saveEmp;
	}

	@Override
	public void deleteEmployee(Integer id) {
		repository.deleteById(id);
		
	}

	@Override
	public Optional<Employee> getById(Integer id) {
		
		return repository.findById(id) ;
	}
     @Override
	public List<Employee> getAllEmps() {
		
		return repository.findAll();
	}

	 @Override
	 public boolean existsById(Integer id) {
		
		return repository.existsById(id);
	 }

	 @Override
	 public Page<Employee> getPaginationDate(int pageNum, int pagesize) {
		
		 Pageable pageable=PageRequest.of(pageNum, pagesize);
		 
		 
		return  repository.findAll(pageable); 
	 }

	 @Override
	 public List<Employee> getBysortingData(String property, String orderType) {
		
		 if(orderType.equalsIgnoreCase("desc")) {
		return repository.findAll(Sort.by( Direction.DESC,property));
		 }
		 
		 return repository.findAll(Sort.by(Direction.ASC,property));
	 }

	 @Override
	 public List<Employee> findByDept(String dept) {
		
		return repository.findByDept(dept);
	 }

	 @Override
	 public List<Employee> findByfname(String fname) {
		
		return  repository.findByFname(fname);
	 }

		@Override
		public List<Employee> findByfnameAndlname(String fname, String lname) {
			
			return repository.findByFnameAndLname(fname, lname);
		}
	 
		
	 
		@Override
		public List<String> getdistinctByDept() {
			
			return repository.findDistinctByDepartment();
		}
	 
		@Override
		public List<Employee> getsearchemployee(String searchterm) {
			
			return repository.searchEmployee(searchterm);
		}

		@Override
		public List<Employee> searchFilters(String filterType, String empcode) {
			
			List<Employee> list=null;
			
			switch(filterType) {
			case SearchFilter.EQUALS:
				list=repository.findByEmpCode(empcode);
			break;
			case SearchFilter.NOT_EQUALS:
				list=repository.findByEmpCodeNot(empcode);
				break;
				
			case SearchFilter.START_WITH:
				list=repository.findByEmpCodeStartingWith(empcode);
				break;
			case SearchFilter.END_WITH:
				list=repository.findByEmpCodeEndingWith(empcode);
				
			case SearchFilter.CONTAINS:
				list=repository.findByEmpCodeContaining(empcode);
				break;
				
			case SearchFilter.NOT_CONTAINS:
				list=repository.findByEmpCodeNotContaining(empcode);
				break;
				default:
					throw new IllegalArgumentException("Unexpected value: "+ filterType);
			
			}
			
			return list;
		}

		@Override
		public List<Employee> findByLastNameOrFirstName(String lname, String fname) {
			
			return repository.findByLnameOrFname(lname, fname);
		}

		@Override
		public List<Employee> findByAgeLessThan(int age) {
		
			return repository.findByAgeLessThan(age);
		}

		@Override
		public List<Employee> findByAgeLessThanEqual(int age) {
			
			return  repository.findByAgeGreaterThanEqual(age);
		}

		@Override
		public List<Employee> findByAgeGreaterThan(int age) {
			
			return repository.findByAgeGreaterThan(age);
		}
		
		

	
}