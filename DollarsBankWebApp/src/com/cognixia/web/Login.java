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

@WebServlet("/Login")
public class Login extends HttpServlet{
	Long id;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("pwd");

		HttpSession httpSession = req.getSession();
		CustomerRepo repo = new CustomerRepo();
		AccountRepo repo2 = new AccountRepo();
		
		
		DollarsBankController controller = new DollarsBankController();
		
		List<Customer> list = repo.getCustomers("getMany", -1L);
		Customer current = controller.login(list, email, password);

		boolean redirect = false;
		if(current.getLastName()!= "NA") {
			
			req.getSession().setAttribute("name",current.getFirstName());
			req.getSession().setAttribute("id",current.getId());
			id = current.getId();
		

		}
		
		else {
			redirect = true;
			
		}
		
		
		Account checkings = repo2.getAccount("checking", id);
		Account savings = repo2.getAccount("saving", id);

		
		
		String currentChecking = Double.toString(checkings.getAmount());
		String currentSavings = Double.toString(savings.getAmount());

		
		
		req.getSession().setAttribute("currentChecking",currentChecking);
		req.getSession().setAttribute("currentSavings",currentSavings);

	
		if(redirect) {
			resp.sendRedirect("LoginError.jsp");
			
		}
		else {
		resp.sendRedirect("LoggedInPage.jsp");
		}
		

	}

}


