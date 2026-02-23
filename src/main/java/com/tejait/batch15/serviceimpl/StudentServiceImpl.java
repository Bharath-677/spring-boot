package com.tejait.batch15.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tejait.batch15.model.Student;

import com.tejait.batch15.repository.StudentRepository;
import com.tejait.batch15.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository repository;
	
	@Override
	public Student saveStudent(Student student) {
		
		student.setFullname(student.getFname().concat(" "+student.getLname()));
		
		return repository.save(student) ;
	}

	@Override
	public void deleteStudent(Integer id) {
		repository.deleteById(id);
		
	}

	@Override
	public Optional<Student> getByStudentId(Integer id) {
		
		return repository.findById(id);
	}

	@Override
	public List<Student> getAll() {
		
		return repository.findAll();
	}


	
	
}
