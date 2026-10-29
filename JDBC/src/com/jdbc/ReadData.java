package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadData {

	public static void main(String[] args) {

		final String URL="jdbc:mysql://localhost:3306/mydata101r";
		String user="root";
		String password="vinay";
		
		String query="select * from student";
		
		try {
			Connection con=DriverManager.getConnection(URL,user,password);
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			
			rs.next();
			int id=rs.getInt(1);
			String name=rs.getString(2);
			System.out.println(id);
			System.out.println(name);
			
			rs.next();
			String name2=rs.getString(2);
			int age=rs.getInt(3);
			System.out.println(name2);
			System.out.println(age);
			
			rs.next();
			String name3=rs.getString(2);
			int marks=rs.getInt(4);
			System.out.println(name3);
			System.out.println(marks);
			
			rs.close();
			con.close();
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
