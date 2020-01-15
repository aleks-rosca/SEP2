package LogFile;

import java.io.FileNotFoundException;

import Log.LogLine;

/**
 * @inheritDoc
 * @author Dumitru Muntean
 *
 */
public class FileAdaptor implements I_FileAdaptor{
	
	private MyFile myFile;
	
	/**
	 * non-argument constructor
	 */
	public FileAdaptor()
	{
		myFile = MyFile.getInstance();
	}
	@Override
	public void writeToFile(LogLine logline) {
		
		myFile.writeToFile(logline.toString());	
	}
}
