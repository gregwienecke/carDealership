package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import car.Car;
import transaction.Transaction;

/**
 * Servlet implementation class BuyServlet
 */
@WebServlet("/BuyServlet")
public class BuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    // Buy the car, remove it from the inventory, and add it to the transaction report
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		ArrayList<Car> cars = (ArrayList<Car>) session.getAttribute("cars");
		Car boughtCar = (Car) session.getAttribute("carToBuy");
		
		// Remove the bought car from the inventory
		for (Car car : cars) {
			if (car == boughtCar) {
				cars.remove(car);
				session.setAttribute("cars", cars);
				break;
			}
		}	
		
		// Create a Transaction object
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		Date saleDate = new Date();
		Transaction newTransaction = new Transaction(firstName, lastName, saleDate, boughtCar);
		
		// Add the transaction to the report
		ArrayList<Transaction> report = (ArrayList<Transaction>) session.getAttribute("report");
		report.add(0, newTransaction);
		
		// For printing first name on the confirmation page
		session.setAttribute("firstName", firstName);
				
		RequestDispatcher rs = request.getRequestDispatcher("confirmation.jsp");
		rs.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
