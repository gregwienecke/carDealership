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
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		session.setAttribute("modelSearch", request.getParameter("modelSearch"));
		
		ArrayList<Car> cars = (ArrayList<Car>) session.getAttribute("cars");
		ArrayList<Car> matches = new ArrayList<Car>();

		String modelSearch = request.getParameter("modelSearch");
		modelSearch = modelSearch.toUpperCase();
		
		for (Car car : cars) {
			if(car.getModel().toUpperCase().equals(modelSearch)) {
				matches.add(car);
			}
		}
		
		session.setAttribute("matches", matches);
		
		RequestDispatcher rs = request.getRequestDispatcher("searchResults.jsp");
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
