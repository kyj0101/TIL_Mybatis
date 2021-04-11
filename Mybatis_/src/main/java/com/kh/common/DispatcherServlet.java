package com.kh.common;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.common.exception.ControllerNotFoundException;
import com.kh.common.exception.MethodNotAllowedException;


@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet{
	Properties prop = new Properties();
	Map<String, AbstractController> urlMap = new HashMap<>();
	
	@Override
	public void init() throws ServletException {
		String fileName = DispatcherServlet.class.getResource("/url.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		Set<String> keys = prop.stringPropertyNames();
		for(String key : keys) {
			String value = prop.getProperty(key);
			
			try {
				Class clazz = Class.forName(value);
				Object clazzInstance = clazz.newInstance();
				
				if(clazzInstance instanceof AbstractController) {
					AbstractController controller = (AbstractController)clazzInstance;
					urlMap.put(key, controller);
				}
				
				
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI(); ///ex)/Mybatis_/student/studentEnroll.do
		int beginIndex = request.getContextPath().length(); //ex)9
		String url = uri.substring(beginIndex); //ex)/student/studentEnroll.do
		
		AbstractController controller = urlMap.get(url);
		if(controller == null) {
			throw new ControllerNotFoundException();
		}
		
		String viewName = null;
		String method = request.getMethod(); //GET or POST
		
		if("GET".equals(method)) {
			viewName = controller.doGet(request, response);
		}else if("POST".equals(method)) {
			viewName = controller.doPost(request, response);
		}else{
			throw new MethodNotAllowedException(method);
		}
		
		if(viewName != null) {

			if(viewName.startsWith("redirect:")) {
				String location = request.getContextPath()
								+ viewName.replace("redirect:", "");
				response.sendRedirect(location);
			}else {
				String prefix = "/WEB-INF/views";
				String suffix = ".jsp";
				viewName = prefix + viewName + suffix;
				
				request.getRequestDispatcher(viewName)
					   .forward(request, response);
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	
}
