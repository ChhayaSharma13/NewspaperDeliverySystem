package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;  
import java.sql.Date; 

import com.utils.DbConnector;

public class addSubscriptionDAOImpl implements addSubscriptionDAOInter {
	
	public Date setDate(String strDate) {
		String[] dates = strDate.split("/",3);
		String newDate = dates[2] + "-" + dates[1] + "-" + dates[0];
		Date date = Date.valueOf(newDate);
		return date;
	}
	
	@Override
	public boolean addSubscription(String type, String startDate, String endDate) {
		
		Connection connection = DbConnector.getConnection();
		try {
			 
			Date S_Date = setDate(startDate);
			Date E_Date = setDate(endDate);
			PreparedStatement statement = connection.prepareStatement("insert into subscription(type, start_date, end_date)" + "values (?,?,?)");
			statement.setString(1, type);
			statement.setDate(2, S_Date);
			statement.setDate(3, E_Date);
			statement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
