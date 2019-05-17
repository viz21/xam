package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GraphicsConfiguration;

import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

import Connectivity.ClientX;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;

/*@author Vishwa
 * 
 * */

public class ExamSelectionWindowTeacher extends JFrame {

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
					String selectedSubjectID = null;
					ClientX clientX = null;
					ExamSelectionWindowTeacher frame = new ExamSelectionWindowTeacher(ID, clientX, selectedSubjectID);
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
	public ExamSelectionWindowTeacher(String ID, ClientX clientX, String selectedSubjectID) {
		
		this.uid = ID;
		this.temp = clientX;
		this.selectedSubjectID = selectedSubjectID;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 920, 590);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblItObject = new JLabel(selectedSubjectID);
		lblItObject.setBounds(12, 13, 904, 31);
		lblItObject.setHorizontalAlignment(SwingConstants.LEFT);
		lblItObject.setFont(new Font("Product Sans", Font.PLAIN, 25));
		contentPane.add(lblItObject);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 98, 50, 2);
		contentPane.add(separator);
		
		JLabel lblAssignments = new JLabel("Assignments");
		lblAssignments.setFont(new Font("Product Sans", Font.PLAIN, 15));
		lblAssignments.setBounds(74, 88, 95, 18);
		contentPane.add(lblAssignments);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(181, 98, 721, 2);
		contentPane.add(separator_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 119, 890, 317);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, "Online Exam 1", "Complete"},
				{null, "Online Exam 2", "Complete"},
				{null, "OOP - Mid Semester Exam (Online)", "Not Complete"},
				{null, "Online Exam 3", "Not Complete"},
				{null, "Online Exam 4", "Not Complete"},
			},
			new String[] {
				"Assignment ID", "Assignment Title", "Status"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(500);
		table.setRowHeight(40);
		table.setFont(new Font("Product Sans", Font.PLAIN, 20));
		table.setBackground(Color.LIGHT_GRAY);
		scrollPane.setViewportView(table);
		
		this.modtable(table);
		
		JButton btnEnroll = new JButton("View");
		btnEnroll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectedExamID = table.getModel().getValueAt(table.getSelectedRow(), 0).toString(); //get selected examID from table
				if(selectedSubjectID.equals(null)) {
					JOptionPane.showMessageDialog(null, "Please select a module first!", "Error", JOptionPane.WARNING_MESSAGE);
				}
				else {
					new QuestionManagement(uid, temp, selectedSubjectID, selectedExamID).setVisible(true);
					ExamSelectionWindowTeacher.this.dispose();
				}
				/*new Exam_Window().setVisible(true);
				ExamSelectionWindowTeacher.this.dispose();*/
			}
		});
		btnEnroll.setForeground(Color.WHITE);
		btnEnroll.setFont(new Font("Product Sans", Font.BOLD, 20));
		btnEnroll.setBackground(new Color(51, 153, 51));
		btnEnroll.setBounds(752, 449, 150, 35);
		contentPane.add(btnEnroll);
		
		JButton btnBack = new JButton("Previous");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ModuleSelection(uid, temp).setVisible(true);
				ExamSelectionWindowTeacher.this.dispose();
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Product Sans", Font.BOLD, 20));
		btnBack.setBackground(new Color(51, 153, 51));
		btnBack.setBounds(12, 449, 150, 35);
		contentPane.add(btnBack);
		
		setResizable(false);
	}
	
	private void modtable(JTable table1) {
		DefaultTableModel model = (DefaultTableModel) table1.getModel();
		model.setRowCount(0);
		try {
			String[][] results = new String[10][2];
			results = temp.enrolledExamsTeacher(selectedSubjectID);
			int j = 0;
			for(int i = 0; i < 5; i++) {
				model.addRow(new Object[] {results[i][j], results[i][j + 1], results[i][j + 2]});
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
}
