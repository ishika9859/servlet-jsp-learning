package com.ishika;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req , HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();
		out.println("Hi ");
		
//		ServletContext ctx = getServletContext();
//		String st = ctx.getInitParameter("name");
//		out.println(st);
		
		ServletConfig cfg = getServletConfig();
		String st = cfg.getInitParameter("name");
		out.println(st);
	}
}
