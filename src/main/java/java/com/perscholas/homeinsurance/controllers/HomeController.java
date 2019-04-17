package com.perscholas.homeinsurance.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.perscholas.homeinsurance.dao.HomeownerDAO;
import com.perscholas.homeinsurance.dao.UserDAO;
import com.perscholas.homeinsurance.models.Homeowner;
import com.perscholas.homeinsurance.models.User;


	@Controller
	@SessionAttributes
	public class HomeController //THESE REMAINING ADMIN PAGES TO BE ADDED WILL BE CONSTRUCTED BY INTERVIEW
	{							//FOR DEMONSTRATION OF USE. SHORT ON TIME.
		List<String> errorList;
		
		@RequestMapping("/admin")
		public String showAdminLoginPage(HttpSession session) 
		{
			return "AdminLoginPage";
		}


		@RequestMapping(value = "/showAdminLoginPage", method = RequestMethod.GET)
		public String showAdminLoginPage(HttpServletRequest request, HttpServletResponse response) 
		{
			return "AdminLoginPage";
		}
		@RequestMapping(value = "/showAdminUserSearchPage", method = RequestMethod.GET)
		public String showAdminSearchPage(HttpServletRequest request, HttpServletResponse response) 
		{
			return "AdminUserSearchPage";
		}
		
		@RequestMapping(value = "/loginAdminUser", method = RequestMethod.POST)
		public String loginAdminUser(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, IOException, SQLException 
		{
			HttpSession session = request.getSession();
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			
			UserDAO u_dao = new UserDAO();
			User adminUser = u_dao.getUserByUsername(userName);
			System.out.println(adminUser);
			errorList = new ArrayList<>();
			
			if( adminUser == null||adminUser.getAdminRole().equals("user"))
			{	
				errorList.add("This user does not have Administrative privileges.");
				request.setAttribute("errorList", errorList);
				return "AdminLoginPage";
			}
			else if(password.equals(adminUser.getPassword())&&userName.equals(adminUser.getUserName())&&adminUser.getAdminRole().equals("admin"))
			{
				session.setAttribute("currentAdminUser", adminUser);
				response.sendRedirect("showAdminUserSearchPage");
	        }
			else 
				
				System.out.println("here");
				if(!userName.equals(userName))
				{	
					errorList.add("This user does not have a registered account. Please create an account. ");
				}
				if(userName.isEmpty()||password.isEmpty())
				{
					errorList.add("All fields must me be completed. "); 
				}
				
				if(userName.equals(adminUser.getUserName())&&!password.equals(adminUser.getPassword()))	//Validate userName and password, login, and navigate to Welcome Page.
				{	
					errorList.add("Password does not match the associated account. ");
				}
			
			
				session.setAttribute("errorList", errorList);
				return "AdminLoginPage";
			
		}
		
		
	}
