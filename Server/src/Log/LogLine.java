package Log;

import LogFile.FileAdaptor;

/**
 * The class responsible for creating the log;
 * @author Alexandru
 *
 */

public class LogLine {
	
	private String logEntry;
	private DateTime dateTime;
	
	/**
	 * 1-argument constructor;
	 * @param logEntry The string to be logged;
	 */
	public LogLine(String logEntry)
	{
		this.logEntry = logEntry;
		dateTime = new DateTime();
	}
	
	/**
	 * To string method
	 */
	public String toString()
	{
		StringBuilder r = new StringBuilder();
		
		r.append(dateTime.toString());
		r.append(" ");
		r.append(logEntry);
		
		return r.toString();
	}
}
