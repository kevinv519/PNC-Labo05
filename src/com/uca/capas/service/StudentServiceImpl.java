package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.dao.StudentDAO;
import com.uca.capas.domain.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDAO studentDao;
	
	@Override
	public List<Student> getStudentList() {
		return studentDao.findAll();
	}

	@Override
	public Student getStudentById(Integer code) {
		return studentDao.findOne(code);
	}

	@Override
	@Transactional
	public void saveStudent(Student student) throws DataAccessException {
		studentDao.save(student, student.getcStudent() == null? 1: 0);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteStudent(Student student) throws DataAccessException {
		studentDao.delete(student);
	}

}
