package com.tap;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteSpecificUser {
	
	private static Connection con;
	private static PreparedStatement ps;
	
	public static void main(String[] args) {
		
		
		 String sql="delete from `employee` where `id`=?";
		 
		try {
			con=MyConnect.connect();
			ps=con.prepareStatement(sql);
			System.out.println("Enter the id to be deleted: ");
			int id=new Scanner(System.in).nextInt();
		
			ps.setInt(1, id);
			int x=ps.executeUpdate();
			if(x!=0) {
				System.out.println(x+"users deleted sucessfully");
			}
			else {
				System.out.println("failed to delete");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			MyConnect.close(con, ps, null);
		}
		
		
	}

}
