package com.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
			
		// No database yet, so creating a mock inventory here
		// Constructor: String year, String make, String model, double price, long mileage, int mpg, String engine, String transmission, boolean isNew
		Car car1 = new Car("2018", "Toyota", "Camry", 23495, 7, 40, "V8", "Automatic", true);
		car1.setPhoto("photos/camry.png");
		car1.setCarId(1);
		
		Car car2 = new Car("2015", "Honda", "Civic", 11209, 44042, 35, "6-Cylinder", "Manual", false);
		car2.setPhoto("photos/civic.png");
		car2.setCarId(2);

		Car car3 = new Car("2002", "VW", "Jetta", 4900, 7, 22, "6-Cylinder", "Manual", false);
		car3.setPhoto("photos/jetta.jpg");
		car3.setCarId(3);

		Car car4 = new Car("2018", "Toyota", "Corolla", 18600, 6, 31, "4-Cylinder", "Automatic", true);
		car4.setPhoto("photos/corolla.png");
		car4.setCarId(4);

		Car car5 = new Car("2016", "Honda", "Accord", 18000, 24097, 40, "V8", "Automatic", false);
		car5.setPhoto("photos/accord.png");
		car5.setCarId(5);

		Car car6 = new Car("2018", "VW", "Golf", 20999, 1, 32, "V8", "Automatic", true);
		car6.setPhoto("photos/golf.png");
//		car6.setDealerPurchaseDateStringTest("Test");
		car6.setCarId(6);

		Car car7 = new Car("2018", "Hyundai", "Santa Fe", 30000, 10, 29, "V8", "Automatic", true);
		car7.setPhoto("photos/santafe.png");
//		car7.setDealerPurchaseDateStringTest("Test");
		car7.setCarId(7);

		Car car8 = new Car("2017", "Hyundai", "Elantra", 20000, 20000, 40, "V8", "Automatic", false);
		car8.setPhoto("photos/elantra.png");
//		car8.setDealerPurchaseDateStringTest("Test");
		car8.setCarId(8);

		Car car9 = new Car("2016", "Ford", "Focus", 18000, 31233, 35, "6-Cylinder", "Manual", false);
		car9.setPhoto("photos/focus.png");
		car9.setCarId(9);

		Car car10 = new Car("2018", "Lamborghini", "Aventador", 412995, 7, 16, "V12", "Automatic", true);
		car10.setPhoto("photos/aventador.png");			
		car10.setCarId(10);
		
		Car car11 = new Car("2018", "Lamborghini", "Aventador", 412995, 4, 16, "V12", "Automatic", true);
		car11.setPhoto("photos/aveGray.png");			
		car11.setCarId(11);

		ArrayList<Car> cars = new ArrayList<Car>();
		cars.add(car1);
		cars.add(car2);
		cars.add(car3);
		cars.add(car4);
		cars.add(car5);
		cars.add(car6);
		cars.add(car7);
		cars.add(car8);
		cars.add(car9);
		cars.add(car10);
		cars.add(car11);
		
		// Set the purchase date for all cars
		for (Car car : cars) {
			// Set three cars to have older purchase date to test the bidding functionality
			if (car.getCarId() == 3 || car.getCarId() == 5 || car.getCarId() == 9) {
				try {
					car.setDealerPurchaseDate(sdf.parse("11/22/2017"));
				} catch (ParseException e) {
					e.printStackTrace();
				}				
			// Set the rest of the cars to have recent purchase date
			} else {
				try {
					car.setDealerPurchaseDate(sdf.parse("05/29/2018"));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		// Set a Car inventory and Transaction report on the session
		HttpSession session = request.getSession(true);
		session.setAttribute("cars", cars);
		ArrayList<Transaction> report = new ArrayList<Transaction>();
		session.setAttribute("report", report);
		
		
		if (userName.equals("admin") && password.equals("testpw")) {
			boolean admin = true;
			session.setAttribute("admin", admin);
			RequestDispatcher rs = request.getRequestDispatcher("admin.jsp");
			rs.forward(request, response);	
		} else if (userName.equals("user") && password.equals("testpw")) {
			boolean admin = false;
			session.setAttribute("admin", admin);
			RequestDispatcher rs = request.getRequestDispatcher("home.jsp");
			rs.forward(request, response);	
		} else {
			RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
			rs.forward(request, response);	
		}
		
	}

}
