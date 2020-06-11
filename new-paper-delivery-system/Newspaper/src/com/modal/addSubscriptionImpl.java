package com.modal;

public class addSubscriptionImpl implements addSubscriptionInter {

	@Override
	public boolean validSubType(String type) {
		if(type.equals("Daily") || type.equals("Weekly") || type.equals("Monthly")) {
			return true;
		}
		return false;
	}

	@Override
	public boolean validDates(String startDate, String endDate) {
		String[] start = startDate.split("/", 3);
		String[] end = endDate.split("/", 3);
		int sMonth = Integer.parseInt(start[1]);
		int sDate = Integer.parseInt(start[0]);
		int sYear = Integer.parseInt(start[2]);
		
		int eDate = Integer.parseInt(end[0]);
		int eMonth = Integer.parseInt(end[1]);
		int eYear = Integer.parseInt(end[2]);
		
		if(sYear < eYear) {
			return false;
		}
		
		else if( (sDate <= eDate || sDate > eDate) && sMonth < eMonth) {
			return true;
		}
		
		else if(sDate < eDate && sMonth == eMonth) {
			return true;
		}
		
		
		return false;
	}
	
	
}
