import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import Controller.ServerController;
import RMI.ServerInterfaceRMI;
import RMI.ServerRMI;

/**
 * The server main class;
 * @author Marius Papa
 *
 */
public class ServerMain {
	
	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {
		
		try{
			Registry rg = LocateRegistry.createRegistry(1099);
			ServerInterfaceRMI sir = new ServerRMI();
			rg.rebind("warehouse", sir);
			
			ServerController sc = new ServerController();
			System.out.println("server is ready...");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
