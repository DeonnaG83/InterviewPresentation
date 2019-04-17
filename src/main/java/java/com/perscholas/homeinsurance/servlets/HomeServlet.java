package com.perscholas.homeinsurance.servlets;

import java.io.IOException; 
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Calendar.Builder;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.perscholas.homeinsurance.bo.QuoteBO;
import com.perscholas.homeinsurance.dao.HomeownerDAO;
import com.perscholas.homeinsurance.dao.LocationDAO;
import com.perscholas.homeinsurance.dao.PolicyDAO;
import com.perscholas.homeinsurance.dao.PropertyDAO;
import com.perscholas.homeinsurance.dao.QuoteDAO;
import com.perscholas.homeinsurance.dao.UserDAO;
import com.perscholas.homeinsurance.models.Homeowner;
import com.perscholas.homeinsurance.models.Location;
import com.perscholas.homeinsurance.models.Policy;
import com.perscholas.homeinsurance.models.Property;
import com.perscholas.homeinsurance.models.Quote;
import com.perscholas.homeinsurance.models.User;

@WebServlet("/")
public class HomeServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	List<String> errorList;
	
	
	/**Called by server to allows servlet to handle a GET request.
	* @param request An HttpServletResopnse Object that contains the request the client has made of the servlet.
	* @param response An HttpServletResponse Object that contains the response the servlet sends to the client.
	* @throws ServletException
	* @throws IOException
	*/	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String action = request.getServletPath();
		
		try
		{
			switch (action) 
			{
				case "/showLogin":
					showLoginPage(request, response);
					break;
				case "/login":
					loginUser(request, response);
					break;
				case "/logout":
					logout(request, response);
					break;
				case "/showRegistrationPage":
					showRegistrationPage(request, response);
					break;
				case "/registerUser":
					registerUser(request, response);
					break;
				case "/showWelcomePage":
					showWelcomePage(request, response);
					break;
				case "/showGetQuotePage1":
					showGetQuotePage1(request, response);
					break;
				case "/registerLocation":
					registerLocation(request, response);
					break;
				case "/showGetQuotePage2":
					showGetQuotePage2(request, response);
					break;
				case "/registerHomeowner":
					registerHomeowner(request,response);
					break;
				case "/showGetQuotePage3":
					showGetQuotePage3(request, response);
					break;
				case "/registerProperty":
					registerProperty(request, response);
					break;
				case"/showCoverageDetailsPage":
					showCoverageDetailsPage(request, response);
					break;
				case"/showAdditionalInfoPage":
					showAdditionalInfoPage(request, response);
					break;
				case"/showQuoteSummaryPage":
					showQuoteSummaryPage(request, response);
					break;
				case"/showBuyPolicyPage":
					showBuyPolicyPage(request, response);
					break;
				case"/showTermsAndConditionsPage":
					showTermsAndConditionsPage(request, response);
					break;
				case"/showPolicyConfirmationPage":
					showPolicyConfirmationPage(request, response);
					break;
				case"/registerPolicy":
					registerPolicy(request, response);
					break;
				case"/showRetrieveQuotePage":
					showRetrieveQuotePage(request, response);
					break;
				case"/retrieveQuote":
					retrieveQuote(request, response);
					break;
				case"/displayQuotePage":
					displayQuotePage(request, response);
					break;
				case"/getQuoteDetails":
					getQuoteDetails(request, response);
					break;
				default:
					showLoginPage(request, response);
			}
		}
		catch (Exception e)
		{
			e.getMessage();
		}
	}
	
	
	/**Called by server to allows servlet to handle a POST request.
	* @param request An HttpServletResopnse Object that contains the request the client has made of the servlet.
	* @param response An HttpServletResponse Object that contains the response the servlet sends to the client.
	* @throws ServletException
	* @throws IOException
	*/	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
	}
	
	/**GET the Login Page in the homeinsurance application.
	* @param request An HttpServletResopnse Object that contains the request the client has made of the servlet.
	* @param response An HttpServletResponse Object that contains the response the servlet sends to the client.
	* @throws ServletException
	* @throws IOException
	*/
	private void showLoginPage(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/LoginPage.jsp");
		rd.forward(request, response);
	}
	
	/**GET the Welcome Page in the homeinsurance application.
	* @param request An HttpServletResopnse Object that contains the request the client has made of the servlet.
	* @param response An HttpServletResponse Object that contains the response the servlet sends to the client.
	* @throws ServletException
	* @throws IOException
	* @throws SQLException
	*/
	private void showWelcomePage(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, SQLException 
	{
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/WelcomePage.jsp");
		rd.forward(request, response);
	}
	
	/**GET the Registration Page in the homeinsurance application.
	* @param request An HttpServletResopnse Object that contains the request the client has made of the servlet.
	* @param response An HttpServletResponse Object that contains the response the servlet sends to the client.
	* @throws ServletException
	* @throws IOException
	*/
	private void showRegistrationPage(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/RegistrationPage.jsp");
		rd.forward(request, response);
	}
	
	/**GET the Location Details Page in the homeinsurance application.
	* @param request An HttpServletResopnse Object that contains the request the client has made of the servlet.
	* @param response An HttpServletResponse Object that contains the response the servlet sends to the client.
	* @throws ServletException
	* @throws IOException
	*/
	private void showGetQuotePage1(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/GetQuotePage1.jsp");
		rd.forward(request, response);
	}
	
	
	/**GET the Homeowner details Page in the homeinsurance application.
	* @param request An HttpServletResopnse Object that contains the request the client has made of the servlet.
	* @param response An HttpServletResponse Object that contains the response the servlet sends to the client.
	* @throws ServletException
	* @throws IOException
	*/
	private void showGetQuotePage2(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/GetQuotePage2.jsp");
		rd.forward(request, response);
	}
	
	/**GET the Property details Page in the homeinsurance application.
	* @param request An HttpServletResopnse Object that contains the request the client has made of the servlet.
	* @param response An HttpServletResponse Object that contains the response the servlet sends to the client.
	* @throws ServletException
	* @throws IOException
	*/
	private void showGetQuotePage3(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/GetQuotePage3.jsp");
		rd.forward(request, response);
	}
	
	/**GET the Coverage details Page in the homeinsurance application.
	* @param request An HttpServletResopnse Object that contains the request the client has made of the servlet.
	* @param response An HttpServletResponse Object that contains the response the servlet sends to the client.
	* @throws ServletException
	* @throws IOException
	*/
	private void showCoverageDetailsPage(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/CoverageDetailsPage.jsp");
		rd.forward(request, response);
	}
	
	/**GET the Additional Info Page in the homeinsurance application.
	* @param request An HttpServletResopnse Object that contains the request the client has made of the servlet.
	* @param response An HttpServletResponse Object that contains the response the servlet sends to the client.
	* @throws ServletException
	* @throws IOException
	* @throws SQLException
	*/
	private void showAdditionalInfoPage(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, SQLException 
	{
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/additionalInfoPage.jsp");
		rd.forward(request, response);
	}
	
	/**GET the Quote Summary Page in the homeinsurance application.
	* @param request An HttpServletResopnse Object that contains the request the client has made of the servlet.
	* @param response An HttpServletResponse Object that contains the response the servlet sends to the client.
	* @throws ServletException
	* @throws IOException
	*/
	private void showQuoteSummaryPage(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/QuoteSummaryPage.jsp");
		rd.forward(request, response);
	}
	
	/**GET the Buy Policy in the homeinsurance application.
	* @param request An HttpServletResopnse Object that contains the request the client has made of the servlet.
	* @param response An HttpServletResponse Object that contains the response the servlet sends to the client.
	* @throws ServletException
	* @throws IOException
	* @throws SQLException
	*/
	private void showBuyPolicyPage(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, SQLException 
	{
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/BuyPolicyPage.jsp");
		rd.forward(request, response);
	}
	
	/**GET the Terms and Conditions Page in the homeinsurance application.
	* @param request An HttpServletResopnse Object that contains the request the client has made of the servlet.
	* @param response An HttpServletResponse Object that contains the response the servlet sends to the client.
	* @throws ServletException
	* @throws IOException
	* @throws SQLException
	*/
	private void showTermsAndConditionsPage(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, SQLException 
	{
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/TermsAndConditionsPage.jsp");
		rd.forward(request, response);
	}
	
	/**GET the Buy Policy in the homeinsurance application.
	* @param request An HttpServletResopnse Object that contains the request the client has made of the servlet.
	* @param response An HttpServletResponse Object that contains the response the servlet sends to the client.
	* @throws ServletException
	* @throws IOException
	* @throws SQLException
	*/
	private void showPolicyConfirmationPage(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, SQLException 
	{
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/PolicyConfirmationPage.jsp");
		rd.forward(request, response);
	}
	
	/**GET an existing quote in the homeinsurance application.
	* @param request An HttpServletResopnse Object that contains the request the client has made of the servlet.
	* @param response An HttpServletResponse Object that contains the response the servlet sends to the client.
	* @throws ServletException
	* @throws IOException
	* @throws SQLException
	*/
	private void showRetrieveQuotePage(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/RetrieveQuotePage.jsp");
		rd.forward(request, response);
	}
	
	/**GET the Quote display Page in the homeinsurance application.
	* @param request An HttpServletResopnse Object that contains the request the client has made of the servlet.
	* @param response An HttpServletResponse Object that contains the response the servlet sends to the client.
	* @throws ServletException
	* @throws IOException
	*/
	private void displayQuotePage(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/DisplayQuotePage.jsp");
		rd.forward(request, response);
	}
	
	/**Called by server to allow servlet to handle a login user POST request.
	* @param request An HttpServletResopnse Object that contains the request the client has made of the servlet.
	* @param response An HttpServletResponse Object that contains the response the servlet sends to the client.
	* @throws ServletException
	* @throws IOException
	* @throws ClassNotFoundException
	* @throws SQLException
	 * @throws ParseException 
	*/	
	private void loginUser(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, ClassNotFoundException, SQLException, ParseException 
	{
		HttpSession session = request.getSession();
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		UserDAO u_dao = new UserDAO();
		User user = u_dao.getUserByUsername(userName);
		errorList = new ArrayList<>();
		
		if( user == null)
		{	
			errorList.add("This user does not have a registered account. Please create an account. ");
		}
		else if(password.equals(user.getPassword())&&userName.equals(user.getUserName()))
		{
			HomeownerDAO hd = new HomeownerDAO();
			session.setAttribute("currentUser", user);
            Homeowner checkForHomeowner = hd.getHomeownerByUserId(user.getUserId());
            if(checkForHomeowner == null)
            {
            	response.sendRedirect("showWelcomePage");
            }
            else
            {
            	Homeowner userWithHomeowner = new Homeowner(user.getUserId(), user.getUserName(), user.getPassword(), user.getAdminRole());
            	userWithHomeowner.setFirstName(checkForHomeowner.getFirstName());
            	userWithHomeowner.setLastName(checkForHomeowner.getLastName());
            	String dob = (checkForHomeowner.getDateOfBirth().toString());
            	userWithHomeowner.setDateOfBirth(dob);
            	userWithHomeowner.setRetirementStatus(checkForHomeowner.getRetirementStatus());
            	userWithHomeowner.setSocialSecurityNum(checkForHomeowner.getSocialSecurityNumber());
            	userWithHomeowner.setEmailAddress(checkForHomeowner.getEmailAddress());
            	
            	session.setAttribute("currentHomeowner", userWithHomeowner);
            	
            	LocationDAO ld = new LocationDAO();
            	List<Location> locations =  ld.getLocationByUserId(userWithHomeowner.getUserId());
            	
            	if(locations.isEmpty())
            	{
            		response.sendRedirect("showWelcomePage");
            	}
            	else
            	{
            		session.setAttribute("currentLocations", locations);
            		QuoteDAO qd = new QuoteDAO();
            		Quote quote = null;
            		List<Quote> quotes = new ArrayList<>();
            		for(Location location: locations)
            		{
            			Integer locationId = location.getLocationId();
            			quote = qd.getQuoteByLocationId(locationId);
            			quotes.add(quote);
            			session.setAttribute("currentQuotes", quotes);
            		}
            		response.sendRedirect("showWelcomePage");
            	}
            }
        }
		else 
		{	
			
			if(!userName.equals(userName))
			{	
				errorList.add("This user does not have a registered account. Please create an account. ");
			}
			if(userName.isEmpty()||password.isEmpty())
			{
				errorList.add("All fields must me be completed. "); 
			}
			
			if(userName.equals(user.getUserName())&&!password.equals(user.getPassword()))	//Validate userName and password, login, and navigate to Welcome Page.
			{	
				errorList.add("Password does not match the associated account. ");
			}
		}
		
			request.setAttribute("errorList", errorList);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/LoginPage.jsp");
			rd.forward(request, response);
	}
	
	
	
	/**Called by server to allow servlet to handle a POST request.
	* @param request An HttpServletResopnse Object that contains the request the client has made of the servlet.
	* @param response An HttpServletResponse Object that contains the response the servlet sends to the client.
	* @throws ServletException
	* @throws IOException
	*/
	private void logout(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("showLogin");
	}
	
	
	/**Called by server to allows servlet to handle a POST request.
	* @param request An HttpServletResopnse Object that contains the request the client has made of the servlet.
	* @param response An HttpServletResponse Object that contains the response the servlet sends to the client.
	* @throws ServletException
	* @throws IOException
	* @throws ClassNotFoundException
	* @throws SQLException
	*/
	private void registerUser(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ClassNotFoundException, SQLException, ServletException 
	{
		User user = new User();
		UserDAO udao = new UserDAO();
		errorList = new ArrayList<>();
		
		
		//Declare variables and initialize values from HttpServletRequest Object. 
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String adminRole = request.getParameter("adminRole");
		
		
		//Verify all requirements are met for User registration, 
		//if not display appropriate error message.
		if (udao.getUserByUsername(userName)==null&&udao.getUserByPassword(password)==null&&password.equals(password2)&&userName.matches("[a-zA-Z0-9]+")
			&&userName.length() >=2 && userName.length()<=50 && 
			password.matches("[a-zA-Z0-9]+")&&password.length() >=8 && 
			password.length() <= 20&& userName!= null) 
		{
			//Create User Object and set values. Create UserDAO Object and insert into database.
			//Display login page.
			user.setUserName(userName);
			user.setPassword(password);
			if(adminRole.equals("true"))
				user.setAdminRole("admin");

			udao.registerUser(user);
			response.sendRedirect("showLogin");
		}
		else//If registration requirements not met, get appropriate error message(s) and display.
		{	
			if(udao.getUserByPassword(password)!=null)
			{
				errorList.add("The password has already been taken. Please try again using a different password.");
			}
			if(udao.getUserByUsername(userName)!=null)
			{
				errorList.add("The username has already been taken. Please try again using a different username.");
			}
			if(!password.equals(password2))
			{
				errorList.add("Passwords Do Not Match. Note: CASE SENSITIVE");
			}
			if(!userName.matches("[a-zA-Z0-9]+"))
			{
				errorList.add("User Name must be between 8 and 20 alphanumeric characters.");
			}
			if(!password.matches("[a-zA-Z0-9]+"))
			{
				errorList.add("Password must be between 8 and 20 alphanumeric characters.");
			}
			if(userName.length()<2||userName.length()>50)
			{
				errorList.add("User name must be at least 2 characters and a maximum of 50 characters.");
			}
			if(password.length()<2||password.length()>50)
			{
				errorList.add("Password must be at least 8 characters and a maximum of 20 characters.");
			}
			if(userName==null||password==null)
			{
				errorList.add("All fields must be completed.");
			}
		}
			//Display error list.
		request.setAttribute("errorList", errorList);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/RegistrationPage.jsp");
		rd.forward(request, response);
		
	}
	
	/**Called by server to allows servlet to handle a POST request.
	* @param request An HttpServletResopnse Object that contains the request the client has made of the servlet.
	* @param response An HttpServletResponse Object that contains the response the servlet sends to the client.
	* @throws ServletException
	* @throws IOException
	* @throws ClassNotFoundException
	* @throws SQLException
	* @throws ParseException
	*/
	private void registerLocation(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ClassNotFoundException, SQLException, ServletException 
	{
		HttpSession session=request.getSession();
		Location location = new Location();
		User user = (User)session.getAttribute("currentUser");
		
		//Declare variables and initialize values from HttpServletRequest Object. 
		String residenceType = request.getParameter("residenceType");
		String addressLine1 = request.getParameter("addressLine1");
		String addressLine2 = request.getParameter("addressLine2");
		String city = request.getParameter("city");
		String locationState = request.getParameter("locationState");
		String zipCode = request.getParameter("zipCode");
		String residenceUse = request.getParameter("residenceUse");
		
		location.setUserId(user);
		location.setResidenceType(residenceType);
		location.setAddressLine1(addressLine1);
		location.setAddressLine2(addressLine2);
		location.setCity(city);
		location.setLocationState(locationState);
		location.setZipCode(zipCode);
		location.setResidenceUse(residenceUse);
		
		if(location.getAddressLine1()!=null&&location.getCity()!=null&&location.getLocationState()!=null
			&&location.getZipCode()!=null&&location.getUserId()!=null)
		{
			// Create LocationDAO Object and insert into database.
			//Display homeowner information page.
			LocationDAO ldao = new LocationDAO();
			
			if(null == session.getAttribute("currentHomeowner"))
			{
				int id = ldao.registerLocation(location);
				location.setLocationId(id);
				session.setAttribute("currentLocation", location);
				response.sendRedirect("showGetQuotePage2");
			}
			else
			{
				Homeowner homeowner = (Homeowner)session.getAttribute("currentHomeowner");
				location.setHomeowner(homeowner);
				System.out.println(homeowner);
				int id = ldao.registerLocation(location);
				location.setLocationId(id);
				session.setAttribute("currentLocation", location);
				response.sendRedirect("showGetQuotePage3");
			}
			
				
		}
		else//If registration requirements not met, get appropriate error message(s) and display.
		{	
			errorList = new ArrayList<>();
			if(location.getAddressLine1()==null)
			{
				errorList.add("Please enter a valid location address.");
			}
			if(location.getCity()==null)
			{
				errorList.add("Please enter a valid City.");
			}
			if(location.getLocationState()==null)
			{
				errorList.add("Please enter a valid State.");
			}
			if(location.getZipCode()==null)
			{
				errorList.add("Please enter a valid zipcode.");
			}
		}
		request.setAttribute("errorList", errorList);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/GetQuotePage1.jsp");
		rd.forward(request, response);
	}
	
	
	/**Called by server to allows servlet to handle a POST request.
	* @param request An HttpServletResopnse Object that contains the request the client has made of the servlet.
	* @param response An HttpServletResponse Object that contains the response the servlet sends to the client.
	* @throws ServletException
	* @throws IOException
	* @throws ClassNotFoundException
	* @throws SQLException
	* @throws ParseException
	*/
	private void registerHomeowner(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ClassNotFoundException, SQLException, ServletException, ParseException 
	{
		
		HttpSession session=request.getSession();
		User user = (User) session.getAttribute("currentUser");
		Homeowner homeowner = new Homeowner(user.getUserId(), user.getUserName(), user.getPassword(), user.getAdminRole());
		
		//Declare variables and initialize values from HttpServletRequest Object. 
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String dob = request.getParameter("dob");
		String retiredStatus = request.getParameter("retiredStatus");
		boolean rStatus;
		if(retiredStatus.equals("true"))
			rStatus=true;
		else
			rStatus = false;
	
		String ssn = request.getParameter("ssn");
		String email = request.getParameter("email");
		homeowner.setFirstName(firstName);
		homeowner.setLastName(lastName);
		homeowner.setDateOfBirth(dob);
		homeowner.setRetirementStatus(rStatus);
		homeowner.setSocialSecurityNum(ssn);
		homeowner.setEmailAddress(email);
		
		if(homeowner.getFirstName()!=null&&homeowner.getLastName()!=null
			&&dob.matches("^(19|20)\\d\\d([-])(0[1-9]|1[012])\\2(0[1-9]|[12][0-9]|3[01])$")
			&&homeowner.getSocialSecurityNumber()!=null&&homeowner.getEmailAddress()!=null)
		{
			
			HomeownerDAO hdao = new HomeownerDAO();
			int id = hdao.registerHomeowner(homeowner);
			if(id!=-1)
			{
				Location location = (Location) session.getAttribute("currentLocation");
				location.setHomeowner(homeowner);
				session.setAttribute("currentHomeowner", homeowner);
				session.setAttribute("currentLocation",location);
				
				response.sendRedirect("showGetQuotePage3");
			}
		}
		else//If registration requirements not met, get appropriate error message(s) and display.
		{	
			errorList = new ArrayList<>();
		
			if(homeowner.getFirstName()==null)
			{
				errorList.add("Please enter a first name between 2 and 50 alphanumeric characters.");
			}
			if(homeowner.getLastName()==null)
			{
				errorList.add("Please enter a last name between 2 and 50 alphanumeric characters.");
			}
			if(!dob.matches(("^(19|20)\\d\\d([-])(0[1-9]|1[012])\\2(0[1-9]|[12][0-9]|3[01])$")))
			{
				errorList.add("Please enter a valid date of birth. Must be in YYYY-MM-DD format.");
			}
			if(homeowner.getSocialSecurityNumber()==null)
			{
				errorList.add("Please enter a valid Social Security number. Must be in 9 digit format.");
			}
			if(homeowner.getEmailAddress()==null)
			{
				errorList.add("Please enter a valid email address.");
			}
		}	
			request.setAttribute("errorList", errorList);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/GetQuotePage2.jsp");
			rd.forward(request, response);
	}
	
	
	/**Called by server to allows servlet to handle a POST request.
	* @param request An HttpServletResopnse Object that contains the request the client has made of the servlet.
	* @param response An HttpServletResponse Object that contains the response the servlet sends to the client.
	* @throws ServletException
	* @throws IOException
	*/
	private void registerProperty(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ClassNotFoundException, SQLException, ServletException, ParseException 
	{
		HttpSession session=request.getSession();
		Location location = (Location) session.getAttribute("currentLocation");
		Property property;
		
		if(location.getAddressLine2()!=null)
		{
			property = new Property(location.getHomeowner(), location.getResidenceType(), location.getAddressLine1(), location.getAddressLine2(),
											location.getCity(), location.getLocationState(),location.getZipCode(), location.getResidenceUse());
		}
		else
		{
			property = new Property(location.getHomeowner(), location.getResidenceType(), location.getAddressLine1(), 
					location.getCity(), location.getLocationState(),location.getZipCode(), location.getResidenceUse());
		}
	
		property.setLocationId(location.getLocationId());
		
		String marketValue = request.getParameter("marketValue".toString());
		String yearBuilt = request.getParameter("yearBuilt".toString());
		String squareFootage = request.getParameter("squareFootage".toString());
		String dwellingType = request.getParameter("dwellingType");
		String roofingMaterial = request.getParameter("roofingMaterial");
		String garageType = request.getParameter("garageType");
		String fullBaths = request.getParameter("fullBaths".toString());
		String halfBaths = request.getParameter("halfBaths".toString());
		String pool = request.getParameter("pool");
		
		boolean isPool;
		if(pool.equals("true"))
			isPool=true;
		else
			isPool = false;
		if(!marketValue.isEmpty())
			property.setMarketValue(Float.parseFloat(marketValue));
		if(!yearBuilt.isEmpty())
			property.setYearBuilt(Integer.parseInt(yearBuilt));
		if(!squareFootage.isEmpty())
			property.setSquareFootage(Integer.parseInt(squareFootage));
		property.setDwellingType(dwellingType);
		property.setRoofMaterial(roofingMaterial);
		property.setGarageType(garageType);
		property.setFullBaths(Integer.parseInt(fullBaths));
		property.setHalfBaths(Integer.parseInt(halfBaths));
		property.setPool(isPool);
		
		if(property.getMarketValue()!=null&&property.getYearBuilt()!=null&&property.getYearBuilt()<=2019
			&&property.getYearBuilt()>=1700&&property.getSquareFootage()!=null)
		{
			PropertyDAO pdao = new PropertyDAO();
			pdao.registerProperty(property);
			QuoteBO quoteBO = new QuoteBO();
			
			quoteBO.setProperty(property);
			quoteBO.setMonthlyPremium();
			quoteBO.setDwellingCoverage();
			quoteBO.setDetachedStructures();
			quoteBO.setPersonalProperty();
			quoteBO.setAddLivingExp();
			quoteBO.setMedicalExpense();
			quoteBO.setDeductable();
													
			Quote quote = new Quote(quoteBO.getProperty(),quoteBO.getMonthlyPremium(), quoteBO.getDwellingCoverage(),quoteBO.getDetachedStructures(), 
									quoteBO.getPersonalProperty(), quoteBO.getAddLivingExp(),quoteBO.getMedicalExpenses(),
									quoteBO.getDeductable());
			
			Integer qID = quoteBO.registerQuote(quote);
			quote.setQuoteId(qID);
			session.setAttribute("currentProperty", property);
			session.setAttribute("currentQuote",quote);
			response.sendRedirect("showCoverageDetailsPage");
		}
		else//If registration requirements not met, get appropriate error message(s) and display.
		{	
			errorList = new ArrayList<>();
	
			if(property.getMarketValue()==null)
			{
				errorList.add("Please enter a Market Value greater than 0. Only numbers and decimals can be entered");
			}
			if(property.getYearBuilt()==null||property.getYearBuilt()>2019||property.getYearBuilt()<1700)
			{
				errorList.add("Please enter a valid year between 1700 and 2019");
			}
			if(property.getSquareFootage()==null)
			{
				errorList.add("Please enter a Square Footage Value greater than 0.");
			}
			
		}	//Display error list.
		
		request.setAttribute("errorList", errorList);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/GetQuotePage3.jsp");
		rd.forward(request, response);
	}
	
	/**Called by server to allows servlet to handle a POST request.
	* @param request An HttpServletResopnse Object that contains the request the client has made of the servlet.
	* @param response An HttpServletResponse Object that contains the response the servlet sends to the client.
	* @throws ServletException
	* @throws IOException
	*/
	private void registerPolicy(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ClassNotFoundException, SQLException, ServletException, ParseException 
	{
		HttpSession session=request.getSession();
		String startDate = request.getParameter("startDate");
		errorList = new ArrayList<>();
		
		if(Pattern.matches("^\\d{4}-\\d{2}-\\d{2}$", startDate))
		{	
			Date dateToStart;
			Builder calBuild = new Builder();
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			dateToStart = format.parse(startDate);
			dateToStart = new java.sql.Date(dateToStart.getTime());
			
			Date today = Calendar.getInstance().getTime();
			calBuild.setInstant(today);
			Calendar alterDate = calBuild.build();
			alterDate.add(Calendar.MONTH, 2);
			
			if (dateToStart.before(alterDate.getTime()))
			{
				alterDate.add(Calendar.MONTH, -2);
				if(dateToStart.after(alterDate.getTime()))
				{
					alterDate.add(Calendar.MONTH, -2);
					calBuild.setInstant(dateToStart);
					alterDate = calBuild.build();
					alterDate.add(Calendar.MONTH, 12);
					
					Quote quote = (Quote)session.getAttribute("currentQuote");
					Property property= (Property)session.getAttribute("currentProperty");
					
					Policy policy = new Policy(quote.getQuoteId(), property, quote.getMonthlyPremium(), quote.getDwellingCoverage(),
										quote.getDetachedStructures(),quote.getPersonalProperty(), quote.getAddLivingExp(), quote.getMedicalExpenses(),
										quote.getDeductable());
					
					Date dateToEnd =  alterDate.getTime();
					dateToEnd = new java.sql.Date(dateToEnd.getTime());
					
					policy.setEffectiveDate(startDate);
					policy.setEndDate(dateToEnd.toString());
					policy.setTerm(1);
					policy.setPolicyStatus("ACTIVE");
					
					PolicyDAO pd = new PolicyDAO();
					Integer pID = pd.registerPolicy(policy);
					policy.setPolicyId(pID);
					System.out.println(policy.getPolicyId());
					session.setAttribute("currentPolicy", policy);
					response.sendRedirect("showPolicyConfirmationPage");
				}
				else
				{
					errorList.add("The effectivie date can not be a past date.");
					request.setAttribute("errorList", errorList);
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/BuyPolicyPage.jsp");
					rd.forward(request, response);
				}
			}
			else
			{
				errorList.add("The effective date can not be more than 60 days past todays date.");
				request.setAttribute("errorList", errorList);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/BuyPolicyPage.jsp");
				rd.forward(request, response);
			}
		}
		else 
		{
			errorList.add("Please enter a date in the YYYY-MM-DD format");
			request.setAttribute("errorList", errorList);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/BuyPolicyPage.jsp");
			rd.forward(request, response);
		}
	}
	
	
	/**Called by server to allow servlet to handle a login user POST request.
	* @param request An HttpServletResopnse Object that contains the request the client has made of the servlet.
	* @param response An HttpServletResponse Object that contains the response the servlet sends to the client.
	* @throws ServletException
	* @throws IOException
	* @throws ClassNotFoundException
	* @throws SQLException
	 * @throws ParseException 
	*/	
	private void retrieveQuote(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, ClassNotFoundException, SQLException, ParseException 
	{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("currentUser");
		//if(null==)
		System.out.println("A");
		LocationDAO ld = new LocationDAO();
		System.out.println("b");
		
		
		System.out.println(user.getUserId());
		System.out.println("c");
		List<Location> locations = ld.getLocationByUserId(user.getUserId());
		System.out.println("d");
		session.setAttribute("currentLocations", locations);
		System.out.println("e");
		//String quoteId = request.getParameter("quoteId");
		//System.out.println("A");
		//QuoteDAO q_dao = new QuoteDAO();
		//System.out.println("B");
		//Quote quote = q_dao.getQuoteByQuoteId(Integer.parseInt(quoteId));
		//System.out.println("C");
		//errorList = new ArrayList<>();
		//System.out.println("D");
		//if( quote == null)
		//{	
		//	System.out.println("E");
		//	errorList.add("This quote does not exist. Please create a quote or tey a different Quote id number. ");
		//	session.setAttribute("errorList", errorList);
		//	response.sendRedirect("showRetrieveQuotePage");
		//}
		//else if(Integer.parseInt(quoteId) == quote.getQuoteId())
		//{
		//	System.out.println("F");
		//	session.setAttribute("currentQuote", quote);
		System.out.println("f");
			response.sendRedirect("showRetrieveQuotePage");
        //}
	}
	
	/**Called by server to allow servlet to handle a login user POST request.
	* @param request An HttpServletResopnse Object that contains the request the client has made of the servlet.
	* @param response An HttpServletResponse Object that contains the response the servlet sends to the client.
	* @throws ServletException
	* @throws IOException
	* @throws ClassNotFoundException
	* @throws SQLException
	 * @throws ParseException 
	*/	
	private void getQuoteDetails(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, ClassNotFoundException, SQLException, ParseException 
	{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("currentUser");
		//if(null==)
		System.out.println("A");
		LocationDAO ld = new LocationDAO();
		System.out.println("b");
		
		
		System.out.println(user.getUserId());
		System.out.println("c");
		List<Location> locations = ld.getLocationByUserId(user.getUserId());
		System.out.println("d");
		session.setAttribute("currentLocations", locations);
		System.out.println("e");
		//String quoteId = request.getParameter("quoteId");
		//System.out.println("A");
		//QuoteDAO q_dao = new QuoteDAO();
		//System.out.println("B");
		//Quote quote = q_dao.getQuoteByQuoteId(Integer.parseInt(quoteId));
		//System.out.println("C");
		//errorList = new ArrayList<>();
		//System.out.println("D");
		//if( quote == null)
		//{	
		//	System.out.println("E");
		//	errorList.add("This quote does not exist. Please create a quote or tey a different Quote id number. ");
		//	session.setAttribute("errorList", errorList);
		//	response.sendRedirect("showRetrieveQuotePage");
		//}
		//else if(Integer.parseInt(quoteId) == quote.getQuoteId())
		//{
		//	System.out.println("F");
		//	session.setAttribute("currentQuote", quote);
		System.out.println("f");
			response.sendRedirect("showDisplayQuotePage");
        //}
	}
}


	

