package com.kh.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.common.exception.MethodNotAllowedException;

public abstract class AbstractController {
	
	public String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		 throw new MethodNotAllowedException();
	}
	
	public String doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		 throw new MethodNotAllowedException();
	}
}
