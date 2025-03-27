package com.alekhya.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.alekhya.daoclasses.ProductDao;
import com.alekhya.dtoclasses.ProductDto;


@WebServlet("/DisplayProductServlet")
public class DisplayProductServlet extends HttpServlet {
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        ProductDao productDao = new ProductDao();
	        List<ProductDto> products = productDao.getAllProducts();

	        // Debugging
	        System.out.println("Fetched Products: " + products);

	        request.setAttribute("products", products);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("displayProducts.jsp");
	        dispatcher.forward(request, response);
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        doGet(request, response); // Calls doGet when a POST request is made
	    }
}
