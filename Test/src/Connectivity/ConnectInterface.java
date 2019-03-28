package Connectivity;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Connection;

public interface ConnectInterface extends Remote{
	
	//Client
	
	String welcomeBanner() throws RemoteException;
	
	Connection getDBConnection() throws RemoteException;
	
	String signIn(String type, String uid, String pw) throws RemoteException;

}
