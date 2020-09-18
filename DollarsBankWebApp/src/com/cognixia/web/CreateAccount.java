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
import com.cognixia.model.Count;
import com.cognixia.model.Customer;
import com.cognixia.repo.AccountRepo;
import com.cognixia.repo.CustomerRepo;
import com.cognixia.repo.TransactionRepo;

@WebServlet("/CreateAccount")
public class CreateAccount extends HttpServlet {
	static Long countID =1L;
	Count count = new Count();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String dob = req.getParameter("dob");
		String email = req.getParameter("email");
		String password = req.getParameter("pwd");
		String amount = req.getParameter("amount");
		Customer newCustomer = new Customer();
		AccountRepo repo2 = new AccountRepo();

		
		double initialAmount =  Double.parseDouble(amount);
		
		
		
		Long current = count.getCount();
		count.setCount(current +1L);
		System.out.println("Count before incremenert>>>>" + current);
		newCustomer.setFirstName(firstName);
		newCustomer.setLastName(lastName);
		newCustomer.setDob(dob);
		newCustomer.setEmail(email);
		newCustomer.setinitialAmount(initialAmount);
//		newCustomer.setId(count.getCount());
		newCustomer.setPassword(password);
		
		CustomerRepo repo = new CustomerRepo();
		
		System.out.println("count after increment>>:" + count.getCount());
		
		System.out.println(newCustomer.toString());
		
		repo.newCustomer(newCustomer, count);
		
		Account checkings = repo2.getAccount("checking", countID);
		Account savings = repo2.getAccount("saving", countID);

		
		
		String currentChecking = Double.toString(checkings.getAmount());
		String currentSavings = Double.toString(savings.getAmount());

		
		
		req.getSession().setAttribute("currentChecking",currentChecking);
		req.getSession().setAttribute("currentSavings",currentSavings);

		
		
		
		

//		RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
		resp.sendRedirect("index.jsp");
//		requestDispatcher.forward(req, resp);
		req.getSession().setAttribute("currentSavings",currentSavings);

	
	}

}
