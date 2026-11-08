package com.ishika;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class logoutServlet extends HttpServlet{
	public void doGet(HttpServletRequest req , HttpServletResponse res) throws IOException {
		HttpSession session = req.getSession();
		session.removeAttribute("username");
		session.invalidate();
		res.sendRedirect("login.html");
		
	}
}

