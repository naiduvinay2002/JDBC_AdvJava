package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ReadByPre {

	public static void main(String[] args) {

		final String URL="jdbc:mysql://localhost:3306/mydata101r";
		String user="root";
		String password="vinay";
		
		String query="select * from student where id=?";
		
		
		
		try {
			Connection con=DriverManager.getConnection(URL,user,password);
			
			PreparedStatement ps=con.prepareStatement(query);
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Id: ");
			int id=Integer.parseInt(sc.nextLine());
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
			
			if (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Age: " + rs.getInt("age"));
                System.out.println("Marks: " + rs.getInt("marks"));
                
                System.out.println("1 row selected");
    			
            } else {
                System.out.println("Student not found");
            }
			
			
		
			con.close();
			ps.close();
			rs.close();
			sc.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
