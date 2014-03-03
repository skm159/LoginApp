package com.psl.main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginDAO
{
static Connection currentCon = null;
static ResultSet rs = null;

public boolean TestCase(String username, String password)
{
	Statement stmt = null;
	
	String searchQuery = "select * from mysql.users where uname='" + username + "' AND password='" + password + "'";
	try
	{
	//connecting to the DB
	currentCon = ConnectionManager.getConnection();
	stmt=currentCon.createStatement();
	rs = stmt.executeQuery(searchQuery);
	boolean userExists = rs.next();
	
	if(!userExists)
	{
		return false;
	}
	else {
		return true;
		
	}
	
	}
	catch (Exception e) {
		System.out.println("An Exception has occurred! " + e);
//		e.printStackTrace();
	}
	
	return false;

}
public static LoginBean login(LoginBean bean)
{
Statement stmt = null;
String username = bean.getUsername();
String password = bean.getPassword();
System.out.println("Inside login DAO");
String searchQuery = "select * from mysql.users where uname='" + username + "' AND password='" + password + "'";

try
{
//connecting to the DB
currentCon = ConnectionManager.getConnection();
stmt=currentCon.createStatement();
rs = stmt.executeQuery(searchQuery);
boolean userExists = rs.next();



if (!userExists)
{
System.out.println("Username/Password entered is Incorrect or User doesnot Exists.");
bean.setValid(false);
}
else if (userExists)
{
String firstName = rs.getString("FirstName");
String lastName = rs.getString("LastName");
System.out.println("Welcome " + firstName);
bean.setFirstName(firstName);
bean.setLastName(lastName);
bean.setValid(true);
}

}
catch (Exception ex)
{
System.out.println("Log In failed: An Exception has occurred! " + ex);
}
return bean;
}
}