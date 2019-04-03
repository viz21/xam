package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.rmi.RemoteException;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Connectivity.ClientX;

import javax.swing.JButton;

public class QuestionManagement extends JFrame {

	private JPanel contentPane;
	private JTable table;
	String uid = null;
	ClientX temp = null;
	String selectedSubjectID = null;
	String selectedExamID = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String ID = null;
					ClientX clientX = null;
					String selectedSubjectID = null;
					String selectedExamID = null;
					QuestionManagement frame = new QuestionManagement(ID, clientX, selectedSubjectID, selectedExamID);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QuestionManagement(String ID, ClientX clientX, String selectedSubjectID, String selectedExamID) {
		
		this.uid = ID;
		this.temp = clientX;
		this.selectedSubjectID = selectedSubjectID;
		this.selectedExamID = selectedExamID; 
		
		String[][] result = new String[1][2];
		try {
			result = temp.examMgmntFewDetails(this.selectedSubjectID, this.selectedExamID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1295, 770);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel(result[0][0]);
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setFont(new Font("Product Sans", Font.PLAIN, 25)); 
		label.setBounds(12, 13, 890, 31);
		contentPane.add(label);
		
		JLabel lblOopMid = new JLabel(result[0][1]);
		lblOopMid.setHorizontalAlignment(SwingConstants.LEFT);
		lblOopMid.setFont(new Font("Product Sans", Font.PLAIN, 25));
		lblOopMid.setBounds(12, 57, 657, 31);
		contentPane.add(lblOopMid);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 101, 1265, 503);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Product Sans", Font.PLAIN, 23));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				/*{null, "What is JIT compiler?", "JIT improves the runtime performance of computer programs based on bytecode", "JIT is an application development framework", "JIT is an implementation of the Java Virtual Machine which executes Java programs", "None of the mentioned"},
				{null, "A top level class can be private or protected", "False", "True", null, null},
				{null, "Inheritance represents", "IS-A relationship", "HAS-A relationship", null, null},
				{null, "Try statements can be nested", "True", "False", null, null},
				{null, "Which of the following is true about private access modifier?", "Variables, methods and constructors which are declared private can be accessed only by the members of the same class.", "Variables, methods and constructors which are declared private can be accessed by any class lying in same package.", "Variables, methods and constructors which are declared private in the superclass can be accessed only by its child class", "None of the mentioned"},
				{null, "What is inheritance?", "  It is the process where one object acquires the properties of another.", null, null, null},
				{null, "What is the default value of char variable?", "'\\u0000' ", null, null, null},
				{null, "Constructor can be made final", "False", "True", null, null},
				{null, "What are Wrapper classes?", "These are classes that allow primitive types to be accessed as objects.", "These are classes that wraps functionality of an existing class.", "All of the mentioned.", "None of the mentioned."},
				{null, "What is the default value of byte variable?", "0", null, null, null},
				{null, "What invokes a thread's run() method?", "JVM invokes the thread's run() method when the thread is initially executed.", "Main application running the thread", "start() method of the thread class", "None of the mentioned"},
				{null, "How many classes can be defined in a single program?", "As many as you want", null, null, null},
				{null, "Static functions can be accessed using null reference", "False", "True", null, null},
				{null, "Which is the way in which a thread can enter the waiting state?", "Invoke its sleep() method", "invoke object's wait method", "Invoke its suspend() method", "All of the mentioned"},
				{null, "What is runtime polymorphism?", "Runtime polymorphism is a process in which a call to an overridden method is resolved at runtime rather than at compile-time.", "Runtime polymorphism is a process in which a call to an overloaded method is resolved at runtime rather than at compile-time", "All of the mentioned", "None of the mentioned"},
				{null, "What is the default value of short variable?", "0.0", null, null, null},
				{null, "What is Set Interface?", "Set is a collection of element which cannot contain duplicate elements.", "Set is a collection of element which contains elements along with their key", "Set is a collection of element which contains hashcode of elements", "Set is a collection of element which can contain duplicate elements"},*/
			},
			new String[] {
				"QID", "Question Title", "Correct Answer", "Answer 2", "Answer 3", "Answer 4"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(45);
		table.getColumnModel().getColumn(1).setPreferredWidth(588);
		table.getColumnModel().getColumn(2).setPreferredWidth(158);
		table.getColumnModel().getColumn(3).setPreferredWidth(158);
		table.getColumnModel().getColumn(4).setPreferredWidth(158);
		table.getColumnModel().getColumn(5).setPreferredWidth(158);
		table.setRowHeight(30);
		scrollPane.setViewportView(table);
		
		JLabel lblQuestionCount = new JLabel("Question Count: 17");
		lblQuestionCount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblQuestionCount.setFont(new Font("Product Sans", Font.PLAIN, 25));
		lblQuestionCount.setBounds(703, 57, 574, 31);
		contentPane.add(lblQuestionCount);
		
		JButton btnNewQuestion = new JButton("New Question");
		btnNewQuestion.setForeground(Color.WHITE);
		btnNewQuestion.setFont(new Font("Product Sans", Font.BOLD, 20));
		btnNewQuestion.setBackground(new Color(51, 153, 51));
		btnNewQuestion.setBounds(793, 617, 236, 35);
		contentPane.add(btnNewQuestion);
		
		JButton btnEditQuestion = new JButton("Update Question");
		btnEditQuestion.setForeground(Color.WHITE);
		btnEditQuestion.setFont(new Font("Product Sans", Font.BOLD, 20));
		btnEditQuestion.setBackground(new Color(51, 153, 51));
		btnEditQuestion.setBounds(793, 665, 236, 35);
		contentPane.add(btnEditQuestion);
		
		JButton btnDeleteQuestion = new JButton("Delete Question");
		btnDeleteQuestion.setForeground(Color.WHITE);
		btnDeleteQuestion.setFont(new Font("Product Sans", Font.BOLD, 20));
		btnDeleteQuestion.setBackground(new Color(51, 153, 51));
		btnDeleteQuestion.setBounds(1041, 617, 236, 35);
		contentPane.add(btnDeleteQuestion);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setForeground(Color.WHITE);
		btnSubmit.setFont(new Font("Product Sans", Font.BOLD, 20));
		btnSubmit.setBackground(new Color(51, 153, 51));
		btnSubmit.setBounds(1041, 665, 236, 35);
		contentPane.add(btnSubmit);
		
		JButton button = new JButton("Previous");
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Product Sans", Font.BOLD, 20));
		button.setBackground(new Color(51, 153, 51));
		button.setBounds(12, 617, 150, 35);
		contentPane.add(button);
		setResizable(false);
	}
}
