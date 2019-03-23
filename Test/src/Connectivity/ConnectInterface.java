package Connectivity;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ConnectInterface extends Remote{
	
	String welcomeBanner() throws RemoteException;

}
