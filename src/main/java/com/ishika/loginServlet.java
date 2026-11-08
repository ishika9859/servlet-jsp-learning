package com.ishika;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class loginServlet extends HttpServlet{
	public void doGet(HttpServletRequest req , HttpServletResponse res) throws IOException {
		String uname = req.getParameter("uname");
		String password = req.getParameter("pass");
		
		if(uname.equals("ishika") && password.equals("JavaEngineer")) {
			HttpSession session = req.getSession();
			session.setAttribute("username", uname);
			res.sendRedirect("welcome");
		}
		else 
			res.sendRedirect("login.html");
		
	}
}
