package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.utils.DbConnector;

public class readSubscriptionDao {
	
	public String[] readSusbcription(int Id) {
		Connection connection = DbConnector.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement("select * from subscription where id = ? ");			
			statement.setInt(1, Id);
			
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				if(Id == rs.getInt("id")){
					String[] ans = new String[3];
					ans[0] = Id+"";
					ans[1] = rs.getString("type");
					ans[2] = rs.getDate("start_date") + "";
					ans[3] = rs.getDate("end_date") + "";
					return ans;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String ans[] = {"false"};
		return ans;
		
	}
}
