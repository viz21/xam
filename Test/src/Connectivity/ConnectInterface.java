package Connectivity;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * This RMI interface retrieves details regarding the questions from the server and directs it towards the client
 * Methods in this RMI interface were obtained by studying the example code of Mr. Marc Conrad
 * This interface is required to be present on both the client and the server side for functionality.
 * @author Vishwa
 *
 */

public interface ConnectInterface extends Remote{
	
	//Client
	
	/*A String has been implemented from the send stub object from server
	 * under below method. It helps to understand that the stub object has been fetched 
	 * Properly
	 * @return the text "Welcome to X-AM!"
	 * @throws RemoteException
	 * 
	 * */
	String welcomeBanner() throws RemoteException;
	
	/*Establish a connection between the mySQL database 
	 * in the server
	 * @return Connection
	 * @throws RemoteException
	 * */
	Connection getDBConnection() throws RemoteException;
	
	/*Returns the entered uid if the credentials are correct.
	 * Used for StartWindow
	 * @param type Type of the user(Student / Teacher)
	 * @param uid UserID as in the database
	 * @param pw password
	 * @return String
	 * @throws RemoteException
	 * */
	String signIn(String type, String uid, String pw) throws RemoteException;
	
	/*Returns a set of data from the database
	 * as a String array
	 * The data is enrolled module details under a particular student and teacher.
	 * Used for ModuleSelection
	 * @param uid UserID of the user
	 * @return String[][]
	 * @throws RemoteException*/
	String[][] enrolledModules(String uid) throws RemoteException;
	
	/*A method used for testing purposes.
	 * @returns String
	 * @throws RemoteException*/
	String testMethod() throws RemoteException;
	
	/*Returns a set of data from database
	 * as a String array
	 * The data is of exams of a particular module under the supervision of particular teacher.
	 * Used in ExamSelectionWindowTeacher
	 * @param subjectID moduleID as in the database
	 * @returns String[][]
	 * @throws RemoteException*/
	String[][] enrolledExamsTeacher(String subjectID) throws RemoteException;
	
	/*Returns a set of data from database
	 * as a String array
	 * The data is of Details of exam questions and answers under a particular exam
	 * Used in QuestionManagement
	 * (Also used in ExamWindow1) //Out of my contribution
	 * @param examID examID of the exam
	 * @returns String[][]
	 * @throws RemoteException*/
	String[][] viewQsNAns(String examID) throws RemoteException;
	
	/*Returns a set of data from database
	 * as a String array
	 * The data is of few details of a particular exam (Enrollment key, exam name, etc.)
	 * Used in QuestionManagement
	 * (Also used in ExamWindow1) //Out of my contribution
	 * @param subjectID moduleID as in the database
	 * @param examID examID of the exam
	 * @returns String[][]
	 * @throws RemoteException*/
	String[][] examMgmntFewDetails(String subjectID, String examID) throws RemoteException;
	
	/*Submits a new question with answers to the database
	 * Used in QuestionManagement
	 * @param selectedExamID examID of the exam
	 * @param Q new question to be submitted
	 * @param CA correct answer of the question
	 * @param AA1 alternate answer 1
	 * @param AA2 alternate answer 2
	 * @param AA3 alternate answer 3
	 * @throws RemoteException
	 * */
	void addNewQ(String selectedExamID, String Q, String CA, String AA1, String AA2, String AA3) throws RemoteException;
	
	/*Delete a selected question and it's answers from the database
	 * Used in QuestionManagement
	 * @param QID selected questionID to be deleted
	 * @throws RemoteException
	 *  */
	void deleteQuestion(String QID) throws RemoteException;
	
	/*Updates a selected question with answers to the database
	 * Used in QuestionManagement
	 * @param selectedExamID examID of the exam
	 * @param Q new question to be submitted
	 * @param CA correct answer of the question
	 * @param AA1 alternate answer 1
	 * @param AA2 alternate answer 2
	 * @param AA3 alternate answer 3
	 * @throws RemoteException
	 * */
	void updateQnAns(String QID, String Q, String CA, String AA1, String AA2, String AA3) throws RemoteException;
	
	/*Updates the enrollment key of the exam
	 * Used in QuestionManagement
	 * @param examID examID of the exam
	 * @param enKey updated enrollment key
	 * @throws RemoteException
	 * */
	void changeEnrlmntKey(String examID, String enKey) throws RemoteException;
	
	/*Compares and validates the provided enrollment key
	 * with the key in the database
	 * Used in examWindow1 //Out of my contribution 
	 * @param examID examID 
	 * @param enKey enrollment key provided by user to be validated
	 * @returns boolean
	 * @throws RemoteException
	 * */
	boolean checkEnrlmntKey(String examID, String enKey) throws RemoteException;
	
	/*Submits a data set of a single student's exam submission
	 * Used in examWindow1
	 *(Out of my contribution)
	 * @throws RemoteException
	 **/
	void ExamSubmission(String stdID, String examID, String[][] answers) throws RemoteException;
	
	/*Returns all the answers students have submitted through textareas
	 * Used in WrittenAnswerReview.java
	 * @param examID examID of the particular exam
	 * @returns String[][]
	 * @throws RemoteException
	 * */
	String[][] WrittenAnswerReview(String examID) throws RemoteException;
	
	/*Updates the  status of the answers students submitted through textareas to correct or incorrect
	 * @param results
	 * @throws RemoteException
	 * */
	void WrittenAnswerReviewSubmission(String[][] results) throws RemoteException;
	
	/*Returns the student details and final marks
	 * Also validates the answers in the database they have submitted
	 * for MCQs before finalizing the final marks
	 * @param examID examID
	 * @returns String[][]
	 * @throws RemoteException
	 * */
	String[][] finalResults(String examID) throws RemoteException;
}
