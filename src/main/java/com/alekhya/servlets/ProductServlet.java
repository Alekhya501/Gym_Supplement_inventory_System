package com.alekhya.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.io.IOException;
import java.sql.Timestamp;

import com.alekhya.daoclasses.ProductDao;
import com.alekhya.dtoclasses.ProductDto;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Get form data
		String category = request.getParameter("category");
		String name = request.getParameter("name");
		double purchasePrice = Double.parseDouble(request.getParameter("purchase_price"));
		double sellingPrice = Double.parseDouble(request.getParameter("selling_price"));
		int stockQuantity = Integer.parseInt(request.getParameter("stock_quantity"));
		Timestamp addedDate = new Timestamp(System.currentTimeMillis()); // Set current time

		// Create ProductDto object
		ProductDto product = new ProductDto();
		product.setCategory(category);
		product.setName(name);
		product.setPurchasePrice(purchasePrice);
		product.setSellingPrice(sellingPrice);
		product.setStockQuantity(stockQuantity);
		product.setAddedDate(addedDate);

		// Save product
		ProductDao productDao = new ProductDao();
		productDao.addProduct(product);
		 RequestDispatcher dispatcher = request.getRequestDispatcher("displayproduct.jsp");
	        dispatcher.forward(request, response);
	}
}
