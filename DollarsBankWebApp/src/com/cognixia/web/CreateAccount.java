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
import com.cognixia.repo.AccountRepo;
import com.cognixia.repo.CustomerRepo;
import com.cognixia.repo.TransactionRepo;

@WebServlet("/CreateAccount")
public class CreateAccount extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String dob = req.getParameter("dob");
		String email = req.getParameter("email");
		String password = req.getParameter("pwd");
		String amount = req.getParameter("amount");
		Customer newCustomer = new Customer();
		
		newCustomer.setFirstName(firstName);
		newCustomer.setLastName(lastName);
		newCustomer.setDob(dob);
		newCustomer.setEmail(email);
		newCustomer.setAmount(0.0);
		newCustomer.setId(11L);
		newCustomer.setPassword(password);
		
		AccountRepo repo = new AccountRepo();
		
		repo.newCustomer(newCustomer);
		
		

//		RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
		resp.sendRedirect("index.jsp");
//		requestDispatcher.forward(req, resp);

	
	
	}

}
