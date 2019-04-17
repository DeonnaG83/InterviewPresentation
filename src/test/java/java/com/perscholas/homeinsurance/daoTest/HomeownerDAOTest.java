//package com.perscholas.homeinsurance.daoTest;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotSame;
//
//import java.io.IOException;
//import java.sql.*;
//import java.text.ParseException;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.BeforeClass;
//import org.junit.Test;
//
//import com.perscholas.homeinsurance.dao.HomeownerDAO;
//import com.perscholas.homeinsurance.dao.UserDAO;
//import com.perscholas.homeinsurance.models.Homeowner;
//import com.perscholas.homeinsurance.models.User;
//
//public class HomeownerDAOTest
//{
//	//Declare variables
//		private static User user1, user2;					//User Objects are needed to get autogenerated user after registration
//		private static Homeowner homeowner1, homeowner2;		
//		private static UserDAO ud;
//		private static HomeownerDAO hd;
//		private static List<Homeowner> actual, expected;
//		
//		
//		@BeforeClass
//		public static void setUp() throws ClassNotFoundException, SQLException, IOException, ParseException
//		{
//			homeowner1 = null;												//Initialize variables for Test# 1
//			homeowner2 = null;
//			hd = new HomeownerDAO();
//			ud = new UserDAO();
//			
//					//Initialize all variables needed for test#2
//			actual = new ArrayList<Homeowner>();
//		}	
//		
//		/**
//		 *Tests the registerHomeowner method to validate proper registration and insertion in the homeowners table in database.
//		*/
//		@Test
//		public void testRegisterHomeowner() throws SQLException, ClassNotFoundException, IOException, ParseException
//		{
//			user1 = new User("BarackObama16", "DonaldTrump16", "user");		//Construct User Object. 
//			ud.registerUser(user1);											//Register user to generate user ID number.
//			
//			homeowner1 = new Homeowner();									//Using setters instead of a Constructor allows validation of the methods.
//			homeowner1.setUserId(user1.getUserId());						//Sets user Id to value based on the id number provided by the database.
//			homeowner1.setFirstName("HappyFeet16");
//			homeowner1.setLastName("Greenwood16");
//			homeowner1.setDateOfBirth("1942-11-29");
//			homeowner1.setSocialSecurityNum("111111125");
//			homeowner1.setEmailAddress("santa12.green@gmaill.com");
//			
//			System.out.println("\nBEGIN TEST #1\n------------------------------");
//			int id = hd.registerHomeowner(homeowner1);
//			assertNotSame(Integer.toString(user1.getUserId()), Integer.toString(id));
//			assertEquals(Integer.toString(user1.getUserId()), Integer.toString(id));			//Validates all Objects and returned value from Homeowner Registration share same userId value
//			System.out.println("END TEST #1\n------------------------------");
//		}
//		
//		
//		/**
//		 *Tests the Homeowner Object retrieval, validating the appropriate Homeowner is extracted the homeowners table in database.
//		*/
//		@Test
//		public void testGetHomeownerByUserId() throws ClassNotFoundException, IOException, SQLException, ParseException
//		{
//			System.out.println("\nBEGIN TEST #2\n------------------------------");
//			user2 = new User("AbrahamLincoln28", "GeorgeWashington28", "admin");
//			
//			int userId = ud.registerUser(user2);				//The User Object is being inserted into the database and the userId value is returned and stored.
//			
//			homeowner2 = new Homeowner(user2.getUserName(), user2.getPassword(), user2.getAdminRole(),				 	//Here I constructed the Object with a parameterized Constructor.
//									   "Tisha8","Pipkorn8", "1973-04-04", true, "000000024", "pretty7.green@gmail.com");	//Passing the values from the associated User Object.
//			
//			if(userId != -1)									//Set userId if a failed insert value(-1) is not returned.
//				homeowner2.setUserId(userId);
//		
//			hd.registerHomeowner(homeowner2);					//Insert the Homeowner Object into the database in the homeowners table
//			actual.add(homeowner2);								//Insert the identical Homeowner Object into the actual list to test against.
//			
//			expected = hd.getHomeownerByUserId(userId);			//Store the returned List from HomeownerDAO Objects' method into the database
//			
//			System.out.print("\n*******ACTUAL USER DATA*******\n"+actual.get(0)+"\n"			//Display actual and expected results from both list.
//							+ "*******EXPECTED USER DATA*******\n"+expected.get(0)+"\n");
//			
//			assertNotSame(actual.get(0).toString(),expected.get(0).toString());
//			assertEquals(actual.get(0).toString(),expected.get(0).toString());		//Validate the appropriate Object was fetched from the database.
//			System.out.println("END TEST #2\n------------------------------");
//		}
//}
