package Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * A class that is responsible for date and time;
 * @author Alexandru
 *
 */
public class DateTime {
	
	private Date date;
	
	/**
	 * non-argument constructor;
	 */
	public DateTime()
	{
		date = Calendar.getInstance().getTime();
	}
	
	/**
	 * Retrieve the date and time in a certain format "dd/MM/yyyy HH:mm:ss";
	 * @return A string containing the date and the time;
	 */
	public String getTimestamp()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		return sdf.format(date);
	}
	
	/**
	 * To string method
	 */
	public String toString()
	{
		return date.toString();
	}
}