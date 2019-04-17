package com.perscholas.homeinsurance.interfaces;

import java.io.IOException; 
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.perscholas.homeinsurance.models.Homeowner;

public interface HomeownerDAOI 
{
	public Integer registerHomeowner(Homeowner homeowner) throws SQLException, ClassNotFoundException, IOException;
	
	public Homeowner getHomeownerByUserId(int userid)throws ClassNotFoundException, IOException, SQLException, ParseException;
}

