package com.cognixia.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cognixia.controller.DollarsBankController;
import com.cognixia.model.Customer;
import com.cognixia.repo.CustomerRepo;
import com.cognixia.repo.DepositRepo;

@WebServlet("/Deposit")
public class Deposit extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String amount = req.getParameter("amount");
	
	double amount2 = Double.parseDouble(amount);
	
	System.out.println(amount);
	HttpSession httpSession = req.getSession();
	DepositRepo repo = new DepositRepo();

	
	
	repo.makeDeposit(2L, amount2);

	
	
	}

}


