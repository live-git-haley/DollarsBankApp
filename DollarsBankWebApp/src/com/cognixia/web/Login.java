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

@WebServlet("/Login")
public class Login extends HttpServlet{
	Long id;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Got into servlet>>>>>");
		String email = req.getParameter("email");
		String password = req.getParameter("pwd");

		HttpSession httpSession = req.getSession();
		CustomerRepo repo = new CustomerRepo();
		TransactionRepo repo2 = new TransactionRepo();

		
		DollarsBankController controller = new DollarsBankController();
		
		List<Customer> list = repo.getCustomers("getMany", -1L);
		Customer current = controller.login(list, email, password);

		
		if(current.getLastName()!= "NA") {
			
			req.getSession().setAttribute("name",current.getFirstName());
			req.getSession().setAttribute("id",current.getId());
			id = current.getId();
		

		}
		
		double currentAmount = repo2.makeTransaction(id, 0.0, "deposit");
		
		String parsed = Double.toString(currentAmount);
		
		
		req.getSession().setAttribute("currentAmount",parsed);
//		RequestDispatcher requestDispatcher = req.getRequestDispatcher("LoggedInPage.jsp");
//		requestDispatcher.forward(req, resp);
//		
		resp.sendRedirect("LoggedInPage.jsp");
		
		
//		RequestDispatcher requestDispatcher = req.getRequestDispatcher("add-sport.html");
		// resp.sendRedirect("added-product.jsp");
	}

}


