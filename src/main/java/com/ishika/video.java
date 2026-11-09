package com.ishika;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/video")
public class video extends HttpServlet{
	public void doGet(HttpServletRequest req , HttpServletResponse res) throws IOException {
		HttpSession session = req.getSession();
		
		if(session.getAttribute("username")==null) {
			res.sendRedirect("login.html");
		}
		
		PrintWriter out = res.getWriter();
		out.println("<iframe width=\"560\" height=\"315\" "
				+ "src=\"https://www.youtube.com/embed/OuBUUkQfBYM?si=qJOBmBhNf63iASP7\" "
				+ "title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; "
				+ "autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; "
				+ "web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen>"
				+ "</iframe>");
		
	}
}
