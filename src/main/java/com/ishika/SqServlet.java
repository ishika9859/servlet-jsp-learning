package com.ishika;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.net.httpserver.HttpServer;

public class SqServlet extends HttpServlet {
	public void doGet(HttpServletRequest req , HttpServletResponse res) throws IOException {
		
		int k = (int)req.getAttribute("k");  //return an object that's why typeCasting to integer
		k = k*k;
		PrintWriter out = res.getWriter();
		out.println("square is  :" + k);
	}
}
