
import java.rmi.Naming;
import Controller.AdminController;
import RMI.ServerInterfaceRMI;

/**
 * A class containing main method of the administrator part;
 * @author Dumitru Muntean
 *
 */
public class AdminMain {
	
	/**
	 * The main method;
	 * @param args
	 */
	public static void main(String[] args) {
		  if (System.getSecurityManager() == null) {
	            System.setSecurityManager(new SecurityManager());
	        }
		try{
			ServerInterfaceRMI sir = (ServerInterfaceRMI)Naming.lookup("rmi://localhost:1099/warehouse");
			AdminController controller = new AdminController(sir);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
