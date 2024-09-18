package com.tap;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class AcceptData {
   public static void main(String[] args) {
	   Scanner scan1=new Scanner(System.in);
	   Scanner scan2=new Scanner(System.in);
	
	   Connection con=null;
	   PreparedStatement pts=null;
		int id;
		String name;
		String email;
		String department;
		int salary;
		System.out.println("Enter the ID");
		  id=scan1.nextInt();
		  System.out.println("Enter the name");
		  name=scan2.nextLine();
		  System.out.println("Enter the Email");
		  email=scan2.nextLine();
		  System.out.println("Enter the Department");
		  department=scan2.nextLine();
		  System.out.println("Enter the Salary");
		  salary=scan1.nextInt();
	  
	   String SQL2="insert into employee(id,name,email,department,salary)"+"values(?,?,?,?,?)";
	   try {
		   con=MyConnect.connect(); 
		  pts= con.prepareStatement(SQL2);
		  
		  
		 pts.setInt(1, id);
	     pts.setString(2,name);
	     pts.setString(3,email);
	 
	     pts.setInt(5,salary);
	     pts.setString(4,department);
	     int x=pts.executeUpdate();
		  System.out.println("output is"+x);
		  
		  }
	   catch(Exception e){
		   e.printStackTrace();
	   }
   }
}
