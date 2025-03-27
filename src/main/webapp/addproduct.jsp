<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Product</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            background: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            width: 350px;
        }
        h2 {
            text-align: center;
            color: #333;
        }
        label {
            font-weight: bold;
            display: block;
            margin: 10px 0 5px;
        }
        input, select {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        button {
            width: 100%;
            padding: 10px;
            background: #28a745;
            color: white;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
        }
        button:hover {
            background: #218838;
        }
    </style>
</head>
<body>

    <div class="container">
        <h2>Add Product</h2>
        <form action="ProductServlet" method="post">
            <input type="hidden" name="action" value="add">
            
            <label for="category">Category</label>
            <input type="text" name="category" required><br>
            

            <label for="name">Product Name</label>
            <input type="text" id="name" name="name" required>

            <label for="purchase_price">Purchase Price</label>
            <input type="number" id="purchase_price" name="purchase_price" step="0.01" required>

            <label for="selling_price">Selling Price</label>
            <input type="number" id="selling_price" name="selling_price" step="0.01" required>

            <label for="stock_quantity">Stock Quantity</label>
            <input type="number" id="stock_quantity" name="stock_quantity" required>

            <button type="submit">Add Product</button>
        </form>
    </div>

</body>
</html>

