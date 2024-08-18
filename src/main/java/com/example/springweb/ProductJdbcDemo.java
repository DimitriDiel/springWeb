package com.example.springweb;

import com.example.springweb.entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductJdbcDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        List<Product> products = new ArrayList<>();

        Connection conn = null;
        Statement stmt = null;

        Class.forName("com.mysql.cj.jdbc.Driver");

        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/springweb", "root","root");

        stmt = conn.createStatement();
        String sql = "CREATE TABLE products (id INT PRIMARY KEY, name VARCHAR(50), description VARCHAR(50), category VARCHAR(50), price DECIMAL(10,2), quantity INT)";
        stmt.execute(sql);

        String sqlRequest1 = "INSERT INTO products VALUES(1, 'iPhone 15', 'mobile phone Apple', 'Phones', 1500, 10)";
        String sqlRequest2 = "INSERT INTO products VALUES(2, 'Samsung', 'mobile phone Samsung', 'Phones', 1300, 5)";
        String sqlRequest3 = "INSERT INTO products VALUES(3, 'iPad', 'tablet Apple', 'Tablets', 1800, 7)";
        String sqlRequest4 = "INSERT INTO products VALUES(4, 'Lenovo', 'laptop Lenovo', 'Laptops', 1000, 3)";

        stmt.execute(sqlRequest1);
        stmt.execute(sqlRequest2);
        stmt.execute(sqlRequest3);
        stmt.execute(sqlRequest4);

        ResultSet rs = stmt.executeQuery("SELECT * FROM products");

        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String description = rs.getString("description");
            String category = rs.getString("category");
            int price = rs.getInt("price");
            int quantity = rs.getInt("quantity");
            Product product = new Product(id, name, description, category, price, quantity);
            products.add(product);
        }
        for (Product product : products) {
            System.out.println(product);
        }
        stmt.close();
        conn.close();

    }
}
