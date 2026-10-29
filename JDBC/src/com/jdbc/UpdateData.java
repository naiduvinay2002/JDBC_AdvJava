package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateData {

	public static void main(String[] args) {

		final String URL="jdbc:mysql://localhost:3306/mydata101r";
		String user="root";
		String password="vinay";
		
		String query="update student set name= 'nehmiya' where id=107";
		
		try {
			Connection con=DriverManager.getConnection(URL,user,password);
			
			Statement st=con.createStatement();
			
			int rows=st.executeUpdate(query);
			
			System.out.println(rows+" updated");
			
			con.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
