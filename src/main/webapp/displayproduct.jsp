<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List, com.alekhya.dtoclasses.ProductDto" %>
<%
    List<ProductDto> products = (List<ProductDto>) request.getAttribute("products");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Product List</title>
    <style>
        body { font-family: Arial, sans-serif; background: #f4f4f4; text-align: center; }
        .container { width: 80%; margin: auto; background: white; padding: 20px; border-radius: 10px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th, td { padding: 10px; border: 1px solid #ddd; text-align: center; }
        th { background: #007bff; color: white; }
        tr:nth-child(even) { background: #f9f9f9; }
        a { text-decoration: none; color: white; padding: 5px 10px; border-radius: 5px; }
        .edit { background: #28a745; }
        .delete { background: #dc3545; }
    </style>
</head>
<body>

    <div class="container">
        <h2>Product List</h2>

        <% if (products == null || products.isEmpty()) { %>
            <p>No products available.</p>
        <% } else { %>

        <table>
            <tr>
                <th>ID</th>
                <th>Category</th>
                <th>Name</th>
                <th>Purchase Price</th>
                <th>Selling Price</th>
                <th>Stock Quantity</th>
                <th>Added Date</th>
                <th>Actions</th>
            </tr>

            <% for (ProductDto product : products) { %>
                <tr>
                    <td><%= product.getId() %></td>
                    <td><%= product.getCategory() %></td>
                    <td><%= product.getName() %></td>
                    <td><%= product.getPurchasePrice() %></td>
                    <td><%= product.getSellingPrice() %></td>
                    <td><%= product.getStockQuantity() %></td>
                    <td><%= product.getAddedDate() %></td>
                    <td>
                        <a class="edit" href="editProduct.jsp?id=<%= product.getId() %>">Edit</a>
                        <a class="delete" href="ProductServlet?action=delete&id=<%= product.getId() %>" onclick="return confirm('Are you sure?');">Delete</a>
                    </td>
                </tr>
            <% } %>
        </table>

        <% } %> <!-- End of if-else -->
    </div>

</body>
</html>

