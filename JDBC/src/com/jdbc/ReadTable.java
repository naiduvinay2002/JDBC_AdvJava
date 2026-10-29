package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadTable {

	public static void main(String[] args) {

		final String URL="jdbc:mysql://localhost:3306/mydata101r";
		String user="root";
		String password="vinay";
		
		String query="select * from student";
		
		try {
			Connection con=DriverManager.getConnection(URL,user,password);
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			
			System.out.println("Id \t Name \t Age \t Marks");
			while(rs.next()) {
				int id=rs.getInt(1);
				String name=rs.getString(2);
				int age=rs.getInt(3);
				int marks=rs.getInt(4);
				
				System.out.println(id+"\t"+name+"\t "+age+"\t "+marks);
			}
			
			rs.close();
			con.close();
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
