package com.mobileprogramming.serviceImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class LoginService {
public boolean check(String uname, String pass)
{
		String url="jdbc:mysql://localhost:3306/ATS_Java";
		String u="atsjava";
		String p="At$J@va12";
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,u,p);
		PreparedStatement pst=con.prepareStatement("select * from login where email=? and password=?");
		pst.setString(1, uname);
		pst.setString(2, pass);
		
		ResultSet rs=pst.executeQuery();
		
		if(rs.next())
		{
			return true;
		}
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	return false;
	
}
}
