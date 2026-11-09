package com.ishika;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/welcome")
public class welcome extends HttpServlet{
	public void doGet(HttpServletRequest req , HttpServletResponse res) throws IOException {
		
		res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		HttpSession session = req.getSession(false);
		if(session == null || session.getAttribute("username")==null) {
			res.sendRedirect("login.html");
		}
		
		PrintWriter out = res.getWriter();
		out.println("Welcome " + session.getAttribute("username"));
		res.setContentType("text/html");
		out.println("<a href='video'>Go to Video Section</a>");
		out.println("<form action='logout' ><input type='submit' value='LogOut'></form>");
		
	}
}
