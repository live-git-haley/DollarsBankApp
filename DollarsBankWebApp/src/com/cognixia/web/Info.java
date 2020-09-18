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
import com.cognixia.repo.TransactionRepo;

@WebServlet("/Info")
public class Info extends HttpServlet{
	double newAmount = 0.0;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	HttpSession httpSession = req.getSession();
	Object id = httpSession.getAttribute("id");
	Long longID  = Long.parseLong(id.toString());
	CustomerRepo repo = new CustomerRepo();
	List<Customer> customer = repo.getCustomers("getOne", longID);
	
	for(Customer c: customer) {
		httpSession.setAttribute("firstName", c.getFirstName());
		httpSession.setAttribute("lastName", c.getLastName());
		httpSession.setAttribute("email", c.getEmail());
		httpSession.setAttribute("dob", c.getDob());

		
		
	}

	
	resp.sendRedirect("InfoPage.jsp");
	
	}

}


