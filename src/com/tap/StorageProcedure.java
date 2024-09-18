package com.tap;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class StorageProcedure {
         private static Connection con;
		private static CallableStatement prepcall;
		

		public static void main(String[] args) {
			Scanner sc=new Scanner(System.in);
        	 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbclasses", "root", "root");
				prepcall=con.prepareCall("{call emp_count_on_dept(?,?)}");
				System.out.println("Enter the department name: ");
				String dept=sc.next();
				prepcall.setString(1, dept); //set input whaterver user as given
				prepcall.registerOutParameter(2, Types.INTEGER); //returns the out storage prpcdeure query.
				prepcall.execute();
				int x=prepcall.getInt(2);
				System.out.println("Enter the no.of employees in deprtament " +dept+" are "+x);
				
				prepcall=con.prepareCall("{call emp_on_salary(?,?)}");
				System.out.println("Enter the salary : ");
			   long dept1=sc.nextInt();
				prepcall.setLong(1, dept1); //set input whaterver user as given
				prepcall.registerOutParameter(2, Types.INTEGER); //returns the out storage prpcdeure query.
				prepcall.execute();
				int x1=prepcall.getInt(2);
				System.out.println("Enter the salary greater than " +dept1+" are "+x1);
			} 
        	 catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	 }
}
