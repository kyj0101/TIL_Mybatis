package com.kh.student.model.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class StudentDAO implements IStudentDAO{

	@Override
	public int insertStudent(SqlSession session, Map<String, Object> studentMap) {
		return session.insert("student.insertStudent",studentMap);
	}
	
}
