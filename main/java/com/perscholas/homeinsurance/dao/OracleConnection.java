package com.perscholas.homeinsurance.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

	public class OracleConnection 	 
	{
		//Create getConnection method
		public Connection getConnection() throws ClassNotFoundException,
		IOException, SQLException 
		{
			//Create final Properties Object
			final Properties prop = new Properties();
			
			//Create InputStream Object and initialize it using the OracleConnection
			//Class static methods to pass of database information file
			final InputStream inputStream = 
			OracleConnection.class.getClassLoader().getResourceAsStream("properties/db.properties");
			
			//Use load method of Properties Object to pass initialized InputStream Object
			prop.load(inputStream);
			
			//Register driver 
			Class.forName(prop.getProperty("driver"));
			
			//Create Connection Object and initialize
			final Connection connection =
				DriverManager.getConnection(prop.getProperty("url"),
				prop.getProperty("user"), prop.getProperty("password"));
		
			//Return Connection Object
			return connection;
		}
	}




