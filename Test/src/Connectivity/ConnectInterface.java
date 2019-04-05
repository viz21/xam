package Connectivity;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectInterface extends Remote{
	
	//Client
	
	String welcomeBanner() throws RemoteException;
	
	Connection getDBConnection() throws RemoteException;
	
	String signIn(String type, String uid, String pw) throws RemoteException;
	
	String[][] enrolledModules(String uid) throws RemoteException;
	
	String testMethod() throws RemoteException;
	
	String[][] enrolledExamsTeacher(String subjectID) throws RemoteException;
	
	String[][] viewQsNAns(String examID) throws RemoteException;
	
	String[][] examMgmntFewDetails(String subjectID, String examID) throws RemoteException;
	
	void addNewQ(String selectedExamID, String Q, String CA, String AA1, String AA2, String AA3) throws RemoteException;
	
	void deleteQuestion(String QID) throws RemoteException;
	
	void updateQnAns(String QID, String Q, String CA, String AA1, String AA2, String AA3) throws RemoteException;

}
