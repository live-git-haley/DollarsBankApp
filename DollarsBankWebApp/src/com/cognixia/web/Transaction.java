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
import com.cognixia.model.Account;
import com.cognixia.model.Customer;
import com.cognixia.repo.AccountRepo;
import com.cognixia.repo.CustomerRepo;
import com.cognixia.repo.TransactionRepo;

@WebServlet("/Transaction")
public class Transaction extends HttpServlet{
	double newAmount = 0.0;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String amount = req.getParameter("amount");
	String action = req.getParameter("action");
	
	String accountType = req.getParameter("accountType");
		
	double amount2 = Double.parseDouble(amount);
	
	System.out.println(amount);
	HttpSession httpSession = req.getSession();
	Object id = httpSession.getAttribute("id");
	Long longID  = Long.parseLong(id.toString());
	TransactionRepo repo = new TransactionRepo();
	AccountRepo repo2 = new AccountRepo();

	System.out.println("Action is>>> " + action);
	switch(action){
	
	case "withdraw":
		newAmount = repo.makeTransaction(longID, amount2, "withdraw", accountType);
		break;

	case "deposit":
		 newAmount = repo.makeTransaction(longID, amount2, "deposit", accountType);
		break;

	case "transfer":
		newAmount = repo.makeTransaction(longID, amount2, "transfer", accountType);
		break;
	}
	
	
	
	
	Account checkings = repo2.getAccount("checking", longID);
	Account savings = repo2.getAccount("saving", longID);

	
	
	String currentChecking = Double.toString(checkings.getAmount());
	String currentSavings = Double.toString(savings.getAmount());
	
	if(newAmount == -1.0) {
		resp.sendRedirect("insufficientFunds.jsp");
		
	}
	else {
	
	req.getSession().setAttribute("currentChecking",currentChecking);
	req.getSession().setAttribute("currentSavings",currentSavings);


	
	
	
//	RequestDispatcher requestDispatcher = req.getRequestDispatcher("LoggedInPage.jsp");
//	requestDispatcher.forward(req, resp);
//	
	
	
	resp.sendRedirect("LoggedInPage.jsp");

	}
	}

}


