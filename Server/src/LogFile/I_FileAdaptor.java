package LogFile;

import Log.LogLine;

/**
 * The interface for the file adaptor. File adaptor is responsible for writing the logs into the file;
 * @author Alexandru
 *
 */

public interface I_FileAdaptor {
	
	/**
	 * Writes a log line into the file;
	 * @param logline log line to be written;
	 */
	public void writeToFile(LogLine logline);
}
