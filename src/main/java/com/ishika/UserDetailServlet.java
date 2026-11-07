package com.ishika;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user")
public class UserDetailServlet extends HttpServlet {
	public void doGet(HttpServletRequest req , HttpServletResponse res) throws IOException {
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		
		PrintWriter out = res.getWriter();
		out.println("Welcome " + name);
		out.println("Your age is "+ age);
	}

}
