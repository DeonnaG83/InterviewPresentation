package com.perscholas.homeinsurance.daoTest;

import static org.junit.Assert.assertArrayEquals; 
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.perscholas.homeinsurance.dao.LocationDAO;
import com.perscholas.homeinsurance.dao.UserDAO;
import com.perscholas.homeinsurance.models.Homeowner;
import com.perscholas.homeinsurance.models.Location;
import com.perscholas.homeinsurance.models.User;

public class LocationDAOTest 
{ 
		private static User user, user2, user3;
		private static UserDAO ud;
		private static Location location, location2, location3, location4;
		private static LocationDAO ld;
		private static Integer userId, userId2, userId3, locationId, locationId2, locationId3;
		private static List<Location> actual, expected;
		
		@BeforeClass
		public static void setUp() throws ClassNotFoundException, SQLException, IOException, ParseException
		{
			ud = new UserDAO();
			ld = new LocationDAO();	
			actual = new ArrayList<Location>();
			expected = new ArrayList<Location>();
			
			//Initialize variables for test# 1
			user = new User("Username13079","Password13079","user");
			userId = ud.registerUser(user);
			user.setUserId(userId);										//Register the User Object so the user ID can be generated.
			Homeowner homeowner = new Homeowner(userId, "Username13079","Password13079", "user");
																		//Set the user ID to the User Object provided by the database(return value of registerUser)
			location = new Location(homeowner, "Townhouse", "430  W Cherry st","upper", "Milwaukee", "Wisconsin",
					   			 	"53208PQ38", "Secondary");
																		//Create a location Object and a LocationDAO Object for testing.
			
			
			//Initialize variables for test# 2
			user2 = new User("Username1186","Password1186","admin");
			userId2 = ud.registerUser(user2);						//Register the User Object so the user ID can be generated.
			user2.setUserId(userId2);
			//location2 = new Location(user2, "Condo", "1849 N 60th st", "South", "Dallas", "Texas",
	   		//	 					"53209", "Primary");
			//CHANGED CONSTRUCTOR NEED TO MAKE EDITS
			//Initialize variables for test# 3
			user3 = new User("LoriGreen74","LoriGreene74","admin");
			userId3 = ud.registerUser(user3);						//Register the User Object so the user ID can be generated.
			user3.setUserId(userId3);
			//location4 = new Location(user3, "Single-Family Home", "675 Sesame St", "Manitowoc", "Wisconsin",
	   		//	 					"53209", "Primary");
			//CHANGED CONSTRUCTOR NEED TO MAKE EDITS
		}
		
		@Test
		//This test assumes the User Object being passed has been properly inserted into the database
		public void testRegisterLocation() throws SQLException, ClassNotFoundException, IOException
		{
			System.out.println("\nBEGIN TEST #1\n------------------------------");
			locationId = ld.registerLocation(location);														//Set the value returned from registerLocation method(location ID provided by database) to the location Id attribute.
			if(locationId!=-1)																				//If -1 is returned the Location Object was not properly inserted. If not, set locationId
				location.setLocationId(locationId);
			System.out.println("\n"+location);																//Display Location Object being tested
			assertNotSame(Integer.toString(user.getUserId()), Integer.toString(location.getUserId()));		//Validates different Objects are being tested against each other.
			assertEquals(Integer.toString(user.getUserId()), Integer.toString(location.getUserId()));		//If properly inserted the User Object's userId should match the location Objects userId
			assertNotSame(Integer.toString(locationId), Integer.toString(location.getLocationId()));											//If properly inserted the value of locationId should match the value returned from the getLocation Id method
			assertEquals(Integer.toString(locationId), Integer.toString(location.getLocationId()));
			System.out.println("END TEST #1\n------------------------------");
		}																									//Remember the value will not be set to the Location Objects locationId variable if -1(failed insert) was 
																											//returned from the LocationDAO registerLocation method.
		


	@Test
	public void testGetLocationByLocationId() throws ClassNotFoundException, IOException, SQLException, ParseException 
	{
		System.out.println("\nBEGIN TEST #2\n---------------------------------");
		locationId2 = ld.registerLocation(location2);					//Set the value returned from registerLocation method(location ID provided by database) to the location Id attribute.
		if(locationId2!=-1)												//If -1 is returned the Location Object was not properly inserted. If not, set locationId
			location2.setLocationId(locationId2);
		location3 = ld.getLocationByLocationId(locationId2);
		System.out.println(location2+"\n");
		System.out.println(location3+"\n");
		assertNotSame(location2.toString(), location3.toString());
		assertEquals(location2.toString(), location3.toString());
		System.out.println("END TEST #2\n-------------------------------------");
	}

	@Test
	public void testGetLocationByUserId() throws ClassNotFoundException, IOException, SQLException 
	{
		System.out.println("\nBEGIN TEST #3\n---------------------------------");
		locationId3 = ld.registerLocation(location4);					//Set the value returned from registerLocation method(location ID provided by database) to the location Id attribute.
		actual.add(location4);
		if(locationId3!=-1)												//If -1 is returned the Location Object was not properly inserted. If not, set locationId
			location4.setLocationId(locationId3);
		//expected = ld.getLocationByUserId(userId3);
		System.out.print("\n*******ACTUAL USER DATA*******\n"+actual.get(0)+"\n"			//Display actual and expected results from both list.
				+ "*******EXPECTED USER DATA*******\n"+expected.get(0)+"\n");
		assertNotSame(actual.get(0).toString(),expected.get(0).toString());					//Validates 2 different Objects are being tested against.
		assertEquals(actual.get(0).toString(),expected.get(0).toString());					//Validates both String values are equivalent.
	
		System.out.println("END TEST #3\n-------------------------------------");					
	}
}		//CHANGED CONSTRUCTOR NEED TO MAKE EDITS
