package com.tap;

import java.sql.Connection;
import java.sql.Statement;

public class Delete {

	private static Statement stmt;

	public static void main(String[] args) {
		Connection con=null;
		
		try {
			con=MyConnect.connect();
			stmt=con.createStatement();
			int x=stmt.executeUpdate("delete from `employee` where id=8");
			System.out.println("data deleted"+x);
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(stmt!=null) {
					stmt.close();
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
