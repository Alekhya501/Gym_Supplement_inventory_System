package com.alekhya.daoclasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alekhya.connection.dbcon;
import com.alekhya.dtoclasses.ProductDto;

public class ProductDao {
	public void addProduct(ProductDto product) {
		try {
			Connection con=dbcon.getcon();
			String query="Insert into products(category,name,purchase_price,selling_price,stock_quantity,added_date) values(?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, product.getCategory());
			ps.setString(2, product.getName());
			ps.setDouble(3, product.getPurchasePrice());
			ps.setDouble(4, product.getSellingPrice());
			ps.setInt(5,product.getStockQuantity());
			ps.setTimestamp(6, product.getAddedDate());
			int i=ps.executeUpdate();
			if(i>0) {
				System.out.println("insertion successfull");
			}
			else {
				System.out.println("insertion unsuccessfull");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ProductDto getProductById(int id) {
		ProductDto product=null;
		try {
			Connection con=dbcon.getcon();
			String query="select * from products where id=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				product=new ProductDto(rs.getInt("id"),rs.getString("category"),rs.getString("name"),rs.getDouble("purchase_price"),rs.getDouble("selling_price"),
						rs.getInt("quantity"),rs.getTimestamp("added_date"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;
		
	}
	public List<ProductDto> getAllProducts() {
	    List<ProductDto> products = new ArrayList<>();
	    try {
	        Connection con = dbcon.getcon();
	        String query = "SELECT * FROM products";
	        PreparedStatement ps = con.prepareStatement(query);
	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {
	            ProductDto product = new ProductDto(
	                rs.getInt("id"),
	                rs.getString("category"),
	                rs.getString("name"),
	                rs.getDouble("purchase_price"),
	                rs.getDouble("selling_price"),
	                rs.getInt("stock_quantity"),
	                rs.getTimestamp("added_date")
	            );
	            products.add(product);
	        }

	        System.out.println("Total products fetched: " + products.size());
	        for (ProductDto p : products) {
	            System.out.println("ID: " + p.getId() + ", Name: " + p.getName());
	        }

	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }
	    return products;
	}


	public void updateProduct(ProductDto product) {
	    try {
	        Connection con = dbcon.getcon();
	        String query = "UPDATE products SET category = ?, name = ?, purchase_price = ?, selling_price = ?, stock_quantity = ?, added_date = ? WHERE id = ?";
	        PreparedStatement ps = con.prepareStatement(query);
	        
	        ps.setString(1, product.getCategory());
	        ps.setString(2, product.getName());
	        ps.setDouble(3, product.getPurchasePrice());
	        ps.setDouble(4, product.getSellingPrice());
	        ps.setInt(5, product.getStockQuantity());
	        ps.setTimestamp(6, product.getAddedDate()); 
	        ps.setInt(7, product.getId()); 
	        
	        int rowsUpdated = ps.executeUpdate();
	        if (rowsUpdated > 0) {
	            System.out.println("Product updated successfully.");
	        } else {
	            System.out.println("No product found with ID: " + product.getId());
	        }
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }
	}


}
