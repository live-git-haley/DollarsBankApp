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
import com.cognixia.model.Transactions;
import com.cognixia.repo.CustomerRepo;
import com.cognixia.repo.TransactionRepo;

@WebServlet("/TransactionInfo")
public class TransactionInfo extends HttpServlet{
	double newAmount = 0.0;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	
	HttpSession httpSession = req.getSession();
	Object id = httpSession.getAttribute("id");
	Long longID  = Long.parseLong(id.toString());
	TransactionRepo repo = new TransactionRepo();

	List<Transactions> list = repo.getTransactionsById(longID);
	
	httpSession.setAttribute("history", list);

	resp.sendRedirect("HistoryPage.jsp");

	
	}

}


