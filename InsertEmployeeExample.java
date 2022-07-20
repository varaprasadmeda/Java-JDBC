package com.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class InsertEmployeeExample {

	public static void main(String[] args) throws ParseException {

		System.out.println("-------> Inserting Employee Records ---------->");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Employee ID :");
		int empId = sc.nextInt();
		System.out.println("Enter the First name :");
		String firstName = sc.next();
		System.out.println("Enter the Last name :");
		String lastName = sc.next();
		System.out.println("Enter the Email :");
		String email = sc.next();
		System.out.println("Enter the Phone number :");
		long phoneNumber = sc.nextLong();
		System.out.println("Enter the Salary :");
		float salary = sc.nextFloat();

		/* Hire Date */
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = simpleDateFormat.format(date);

		java.sql.Date date1 = java.sql.Date.valueOf(formattedDate);

		Connection con = getConnection();
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement("insert into java_practice.employees values(?,?,?,?,?,?,?)");
			stmt.setInt(1, empId);// 1 specifies the first parameter in the query
			stmt.setString(2, firstName);
			stmt.setString(3, lastName);
			stmt.setString(4, email);
			stmt.setLong(5, phoneNumber);
			stmt.setDate(6, date1);
			stmt.setFloat(7, salary);

			System.out.println("Insertion completed successfully");
			int i = stmt.executeUpdate();
			System.out.println(i + " records inserted");
			con.close();

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
