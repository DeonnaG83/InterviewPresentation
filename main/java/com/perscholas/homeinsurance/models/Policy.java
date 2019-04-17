package com.perscholas.homeinsurance.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**This class represents a Policy Object in a Home Insurance Application.
*Class: Platforms by Per Scholas Cognizant QE-01 2019
*Date: 02/20/2019
*@author: Deonna Green
*@version: 1.0.0 
*/
public class Policy extends Quote
{
	private Integer userId;
	private Integer policyId;
	private Date effectiveDate;
	private Date endDate;
	private Integer term;
	private String policyStatus;
	
/**Default Constructor for Policy Object.
 */
	public Policy() 
	{
		super();
		policyId = null;
		effectiveDate = new Date();
		endDate = new Date();
		term = null;
		policyStatus = "cancelled";
	}
	
	/**Default Constructor for Policy Object.
	 */
		public Policy(Integer quoteId, Property property, Float monthlyPremium, Float dwellingCoverage,
				Float detachedStructures, Float personalProperty, Float addLivingExp, 
				Float medicalExpenses, Float deductable) 
		{
			super(property, monthlyPremium, dwellingCoverage,
					detachedStructures, personalProperty, addLivingExp, 
					medicalExpenses, deductable);
			policyId = null;
			super.setQuoteId(quoteId);
			userId = super.getUserId();
			effectiveDate = new Date();
			endDate = new Date();
			term = null;
			policyStatus = "cancelled";
		}
	

	
/**Parameterized Constructor for a Policy Object.
* @param policyId Represents the policy identification number.
* @param quote Represents the Quote Object to reference.
* @param user Represents the User Object to reference.
* @param quoteId Represents the quote identification number.
* @param userId Represents the user identification number.
* @param effectiveDate Represents the first day a policy is effective.
* @param endDate Represents the last day the policy is effective.
* @param term Represents the term of the policy.
* @param policyStatus Represents the current status of the policy(active or cancelled).
*/
	public Policy(int policyId, Date effectiveDate, Date endDate,
				  int term, String policyStatus) 
	{
		super();
		this.policyId = policyId;
		this.userId = getUserId();
		this.effectiveDate = effectiveDate;
		this.endDate = endDate;
		this.term = term;
		this.policyStatus = policyStatus;
	}

/**Returns the policy identification number.
* @return The policy identification number.
*/
	public Integer getPolicyId()
	{
		return this.policyId;
	}

/**Returns the quote identification number.
* @return The quote identification number.
*/
	public Integer getQuoteId()
	{
		return super.getQuoteId();
	}

/**Returns the user identification number.
* @return The user identification number.
*/
	public Integer getUserId()
	{
		return this.userId;
	}

	
/**Returns the last day the policy becomes effective.
* @return The last effective day of the policy.
*/
		public java.sql.Date getEffectiveDate()
		{
			java.sql.Date sqlDob = new java.sql.Date(effectiveDate.getTime()); 
			return sqlDob;
		}

/**Returns the last day the policy becomes effective.
* @return The last effective day of the policy.
*/
	public java.sql.Date getEndDate()
	{
		java.sql.Date sqlDob = new java.sql.Date(endDate.getTime()); 
		return sqlDob;
	}

/**Returns the term of the policy.
* @return The term of the policy.
*/
	public int getTerm() 
	{
		return this.term;
	}

/**Returns the current status of the policy(active or cancelled).
* @return The current status of the policy.
*/
	public String getPolicyStatus() 
	{
		return this.policyStatus;
	}

/**Sets the policy identification number.
* @param policyId The policy identification number to set.
*/
	public void setPolicyId(int policyId)
	{
		this.policyId = policyId;
	}


/**Sets the first day the policy is to go into effect.
* @param effectiveDate The first day the policy is to go into effect.
* @throws ParseException 
*/	
	public void setEffectiveDate(String effectiveDate) throws ParseException 
	{
		if(Pattern.matches("^\\d{4}-\\d{2}-\\d{2}$", effectiveDate))
		{
			Date startDate = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			startDate = format.parse(effectiveDate);
			startDate= new java.sql.Date(startDate.getTime());
			this.effectiveDate = startDate;
		}
		else effectiveDate = null;
	}

/**Sets the last day the policy is to go into effect.
* @param endDate The last day the policy is in effect.
 * @throws ParseException 
*/
	public void setEndDate(String endingDate) throws ParseException
	{
		if(Pattern.matches("^\\d{4}-\\d{2}-\\d{2}$", endingDate))
		{
			Date endDate = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			endDate = format.parse(endingDate);
			endDate= new java.sql.Date(endDate.getTime());
			this.endDate = endDate;
		}
		else endDate = null;
	}

/**Sets the term of the policy.
* @param term Represents the term of the policy.
*/
	public void setTerm(Integer term) 
	{
		this.term = term;
	}

/**Sets the current status of the policy.
* @param policyStatus Represents the status of the policy. (Active or cancelled)
*/
	public void setPolicyStatus(String policyStatus)
	{
		this.policyStatus = policyStatus;
	}	


/**Returns a formatted representation of the Property Objects' values.
*@return Formatted representation of the Property Objects' values.
*/	
	public String toString()
	{
		String str = String.format("Policy ID : %d \nQuote ID: %d \n"+
			"User ID: %d\nEffective Date: %tF\nEnd Date: %tF\nTerm: %d\n"+
			"Policy Status: %d\n", policyId, getQuoteId(), userId, effectiveDate, endDate, term, policyStatus);

		return str;
	}
}
