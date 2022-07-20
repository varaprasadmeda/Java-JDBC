package com.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectExample {
	
	public static void main(String[] args) {
		
		System.out.println("-------> Fetching Employee Records ---------->");
		Connection con = getConnection();
		System.out.println("Connection object created successfully");
		Statement stmt;
		try {
			stmt = con.createStatement();
			System.out.println("Statement object created successfully");
			ResultSet rs = stmt.executeQuery("select * from JDBC_PRACTICE.EMPLOYESS");
			
			//Retrieving purpose
			while (rs.next()) {
				int employeeId = rs.getInt("EMPLOYEE_ID");
				String firstName = rs.getString("FIRST_NAME");
				String lastName = rs.getString("LAST_NAME");
				String email = rs.getString("EMAIL");
				long PhoneNumber = rs.getLong("PHONE_NUMBER");
				String hire_Date = rs.getString("HIRE_DATE");
				float salary = rs.getFloat("SALARY");

				
				System.out.println("EmployeeID : " + employeeId + " " + " firstName : " + firstName + " " + " lastName : "
						+ lastName + " " + " email :" + email + " " + " Address : " + PhoneNumber+" HIRE_DATE : " + hire_Date
						+"salary : "+salary);
			}
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
