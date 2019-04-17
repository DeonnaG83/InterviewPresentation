package com.perscholas.homeinsurance.models;

/**This class represents a Property Object in a Home Insurance Application. 
*It is a child class of Location. 
*Class: Platforms by PerScholas Cognizant QE-01 2019
*Date: 02/20/2019
*@author: Deonna Green
*@version: 1.0.0 
*/
public class Property extends Location
{
	private Float marketValue;
	private Integer yearBuilt;
	private Integer squareFootage;
	private String dwellingType;
	private String roofMaterial;
	private String garageType;
	private Integer fullBaths;
	private Integer halfBaths;
	private boolean pool;
	
/**Default(No argument) Constructor to create a Property Object.*/
	public Property()
	{
		super();
		marketValue = null;
		yearBuilt = null;
		squareFootage = null;
		dwellingType = null;
		roofMaterial = null;
		garageType = null;
		fullBaths = null;
		halfBaths = null;
		pool = false;
	}
	
	/**Parameterized Constructor to create a User Object.
	*@param homeowner Homeowner Object representing the user and homeowner.
	*@param locationId Represents the location identification number.
	*@param residenceType Represents the property type.
	*@param addressLine1 Represents the street address of the property.
	*@param addressLine2 Represents additional address information.
	*@param city Represents the city the property is located in.
	*@param locationState Represents the State the property is located in.
	*@param zipCode Represents the zipcode where the property is located.
	*@param residenceUse Represents primary use of property.*/
	public Property(Homeowner homeowner, String residenceType, String addressLine1, String addressLine2, String city, 
	String locationState, String zipCode, String residenceUse)
	{
		
		super(homeowner, residenceType, addressLine1, addressLine2, city, 
			locationState, zipCode, residenceUse);
		marketValue = null;
		yearBuilt = null;
		squareFootage = null;
		dwellingType = null;
		roofMaterial = null;
		garageType = null;
		fullBaths = null;
		halfBaths = null;
		pool = false;
	}
	
	
	/**Parameterized Constructor to create a User Object.
	*@param homeowner Homeowner Object representing the user and homeowner.
	*@param locationId Represents the location identification number.
	*@param residenceType Represents the property type.
	*@param addressLine1 Represents the street address of the property.
	*@param addressLine2 Represents additional address information.
	*@param city Represents the city the property is located in.
	*@param locationState Represents the State the property is located in.
	*@param zipCode Represents the zipcode where the property is located.
	*@param residenceUse Represents primary use of property.*/
	public Property(Homeowner homeowner, String residenceType, String addressLine1, String city, 
	String locationState, String zipCode, String residenceUse)
	{
		
		super(homeowner, residenceType, addressLine1, city, 
			locationState, zipCode, residenceUse);
		marketValue = null;
		yearBuilt = null;
		squareFootage = null;
		dwellingType = null;
		roofMaterial = null;
		garageType = null;
		fullBaths = null;
		halfBaths = null;
		pool = false;
	}
	
/**Parameterized Constructor to create a User Object.
*@param homeowner Homeowner Object representing the user and homeowner.
*@param locationId Represents the location identification number.
*@param residenceType Represents the property type.
*@param addressLine1 Represents the street address of the property.
*@param addressLine2 Represents additional address information.
*@param city Represents the city the property is located in.
*@param locationState Represents the State the property is located in.
*@param zipCode Represents the zipcode where the property is located.
*@param residenceUse Represents primary use of property. 
*@param marketValue Represents the market value of the property.
*@param yearBuilt Represents the year the property was built.
*@param squareFootage Represents the square footage of the property.
*@param dwellingType Represents the story level of the property.
*@param garageType Represents garage option and type.
*@param roofType Represents the material the roof is made of.
*@param fullBaths Represents the number of full bathrooms in the property.
*@param halfBaths Represents the number of half bathrooms in the property.
*@param pool Sets true if the property has a pool, false if not.
*/	
	public Property(Homeowner homeowner, Integer locationId, String residenceType, String addressLine1, String addressLine2, String city, 
					String locationState, String zipCode, String residenceUse, Float marketValue, 
					Integer yearBuilt,Integer squareFootage, String dwellingType, String garageType,
					String roofMaterial, Integer fullBaths, Integer halfBaths, boolean pool)
	{
		super(homeowner, residenceType, addressLine1, addressLine2, city, locationState, zipCode, residenceUse);
		super.setLocationId(locationId);
		
		if(marketValue >= 0 && marketValue != null)
		{
			this.marketValue = marketValue;
		}
		else
		{
			this.marketValue = null;
		}
		if(yearBuilt <= 2019 && yearBuilt != null)
		{
			this.yearBuilt = yearBuilt;
		}
		if(squareFootage >= 0 && squareFootage != null)
		{
			this.squareFootage = squareFootage;
		}
		else
		{
			this.squareFootage = null;
		}
		switch(dwellingType)
		{
			case "1 Story":
				this.dwellingType = dwellingType;
				break;
			case "1.5 Story":
				this.dwellingType = dwellingType;
				break;
			case "2 Story":
				this.dwellingType = dwellingType;
				break;
			case "2.5 Story":
				this.dwellingType = dwellingType;
				break;
			case "3 Story":
				this.dwellingType = dwellingType;
				break;
			default:
				this.dwellingType = null;
		}
		
		switch(roofMaterial)
		{
			case "Concrete":
				this.roofMaterial = roofMaterial;
				break;
			case "Clay":
				this.roofMaterial = roofMaterial;
				break;
			case "Rubber":
				this.roofMaterial = roofMaterial;
				break;
			case "Steel":
				this.roofMaterial = roofMaterial;
				break;
			case "Tin":
				this.roofMaterial = roofMaterial;
				break;
			case "Wood":
				this.roofMaterial = roofMaterial;
				break;
			default:
				this.roofMaterial = null;
		}
		
		switch(garageType)
		{
			case "Attached":
				this.garageType = garageType;
				break;
			case "Detached":
				this.garageType = garageType;
				break;
			case "Basement":
				this.garageType = garageType;
				break;
			case "Built-In":
				this.garageType = garageType;
				break;
			case "None":
				this.garageType = garageType;
				break;
			default:
				this.garageType = null;
		}
		
		if(fullBaths == 1)
		{
			this.fullBaths = fullBaths;
		}
		else if(fullBaths==2)
		{
			this.fullBaths = fullBaths;
		}
		else if(fullBaths==3)
		{
			this.fullBaths = fullBaths;
		}
		else if(fullBaths > 3)
		{
			this.fullBaths = fullBaths;
		}
		else
			fullBaths = null;
		
		if(halfBaths == 1)
		{
			this.halfBaths = halfBaths;
		}
		else if(halfBaths==2)
		{
			this.halfBaths = halfBaths;
		}
		else if(halfBaths==3)
		{
			this.halfBaths = halfBaths;
		}
		else if(halfBaths > 3)
		{
			this.halfBaths = halfBaths;
		}
		else
			halfBaths = null;
		
		if(pool == true)
			this.pool = pool;
		else 
			this.pool = false;
	}
	
