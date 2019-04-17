package MainEntry;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Calendar.Builder;
import java.util.Date;
import java.util.Locale;

import com.perscholas.homeinsurance.dao.UserDAO;
import com.perscholas.homeinsurance.models.Policy;
import com.perscholas.homeinsurance.models.Property;
import com.perscholas.homeinsurance.models.User;

public class MainEntry 
{

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException, ParseException 
	{
		Date dateToStart;
		Builder calBuild = new Builder();
		String startDate = "2019-07-04";
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		dateToStart = format.parse(startDate);
		dateToStart = new java.sql.Date(dateToStart.getTime());
		//calBuild.setInstant(dateToStart);
		
		Date today = Calendar.getInstance().getTime();
		calBuild.setInstant(today);
		Calendar cToday = calBuild.build();
		
		//Date dateToEnd = new Date();
	
		calBuild.setInstant(today);
		Calendar alterDate = calBuild.build();
		alterDate.add(Calendar.MONTH, 2);
		
		
		
		
		//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		//dateToStart = format.parse(startDate);
		//dateToStart = new java.sql.Date(dateToStart.getTime());
		
		//Calendar DateAfter2Months = Calendar.getInstance();
		
		//calBuild.setInstant(dateToStart);
		//System.out.println(DateAfter3Months.toString());
		//Calendar beginDate = calBuild.build();
		
	
		
		
		
		
		//Calendar DateAfter12Months;
		System.out.println("here232");
		
		
		
	
		//System.out.println(DateAfter3Months.toString());
		
		
		
		
		System.out.println(dateToStart.toString());
		System.out.println(cToday.getTime());
		System.out.println(alterDate.getTime());
		
		if (dateToStart.before(alterDate.getTime()))
		{
			alterDate.add(Calendar.MONTH, -2);
			if(dateToStart.after(alterDate.getTime()))
			{
			calBuild.setInstant(dateToStart);
			alterDate = calBuild.build();
			alterDate.add(Calendar.MONTH, 12);
			//System.out.println("99");
			//policy.setEffectiveDate(startDate);
			System.out.println("100");
			
			System.out.println("101");
			
			Date dateToEnd =  alterDate.getTime();
			
			//dateToEnd = format.parse(startDate);
			
			
			
			dateToEnd = new java.sql.Date(dateToEnd.getTime());
			
			//System.out.println(beginDate.getTime());
			
			dateToEnd = new java.sql.Date(dateToEnd.getTime());
			System.out.println(dateToEnd.toString());
			System.out.println("102");
			}
	}  
}}
