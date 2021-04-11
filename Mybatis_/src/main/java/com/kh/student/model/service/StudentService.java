package com.kh.student.model.service;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.student.model.dao.IStudentDAO;
import com.kh.student.model.dao.StudentDAO;

import static com.kh.common.SqlSessionTemplate.*;
public class StudentService implements IStudentService{
	private IStudentDAO studentDAO = new StudentDAO();
	
	@Override
	public int insertStudent(Map<String, Object> studentMap) {
		SqlSession session = getSqlSession();
		int result = 0;
		
		try {
			result = studentDAO.insertStudent(session, studentMap);
			session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		
		return result;
	}
	
}
