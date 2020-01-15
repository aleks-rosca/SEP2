package LogFile;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 * @inheritDoc
 * Takes care of the file the logs are written in; 
 * @author Alexandru
 *
 */
public class MyFile {
	
	private static String fileName;
	private static MyFile myFile;
    private static FileOutputStream fileOutStream;
    private static PrintWriter writeToFile;
	
	/**
	 * non-argument constructor creates an instance of the file;
	 */
	private MyFile()
	{
		try {
			this.fileName = "log.txt";
			fileOutStream = new FileOutputStream(fileName, true);
			writeToFile = new PrintWriter(fileOutStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Singelton way of getting the file instance;
	 * @return MyFile instance;
	 */
	public synchronized static MyFile getInstance()
	{
		if(myFile == null)
			myFile = new MyFile();
		
		return myFile;
	}
	
	
	public synchronized void  writeToFile(String str)
	{
        writeToFile.println(str);
        
        if (writeToFile != null)
        {
           writeToFile.close();
        }
	}
}
