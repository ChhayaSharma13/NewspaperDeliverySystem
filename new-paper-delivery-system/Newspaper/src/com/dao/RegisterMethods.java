package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.utils.DbConnector;

public class RegisterMethods {

//	private int id;
//	private String name;
//	private String password;
//	private String email;
//	private String phone;


	public static boolean regist(String name, String password, String email, String phone) throws Exception {
		String sql = "INSERT INTO delivery_person(name, password, email, phone) VALUES(?, ?, ?, ?)";
		System.out.println(sql);
		Connection conn = DbConnector.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
//		pstmt.setInt(1, getRandom());
		pstmt.setString(1, name);
		pstmt.setString(2, password);
		pstmt.setString(3, email);
		pstmt.setString(4, phone);
		System.out.println(sql);
		if(!pstmt.execute()) {
			conn.close();
			return Boolean.TRUE;
		} else {
			conn.close();
			return Boolean.FALSE;
		}
		
	}
	
	

	/*
	 * public void insertDatabase(String values, String tableName) {
	 * sql="insert into "+tableName+" values("+values+");"; ResultSet
	 * rs=DatabaseConnection.connectToDatabase(sql); }
	 * 
	 * public static void main(String[] args) { // TODO Auto-generated method stub
	 * 
	 * }
	 */

}
