//package names has to be matched in sever and client
package Connectivity;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.SQLException;

public class ClientX {
	
	ConnectInterface temp;
	
	public ClientX() {
		try {
			System.out.println("Searching for Server");
			String url = "rmi://localhost/127.0.0.1:1065/XAMServer";
			Registry registry = LocateRegistry.getRegistry(1426);
			System.out.println("Registry located");
			this.temp = (ConnectInterface) registry.lookup(url);
			System.out.println("Server found");
		} catch (Exception e) {
			System.out.println("Client Exception: " + e.toString());
		}
	}
	
	public String welcomeBanner() throws RemoteException {
		return temp.welcomeBanner();
	}
	
	public String signIn(String type, String uid, String pw) throws RemoteException, SQLException {
		return temp.signIn(type, uid, pw);
	}
	
	public static void main(String[] args) throws RemoteException, SQLException {
		
		ClientX clientX = new ClientX();
		System.out.println(clientX.welcomeBanner());
		
	}
}


