package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {

	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;

	@Override
	public List<Student> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM public.student ORDER BY id_student");
		Query query = entityManager.createNativeQuery(sb.toString(), Student.class);
		List<Student> result = query.getResultList();
		return result;
	}

	@Override
	public Student findOne(Integer code) throws DataAccessException {
		Student student = entityManager.find(Student.class, code);
		return student;
	}

	@Override
	public int save(Student s, Integer newRow) throws DataAccessException {
		if (newRow == 1)  entityManager.persist(s);
		else entityManager.merge(s);
		entityManager.flush();
		return 1;
	}

	@Override
	public int delete(Student s) throws DataAccessException {
		entityManager.remove(entityManager.contains(s)? s : entityManager.merge(s));
		entityManager.flush();
		return 0;
	}

}