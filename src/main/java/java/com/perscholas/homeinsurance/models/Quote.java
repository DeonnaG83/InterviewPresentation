package com.perscholas.homeinsurance.models;

/**This class represents a Quote Object in a Home Insurance Application.
*Class: Platforms by Per Scholas Cognizant QE-01 2019
*Date: 02/20/2019
*@author: Deonna Green
*@version: 1.0.0 
*/
public class Quote 
{
	protected Property property;
	private Integer quoteId;
	//private Location location;
	private Integer locationId;
	protected Float monthlyPremium;
	protected Float dwellingCoverage;
	protected Float detachedStructures;
	protected Float personalProperty;
	protected Float addLivingExp;
	protected Float medicalExpenses;
	protected Float deductable;
	
/**
* Default Constructor for Quote Object.
*/
	public Quote() 
	{
		property = new Property();
		quoteId = null;
		//location = new Location();
		locationId = property.getLocationId();
		monthlyPremium = null;
		dwellingCoverage = null;
		detachedStructures = null;
		personalProperty = null;
		addLivingExp = null;
		deductable = null;
	}
	
	
	public Quote(Property property) 
	{
		property = this.property;
		quoteId = null;
		//location = new Location();
		locationId = property.getLocationId();
		monthlyPremium = null;
		dwellingCoverage = null;
		detachedStructures = null;
		personalProperty = null;
		addLivingExp = null;
		deductable = null;
	}
	

	
	

/**Parameterized Constructor for a Quote Object
* @param quoteId Represents the quote identification number;
* @param location Represents a Location Object for reference;
* @param locationId Represents the location identification number;
* @param monthlyPremium Represents the dollar amount for the monthly premium coverage.
* @param dwellingCoverage Represents the dollar amount for the dwelling coverage.
* @param detachedStructures Represents the dollar amount for any coverage for detached structures.
* @param personalProperty Represents the dollar amount for personal property coverage.
* @param addLivingExp Represents the dollar amount for living expenses.
* @param medicalExpenses Represents the dollar amount for medical expenses coverage.
* @param deductable Represents the dollar amount for the deductable.
*/
	public Quote(Property property, Float monthlyPremium, Float dwellingCoverage,
			Float detachedStructures, Float personalProperty, Float addLivingExp, 
			Float medicalExpenses, Float deductable) 
	{
		if(property!=null)
		{
			this.property = property;
			this.locationId = property.getLocationId();
		}
		if(monthlyPremium > 0)
		{
			this.monthlyPremium = monthlyPremium;
		}
		if(dwellingCoverage > 0)
		{
			this.dwellingCoverage = dwellingCoverage;
		}
		if(detachedStructures > 0)
		{
			this.detachedStructures = detachedStructures;
		}
		if(personalProperty > 0)
		{
			this.personalProperty = personalProperty;
		}
		if(addLivingExp > 0)
		{
			this.addLivingExp = addLivingExp;
		}
		if(medicalExpenses > 0)
		{
			this.medicalExpenses = medicalExpenses;
		}
		if(deductable > 0)
		{
			this.deductable = deductable;
		}
	}

/**Returns the quote identification number
* @return The quote identification number.
*/
	public Integer getQuoteId() 
	{
		return this.quoteId;
	}

/**Returns the location identification number.
* @return The location identification number.
*/
	public Integer getLocationId() 
	{
		return this.locationId;
	}

/**Returns the monthly premium amount.
* @return The cost of the monthly premium.
*/
	public Float getMonthlyPremium() 
	{
		return this.monthlyPremium;
	}
	
/**Returns the total amount of coverage for the dwelling.
* @return The amount of coverage for the dwelling.	
*/
	public Float getDwellingCoverage()
	{
		return this.dwellingCoverage;
	}

/**Returns the total amount of coverage for any detached structures.
* @return The amount of coverage for any detached structures.	
*/
	public Float getDetachedStructures() 
	{
		return this.detachedStructures;
	}

/**Returns the total amount of coverage for any personal property.
* @return The amount of coverage for all personal property.	
*/
	public Float getPersonalProperty() 
	{
		return this.personalProperty;
	}

/**Returns the total amount of coverage for all living expenses.
* @return The amount of coverage for all living expenses.	
*/
	public Float getAddLivingExp() 
	{
		return this.addLivingExp;
	}

/**Returns the total amount of coverage for medical expenses.
* @return The amount of coverage for medical expenses.	
*/
	public Float getMedicalExpenses() 
	{
		return this.medicalExpenses;
	}

/**Returns the total amount of the deductable.
* @return The amount of the deductable.	
*/
	public Float getDeductable()
	{
		return this.deductable;
	}
	
/**Returns the Property Object associated with the quote.
* @return The Property Object associated with the quote.	
*/
	public Property getProperty()
	{
		return this.property;
	}
	
/**Returns the user Id associated with the Property Object's
* Location Object.
* @return The Property Object associated with the quote.	
*/
	public Integer getUserId()
	{
		return property.getUserId();
	}
	
/**Sets the quote identification number.
* @param quoteId The quote identification number to set.
*/
	public void setProperty(Property property) 
	{
		this.property = property;
	}
	


/**Sets the quote identification number.
* @param quoteId The quote identification number to set.
*/
	public void setQuoteId(Integer quoteId) 
	{
		this.quoteId = quoteId;
	}

/**Sets the location id for the Quote Object.
* @param property The Property Object referenced for the location identification number to set.
*/
	public void setLocationId(Property property) 
	{
		this.locationId = property.getLocationId();
	}

/**Sets the amount for the monthly premium.
* 
*/
	public void setMonthlyPremium() 
	{
		monthlyPremium = 0f;
	}

/**Sets the total dwelling coverage amount.
* 
*/
	public void setDwellingCoverage()
	{
		dwellingCoverage = 0f;
	}

/**Sets the total coverage amount for detached structures.
* 
*/
	public void setDetachedStructures()
	{
		detachedStructures = 0f;
	}

/**Sets the total personal property coverage amount.
* 
*/
	public void setPersonalProperty()
	{
		personalProperty =0f;
	}

/**Sets the total living expense coverage amount.
* 
*/
	public void setAddLivingExp() 
	{
		addLivingExp = 0f;
	}
	
/**Sets the total medical expense coverage amount.
* 
*/	
	public void setMedicalExpense()
	{
		medicalExpenses = 5000f;
	}


/**Sets the total living deductable amount.	
* 
*/
	public void setDeductable()
	{
		deductable = 0f;
	}
	
/**Returns a formatted representation of the Property Objects' values.
*@return Formatted representation of the Property Objects' values.
*/	
	public String toString()
	{
		String str = String.format("Quote ID : %d \nLocation ID: %d \n"+
			"Monthly Premium: %.2f \nDwelling Coverage: %.2f \nDetached Structures: %.2f\nPersonal Property: %.2f\n"+
			"Additional Living Expenses: %.2f\nMedical Expenses: %.2f\nDeductable: %.2f\n", quoteId, getLocationId(), monthlyPremium, dwellingCoverage,
		    detachedStructures, personalProperty, addLivingExp, medicalExpenses, deductable);

		return str;
	}
}
