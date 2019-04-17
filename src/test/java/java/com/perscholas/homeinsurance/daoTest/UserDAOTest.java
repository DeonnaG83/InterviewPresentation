//package com.perscholas.homeinsurance.daoTest;
//
//import static org.junit.Assert.*;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import java.io.IOException;
//import java.sql.*;
//import java.util.*;
//
//import com.perscholas.homeinsurance.dao.UserDAO;
//import com.perscholas.homeinsurance.models.User;
//
//public class UserDAOTest
//{
//	//Declare variables needed for testing			//A CONSTRUCTOR WAS ALTERED EDITS MUST BE MADE
//	private static User user1, user2, user3;
//	private static UserDAO ud;
//	private static List<User> actual1, expected1;
//	
//	
//	@BeforeClass
//	public static void setUp()
//	{
//		ud = new UserDAO();//Initialize all variables needed for test# 1.
//		user1 = new User();
//		user1.setUserName("ItsmybirthdaY19");
//		user1.setPassword("HappyBirthday19");
//		user1.setAdminRole("admin");
//		
//		user2 = new User();		//Initialize all variables needed for test# 2.
//		actual1 = new ArrayList<User>();
//		user2.setUserName("HappyBirthDayToMe20");		
//		user2.setPassword("HappyBirthdayToYou20");
//		user2.setAdminRole("admin");
//		
//		user3 = new User();		//Initialize all variables needed for test# 3.
//		user3.setUserName("MerryChristmas20");		
//		user3.setPassword("HappyNewYear20");
//		user3.setAdminRole("user");
//	}
//	
//	/**
//	 *Tests the registerUser method to validate proper registration and insertion in the User Table in the database.
//	*/
//	@Test//Assumes all variables of User Object except userId have been set.
//	public void testRegisterUser() throws SQLException, ClassNotFoundException, IOException
//	{
//		System.out.println("\nBEGIN TEST #1\n------------------------------");
//		int id = ud.registerUser(user1);		//Stores value(generated user id from database) returned from UserDAO Object into id variable
//		if(id != -1)							//Verify -1(failed insert) was not returned from UserDAO Object.
//			user1.setUserId(id);				//If not -1, assign value to the User Objects userId variable
//		assertNotSame(Integer.toString(id),Integer.toString(user1.getUserId()));	//Verifies 2 different Objects are being tested against.
//		assertEquals(Integer.toString(id),Integer.toString(user1.getUserId()));
//		System.out.println("END TEST #1\n------------------------------");
//	}
//	
//	
//	/**
//	 *Tests the getUserByUserId method to validate retrieval of appropriate user based on user Id#.
//	*/
//	@Test
//	public void testGetUserByUserId() throws ClassNotFoundException, IOException, SQLException
//	{
//		System.out.println("BEGIN TEST #2\n------------------------------");
//		int userId = ud.registerUser(user2);
//		if(userId!=-1)													//Set user id to User Object and insert into actual List.
//			user2.setUserId(userId);
//		actual1.add(user2);
//		expected1 = ud.getUserByUserId(userId);						//Get List Object returned from UserDAO method and assign its' value to expected List
//											   							//userId has been set during insertion into database.
//		
//		System.out.print("\n*******ACTUAL USER DATA*******\n"+actual1.get(0)+
//						 "\n*******EXPECTED USER DATA*******\n"+expected1.get(0)+"\n");	//Display results
//		
//		assertNotSame(actual1.get(0).toString(), expected1.get(0).toString());	//Verifies 2 different Objects being tested against
//		assertEquals(actual1.get(0).toString(),expected1.get(0).toString());	//If properly retrieved, both list will contain identical User Objects.
//		System.out.println("END TEST #2\n------------------------------");
//	}
//	
//	
//	/**
//	 *Tests the getUserByUsernameAndPassword method to validate retrieval of appropriate user based on user Id#.
//	*/
//	@Test
//	public void testGetUserByNameAndPassword() throws ClassNotFoundException, IOException, SQLException
//	{
//		System.out.println("BEGIN TEST #3\n------------------------------");
//		User user4;							//Create User Object to store User Object's values returned from method called.
//		int userId = ud.registerUser(user3);
//		if(userId!=-1)						//Set user id to User Object and insert into actual List.
//			user3.setUserId(userId);
//		
//		user4 = ud.getUserByUsername(user3.getUserName());//Get User Object returned from UserDAO method and assign its' values to the user4 User Object.
//														//userId has been set during insertion into database.
//		
//		System.out.print("*******ACTUAL USER DATA*******\n"+user3+
//						 "\n*******EXPECTED USER DATA*******\n"+user4+"\n");	//Display results
//		
//		assertTrue(user3.getUserName().equals(user4.getUserName()));	//If properly retrieved, both usernames' and passwords will be identical.
//		System.out.println("END TEST #3\n------------------------------");
//	}
//}