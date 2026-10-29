package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo {

	public static void main(String[] args) {

		final String URL="jdbc:mysql://localhost:3306/mydata101r";
		String user="root";
		String password="vinay";
		
		String query="create table student(id int,name varchar(50),age int,marks int)";
		
		try {
			Connection conn=DriverManager.getConnection(URL,user,password);
			
			Statement stmt=conn.createStatement();
			
			stmt.executeUpdate(query);
			
			System.out.println("Table created");
			
			conn.close();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
