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
			Registry registry = LocateRegistry.getRegistry(1410);
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
	
	public String[][] enrolledModules(String uid) throws RemoteException, SQLException{
		return temp.enrolledModules(uid);
	}
	
	public String testMethod() throws RemoteException {
		return temp.testMethod();
	}
	
	public String[][] enrolledExamsTeacher(String subjectID) throws RemoteException{
		return temp.enrolledExamsTeacher(subjectID);
	}
	
	public String[][] viewQsNAns(String examID) throws RemoteException{
		return temp.viewQsNAns(examID);
	}
	
	public String[][] examMgmntFewDetails(String subjectID, String examID) throws RemoteException{
		return temp.examMgmntFewDetails(subjectID, examID);
	}
	
	/*public static void main(String[] args) throws RemoteException, SQLException {
		
		ClientX clientX = new ClientX();
		String[][] result = new String[1][2];
		
		result = clientX.examMgmntFewDetails("IT2030", "IT2030MID1");
		
		System.out.println(result[0][0]);
		System.out.println(result[0][1]);
		
	}*/
}


