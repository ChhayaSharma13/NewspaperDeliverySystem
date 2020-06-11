package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.utils.DbConnector;
public class newsAgentRegisterDAO implements newAgentRegisterDAOInter {

	@Override
	public boolean Register(String username, String email, long phone, String password) {
		Connection connection = DbConnector.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement("insert into news_agent (name, password, email, phone)" + "values (?,?,?,?)");
			statement.setString(1, username);
			statement.setString(2, password);
			statement.setString(3, email);
			statement.setLong(4, phone);
			statement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}