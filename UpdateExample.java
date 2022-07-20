package com.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateExample {

	public static void main(String[] args) {
		System.out.println("-------> Fetching Employee Records ---------->");
		Connection con = getConnection();
		Statement stmt;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "admin");
			System.out.println("Connection established successfully");
			stmt = con.createStatement();
			System.out.println("Statement object created successfully");

			// Updating Record
			String sql = "update JDBC_PRACTICE.EMPLOYEES set email ='gopi.yadav@gmail.com' where EMPLOYEE_ID =10006";
			stmt.executeUpdate(sql);
			System.out.println("Database updated successfully");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Connectivity Logic
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "admin");
			System.out.println("Connection established successfully");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

}
