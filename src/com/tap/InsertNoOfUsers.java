package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertNoOfUsers {

	static  Connection con;
	static PreparedStatement pstmt;
	 
	public static void main(String[] args) {
		Scanner scan1=new Scanner(System.in);
		Scanner scan2=new Scanner(System.in);
		int id,salary;
		String email,name,department;
		int x = 0,n=0;
		String ch=null;
		
		String url="jdbc:mysql://localhost:3306/jdbclasses";
		String userName="root";
		String password="root";
		String sql="insert into `employee`(`id`,`name`,`email`,`department`,`salary`) values (?,?,?,?,?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, userName, password);
			pstmt=con.prepareStatement(sql);
//		System.out.println("no.of Employ2ess to be inserted");
//		 n=scan1.nextInt();
			for(;;) {
				System.out.println("Enter the id: ");
				 id=scan1.nextInt();
				System.out.println("Enter the name: ");
				name=scan2.next();
				System.out.println("Enter the email: ");
				email=scan2.next();
				System.out.println("Enter the department: ");
				department=scan2.next();
				System.out.println("ENter the salary");
				salary=scan1.nextInt();
				
				pstmt.setInt(1, id);
				pstmt.setString(2, name);
				pstmt.setString(3, email);
				pstmt.setString(4, department);
				pstmt.setInt(5, salary);
				 pstmt.executeUpdate();
				 System.out.println("Do you want to insert more data:(y/n)");
				 ch=scan2.next();
				 if(ch.equals("n")) {
					 break;
				 }
				
			}
//			if(x!=0) {
//				System.out.println( " inserted" +" rows sucessfully");
//			}
//			else {
//				System.out.println("Not inserted sucessfully");
//			}
			
			
			
			
			
		}
		catch(Exception e){
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
				
					catch (SQLException e) {
					
					e.printStackTrace();
				}
				
			}
		}

	
}
