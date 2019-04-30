package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

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

public class ExamSelectionWindowStudent extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textEnKey;
	String uid = null;
	ClientX temp = null;
	String selectedSubjectID = null;

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
					ExamSelectionWindowStudent frame = new ExamSelectionWindowStudent(ID, clientX, selectedSubjectID);
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
	public ExamSelectionWindowStudent(String ID, ClientX clientX, String selectedSubjectID) {
		
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
		
		JLabel lblItObject = new JLabel("IT2030 - Object Oriented Programming");
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
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(580);
		table.getColumnModel().getColumn(2).setPreferredWidth(110);
		table.setRowHeight(40);
		table.setFont(new Font("Product Sans", Font.PLAIN, 20));
		table.setBackground(Color.LIGHT_GRAY);
		scrollPane.setViewportView(table);
		
		this.modTable(table);
		
		JButton btnEnroll = new JButton("Start");
		btnEnroll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String examID = table.getModel().getValueAt(table.getSelectedRow(), 0).toString();
				if (textEnKey.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "Please enter an Enrollment Key", "Error", JOptionPane.WARNING_MESSAGE);
					/*if (temp.checkEnrlmntKey(examID, enKey)) {
						
					}*/
				} else
					try {
						if (temp.checkEnrlmntKey(table.getModel().getValueAt(table.getSelectedRow(), 0).toString(), textEnKey.getText())) {
							new ExamWindow1(ID, clientX, table.getModel().getValueAt(table.getSelectedRow(), 0).toString()).setVisible(true);
							ExamSelectionWindowStudent.this.dispose();
						}
						else {
							JOptionPane.showMessageDialog(null, "Incorrect Enrollment Key!", "Error", JOptionPane.WARNING_MESSAGE);
						}
					} catch (HeadlessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		});
		btnEnroll.setForeground(Color.WHITE);
		btnEnroll.setFont(new Font("Product Sans", Font.BOLD, 20));
		btnEnroll.setBackground(new Color(51, 153, 51));
		btnEnroll.setBounds(752, 449, 150, 35);
		contentPane.add(btnEnroll);
		
		textEnKey = new JTextField();
		textEnKey.setBounds(565, 449, 175, 35);
		contentPane.add(textEnKey);
		textEnKey.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enrollment key");
		lblNewLabel.setFont(new Font("Product Sans", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(378, 449, 175, 35);
		contentPane.add(lblNewLabel);
		
		JButton btnBack = new JButton("Previous");
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Product Sans", Font.BOLD, 20));
		btnBack.setBackground(new Color(51, 153, 51));
		btnBack.setBounds(12, 449, 150, 35);
		contentPane.add(btnBack);
		setResizable(false);
	}
	
	private void modTable(JTable table1) {
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
