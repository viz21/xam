package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.rmi.RemoteException;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Connectivity.ClientX;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JSeparator;

public class QuestionManagement extends JFrame {

	private JPanel contentPane;
	private JTable table;
	String uid = null;
	ClientX temp = null;
	String selectedSubjectID = null;
	String selectedExamID = null;
	String Enrollments = null;
	static JLabel lblQuestionCount = null;
	int numberOfQs = 0;
	private JTextField txtEnrlmnt;

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
		
		String[][] result = new String[1][3];
		try {
			result = temp.examMgmntFewDetails(this.selectedSubjectID, this.selectedExamID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1295, 805);
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
		
		JLabel lblQuestionCount = new JLabel("Question Count: "); //Can get this from counting QID where it's not null
		lblQuestionCount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblQuestionCount.setFont(new Font("Product Sans", Font.PLAIN, 25));
		lblQuestionCount.setBounds(703, 57, 574, 31);
		contentPane.add(lblQuestionCount);
		
		this.lblQuestionCount = lblQuestionCount;
		
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
		table.setBackground(Color.LIGHT_GRAY);
		this.modTable(table); //Inserting QnA to the table
		
		JButton btnNewQuestion = new JButton("New Question");
		btnNewQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { //Redirects to add new question window
				if (numberOfQs == 30) {
					JOptionPane.showMessageDialog(null, "Cannot add anymore questions", "Error", JOptionPane.WARNING_MESSAGE);
				}
				else {
					new addNewQ(temp, selectedExamID).setVisible(true);
				}
			}
		});
		btnNewQuestion.setForeground(Color.WHITE);
		btnNewQuestion.setFont(new Font("Product Sans", Font.BOLD, 20));
		btnNewQuestion.setBackground(new Color(51, 153, 51));
		btnNewQuestion.setBounds(793, 617, 236, 35);
		contentPane.add(btnNewQuestion);
		
		JButton btnEditQuestion = new JButton("Update Question");
		btnEditQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String QID1 = table.getModel().getValueAt(table.getSelectedRow(), 0).toString();
				String Q1 = table.getModel().getValueAt(table.getSelectedRow(), 1).toString();
				String CA1 = table.getModel().getValueAt(table.getSelectedRow(), 2).toString();
				String AA1i = null;
				String AA2i = null;
				String AA3i = null;
				
				if (table.getModel().getValueAt(table.getSelectedRow(), 3) != null) {
					AA1i = table.getModel().getValueAt(table.getSelectedRow(), 3).toString();
				} 
				if (table.getModel().getValueAt(table.getSelectedRow(), 4) != null) {
					AA2i = table.getModel().getValueAt(table.getSelectedRow(), 4).toString();
				} 
				if (table.getModel().getValueAt(table.getSelectedRow(), 5) != null) {
					AA3i = table.getModel().getValueAt(table.getSelectedRow(), 5).toString();
				}
				
				new updateQs(temp, QID1, Q1, CA1, AA1i, AA2i, AA3i).setVisible(true);
			}
		});
		btnEditQuestion.setForeground(Color.WHITE);
		btnEditQuestion.setFont(new Font("Product Sans", Font.BOLD, 20));
		btnEditQuestion.setBackground(new Color(51, 153, 51));
		btnEditQuestion.setBounds(1041, 617, 236, 35);
		contentPane.add(btnEditQuestion);
		
		JButton btnDeleteQuestion = new JButton("Delete Question");
		btnDeleteQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { //Deletes the question and answers
				String QID = table.getModel().getValueAt(table.getSelectedRow(), 0).toString();
				
				int a = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this entry?");
	            if(a == JOptionPane.YES_OPTION){
	                try {
						temp.deleteQuestion(QID);
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                JOptionPane.showMessageDialog(null, "Successfully Deleted!");
	                modTable(table);
	            }
			}
		});
		btnDeleteQuestion.setForeground(Color.WHITE);
		btnDeleteQuestion.setFont(new Font("Product Sans", Font.BOLD, 20));
		btnDeleteQuestion.setBackground(new Color(51, 153, 51));
		btnDeleteQuestion.setBounds(1041, 665, 236, 35);
		contentPane.add(btnDeleteQuestion);
		
		JButton button = new JButton("Previous");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ExamSelectionWindowTeacher(uid, temp, selectedSubjectID).setVisible(true);
				QuestionManagement.this.dispose();
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Product Sans", Font.BOLD, 20));
		button.setBackground(new Color(51, 153, 51));
		button.setBounds(12, 665, 150, 35);
		contentPane.add(button);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modTable(table);
			}
		});
		btnRefresh.setForeground(Color.WHITE);
		btnRefresh.setFont(new Font("Product Sans", Font.BOLD, 20));
		btnRefresh.setBackground(new Color(51, 153, 51));
		btnRefresh.setBounds(12, 617, 150, 35);
		contentPane.add(btnRefresh);
		
		txtEnrlmnt = new JTextField();
		txtEnrlmnt.setColumns(10);
		txtEnrlmnt.setBounds(779, 665, 236, 35);
		contentPane.add(txtEnrlmnt);
		
		txtEnrlmnt.setText(result[0][2]);
		
		JButton btnEnrollmentKey = new JButton("Change Enrollment Key");
		btnEnrollmentKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (txtEnrlmnt.getText().length() > 10) {
						JOptionPane.showMessageDialog(null, "Enrollment key cannot be more than 10 characters!", "Error", JOptionPane.WARNING_MESSAGE);
					} else {
						temp.changeEnrlmntKey(selectedExamID, txtEnrlmnt.getText());
					}
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnEnrollmentKey.setForeground(Color.WHITE);
		btnEnrollmentKey.setFont(new Font("Product Sans", Font.BOLD, 20));
		btnEnrollmentKey.setBackground(new Color(51, 153, 51));
		btnEnrollmentKey.setBounds(509, 665, 258, 35);
		contentPane.add(btnEnrollmentKey);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(1027, 665, 2, 35);
		contentPane.add(separator);
		
		JButton btnCheckResults = new JButton("Check Results");
		btnCheckResults.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new WrittenAnswersReview(ID, clientX, selectedSubjectID, selectedExamID).setVisible(true);
				QuestionManagement.this.dispose();
			}
		});
		btnCheckResults.setForeground(Color.WHITE);
		btnCheckResults.setFont(new Font("Product Sans", Font.BOLD, 20));
		btnCheckResults.setBackground(new Color(240, 128, 128));
		btnCheckResults.setBounds(1041, 722, 236, 35);
		contentPane.add(btnCheckResults);
		setResizable(false);
	}
	
	private void modTable(JTable table1) {
		DefaultTableModel model = (DefaultTableModel) table1.getModel();
		model.setRowCount(0);
		try {
			String[][] results = new String[30][6];
			results = temp.viewQsNAns(selectedExamID);
			numberOfQs = 0; // 
			for(int i = 0; i < 30; i++) {
				model.addRow(new Object[] {results[i][0], results[i][1], results[i][2], results[i][3], results[i][4], results[i][5]});
				if(results[i][0] != null){ // for 'Question Count:' label
					numberOfQs++;
				}
			}
			
			QuestionManagement.lblQuestionCount.setText("Question Count: " + Integer.toString(numberOfQs)); //Can get this from counting QID where it's not null
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
