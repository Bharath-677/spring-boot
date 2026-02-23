
package com.tejait.batch15.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tejait.batch15.exceptions.DataNotFoundException;
import com.tejait.batch15.exceptions.IdNotFoundException;
import com.tejait.batch15.exceptions.MailAlredyExists;
import com.tejait.batch15.exceptions.MobileAlredyExists;
import com.tejait.batch15.model.Employee;
import com.tejait.batch15.service.EmployeeService;

import lombok.AllArgsConstructor;
 
@AllArgsConstructor
// @CrossOrigin
@RestController
@RequestMapping ("/employee")
  public class EmployeeController {
	
	     // @Autowired
	       EmployeeService service;
	
	 //  @RequestMapping(value="saveEmp", method=RequestMethod.POST)
	   @PostMapping("saveEmp")
	
	  public ResponseEntity<Employee> saveEmployeeEntity(@RequestBody Employee emp){	
       Employee	savedEmp =service.saveEmployee(emp);
      
     return new ResponseEntity<>(savedEmp, HttpStatus.CREATED);
	
		
	}
	   
	  // @RequestMapping(value="updateEmp",method = RequestMethod.PUT)
	   @GetMapping("updateEmp")
	   public ResponseEntity<Employee> updateEmployee( @RequestBody Employee emp){
		   
		   Employee updateEmployee=service.saveEmployee(emp);
		   
		 return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
		   
		   
	   }
	   
	 //  @RequestMapping(value="deleteEmp/{id}",method = RequestMethod.DELETE)
	   @GetMapping("deleteEmp/{id}")
	   public ResponseEntity<String> deleteByEmpId(@PathVariable Integer id){
		   
		   service.deleteEmployee(id);
		   
		   return new ResponseEntity<>("delete Employee ID", HttpStatus.OK);
		   
  	   }
	   
	  // @RequestMapping(value="getByEmpId/{id}",method = RequestMethod.GET)
	   @GetMapping("getByEmpId/{id}")
	   public ResponseEntity<Employee> getByEmpId( @PathVariable Integer id){
		   
		 Optional<Employee> empobj =service.getById(id);
		   
		return new ResponseEntity<>(empobj.get(), HttpStatus.OK);
		   
	   }
	   
	  // @RequestMapping(value ="getAll",method = RequestMethod.GET)
	   @GetMapping("getAll")
	   public ResponseEntity<List<Employee>> getAll(){
		   
		   List<Employee> list=service.getAllEmps();
		   for(Employee emp:list) {
			   System.out.println(emp);
		   }
		   
		return new ResponseEntity<>(list,HttpStatus.OK);
	
	   }
	   
	   @GetMapping("existingById/{id}")
	   public ResponseEntity<Boolean> existsByid(@PathVariable Integer id){
		   boolean result=service.existsById(id);
		   
		   if(!result) {
			  // throw new IdNotFoundException("given Id not Available")
			  // throw new MobileAlredyExists("given mobile num is alredy exists")
			 //  throw new MailAlredyExists("given mail alredy exists")
			 throw new  DataNotFoundException("unknown error occures"); 
		   }
		   
		return new ResponseEntity<>(result,HttpStatus.OK);   
	   }
	   @GetMapping("pagination")
	   public ResponseEntity<Page<Employee>> paginationData(@RequestParam int pageNum,@RequestParam int pagesize){
		  Page<Employee> page= service.getPaginationDate(pageNum,pagesize);
		   
		return new ResponseEntity<>(page, HttpStatus.OK);
	   
	   }
	   @GetMapping("dataSorting")
	   public ResponseEntity<List<Employee>> dataSorting(@RequestParam String property,@RequestParam String  orderType){
		   List<Employee> list=service.getBysortingData(property,orderType);
		return new ResponseEntity<>(list, HttpStatus.OK);
	
	   }
	   @GetMapping("findByDept/{dept}")
	   public ResponseEntity<List<Employee>> findByDept(@PathVariable String dept){
		   List<Employee>list=service.findByDept(dept);
		return new ResponseEntity<>(list, HttpStatus.OK);
	   
	   }
	   
	   @GetMapping("findByfname/{fname}")
	   public ResponseEntity<List<Employee>> findByfname(@PathVariable String fname){
		   List<Employee> list=service.findByfname(fname);
		   return new ResponseEntity<>(list, HttpStatus.OK);
		      
	   }
   @GetMapping("fullname")
     public ResponseEntity<List<Employee>> findByFnameAndLname(@RequestParam String fname, @RequestParam String lname){
	List<Employee> list=service.findByfnameAndlname(fname,lname);
	return new ResponseEntity<>(list, HttpStatus.OK);	
   }


    @GetMapping("distinctbydept")
   public ResponseEntity<List<String>> distinctbydept(){
	List<String> list=service.getdistinctByDept();
	return new ResponseEntity<>(list, HttpStatus.OK);
	
    }
    @GetMapping("search/{searchterm}")
  public ResponseEntity<List<Employee>> searchData(@PathVariable String searchterm){
	List<Employee> list=service.getsearchemployee(searchterm);
	return new ResponseEntity<>(list, HttpStatus.OK);
  }
    
    @GetMapping("searchFilters")
    public ResponseEntity<List<Employee>> searchFilters(@RequestParam String filterType,@RequestParam String empCode ){
    	List<Employee> list=service.searchFilters(filterType,empCode);
		return new ResponseEntity<>(list, HttpStatus.OK);
    	
    	
    }
    
    @GetMapping("findByLastNameOrFirstName")
	public ResponseEntity<List<Employee>>  findByLastNameOrFirstName(@RequestParam String lname, @RequestParam String fname){
    	
    	List<Employee> list=service.findByLastNameOrFirstName(lname, fname);
		
		
		return new ResponseEntity<>(list,HttpStatus.OK);
		
		
	}
  
     
     
     
     @GetMapping("findByAgeLessthan/{age}")
     public ResponseEntity<List<Employee>> findByAgeLessthan(@PathVariable int age){
    List<Employee>	list=service.findByAgeLessThan(age);
    
    return new ResponseEntity<>(list, HttpStatus.OK);
  	
     }
     
     
     @GetMapping("findByAgeLessThanEquals")
     public ResponseEntity<List<Employee>> findByAgeLessThanEqual(@RequestParam int age){
    	
    	 List<Employee> list = service.findByAgeLessThanEqual(age);
    	
		return new ResponseEntity<> (list, HttpStatus.OK);
		
     }
     @GetMapping("findByAgeGreaterThanEqual")
     public ResponseEntity<List<Employee>> findByAgeGreaterThanEqual (@RequestParam int age){
    	  
    	 List<Employee> list= service.findByAgeLessThanEqual(age);
    	
    	 return new ResponseEntity<> (list, HttpStatus.OK);
    	
     }
     @GetMapping("findByAgeGreaterThan")
     public ResponseEntity<List<Employee>> findByAgeGreaterThan(@RequestParam int age){
    	
    	        List<Employee>  list=service.findByAgeGreaterThan(age);
    	        
		return new ResponseEntity<> (list, HttpStatus.OK);
    
    
    
     }
		   
}
	   
	   
	
