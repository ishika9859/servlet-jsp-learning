package com.ishika;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.net.httpserver.HttpServer;

@WebServlet("/sq")
public class SqServlet extends HttpServlet {
	public void doGet(HttpServletRequest req , HttpServletResponse res) throws IOException {
		
//		int k = Integer.parseInt(req.getParameter("k"));  //return an object that's why typeCasting to integer
		
//		HttpSession session = req.getSession();
//		int k = (int)session.getAttribute("val");
//		k = k*k;
//		PrintWriter out = res.getWriter();
//		out.println("square is  :" + k);
		
		
		int k = 0;
		Cookie cookies[] = req.getCookies();
		for(Cookie c : cookies) {
			if(c.getName().equals("val")) {
				k = Integer.parseInt(c.getValue());
			}
		}
		k = k*k;
		PrintWriter out = res.getWriter();
		out.println("square is  :" + k);
		
		
		
//		PrintWriter out = res.getWriter();
//		out.println("square is called");
	}
}
