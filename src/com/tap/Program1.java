package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program1 {
 
	public static void display(Connection connection,Statement st,ResultSet res) throws SQLException {
		String SQL="select* from employee";
		 st=connection.createStatement();
		res=st.executeQuery(SQL);
		while(res.next()) {
			System.out.println(res.getInt("id") +" "+res.getString("name") +" "+res.getString("email") +" "+res.getString("department")+" "+res.getInt("salary"));
		}
	
		
		
		
	}

	public static void main(String[] args) {
		
		String url="jdbc:mysql://localhost:3306/jdbclasses";
		String userName="root";
		String password="root";
		
		Connection connection=null;
		Statement st=null;
		ResultSet res=null;
		try {
	 connection =DriverManager.getConnection(url,userName,password);
		System.out.println("Connection establixed>>>>");
		System.out.println("heloo");
		
		display(connection,st,res);
		
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(connection, st, res);
			
			}
		
			
		}

	public static void close(Connection connection, Statement st, ResultSet res) {
		try {
			if(res!=null) {
			res.close();
			}
		}
		catch(Exception e){
			
			e.printStackTrace();
		}
		try {
			if(st!=null) {
			st.close();
			}
			
			
			
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
		try {
			if(connection!=null) {
			connection.close();
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	}


