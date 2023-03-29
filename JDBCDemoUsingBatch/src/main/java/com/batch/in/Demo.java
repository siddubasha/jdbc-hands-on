package com.batch.in;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Demo {
	public static void main(String[] args) {
		// insertWithBatch();
		// inserWithBatchPreparestmt();
		updateWithBatch();
	}

	private static void updateWithBatch() {

		String query2 = "update salary set salary=? where id=?";
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/softech", "root", "Siddu@123");
				PreparedStatement pstmt = con.prepareStatement(query2);) {
			con.setAutoCommit(false);

			pstmt.setInt(1, 1000);
			pstmt.setInt(2, 58);
			pstmt.addBatch();

			pstmt.setInt(1, 1000);
			pstmt.setInt(2, 25);
			pstmt.addBatch();

			pstmt.setInt(1, 1000);
			pstmt.setInt(2, 66);
			pstmt.addBatch();

			int[] count = pstmt.executeBatch();
			con.commit();
			con.setAutoCommit(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void inserWithBatchPreparestmt() {

		String query = "insert into salary values(?,?,?)";
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/softech", "root", "Siddu@123");
				PreparedStatement pstmt = con.prepareStatement(query);) {
			con.setAutoCommit(false);

			pstmt.setInt(1, 66);
			pstmt.setString(2, "Gulam");
			pstmt.setInt(3, 2000);
			pstmt.addBatch();

			pstmt.setInt(1, 77);
			pstmt.setString(2, "lama");
			pstmt.setInt(3, 25200);
			pstmt.addBatch();

			pstmt.setInt(1, 99);
			pstmt.setString(2, "neha");
			pstmt.setInt(3, 96000);
			pstmt.addBatch();

			int[] count = pstmt.executeBatch();
			System.out.println(count);
			con.commit();
			con.setAutoCommit(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void insertWithBatch() {
		// try-with-resource statements to close resources automatically

		try (
				// 1. creating connection with database
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/softech", "root",
						"Siddu@123");
				// 2.creating statement object
				Statement stmt = con.createStatement();) {
			con.setAutoCommit(false);

			stmt.addBatch("insert into salary values(18,'ramu',58000);");
			stmt.addBatch("insert into salary values(25,'kapa',8000);");
			stmt.addBatch("insert into salary values(89,'amal',42000);");

			int[] count = stmt.executeBatch();
			System.out.println(count);
			con.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
