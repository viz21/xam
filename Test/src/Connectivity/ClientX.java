//package names has to be matched in sever and client
package Connectivity;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientX {
	
	ConnectInterface temp;
	
	public ClientX() {
		try {
			System.out.println("Searching for Server");
			String url = "rmi://localhost/127.0.0.1:1065/xamserver";
			Registry registry = LocateRegistry.getRegistry(1302);
			System.out.println("Registry located");
			this.temp = (ConnectInterface) registry.lookup(url);
			System.out.println("Server found");
			//this.welcomeBanner();
		} catch (Exception e) {
			System.out.println("Client Exception: " + e.toString());
		}
	}
	
	public String welcomeBanner() throws RemoteException {
		return temp.welcomeBanner();
	}
	
	/*public static void main(String[] args) throws RemoteException {
		
		ClientX clientX = new ClientX();
		System.out.println(clientX.welcomeBanner());
		
	}*/
}
