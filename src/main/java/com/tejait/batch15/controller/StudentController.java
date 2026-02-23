package com.tejait.batch15.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.tejait.batch15.model.Student;
import com.tejait.batch15.service.StudentService;

@RestController
@RequestMapping("/student")

public class StudentController {
	
	
	@Autowired
	StudentService service;
	
	@RequestMapping(value="saveStudent",method = RequestMethod.POST)
	public ResponseEntity<Student> saveStudentResponseEntity(@RequestBody Student student) {
		       Student saveStudent= service.saveStudent(student);
		       ResponseEntity<Student> response=new ResponseEntity<Student>(saveStudent, HttpStatus.CREATED);
		       
				return response;
		
	
	}
	
	@RequestMapping(value="updateStudent",method = RequestMethod.PUT)
	public ResponseEntity<Student> updateStudent(@RequestBody Student student){
		
		   Student updateStudent=service.saveStudent(student);
		
		return new ResponseEntity<Student>(updateStudent, HttpStatus.OK);
		
		
	}
	
	@RequestMapping(value="deleteStudentId/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteByStudentId(@PathVariable Integer id){
		
		service.deleteStudent(id);
		
		return new ResponseEntity<String>("delete Student ID", HttpStatus.OK);
	
	}
	
	@RequestMapping(value ="getByStudentId/{id}",method = RequestMethod.GET)
	public ResponseEntity<Student> getByStudentId(@PathVariable Integer id){
		
		      Optional<Student> Studentobj=service.getByStudentId(id);
		
		  	return new ResponseEntity<Student>(Studentobj.get(), HttpStatus.OK);
		
		
	}
	
	@RequestMapping(value="getAll",method = RequestMethod.GET)
	public ResponseEntity<List<Student>> getAll(){
		List<Student> list=service.getAll();
		
		
		
		return new ResponseEntity<List<Student>>(list,HttpStatus.OK);
		
		
		
		
	}
	
	
	
	
	

}
