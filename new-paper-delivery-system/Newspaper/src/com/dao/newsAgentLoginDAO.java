package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.utils.DbConnector;

public class newsAgentLoginDAO implements newsAgentLoginDaoInterface{

	@Override
	public boolean Login(String username, String password) {
		Connection connection = DbConnector.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement("select * from news_agent where name = ? and password = ?");
			statement.setString(1, username);
			statement.setString(2, password);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				if(rs.getString("name").equals(username) && rs.getString(password).equalsIgnoreCase(password)) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
