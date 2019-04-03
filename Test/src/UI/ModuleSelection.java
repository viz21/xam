package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.omg.CORBA.PRIVATE_MEMBER;

import Connectivity.ClientX;
import Connectivity.ConnectInterface;
import jdk.internal.dynalink.beans.StaticClass;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class ModuleSelection extends JFrame {

	private JPanel contentPane;
	private JTable table;
	ClientX temp = null;
	String uid = null;
	String uType = null;
	String selectedSubjectID = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String ID = null;
					ClientX clientx = null;
					ModuleSelection frame = new ModuleSelection(ID, clientx);
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
	public ModuleSelection(String ID, ClientX clientx) {
		this.uid = ID;
		this.temp = clientx;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 920, 590);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome " + ID + "!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Product Sans", Font.PLAIN, 25));
		lblNewLabel.setBounds(270, 13, 380, 50);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 119, 890, 317);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Product Sans", Font.PLAIN, 20));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Module Title", "Code"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(650);

		//for (int count = 0; count < 5; count++) {
			table.setRowHeight(40); //You can also set height row by row using the same method with two parameters 
		//}
		
		scrollPane.setViewportView(table);
		table.setBackground(Color.LIGHT_GRAY);
		this.modTable(table); //Inserting data to the JTable with modTable(table) method
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectedSubjectID = table.getModel().getValueAt(table.getSelectedRow(), 1).toString(); //Get selected subjectID from table
				if(selectedSubjectID.equals(null)) {
					JOptionPane.showMessageDialog(null, "Please select a module first!", "Error", JOptionPane.WARNING_MESSAGE);
				} else {
					if(uid.charAt(0) == 'I' && uid.charAt(1) == 'T') { //If the user is a student
						new ExamSelectionWindowStudent(uid, temp, selectedSubjectID).setVisible(true);
						ModuleSelection.this.dispose();
					}
					else if (uid.charAt(0) == 'T' && uid.charAt(1) == 'E') { //if the user is a teacher
						new ExamSelectionWindowTeacher(uid, temp, selectedSubjectID).setVisible(true);
						ModuleSelection.this.dispose();
					}
				}
				/*new ExamSelectionWindowStudent().setVisible(true);
				ModuleSelection.this.dispose();*/
			}
		});
		btnNext.setFont(new Font("Product Sans", Font.BOLD, 20));
		btnNext.setForeground(Color.WHITE);
		btnNext.setBackground(new Color(51, 153, 51));
		btnNext.setBounds(752, 449, 150, 35);
		contentPane.add(btnNext);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 98, 50, 2);
		contentPane.add(separator);
		
		JLabel lblYourModules = new JLabel("Your Modules");
		lblYourModules.setFont(new Font("Product Sans", Font.PLAIN, 15));
		lblYourModules.setBounds(74, 88, 95, 18);
		contentPane.add(lblYourModules);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(181, 98, 721, 2);
		contentPane.add(separator_1);
		
		setResizable(false);
	}
	
	private void modTable(JTable table1) {
		DefaultTableModel model = (DefaultTableModel) table1.getModel();
		model.setRowCount(0);
		try {
			String[][] results = new String[10][2];
			results = temp.enrolledModules(this.uid);
			int j = 0;
			for(int i = 0; i < 4; i++) {
				model.addRow(new Object[] {results[i][j], results[i][j + 1]}); //Inserting Subject name and subjectID to the table
				
				//For some reason results[i][i] does not return the expected value, therefore an extra variable had to be used.
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
