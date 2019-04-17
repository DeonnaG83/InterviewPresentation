package com.perscholas.homeinsurance.models;

import java.util.regex.Pattern;

/**This class represents a Location Object in a Home Insurance Application.
*Class: Platforms by Per Scholas Cognizant QE-01 2019
*Date: 02/20/2019
*@author: Deonna Green
*@version: 1.0.0 
*/
	public class Location 
	{
		private Integer locationId;
		private User homeowner;
		private Integer userId;
		private String residenceType;
		private String addressLine1;
		private String addressLine2;
		private String city;
		private String locationState;
		private String zipCode;
		private String residenceUse;
		
/**Default(No argument) Constructor to create a Location Object.*/
		public Location()
		{
			locationId = null;
			homeowner = new Homeowner();
			userId = homeowner.getUserId();
			residenceType = null;
			addressLine1 = null;
			addressLine2 = null;
			city = null;
			locationState = null;
			zipCode = null;
			residenceUse = null;
		}
		
/**Parameterized Constructor to create a Location Object. 
*@param homeowner Homeowner Object representing a user and Homeowner.
*@param residenceType Represents the property type.
*@param addressLine1 Represents the street address of the property.
*@param city Represents the city the property is located in.
*@param locationState Represents the State the property is located in.
*@param zipCode Represents the zipcode where the property is located.
*@param residenceUse Represents primary use of property.
*/

		public Location(Homeowner homeowner, String residenceType,
						String addressLine1, String city, String locationState,
						String zipCode, String residenceUse)
		{
			locationId  = null;
			
			this.homeowner = homeowner;
			userId = homeowner.getUserId();
			
			switch(residenceType)
			{
				case "Single-Family Home":
					this.residenceType = residenceType;
					break;
				case "Condo":
					this.residenceType = residenceType;
					break;
				case "Townhouse":
					this.residenceType = residenceType;
					break;
				case "Rowhouse":
					this.residenceType = residenceType;
					break;
				case "Duplex":
					this.residenceType = residenceType;
					break;
				case "Apartment":
					this.residenceType = residenceType;
					break;
				default:
					this.residenceType = null;
			}
			
			if(addressLine1.length() >=3 && addressLine1.length()<=50
				&& Pattern.matches("[a-zA-Z0-9\\.\\-\\s\\,/]+",addressLine1)) 
					this.addressLine1 = addressLine1;
				
			this.addressLine2 = null;
				
			if(city.length() >=2 && city.length()<=25
				&& Pattern.matches("[a-zA-Z0-9\\s]+",city)) 
					this.city = city;
				
			if(locationState.length() >=2 && locationState.length()<=25
				&& Pattern.matches("[a-zA-Z0-9\\s]+",locationState)) 
					this.locationState = locationState;
				
			String autoFillZip;
			if(zipCode.length()==5)
			{
				autoFillZip = zipCode.concat("0000");
				this.zipCode = autoFillZip;
			}
			else if(zipCode.length()==9)
			{
				this.zipCode = zipCode;
			}
			else
				zipCode = null;
			
			switch(residenceUse)
			{
				case "Primary":
					this.residenceUse = residenceUse;
					break;
				case "Secondary":
					this.residenceUse = residenceUse;
					break;
				case "Rental Property":
					this.residenceUse = residenceUse;
					break;
				default:
					this.residenceUse = null;
			}
		}
		
/**Parameterized Constructor to create a Location Object. 
*@param user Homeowner Object representing the user.
*@param residenceType Represents the property type.
*@param addressLine1 Represents the street address of the property.
*@param addressLine2 Represents additional address information.
*@param city Represents the city the property is located in.
*@param locationState Represents the State the property is located in.
*@param zipCode Represents the zipcode where the property is located.
*@param residenceUse Represents primary use of property.
*/
		public Location(Homeowner homeowner, String residenceType,
						String addressLine1, String addressLine2, 
						String city, String locationState, String zipCode, 
						String residenceUse)
		{
			locationId  = null;
			
			this.homeowner = homeowner;
			userId = homeowner.getUserId();
			
			switch(residenceType)
			{
				case "Single-Family Home":
					this.residenceType = residenceType;
					break;
				case "Condo":
					this.residenceType = residenceType;
					break;
				case "Townhouse":
					this.residenceType = residenceType;
					break;
				case "Rowhouse":
					this.residenceType = residenceType;
					break;
				case "Duplex":
					this.residenceType = residenceType;
					break;
				case "Apartment":
					this.residenceType = residenceType;
					break;
				default:
					this.residenceType = null;
			}
			
			if(addressLine1.length() >=3 && addressLine1.length()<=50
				&& Pattern.matches("[a-zA-Z0-9\\.\\-\\s\\,/]+",addressLine1)) 
					this.addressLine1 = addressLine1;
			
			if(addressLine2.length() >=3 && addressLine2.length()<=50
					&& Pattern.matches("[a-zA-Z0-9\\.\\-\\s\\,/]+",addressLine2)) 
						this.addressLine2 = addressLine2;
			else 
				this.addressLine2 = null;
			
				
			if(city.length() >=2 && city.length()<=25
				&& Pattern.matches("[a-zA-Z0-9\\s]+",city)) 
					this.city = city;
				
			if(locationState.length() >=2 && locationState.length()<=25
				&& Pattern.matches("[a-zA-Z0-9\\s]+",locationState)) 
					this.locationState = locationState;
				
			String autoFillZip;
			if(zipCode.length()==5)
			{
				autoFillZip = zipCode.concat("0000");
				this.zipCode = autoFillZip;
			}
			else if(zipCode.length()==9)
			{
				this.zipCode = zipCode;
			}
			else
				zipCode = null;
			
			switch(residenceUse)
			{
				case "Primary":
					this.residenceUse = residenceUse;
					break;
				case "Secondary":
					this.residenceUse = residenceUse;
					break;
				case "Rental Property":
					this.residenceUse = residenceUse;
					break;
				default:
					this.residenceUse = null;
			}
		}
/**Returns the location identification.
*@return Returns the location identification.
*/
		public Integer getLocationId() 
		{
			return this.locationId;
		}

/**Sets the location identification.
* @param locationId The location identification to set.
*/
		public void setLocationId(Integer locationId)
		{
			this.locationId = locationId;
		}

/**Sets the User Object for reference.
* @param Homeowner The Homeowner Object to be set for reference.
*/
		public void setUserId(User user)
		{
			this.userId = user.getUserId();
		}
		
/**Sets the User Object for reference.
* @param Homeowner The Homeowner Object to be set for reference.
*/
		public void setHomeowner(Homeowner homeowner)
		{			
			this.homeowner = homeowner;
		}

/**Returns the user identification number assigned to the Homeowner Object.
* @return The user identification number.
*/
		public Integer getUserId() 
		{
			return this.userId;
		}
		
/**Returns the Homeowner associated the Location Object.
* @return The associated Homeowner Object.
*/
		public Homeowner getHomeowner() 
		{
			return (Homeowner) this.homeowner;
		}
		


/**Returns the residence type.
* @return The residence type.
*/
		public String getResidenceType() 
		{
			return residenceType;
		}

/**Sets the residence type.
* @param residenceType The residence type to set.
*/
		public void setResidenceType(String residenceType) 
		{
			switch(residenceType)
			{
				case "Single-Family Home":
					this.residenceType = residenceType;
					break;
				case "Condo":
					this.residenceType = residenceType;
					break;
				case "Townhouse":
					this.residenceType = residenceType;
					break;
				case "Rowhouse":
					this.residenceType = residenceType;
					break;
				case "Duplex":
					this.residenceType = residenceType;
					break;
				case "Apartment":
					this.residenceType = residenceType;
					break;
				default:
					this.residenceType = null;
			}
			
		}

/**Returns the locations address.
 * @return The locations address.
*/
		public String getAddressLine1()
		{
			return this.addressLine1;
		}

/**Sets the address of the location.
* @param addressLine1 Represents the address of the location.
*/
		public void setAddressLine1(String addressLine1)
		{
			if(addressLine1.length() >=3 && addressLine1.length()<=50
			   && Pattern.matches("[a-zA-Z0-9\\.\\-\\s\\,/]+",addressLine1)) 
				this.addressLine1 = addressLine1;
		}

/**Returns additional address information.
* @return Any additional address information.
*/
		public String getAddressLine2()
		{
			return this.addressLine2;
		}

/**Sets the additional address information
* @param addressLine2 Represents additional address information to set.
*/
		public void setAddressLine2(String addressLine2) 
		{
			if(addressLine2.length() >=3 && addressLine2.length()<=50
			   && Pattern.matches("[a-zA-Z0-9\\.\\-\\s\\,/]+",addressLine2)) 
				this.addressLine2 = addressLine2;
			else 
				this.addressLine2 =null;
		}

/**Returns the city the property is located in.
* @return The city the property is located in.
*/
		public String getCity()
		{
			return city;
		}

/**Sets the city the property is located in.
* @param city The city to set where the property is located in.
*/
		public void setCity(String city) 
		{
			if(city.length() >=2 && city.length()<=25
			   && Pattern.matches("[a-zA-Z0-9\\s]+",city)) 
			this.city = city;
		}

/**Returns the state the property is located in.
* @return The state the property is located in.
*/
		public String getLocationState() 
		{
			return this.locationState;
		}

/**Sets the state the property is located in.
* @param locationState Represents the state the property is located in.
*/
		public void setLocationState(String locationState)
		{
			if(locationState.length() >=2 && locationState.length()<=25
			   && Pattern.matches("[a-zA-Z0-9\\s]+",locationState)) 
					this.locationState = locationState;
		}

/**Returns the zipcode the property is located in.
* @return The zipCode the property is located in.
*/
		public String getZipCode()
		{
			return this.zipCode;
		}

/**Sets the zipcode the property is located in.
* @param zipCode The zipcode where the property is located to be set.
*/
		public void setZipCode(String zipCode)
		{
			String autoFillZip;
			if(zipCode.length()==5)
			{
				autoFillZip = zipCode.concat("0000");
				this.zipCode = autoFillZip;
			}
			else if(zipCode.length()==9)
			{
				this.zipCode = zipCode;
			}
			else
				zipCode = null;
		}

/**Returns the primary use status of the property.
* @return The primary use status of the property.
*/
		public String getResidenceUse()
		{
			return this.residenceUse;
		}

/**Sets the primary use of the property.
* @param residenceUse The primary use of the residence to be set.
*/
		public void setResidenceUse(String residenceUse) 
		{
			switch(residenceUse)
			{
				case "Primary":
					this.residenceUse = residenceUse;
					break;
				case "Secondary":
					this.residenceUse = residenceUse;
					break;
				case "Rental Property":
					this.residenceUse = residenceUse;
					break;
				default:
					this.residenceUse = null;
			}
		}
		
	/**Returns a formatted representation of the Location Objects' values.
	 *@return Formatted representation of the Location Objects' values.
	*/	
		public String toString()
		{
			String str = String.format("User ID : %d \nLocation ID: %d \n"+
				"Residence Type: %s \nAddress Line 1: %s \nAddress Line 2: %s\nCity: %s\n"+
				"State: %s\nZip Code: %s\nResidence Use: %s\n", getUserId(), locationId, residenceType, addressLine1, addressLine2,
			    city, locationState, zipCode, residenceUse);

			return str;
		}

}
