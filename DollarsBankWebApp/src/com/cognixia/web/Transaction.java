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

@WebServlet("/Transaction")
public class Transaction extends HttpServlet{
	double newAmount = 0.0;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String amount = req.getParameter("amount");
	String action = req.getParameter("action");
	
	System.out.println("Action required from form>>>> " + action);
	
	double amount2 = Double.parseDouble(amount);
	
	System.out.println(amount);
	HttpSession httpSession = req.getSession();
	Object id = httpSession.getAttribute("id");
	System.out.println("This is the id retrieved" + id.toString());
	Long longID  = Long.parseLong(id.toString());
	TransactionRepo repo = new TransactionRepo();

	if(action.equals("deposit")) {
		 newAmount = repo.makeTransaction(longID, amount2, "deposit");
		
	}
	else {
		newAmount = repo.makeTransaction(longID, amount2, "withdraw");
	}
	
	String newAmount2 = Double.toString(newAmount);
	httpSession.setAttribute("currentAmount", newAmount2);
	
//	RequestDispatcher requestDispatcher = req.getRequestDispatcher("LoggedInPage.jsp");
//	requestDispatcher.forward(req, resp);
//	
	
	
	resp.sendRedirect("LoggedInPage.jsp");

	}

}


