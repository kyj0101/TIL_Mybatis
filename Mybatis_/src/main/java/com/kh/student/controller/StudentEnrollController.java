package com.kh.student.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.common.AbstractController;
import com.kh.student.model.service.IStudentService;
import com.kh.student.model.service.StudentService;

public class StudentEnrollController extends AbstractController{
	private IStudentService studentService = new StudentService();
	
	@Override
	public String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return "/student/studentEnroll";
	}

	@Override
	public String doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");

		Map<String, Object> studentMap = new HashMap<>();
		studentMap.put("name", name);
		studentMap.put("tel", tel);
		
		int result = studentService.insertStudent(studentMap);
		String msg = (result > 0) ? "학생 등록을 성공했습니다." : "학생 등록을 실패했습니다.";
		
		request.getSession().setAttribute("msg", msg);
		return "redirect:/student/studentEnroll.do";
	}
	
}
