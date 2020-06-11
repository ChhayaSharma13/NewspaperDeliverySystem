package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.utils.DbConnector;

public class SubscriptionDeleteMethod {
	
	public static boolean delete(int id) throws Exception {
		String sql = "delete from subscription where id=?";
		System.out.println(sql);
		Connection conn = DbConnector.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1, id);
		System.out.println(sql);
		if(!pstmt.execute()) {
			conn.close();
			return Boolean.TRUE;
		} else {
			conn.close();
			return Boolean.FALSE;
		}
	}
}
