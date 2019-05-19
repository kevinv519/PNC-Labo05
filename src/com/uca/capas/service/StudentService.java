package com.uca.capas.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Student;

public interface StudentService {
	List<Student> getStudentList();
	
	Student getStudentById(Integer code);
	
	void saveStudent(Student student)throws DataAccessException;
	
	void deleteStudent(Student student) throws DataAccessException;
}
