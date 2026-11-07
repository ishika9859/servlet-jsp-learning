package com.ishika;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/user")
public class ageFilter extends HttpFilter implements Filter {
  

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		int age = Integer.parseInt(req.getParameter("age"));
		
		if(age>1)
			chain.doFilter(request, response);
		else {
			PrintWriter out = response.getWriter();
			out.println("Invalid Input : negative age");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
