package com.perscholas.homeinsurance.models;

import java.sql.*;  
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

	/**This class represents a Homeowner Object in a Home Insurance Application.
	*Class: Platforms by Per Scholas Cognizant QE-01 2019
	*Date: 02/20/2019
	*@author: Deonna Green
	*@version: 1.0.0 
	*/

	public class Homeowner extends User
	{
		private String firstName;
		private String lastName;
		private Date dob;
		private boolean retiredStatus;
		private String ssn;
		private String email;
		
	/**Default(No argument) Constructor to create a Homeowner Object.*/
		
		public Homeowner()
		{
			super();
			firstName = null;
			lastName = null;
			dob = null;
			retiredStatus = false;
			ssn = null;
			email = null;
		}
		
	/**Parameterized Constructor to create a Homeowner Object. 
	*@param String userName Represents the username on the account.
	*@param String password Represents the password on the user account.
	*@param String adminRole Represents the adminRole of the user.
	*/
		public Homeowner(Integer userId, String userName, String password, String adminRole) throws ParseException
		{
			super(userName, password, adminRole);
			super.setUserId(userId);
			firstName = null;
			lastName = null;
			dob = null;
			retiredStatus = false;
			ssn = null;
			email = null;
		
		}
		
	/**Parameterized Constructor to create a Homeowner Object. 
	*@param String userName Represents the username on the account.
	*@param String password Represents the password on the user account.
	*@param String adminRole Represents the adminRole of the user.
	*@param firstName Represents the user's first name on the account.
	*@param lastName Represents the user's last name. *@param firstName Represents the user's first name on the account.
	*@param dob Represents the user's date of birth. Must be in yyyy-MM-dd format.
	*@param retiredStatus Is set to true if the user is retired, false if not.
	*@param ssn Represents the user's social security number.
	*@param email Represent the users email address.
	*@throws ParseException If date is not passed in proper "yyyy-MM-dd" format
	*/
		public Homeowner(String userName, String password, String adminRole, String firstName, String lastName,
						 String dateString, boolean retiredStatus, String ssn, String email) throws ParseException
		{
			super(userName, password, adminRole);
			
			if(firstName.length() >=2 && firstName.length()<=50
			&& Pattern.matches("[a-zA-Z0-9]+",firstName)) 
				this.firstName = firstName;
					
			if(lastName.length() >=3 && lastName.length() <= 50
			&& Pattern.matches("[a-zA-Z0-9]+", lastName))
				this.lastName = lastName;
				

			if(Pattern.matches("^\\d{4}-\\d{2}-\\d{2}$", dateString))
			{
				Date currentDate = new Date();
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				dob = format.parse(dateString);
				
				if(dob.after(currentDate))
					dob = null;
			}
			 
			this.retiredStatus = retiredStatus;
			
			if(Pattern.matches("[0-9]+",ssn) && ssn.length()==9)
				this.ssn = ssn;
			
			String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*"+
				      "@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
			
			if(Pattern.matches(emailPattern,email) && email.length() < 50)
				this.email = email;
		}
		
	/**Sets a value to the firstName field.
	*@param firstName Represents the value being set as the user's first name.
	*/
		public void setFirstName(String firstName)
		{
			if(firstName.length() >=2 && firstName.length()<=50
			&& Pattern.matches("[a-zA-Z0-9]+",firstName)) 
				this.firstName = firstName;
		}
				
	/**Sets a value to the lastName field.
	*@param lastName Represents the user's last name. 
	*/
		public void setLastName(String lastName)
		{
			if(lastName.length() >=3 && lastName.length() <= 50
			&& Pattern.matches("[a-zA-Z0-9]+", lastName))
				this.lastName = lastName;		
		}
			
	/**Sets a date value to the dob (date of birth) field.
	*The argument should be passed in the "yyyy-MM-dd" format. 
	*@param date Represents the user's date of birth.
	 * @throws ParseException 
	*/
		public void setDateOfBirth(String date) throws ParseException
		{
			if(Pattern.matches("^\\d{4}-\\d{2}-\\d{2}$", date))
			{
				Date currentDate = new Date();
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				dob = format.parse(date);
				dob = new java.sql.Date(dob.getTime());
				if(dob.after(currentDate))
					dob = null;
			}
		}
		
	/**Sets a true or false value to the retirementStatus field.
	*@param retiredStatus The field is set true if the user is retired, false if not. 
	*/
		public void setRetirementStatus(boolean retiredStatus)
		{
			this.retiredStatus = retiredStatus;
		}
		
	/**Sets the user's social security number to the ssn field.
	*@param ssn Represents the user's social security number. 
	*/
		public void setSocialSecurityNum(String ssn)
		{
			if(Pattern.matches("[0-9]+",ssn) && ssn.length()==9)
				this.ssn = ssn;				
		}
		
	/**Sets the user's email address to the email field.
	*@param email Represents the homeowners's email address. 
	*/
		public void setEmailAddress(String email)
		{
			String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*"+
				      "@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
			
			if(Pattern.matches(emailPattern,email) && email.length() < 50)
				this.email = email;					
		}
		
	/**Returns the current value set as the user's first name.
	*@return The current value set to the firstName field in the Homeowner Object.
	*/
		public String getFirstName()
		{
			return this.firstName;
		}
		
	/**Returns the current value set as the user's last name.
	*@return The current value set to the lastName field in the Homeowner Object.
	*/
		public String getLastName()
		{
			return this.lastName;
		}
		
	/**Returns the current date set as the user's date of birth.
	*@return The current date set to the dob field in the Homeowner Object.
	*/
		public java.sql.Date getDateOfBirth()
		{
			java.sql.Date sqlDob = new java.sql.Date(dob.getTime()); 
			return sqlDob;
		}
			
	/**Returns the user's current retirement status.
	*@return Returns true if the home owner is retired, false if not.
	*/
		public boolean getRetirementStatus()
		{
			return this.retiredStatus;
		}
		
	/**Returns the current value set as the user's social security number.
	*@return The current value set to the ssn field in the Homeowner Object.
	*/
		public String getSocialSecurityNumber()
		{
			return this.ssn;
		}
		
	/**Returns the current value set as the user's social security number.
	*@return The current value set to the ssn field in the Homeowner Object.
	*/
		public String getEmailAddress()
		{
			return this.email;
		}

	/**Returns a formatted representation of the Homeowner Objects' values.
	*@return Formatted representation of the Homeowner Objects' values.
	*/
		public String toString()
		{
			String str = String.format("User ID : %d \nFirst Name: %s \n"+
				"Last Name: %s \nDOB: %tF %nRetired Status: %s\nSSN: %s\n"+
				"Email: %s\n", getUserId(), firstName, lastName, 
			    dob, retiredStatus, ssn, email);

			return str;
		}
	}