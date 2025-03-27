package com.alekhya.daoclasses;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.alekhya.connection.dbcon;

public class DashBoardDao{

    public static int getTotalProducts() throws ClassNotFoundException {
        String query = "SELECT COUNT(*) FROM products";
        return getIntValue(query);
    }

    public static double getTotalSales() throws ClassNotFoundException {
        String query = "SELECT SUM(quantity * selling_price) FROM sales";
        return getDoubleValue(query);
    }

    public static double getTotalProfit() throws ClassNotFoundException {
        String query = "SELECT SUM(s.quantity * (s.selling_price - p.purchase_price)) FROM sales s JOIN products p ON s.product_id = p.id";
        return getDoubleValue(query);
    }

    private static int getIntValue(String query) throws ClassNotFoundException {
        try (Connection conn = dbcon.getcon();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private static double getDoubleValue(String query) throws ClassNotFoundException {
        try (Connection conn = dbcon.getcon();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getDouble(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0.0;
    }
}