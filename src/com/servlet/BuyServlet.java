package com.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
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
		
		// First determine if there is a customerBid, and if it is good or too low
		boolean goodBid = false;
		if (request.getParameter("customerBid") != null && !request.getParameter("customerBid").equals("")) {
			// Get their bid from the form
			double customerBid = Double.parseDouble(request.getParameter("customerBid"));

			// Determine MINIMUM BID allowed for this car
			Car carToBuy = (Car) session.getAttribute("carToBuy");
			double minBid = carToBuy.getPrice() - carToBuy.getPrice() * .1;
			
			if (customerBid >= minBid) {
				goodBid = true;
			}
		}
		
		// If there is no customerBid parameter on the request OR it is left empty OR the customerBid is high enough:
		if (request.getParameter("customerBid") == null || request.getParameter("customerBid").equals("") || goodBid == true){
			
			// Send to CONFIRMATION, remove car from inventory, add transaction to the report
			
			// Get the car inventory and current car from the session
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
					
			// Reset just in case
			session.setAttribute("lowBid", false);
			
			// Forward to confirmation page
			RequestDispatcher rs = request.getRequestDispatcher("confirmation.jsp");
			rs.forward(request, response);

		// If there IS a customerBid parameter on the request, but it is too low:
		} else if (request.getParameter("customerBid") != null) {
			
			// Resend to buy page with error message
			session.setAttribute("lowBid", true);
			RequestDispatcher rs = request.getRequestDispatcher("buy.jsp");
			rs.forward(request, response);
			
		} // End if
	} // End doGet

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
