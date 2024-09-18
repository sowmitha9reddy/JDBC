package com.tap;

import java.sql.Connection;
import java.sql.Statement;



public class Program2 {
        public static void main(String[] args) {
        	Connection con=null;
        	Statement st=null;
        	
         String SQL2="insert into `employee`(`id`,`name`,`email`,`department`,`salary`) "
         		+ "values(10,'pallavi','pallavi@gmail.com','it',500000)";
        	try {
        		con=MyConnect.connect();
        		st=con.createStatement();
        		int x=st.executeUpdate(SQL2);
        		if(x==0) {
        			System.out.println("data is not updated");
        		}
        		else {
        			System.out.println("data is  updated");
        		}
        	
        		
        		
        	}
        	catch(Exception e) {
        		e.printStackTrace();
        	}
        	finally {
        		MyConnect.close(con, st, null);
        	}
        }
}
