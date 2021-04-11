package com.kh.student.model.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public interface IStudentDAO {
	public int insertStudent(SqlSession session, Map<String, Object> studentMap);
}
