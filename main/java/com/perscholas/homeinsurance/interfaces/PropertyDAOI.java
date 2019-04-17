package com.perscholas.homeinsurance.interfaces;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.perscholas.homeinsurance.models.Property;

public interface PropertyDAOI 
{
	public Integer registerProperty(Property property) throws SQLException, ClassNotFoundException, IOException;
	
	//public List<Property> getPropertyByLocationId(Integer LocationId)throws SQLException, ClassNotFoundException, IOException;
}
