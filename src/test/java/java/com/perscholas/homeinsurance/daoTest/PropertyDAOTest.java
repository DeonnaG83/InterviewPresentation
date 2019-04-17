package com.perscholas.homeinsurance.daoTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.perscholas.homeinsurance.dao.LocationDAO;
import com.perscholas.homeinsurance.dao.PropertyDAO;
import com.perscholas.homeinsurance.dao.UserDAO;
import com.perscholas.homeinsurance.models.Homeowner;
import com.perscholas.homeinsurance.models.Location;
import com.perscholas.homeinsurance.models.Property;
import com.perscholas.homeinsurance.models.User;

public class PropertyDAOTest
{
	private static User homeowner;		//CHANGED CONSTRUCTORS EDITS NEEDED
	private static UserDAO ud;
	private static Location location;
	private static LocationDAO ld;
	private static Property property;
	private static PropertyDAO pd;
	private static Integer userId, locationId;
	private static List<Property> actual, expected;
	
	@BeforeClass
	public static void setUp() throws ClassNotFoundException, SQLException, IOException
	{
		pd = new PropertyDAO();	
		ud = new UserDAO();
		ld = new LocationDAO();
		actual = new ArrayList<Property>();
		expected = new ArrayList<Property>();
		
		//Initialize variables for test# 1
		//user = new User("Property004","PropPass004","user");	//Create User Object to Passed to Location Object.
		//userId = ud.registerUser(user);							//Register the User Object so the user ID can be generated.
		//user.setUserId(userId);									//Set the user ID to the User Object provided by the database(return value of registerUser).
		
		Homeowner homeowner = new Homeowner();
		location = new Location(homeowner, "Townhouse", "3314  W Cherry st","upper", "Milwaukee", "Wisconsin",
   			 					"75215", "Secondary");
		locationId = ld.registerLocation(location);
		location.setLocationId(locationId);
		
		//property = new Property(user, "Townhouse", "6167  W Cherry st","upper", "Milwaukee", "Wisconsin",
			//	   			 	"53208PQ38", "Secondary", 25000.00f, 1983, 20000, "2.5 Story", "Attached", "Rubber", 3, 2, true);
	}
	
	@Test
	//This test assumes the User Object being passed has been properly inserted into the database
	public void testRegisterLocation() throws SQLException, ClassNotFoundException, IOException
	{
		System.out.println("\nBEGIN TEST #1\n------------------------------");
		pd.registerProperty(property);														//Set the value returned from registerLocation method(location ID provided by database) to the location Id attribute.
		if(locationId!=-1)																				//If -1 is returned the Location Object was not properly inserted. If not, set locationId
			property.setLocationId(locationId);
		System.out.println("\n"+property);																//Display Location Object being tested
		assertNotSame(Integer.toString(property.getLocationId()), Integer.toString(location.getLocationId()));		//Validates different Objects are being tested against each other.
		assertEquals(Integer.toString(property.getLocationId()), Integer.toString(location.getLocationId()));		//If properly inserted the User Object's userId should match the location Objects userId
		assertNotSame(Integer.toString(locationId), Integer.toString(property.getLocationId()));											//If properly inserted the value of locationId should match the value returned from the getLocation Id method
		assertEquals(Integer.toString(locationId), Integer.toString(property.getLocationId()));
		System.out.println("END TEST #1\n------------------------------");
	}	
}
