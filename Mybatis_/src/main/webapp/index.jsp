<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Mybatis</title>
</head>
<body>
	<h1>Hello Mybatis</h1>
	<h2>Student</h2>
	<ul>
		<li><a href="${pageContext.request.contextPath}/student/studentEnroll.do">학생 등록</a></li>
		<li><a href="${pageContext.request.contextPath}/student/selectStudent.do">학생 조회</a></li>
		<li><a href="${pageContext.request.contextPath}/student/selectStudentList.do">학생 목록 조회</a></li>
	</ul>
	
	<h2>Employee</h2>
	<ul>
		<li><a href="${pageContext.request.contextPath}/emp/searchEmp1.do">사원 조회1</a></li>
		<li><a href="${pageContext.request.contextPath}/emp/searchEmp2.do">사원 조회2</a></li>
	</ul>
</body>
</html>