package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;



public class Meta {
	
	private static final String URL="jdbc:mysql://localhost:3306/jeee4";
	private static final String USERNAME="root";
	private static final String PASSWORD="root";
	private static  Connection con=null;
	private static Statement stmt=null;
	private static ResultSet result=null;
	private static ResultSetMetaData rsmd;
	
	private static final String QUERY="select * from `members`";
	
	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
				con=DriverManager.getConnection(URL, USERNAME, PASSWORD);
				stmt=con.createStatement();
				result=stmt.executeQuery(QUERY);
				
				rsmd=result.getMetaData();
				int x=rsmd.getColumnCount(); 
				System.out.println("No.of columns  "+ x +"\n");
			for(int i=1;i<=x;i++) {
				System.out.println("column no: "+ i+"\n \tColumn Name : "+rsmd.getColumnName(i) +"\n \t column Data type: "+
			               rsmd.getColumnTypeName(i) +" \n \t is column nullable " +(rsmd.isNullable(i)==1 ?"yes":"No") +"\n");
			}
			
			
		} 
		
		
		catch (ClassNotFoundException  |SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
