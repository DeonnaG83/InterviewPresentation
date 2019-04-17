package com.perscholas.homeinsurance.interfaces;

import com.perscholas.homeinsurance.models.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface UserDAOI 
{
	public Integer registerUser(User user) throws SQLException, ClassNotFoundException, IOException;

	public User getUserByUserId(int userId)throws ClassNotFoundException, IOException, SQLException;
	
	public User getUserByUsername(String userName) throws ClassNotFoundException, IOException, SQLException;

	public User getUserByPassword(String password) throws ClassNotFoundException, IOException, SQLException;
}
