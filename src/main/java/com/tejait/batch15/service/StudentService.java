package com.tejait.batch15.service;

import java.util.List;
import java.util.Optional;

import com.tejait.batch15.model.Student;

public interface StudentService {

 public 	Student saveStudent(Student student);

 public void deleteStudent(Integer id);

 public Optional<Student> getByStudentId(Integer id);

 public List<Student> getAll();





}
