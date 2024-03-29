package com.perscholas.homeinsurance.dao;

import java.io.IOException; 
import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.perscholas.homeinsurance.interfaces.HomeownerDAOI;
import com.perscholas.homeinsurance.models.Homeowner;
import com.perscholas.homeinsurance.models.User;

public class HomeownerDAO implements HomeownerDAOI
{
	
	/**Returns the user Id autogenerated by the database during insertion of the User Object that will
	 *be passed as a parameter in the Homeowner Constructor, and assigned to the Homeowner Object's userId
	 *variable during Construction of the Homeowner Object. 
	 *@param homeowner Represents an initialized Homeowner Object. Note: A null value will render failed insertion.
	 *@return Returns the user identification number of the Homeowner Object.
	 *@throws SQLException
	 *@throws ClassNotFoundException
	 *@throws IOException
	*/
	@Override
	public Integer registerHomeowner(Homeowner homeowner) throws SQLException, ClassNotFoundException, IOException  
	{
		
		Connection conn = null;				//Declare variables for JDBC.
		PreparedStatement stmt = null;
		ResultSet rs = null;
		OracleConnection orcl = new OracleConnection();
	
		String insertString = "insert into Homeowners(user_id,first_name, last_name,"	//Create sql query for database.
				+ "dob, retired_status, ssn, email) values (?,?,?,?,?,?,?)";
	
		String[] COL = {"user_id"};
		int ID = -1; 
		conn = orcl.getConnection();							//Establish connection and display status to user.
		System.out.println("DATABASE CONNECTION ESTABLISHED");	
	
		try
		{
			stmt = conn.prepareStatement(insertString, COL);
			stmt.setInt(1,homeowner.getUserId());				//Assign values to statement Object.
			stmt.setString(2, homeowner.getFirstName());
			stmt.setString(3, homeowner.getLastName());
			stmt.setDate(4, homeowner.getDateOfBirth());
			stmt.setBoolean(5, homeowner.getRetirementStatus());
			stmt.setString(6, homeowner.getSocialSecurityNumber());
			stmt.setString(7, homeowner.getEmailAddress());
			stmt.executeUpdate();			//Execute query.

			rs = stmt.getGeneratedKeys();

			if(rs != null && rs.next())
			{
				
				ID = rs.getInt(1);
				System.out.println("The Homeowner has been registered as USER ID#: "+ID);	//Display validation of insertion
			}
		  }
	    catch (SQLException e)
		{
			System.out.println("Error: " + e.getMessage());
		}
		finally						//Close all connection Objects.
		{
			if (rs != null) 
			{
				rs.close();
			}
			if (stmt != null) 
			{
				stmt.close();
			}
			if (conn != null) 
			{
				conn.close();
			}
		}
	    
		return ID;		//Return value of userId, -1 = failed insert.
	}
	
	
	/**Returns a List containing a Homeowner Object retrieved from the database based on the user identification number passed.
	*@param userId Represents the user identification number.
	*@return Returns List containing User Object matching passed userId variable.
	*@throws SQLException
	*@throws ClassNotFoundException
	*@throws IOException
	*@throws ParseException
	*/
	@Override
	public Homeowner getHomeownerByUserId(int userId) throws ClassNotFoundException, IOException, SQLException, ParseException
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		OracleConnection orcl = new OracleConnection();
		
		//Declare User Object to assign values and List for Homeowner Object(s) to  be returned.
		
		Homeowner homeowner = null;
		
		//This query retrieves the User data first needed to properly create Homeowner Object(aggregate)
		//then obtains the associated homeowner information.
		String fetchString =  "SELECT homeowners.user_Id, users.user_name, users.password,"+
				  "users.admin_Role, homeowners.first_name, homeowners.last_name, homeowners.dob,"+ 
				  "homeowners.retired_status, homeowners.ssn, homeowners.email FROM homeowners "+
				  "Inner JOIN users On users.user_Id = homeowners.USER_ID Where homeowners.USER_ID = ?";

		try
		{
			conn = orcl.getConnection();
			stmt = conn.prepareStatement(fetchString);
			stmt.setInt(1, userId);
			rs = stmt.executeQuery();							//Execute Query
			
			while(rs.next())									//Construct Object based on values from query. 
			{
				Date date = rs.getDate(7);						//Construct date Object to store value from database.
				
				homeowner = new Homeowner(rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5), rs.getString(6), date.toString(), 
						  rs.getBoolean(8), rs.getString(9), rs.getString(10));
				homeowner.setUserId(rs.getInt(1));
			}
		}
		catch(SQLException e)
		{
			System.out.println("Error: " + e.getMessage());
		}
		finally									//Close all connection Objects.
		{
			if (rs != null) 
			{
				rs.close();
			}
			if (stmt != null) 
			{
				stmt.close();
			}
			if (conn != null) 
			{
				conn.close();
			}
		}
		return homeowner;				//Return List.
	}
	
}