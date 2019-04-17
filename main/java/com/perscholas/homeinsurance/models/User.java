package com.perscholas.homeinsurance.models;
import java.util.regex.Pattern;

public class User
{
		private Integer userId;
		private String userName;
		private String password;
		private String adminRole;

	/**Default(No argument) Constructor to create a User Object.*/
			
		public User()
		{
			userId = null;
			userName = null;
			password = null;
			adminRole = "user";		 
		}

	/**Parameterized Constructor to create a User Object. 
	*@param userId Represents the identification number for a user account.
	*@param userName Represents the user name on the account for login access.
	*@param password Represents the password for login access.
	*@param adminRole Represent the administrative role for specific interface access.
	*/
		public User(String userName, String password, String adminRole)
		{	
			userId = null;
			
			if(userName.length() >=2 && userName.length()<=50
			&& Pattern.matches("[a-zA-Z0-9]+",userName)) 
				this.userName = userName;
			
			if(password.length() >=8 && password.length() <= 20
			&& Pattern.matches("[a-zA-Z0-9]+", password))
				this.password = password;
				
			if(adminRole.equals("user") || adminRole.equals("admin"))
				this.adminRole = adminRole;
		}
		
	/**Sets a value to the userId field.
	*@param userId Represents the user identification number. 
	*/
		public void setUserId(int userId)
		{
			this.userId = userId;	
		}
			
	/**Sets a value to the userName field.
	*@param userName Represents the user name for login access. 
	*/
		public void setUserName(String userName)
		{
			if(userName.length() >=2 && userName.length()<=50
			&& userName.matches("[a-zA-Z0-9]+")) 
				this.userName = userName;	
			else
				this.userName = null;
		}
			
	/**Sets a value to the password field.
	*@param password Represents the password on the account for login access.
	*/
		public void setPassword(String password)
		{
			if(password.length() >=8 && password.length() <= 20
			&& password.matches("[a-zA-Z0-9]+"))
				this.password = password;
			else
				this.password = null;
		}
			
	/**Sets a value to the adminRole field.
	*@param adminRole Represents the role for administrative access.
	*/
		public void setAdminRole(String adminRole)
		{
			if(adminRole.equals("admin"))
				this.adminRole = adminRole;
			else
				this.adminRole = "user";
		}
			
	/**Returns the current value set as the user identification number.
	*@return The current value set to the userId field.
	*/
		public Integer getUserId()
		{
			return this.userId;
		}
			
	/**Returns the current value set to the userName field for login access.
	*@return The current value set to the userName field. 
	*/
		public String getUserName()
		{
			return this.userName;
		}
			
	/**Returns the current value set to the password for login access.
	*@return The current value set to the password field.
	*/
		public String getPassword()
		{
			return this.password;
		}
			
	/**Returns the current status of the administrative role.
	*@return The current value set to the adminRole field.
	*/
		public String getAdminRole()
		{
			return this.adminRole;
		}
		
		/**Returns a formatted representation of the User Objects' values.
		 *@return Formatted representation of the User Objects' values.
		*/	
		
		public String toString()
		{
			String str = String.format("User ID : %d \nUsername: %s \nPassword: %s \nAdmin Role: %s\n", userId, userName, password, adminRole);
			return str;
		}
	}



