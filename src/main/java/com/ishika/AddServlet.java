package com.ishika;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddServlet extends HttpServlet
{
	public void doGet(HttpServletRequest req , HttpServletResponse res) throws IOException, ServletException {
		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));
		int k = i + j ;
		
		
//		req.setAttribute("k", k);
//		RequestDispatcher rd = req.getRequestDispatcher("sq");
//		rd.forward(req, res);
		
		
//		res.sendRedirect("sq?k=" + k); // sending response to client to go to sq servlet (URL Rewriting)
		
//		HttpSession session = req.getSession();
//		session.setAttribute("val", k);
//		res.sendRedirect("sq");
		
		
		Cookie cookie = new Cookie("val" , k +"");
		res.addCookie(cookie);
		res.sendRedirect("sq");
		
	}
}
