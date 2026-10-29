package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Prepare_Statement {

	public static void main(String[] args) {

		final String URL="jdbc:mysql://localhost:3306/mydata101r";
		String user="root";
		String password="vinay";
		
		String query="insert into student values(?,?,?,?)";
		
		
		
		try {
			Connection con=DriverManager.getConnection(URL,user,password);
			
			PreparedStatement ps=con.prepareStatement(query);
			Scanner sc = new Scanner(System.in);
			
			for(int i=1;i<=5;i++) {
			
				System.out.println("Enter Id: ");
				int id=Integer.parseInt(sc.nextLine());
				System.out.println("Enter name: ");
				String name=sc.nextLine();
				System.out.println("Enter age: ");
				int age=Integer.parseInt(sc.nextLine());
				System.out.println("Enter marks: ");
				int marks=Integer.parseInt(sc.nextLine());
				
				ps.setInt(1, id);
				ps.setString(2, name);
				ps.setInt(3, age);
				ps.setInt(4, marks);
				
				int rows=ps.executeUpdate();
				
				System.out.println(rows+" inserted");
			}
			con.close();
			ps.close();
			sc.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
