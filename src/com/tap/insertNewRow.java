package com.tap;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;





public class insertNewRow {
	public static void main(String[] args) {
		Connection connection=null;
		Statement st=null;
		ResultSet res=null;
	//String SQL1="Insert into Employee" +"(id,name,email,department,salary) values"+"(9,'prathyusha','prathyuu@gmail.com','Embedded',98768)";
	String SQL2="Select * from 	`Employee`";
	int id;
	String name;
	String email;
	String department;
	int salary;
	try 
	{
    connection=MyConnect.connect();
   st=connection.createStatement();
   // st.executeUpdate(SQL1);
   res=st.executeQuery(SQL2);
   
    
	while(res.next()) {
		 id=res.getInt(1);
		 name=res.getString(2);
		 email=res.getString(3);
		 department=res.getString(4);
	     salary=res.getInt(5);
		//System.out.println(res.getInt("id") +" "+res.getString("name") +" "+res.getString("email") +" "+res.getString("department")+" "+res.getInt("salary"));
	      System.out.printf("%d  %-10s  %-30s  %-10s %-10d \n", id,name,email,department,salary);
	}
	}
	catch(SQLException e) {
		e.printStackTrace();
	}
	finally {
		MyConnect.close(connection,st,res);
	}

	
}
}

