package com.cognixia.web;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognixia.model.Customer;
import com.cognixia.repo.CustomerRepo;

@WebServlet("/Welcome")
public class WelcomeServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter printWriter = resp.getWriter();
		printWriter.println("Welcome to the world of servlets!");
		
		System.out.println("Before entering repo...");
		
	
	}

}
