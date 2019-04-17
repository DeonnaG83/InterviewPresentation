package com.perscholas.homeinsurance.interfaces;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.perscholas.homeinsurance.models.Location;

public interface LocationDAOI 
{
	public Integer registerLocation(Location location) throws SQLException, ClassNotFoundException, IOException;
	
	public Location getLocationByLocationId(int locationId)throws ClassNotFoundException, IOException, SQLException, ParseException;
	
	public List<Location> getLocationByUserId(int userId)throws ClassNotFoundException, IOException, SQLException, ParseException;
}
