package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Vector;



public interface RemoteQuestions extends Remote {

	
	public int getNumberOfQuestions() throws RemoteException;
	
	
	
	public Question getQuestion(int i) throws RemoteException;
	
	
	
	void submitAnswer(int i,String answer) throws RemoteException;
	
	
	public Vector<Question> getData() throws RemoteException;
	
	
	public List<Question> getStudent() throws Exception; 
	
	
	public List<Question> getTeacher() throws Exception;
	
}
