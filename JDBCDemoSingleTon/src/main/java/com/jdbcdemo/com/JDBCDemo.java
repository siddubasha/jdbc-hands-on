package com.jdbcdemo.com;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jdbcdemo.com.singleton.DBConnection;

public class JDBCDemo {

	public static void main(String[] args) {
		
		//JDBCDemo.getDataFromTabel();
		// JDBCDemo.createTable();
		//JDBCDemo.insertRecords();
		//JDBCDemo.updateRecords();
		//JDBCDemo.deleteRecords();
}
	 private static void deleteRecords() {
      String query5="delete from  salary_myorg where id=?";	
   			try (PreparedStatement pstmt=DBConnection.getDBConnection().prepareStatement(query5)){
   				pstmt.setInt(1,58);
   				int rs= pstmt.executeUpdate();
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

		 String query4="update salary_myorg set name =? where id=?";
			try (PreparedStatement pstmt=DBConnection.getDBConnection().prepareStatement(query4)){
				pstmt.setString(1,"hafiz");
				pstmt.setInt(2,22);
				int rs= pstmt.executeUpdate();
				if(rs!=0)
				System.out.println("Updated sucessfully");
				else
					System.out.println("failed to update");
			}
			    catch (Exception e) {
				e.printStackTrace();
			    }
		 
	}
	private static void insertRecords() {
       
		 String query3="insert into salary_myorg "
		 +" values(?,?,?)";
					try(PreparedStatement pstmt=DBConnection.getDBConnection().prepareStatement(query3)) {
						pstmt.setInt(1,22);
						pstmt.setString(2,"himan");
						pstmt.setInt(3,25000);
						int rs=pstmt.executeUpdate();
						if(rs!=0)
						System.out.println("inserted sucessfully");
						 else
							 System.out.println("failed to insert");
						}catch (Exception e) {
						e.printStackTrace();
					} 
		 
	}
	public static String createTable(){
		 String query2 = "create table salary_myorg " +
                 "(id int not null, " +
                 " name varchar(20), "+
                 "salary int)";
			try ( PreparedStatement pstmt=DBConnection.getDBConnection().prepareStatement(query2)){
				boolean status=pstmt.execute();
				if(status==false) {
					System.out.println("Table created suceefully");
				}
				else {
					System.out.println("failed to create table");
				}
				}catch (Exception e) {
				e.printStackTrace();
			} 
			
		return "created";
		 
	 }
	 
	 public static void getDataFromTabel(){
		 String query1="select * from alien";
			try (   PreparedStatement pstmt=DBConnection.getDBConnection().prepareStatement(query1);){
				ResultSet rs=pstmt.executeQuery();
				while(rs.next()) {
			    int id=rs.getInt("aid");
			    String name=rs.getString("aname");
			    String tech=rs.getString("atech");
			    System.out.println(id+" "+name+" "+tech);
				
				}
			}catch (Exception e) {
				e.printStackTrace();
			} 
			 
		 }
}
