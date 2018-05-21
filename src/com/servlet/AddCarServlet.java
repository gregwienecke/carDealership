package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import car.Car;

/**
 * Servlet implementation class AddCarServlet
 */
@WebServlet("/AddCarServlet")
public class AddCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);

		//Constructor: public Car(String year, String make, String model, double price, long mileage, int mpg, String engine, String transmission, boolean isNew) {
		String year = request.getParameter("year");
		String make = request.getParameter("make");
		String model = request.getParameter("model");
		double price = Double.parseDouble(request.getParameter("price"));
		long mileage = Long.parseLong(request.getParameter("mileage"));
		int mpg = Integer.parseInt(request.getParameter("mpg"));
		String engine = request.getParameter("engine");
		String transmission = request.getParameter("transmission");
		boolean isNew = Boolean.parseBoolean(request.getParameter("isNew"));
		String photo = request.getParameter("photo");
		
		ArrayList<Car> cars = (ArrayList<Car>) session.getAttribute("cars");

		Car newCar = new Car(year, make, model, price, mileage, mpg, engine, transmission, isNew);
		newCar.setPhoto(photo);
		newCar.setCarId(cars.size()+1);
		
		cars.add(newCar);
		
		RequestDispatcher rs = request.getRequestDispatcher("admin.jsp");
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
