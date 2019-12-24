package com.pa.qa.util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataBaseConnection extends Constants {
	
	
	public  static List<String> getDBData(String fieldName ) throws SQLException {
		List<String>lstdata=new ArrayList<String>();
		try {
			stmt=connect.createStatement();
			rs=stmt.executeQuery(prop.getProperty("Query"));
		while(rs.next())  {
		System.out.println(rs.getString(fieldName));  
	lstdata.add(rs.getString(fieldName));
		 }
	}
		 catch (Exception e) {
			e.printStackTrace();
		}
		return lstdata;
	
			
}
	
}
