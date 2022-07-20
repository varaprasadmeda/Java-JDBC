package com.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteEmployeeRecordExample {

	public static void main(String[] args) {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "admin");
			System.out.println("Connection established successfully");
			Statement stmt = con.createStatement();
			System.out.println("Statement object created successfully");
			
			//Deleting purpose
			String sql = "Delete from java_practice.Employees where EMPLOYEE_ID =10005";
			stmt.executeUpdate(sql);
			System.out.println("Database Deletion successfully");			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}

}