	/**Parameterized Constructor to create a User Object.
	*@param locationId Represents the location identification number.
	*@param marketValue Represents the market value of the property.
	*@param yearBuilt Represents the year the property was built.
	*@param squareFootage Represents the square footage of the property.
	*@param dwellingType Represents the story level of the property.
	*@param garageType Represents garage option and type.
	*@param roofType Represents the material the roof is made of.
	*@param fullBaths Represents the number of full bathrooms in the property.
	*@param halfBaths Represents the number of half bathrooms in the property.
	*@param pool Sets true if the property has a pool, false if not.
	*/	
		public Property(Integer locationId, Float marketValue, 
						Integer yearBuilt,Integer squareFootage, String dwellingType, String garageType,
						String roofMaterial, Integer fullBaths, Integer halfBaths, boolean pool)
		{
			super();
			super.setLocationId(locationId);
			
			if(marketValue >= 0 && marketValue != null)
			{
				this.marketValue = marketValue;
			}
			if(yearBuilt <= 2019 && yearBuilt != null)
			{
				this.yearBuilt = yearBuilt;
			}
			if(squareFootage >= 0 && squareFootage != null)
			{
				this.squareFootage = squareFootage;
			}
			
			switch(dwellingType)
			{
				case "1 Story":
					this.dwellingType = dwellingType;
					break;
				case "1.5 Story":
					this.dwellingType = dwellingType;
					break;
				case "2 Story":
					this.dwellingType = dwellingType;
					break;
				case "2.5 Story":
					this.dwellingType = dwellingType;
					break;
				case "3 Story":
					this.dwellingType = dwellingType;
					break;
				default:
					this.dwellingType = null;
			}
			
			switch(roofMaterial)
			{
				case "Concrete":
					this.roofMaterial = roofMaterial;
					break;
				case "Clay":
					this.roofMaterial = roofMaterial;
					break;
				case "Rubber":
					this.roofMaterial = roofMaterial;
					break;
				case "Steel":
					this.roofMaterial = roofMaterial;
					break;
				case "Tin":
					this.roofMaterial = roofMaterial;
					break;
				case "Wood":
					this.roofMaterial = roofMaterial;
					break;
				default:
					this.roofMaterial = null;
			}
			
			switch(garageType)
			{
				case "Attached":
					this.garageType = garageType;
					break;
				case "Detached":
					this.garageType = garageType;
					break;
				case "Basement":
					this.garageType = garageType;
					break;
				case "Built-In":
					this.garageType = garageType;
					break;
				case "None":
					this.garageType = garageType;
					break;
				default:
					this.garageType = null;
			}
			
			if(fullBaths == 1)
			{
				this.fullBaths = fullBaths;
			}
			else if(fullBaths==2)
			{
				this.fullBaths = fullBaths;
			}
			else if(fullBaths==3)
			{
				this.fullBaths = fullBaths;
			}
			else if(fullBaths > 3)
			{
				this.fullBaths = fullBaths;
			}
			else
				fullBaths = null;
			
			if(halfBaths == 1)
			{
				this.halfBaths = halfBaths;
			}
			else if(halfBaths==2)
			{
				this.halfBaths = halfBaths;
			}
			else if(halfBaths==3)
			{
				this.halfBaths = halfBaths;
			}
			else if(halfBaths > 3)
			{
				this.halfBaths = halfBaths;
			}
			else
				halfBaths = null;
			
			if(pool == true)
				this.pool = true;
			else 
				this.pool = false;
		}
	
/**Returns the current value set as the property's market value.
*@return The current value set to the marketValue field in the Object.
*/
	public Float getMarketValue()
	{
		return this.marketValue;
	}
	
/**Sets the market value price to the marketValue field of the Object.
*@param marketValue Represents the market value price to the marketValue field.
*/
	public void setMarketValue(Float marketValue) 
	{
		if(marketValue >= 0 && marketValue != null)
		{
			this.marketValue = marketValue;
		}
		else
			this.marketValue = null;
	}

/**Returns the year the property was built.
*@return The year set to the yearBuilt field of the Object.
*/
	public Integer getYearBuilt() 
	{
		return this.yearBuilt;
	}

/**Sets a year value representing the year the property was built.
*@param yearBuilt Represents the year the property was built.
*/	
	public void setYearBuilt(Integer yearBuilt)
	{
		if(yearBuilt <= 2019 && yearBuilt>=1700)
		{
			this.yearBuilt = yearBuilt;
		}
		else 
			this.yearBuilt = null;
	}

/**Returns the current value set as the property's area in square feet.
*@return The current value set to the squareFootage field in the Object.
*/
	public Integer getSquareFootage()
	{
		return this.squareFootage;
	}
	
/**Sets a square footage value to the squareFootage field.
*@param squareFootage Represents the value being set as the square footage of the property.
*/
	public void setSquareFootage(Integer squareFootage) 
	{
		if(squareFootage >= 0 && squareFootage != null)
		{
			this.squareFootage = squareFootage;
		}
		else
			this.squareFootage = null;
	}
	
/**Returns the story level of the property.
*@return The type value set to the dwellingType field of the Object.
*/
	public String getDwellingType() 
	{
		return this.dwellingType;
	}

/**Sets the story level of the property.
*@param dwellingType Represents the story level of the property.
*/
	public void setDwellingType(String dwellingType) 
	{
		switch(dwellingType)
		{
			case "1 Story":
				this.dwellingType = dwellingType;
				break;
			case "1.5 Story":
				this.dwellingType = dwellingType;
				break;
			case "2 Story":
				this.dwellingType = dwellingType;
				break;
			case "2.5 Story":
				this.dwellingType = dwellingType;
				break;
			case "3 Story":
				this.dwellingType = dwellingType;
				break;
			default:
				this.dwellingType = null;
		}
	}

/**Returns the type of material the roof is made of.
* @return The type of material the roof is made of.
*/
	public String getRoofMaterial() 
	{
		return this.roofMaterial;
	}

/**Sets the type of material the roof is made of.
* @param roofMaterial Represents the type of material the roof is made of.
*/
public void setRoofMaterial(String roofMaterial)
	{
		switch(roofMaterial)
		{
			case "Concrete":
				this.roofMaterial = roofMaterial;
				break;
			case "Clay":
				this.roofMaterial = roofMaterial;
				break;
			case "Rubber":
				this.roofMaterial = roofMaterial;
				break;
			case "Steel":
				this.roofMaterial = roofMaterial;
				break;
			case "Tin":
				this.roofMaterial = roofMaterial;
				break;
			case "Wood":
				this.roofMaterial = roofMaterial;
				break;
			default:
				this.roofMaterial = null;
		}
	}

/**Returns the garage type.
 * @return The garage type.
 */
	public String getGarageType() 
	{
		return this.garageType;
	}

/**Sets the garage type.
 * @param Sets the garage type.
 */
	public void setGarageType(String garageType) 
	{
		switch(garageType)
		{
			case "Attached":
				this.garageType = garageType;
				break;
			case "Detached":
				this.garageType = garageType;
				break;
			case "Basement":
				this.garageType = garageType;
				break;
			case "Built-In":
				this.garageType = garageType;
				break;
			case "None":
				this.garageType = garageType;
				break;
			default:
				this.garageType = null;
		}
	}

/**Returns the amount of full bathrooms in the property.
 * @return The amount of full bathrooms on the property.
 */
	public Integer getFullBaths() 
	{
		return this.fullBaths;
	}

/**Sets the amount of full bathrooms in the property.
 * @param fullBaths Represents the number of full bathrooms on the property.
 */
	public void setFullBaths(Integer fullBaths) 
	{
		if(fullBaths == 1)
		{
			this.fullBaths = fullBaths;
		}
		else if(fullBaths==2)
		{
			this.fullBaths = fullBaths;
		}
		else if(fullBaths==3)
		{
			this.fullBaths = fullBaths;
		}
		else if(fullBaths > 3)
		{
			this.fullBaths = fullBaths;
		}
		else
			fullBaths = null;
	}

/**Returns the amount of half bathrooms in the property.
 * @return The amount of half bathrooms in the property.
 */
	public Integer getHalfBaths()
	{
		return halfBaths;
	}

/**Sets the amount of half bathrooms in the property.
 * @param Represents the amount of half bathrooms in the property.
 */
	public void setHalfBaths(Integer halfBaths) 
	{
		if(halfBaths == 1)
		{
			this.halfBaths = halfBaths;
		}
		else if(halfBaths==2)
		{
			this.halfBaths = halfBaths;
		}
		else if(halfBaths==3)
		{
			this.halfBaths = halfBaths;
		}
		else if(halfBaths > 3)
		{
			this.halfBaths = halfBaths;
		}
		else
			halfBaths = null;
	}

/**Returns true if the property has a pool, false if not.
 * @return True if the property has a pool, false if not.
 */
	public boolean isPool() 
	{
		return pool;
	}

/**Sets to true if the property includes a pool, false if not.
 * @param pool Set to true if the property includes a pool, false if not.
 */
	public void setPool(boolean pool)
	{
		if(pool == true)
			this.pool = true;
		else 
			this.pool = false;
	}
		
/**Returns a formatted representation of the Property Objects' values.
 *@return Formatted representation of the Property Objects' values.
*/	
		public String toString()
		{
			String str = String.format("User ID : %d \nLocation ID: %d \n"+
				"Market value: %.2f \nYear Built: %d \nSquare Footage: %d\nDwelling Type: %s\n"+
				"Roof Material: %s\nGarageType: %s\nFull Baths: %d\nHalf Baths: %d\nPool: %s\n", getUserId(), getLocationId(), marketValue, yearBuilt, squareFootage,
			    dwellingType, roofMaterial, garageType, fullBaths, halfBaths, pool);

			return str;
		}
}

