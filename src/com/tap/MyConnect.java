package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyConnect{
	

		private static  String url="jdbc:mysql://localhost:3306/jdbclasses";
		private static String userName="root";
		private static String password="root";
		 static Connection connection=null;
		
		

		public static Connection connect() throws SQLException
		{
			 connection =DriverManager.getConnection(url,userName,password);
			 return connection;
		}
		public static void close(Connection connection, Statement st, ResultSet res) {
			// TODO Auto-generated method stub
			try {
				if(res!=null) {
					System.out.println("result set Closed");
				res.close();
				}

				if(st!=null) {
					System.out.println("Statement Closed");
				st.close();
				}
				if(connection!=null) {
					System.out.println("connection Closed");
				    connection.close();
				}
			
		     }
			catch(SQLException e) {
				e.printStackTrace();
			 }
			
		}
}