import java.rmi.Naming;

import Controller.CashierController;
import RMI.ServerInterfaceRMI;


/**
 * A class containing main method of the cashier part;
 * @author Alexandru
 *
 */
public class CashierMain {
	
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
			CashierController controller = new CashierController(sir);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
