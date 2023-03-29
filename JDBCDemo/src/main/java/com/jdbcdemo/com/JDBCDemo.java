package com.jdbcdemo.com;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {

	public static void main(String[] args) {
		
		//JDBCDemo.getDataFromTabel();
		//JDBCDemo.createTable()
		//JDBCDemo.insertRecords();
		//JDBCDemo.updateRecords();
		//JDBCDemo.deleteRecords();
}
	 private static void deleteRecords() {
      String query5="delete from  salary where id=65";	
   // try-with-resource statements to close resources automatically
   			try (
   					// 1. creating connection with database
   					Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/softech","root","Siddu@123");
   					//2.creating statement object
   					Statement stmt=con.createStatement();
   					//3.executing query with statement object help.
   					
   					
   					){
   				//Class.forName("com.mysql.cj.jdbc.Driver");
   				//Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/softech","root","Siddu@123");
   				//Statement stmt=con.createStatement();
   				int rs= stmt.executeUpdate(query5);
   				if(rs!=0)
   				System.out.println("deleted sucessfully");
   				else
   					System.out.println("failed to delete");
   			}
   			    catch (Exception e) {
   				// TODO Auto-generated catch block
   				e.printStackTrace();
   			    }
      
	}
	private static void updateRecords() {

		 String query4="update salary set name = 'raju' where id=65";
		// try-with-resource statements to close resources automatically
			try (
					// 1. creating connection with database
					Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/softech","root","Siddu@123");
					//2.creating statement object
					Statement stmt=con.createStatement();
					//3.executing query with statement object help.
					
					
					){
				//Class.forName("com.mysql.cj.jdbc.Driver");
				//Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/softech","root","Siddu@123");
				//Statement stmt=con.createStatement();
				int rs= stmt.executeUpdate(query4);
				if(rs!=0)
				System.out.println("Updated sucessfully");
				else
					System.out.println("failed to update");
			}
			    catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			    }
		 
	}
	private static void insertRecords() {
       
		 String query3="insert into salary "
		 +" values( 65,'siddu',25000),"
	     +" (58,'basha',80000)";
		// try-with-resource statements to close resources automatically
					try (
							// 1. creating connection with database
							Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/softech","root","Siddu@123");
							//2.creating statement object
							Statement stmt=con.createStatement();
							//3.executing query with statement object help.
							
							
							){
						//Class.forName("com.mysql.cj.jdbc.Driver");
						//Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/softech","root","Siddu@123");
						//Statement stmt=con.createStatement();
						 int rs=stmt.executeUpdate(query3);
						 if(rs!=0)
						System.out.println("inserted sucessfully");
						 else
							 System.out.println("failed to insert");
						}
					    catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
		 
	}
	public static String createTable(){
		 String query2 = "create table salary " +
                 "(id int not null, " +
                 " name varchar(20), "+
                 "salary int)";
			// try-with-resource statements to close resources automatically
			try (
					// 1. creating connection with database
					Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/softech","root","Siddu@123");
					//2.creating statement object
					Statement stmt=con.createStatement();
					//3.executing query with statement object help.
					//ResultSet rs=stmt.executeQuery(query2);
					
					){
				//Class.forName("com.mysql.cj.jdbc.Driver");
				//Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/softech","root","Siddu@123");
				//Statement stmt=con.createStatement();
				int rs=stmt.executeUpdate(query2);
				System.out.println(rs);
				}
			    catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		return "created";
		 
	 }
	 
	 public static void getDataFromTabel(){
		 String query1="select * from alien";
		// try-with-resource statements to close resources automatically
			try (
					// 1. creating connection with database
					Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/softech","root","Siddu@123");
					//2.creating statement object
					Statement stmt=con.createStatement();
					//3.executing query with statement object help.
					ResultSet rs=stmt.executeQuery(query1);
					
					){
				//Class.forName("com.mysql.cj.jdbc.Driver");
				//Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/softech","root","Siddu@123");
				//Statement stmt=con.createStatement();
				//ResultSet rs=stmt.executeQuery(query);
				while(rs.next()) {
			    int id=rs.getInt("aid");
			    String name=rs.getString("aname");
			    String tech=rs.getString("atech");
			    System.out.println(id+" "+name+" "+tech);
				
				}
			}
			    catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			 
		 }
}
