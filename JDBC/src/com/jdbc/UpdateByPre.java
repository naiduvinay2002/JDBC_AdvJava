package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateByPre {

	public static void main(String[] args) {

		final String URL="jdbc:mysql://localhost:3306/mydata101r";
		String user="root";
		String password="vinay";
		
		String query="update student set name=? where id=?";
		
		
		
		try {
			Connection con=DriverManager.getConnection(URL,user,password);
			PreparedStatement ps=con.prepareStatement(query);
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Id: ");
			int id=Integer.parseInt(sc.nextLine());
			System.out.println("Enter name: ");
			String name=sc.nextLine();
			
			ps.setString(1, name);
			ps.setInt(2, id);
			
			int rows=ps.executeUpdate();
			System.out.println(rows+" row updated");
			
			con.close();
			ps.close();
			sc.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
