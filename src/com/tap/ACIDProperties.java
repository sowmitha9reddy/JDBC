package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ACIDProperties {
	private static final String URL="jdbc:mysql://localhost:3306/jeee4";
	private static final String USERNAME="root";
	private static final String PASSWORD="root";
	static Connection con=null;
	 static PreparedStatement pstmt_s=null;
	 static PreparedStatement pstmt_r=null;
	 static int pin=121212;
	
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		try {
			
				Class.forName("com.mysql.cj.jdbc.Driver");
			  con= DriverManager.getConnection(URL, USERNAME, PASSWORD);
			  con.setAutoCommit(false); //by default true
			   String sendQuery="update `bank` set `balance` =balance-? where id=?";
			   String reQuery="update `bank` set `balance` =balance+? where id=?";
			  pstmt_s= con.prepareStatement(sendQuery); //if recievers id is not known 
			  pstmt_r= con.prepareStatement(reQuery);
			   System.out.println("Enter the sender ID: ");
			   int sid=scan.nextInt();                       
			 
			   System.out.println("Enter the amount to be send ");
			   int amount=scan.nextInt();
			   
			   pstmt_s.setInt(1, amount);
			   pstmt_s.setInt(2, sid);
			  
			  
			   int x=pstmt_s.executeUpdate();
			   System.out.println("sending money :" +x);
			  
			   System.out.println("Enter the recieving ID: ");
			   int rid=scan.nextInt();
			  
			   pstmt_r.setInt(1, amount);
			   pstmt_r.setInt(2, rid);
			  
			   int y=pstmt_r.executeUpdate();
			    System.out.println("Money received sucessfully:" +y);
			 
			    System.out.println("Enter the pin");
			   // int pine=scan.nextInt();
			    if(scan.nextInt()==pin &&x==1 && y==1) {
			    	   con.commit();
			    	   System.out.println("sucessfull");
			    }
			    else {
			    	con.rollback();
			    	System.out.println("failed");
			    }
			
			
			   
			   
		} 
		
		catch (SQLException  |ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			scan.close();
			try {
				if(pstmt_s!=null) {
					pstmt_s.close();
					
				}
				if(pstmt_r!=null) {
					pstmt_r.close();
					
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
