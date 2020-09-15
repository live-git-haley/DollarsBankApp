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

@WebServlet("/Login")
public class Login extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Got into servlet>>>>>");
		String email = req.getParameter("email");
		String password = req.getParameter("pwd");
		System.out.println(email);
		System.out.println(password);
		HttpSession httpSession = req.getSession();
		CustomerRepo repo = new CustomerRepo();
		
		
		
		DollarsBankController controller = new DollarsBankController();
		
		List<Customer> list = repo.getCustomers();
		Customer current = controller.login(list, email, password);

		
		if(current.getLastName()!= "NA") {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("LoggedIn.jsp");
			req.getSession().setAttribute("name",current.getFirstName());
			System.out.println(current.getFirstName());
			requestDispatcher.forward(req, resp);

		}
		
		
		
		
		
		
//		RequestDispatcher requestDispatcher = req.getRequestDispatcher("add-sport.html");
		// resp.sendRedirect("added-product.jsp");
	}

}


