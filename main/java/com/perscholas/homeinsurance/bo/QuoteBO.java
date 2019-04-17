package com.perscholas.homeinsurance.bo;

import java.io.IOException;
import java.sql.SQLException;

import com.perscholas.homeinsurance.dao.QuoteDAO;
import com.perscholas.homeinsurance.models.Property;
import com.perscholas.homeinsurance.models.Quote;

public class QuoteBO extends Quote
{
	
	private QuoteDAO qdao;
	private Float exposureUnits = 1f;	//Initialized to 1 to account for the home
	private final Float euCoverageCost = 1000f;
	private final Float euRate = 5f;
	
	
	
	/**
	 * Default Constructor for QuoteBO
	 */
	public QuoteBO() 
	{	
		super();
		qdao = new QuoteDAO();
	}
	
	
	/**
	 * Registers a Quote Object into the data base
	 */
	public Integer registerQuote(Quote quote) 
			throws ClassNotFoundException, SQLException, IOException
	{
		Integer ID = qdao.registerQuote(quote);
		return ID;
	}
	
	/**
	 * Sets the monthly premium for the Quote Object based on 
	 * values provided by the Property Object.
	 */
	@Override
	public void setMonthlyPremium()
	{
		if(property.getGarageType()!="none")
		{
			exposureUnits = exposureUnits+1;
		}
		if(property.isPool()==true)
		{
			exposureUnits = exposureUnits+1;
		}
		Float rate = euRate * exposureUnits;
		Float yearlyPremium = rate *exposureUnits; 
		yearlyPremium = yearlyPremium + (property.getMarketValue()/euCoverageCost);
		if(property.getDwellingType().equals("SingleFamilyHome"))
		{
			yearlyPremium = yearlyPremium + (yearlyPremium*.05f);
		}
		else if(property.getDwellingType().equals("Condo")||property.getDwellingType().equals("Duplex")||property.getDwellingType().equals("Apartment"))
		{
			yearlyPremium = yearlyPremium + (yearlyPremium*.06f);
		}
		else
		{
			yearlyPremium = yearlyPremium + (yearlyPremium*.07f);
		}
		monthlyPremium = yearlyPremium/12;
	}
		
	/**
	 * Sets the Dwelling coverage for the Quote Object
	 * based on the values of the property
	*/
		@Override
		public void setDwellingCoverage()
		{
			Float constructionCost = 120f;
			Float homeValue = constructionCost* property.getSquareFootage();
			Float reduction = null;
			Integer ageOfHome = (2019 - property.getYearBuilt());
			if(ageOfHome<=5)
			{
				reduction = homeValue*.10f;
			}
			else if(ageOfHome>5&&ageOfHome<=10)
			{
				reduction = homeValue*.2f;
			}
			else if(ageOfHome>10&&ageOfHome<=20)
			{
				reduction = homeValue*.3f;
			}
			else if(ageOfHome>20)
			{
				reduction = homeValue*.5f;
			}
			homeValue = (homeValue - reduction);
			dwellingCoverage = ((property.getMarketValue()*.5f) + homeValue);
		}
	/**
	 * Sets the Detached Structures value for the Quote Object
	 * based on the values of the property.
	*/	
		@Override
		public void setDetachedStructures()
		{
			detachedStructures = (.1f * dwellingCoverage);
		}
		
	/**
	 * Sets the Personal Property value for the Quote Object
	 * based on the values of the property.
	 */		
		@Override
		public void setPersonalProperty()
		{
			personalProperty = ((.6f * dwellingCoverage));
		}
		
	/**
	 * Sets the Personal Property value for the Quote Object
	 * based on the values of the property.
	 */	
		@Override
		public void setAddLivingExp()
		{
			 addLivingExp = (.2f * dwellingCoverage);
		}
		
	/**
	 * Returns the value of medical expense coverage.
	 * @return Value of medical expense. 
	*/		
		@Override
		public void setDeductable()
		{
			deductable = (.1f * property.getMarketValue());
		}
		
	/**
	 * Returns the value of medical expense coverage.
	 * @return Value of medical expense. 
	*/	
		@Override
		public void setMedicalExpense()
		{
			medicalExpenses = 5000f;
		}
		
	
	/**Returns a formatted representation of the Property Objects' values.
	*@return Formatted representation of the Property Objects' values.
	*/	
		public String toString()
		{
			String str = super.toString();
			return str;
		}
	}
