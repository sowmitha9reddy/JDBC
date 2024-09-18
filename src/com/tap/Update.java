package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
//import java.sql.Statement;

public class Update {
	private static Connection con=null;
	//Statement stmt=null;
	private static PreparedStatement pstmt;
	 
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		String url="jdbc:mysql://localhost:3306/jdbclasses";
		String userName="root";
		String password="root";
		
		//String sql3="update `employee` set `salary`=salary+500 where department='it'";
		String sql3="update `employee` set `salary`=salary+? where department=?";
		try {
		
		 con = DriverManager.getConnection(url,userName,password);
		 
	    //	stmt=con.createStatement();
		 pstmt= con.prepareStatement(sql3);
		 System.out.println("Enter the department: ");
		 String department=scan.next();
		 System.out.println("enter the salary to be incrementent: ");
		 int inc=scan.nextInt();
		 pstmt.setInt(1,inc);
		 pstmt.setString(2, department);
		 
		int x=pstmt.executeUpdate();
		if(x!=0) {
			System.out.println("statement executed"+x);
		}
		else {
			System.out.println("updated failed");
		}
		 
		 
		 
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			
			
			try {
				if(pstmt!=null) {
					pstmt.close();
					
				}
				if(con!=null) {
					con.close();
				}
		}
			catch(Exception e) {
				e.printStackTrace();
			}
		
		}

	}

}
