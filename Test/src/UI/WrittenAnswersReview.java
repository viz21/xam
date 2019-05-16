package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

import Connectivity.ClientX;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;

public class WrittenAnswersReview extends JFrame {

	private JPanel contentPane;
	private JTable table;
	//ClientX temp = new ClientX();
	String ID = null;
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
					WrittenAnswersReview frame = new WrittenAnswersReview(ID, clientX, selectedSubjectID, selectedExamID);
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
	public WrittenAnswersReview(String ID, ClientX clientX, String selectedSubjectID, String selectedExamID) {
		
		this.ID = ID;
		this.temp = clientX;
		this.selectedSubjectID = selectedSubjectID;
		this.selectedExamID = selectedExamID;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1314, 769);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPleaseReviewThe = new JLabel("Please review the written answers first");
		lblPleaseReviewThe.setHorizontalAlignment(SwingConstants.LEFT);
		lblPleaseReviewThe.setFont(new Font("Product Sans", Font.PLAIN, 25));
		lblPleaseReviewThe.setBounds(12, 13, 574, 31);
		contentPane.add(lblPleaseReviewThe);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 57, 1284, 529);
		contentPane.add(scrollPane);
		
		JComboBox AnswerStatus = new JComboBox();
		AnswerStatus.setFont(new Font("Product Sans", Font.PLAIN, 15));
		AnswerStatus.setModel(new DefaultComboBoxModel(new String[] {"Correct", "Incorrect"}));
		
		table = new JTable();
		table.setFont(new Font("Product Sans", Font.PLAIN, 23));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"studentID", "examID", "questionID", "given Answer", "correct Answer", "Answer status"
			}
		));
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(20);
		table.getColumnModel().getColumn(1).setPreferredWidth(50);
		table.getColumnModel().getColumn(2).setPreferredWidth(20);
		table.getColumnModel().getColumn(3).setPreferredWidth(225);
		table.getColumnModel().getColumn(4).setPreferredWidth(225);
		table.setRowHeight(30);
		scrollPane.setViewportView(table);
		table.setBackground(Color.LIGHT_GRAY);
		this.modTable(table);
		
		JButton btnPrevious = new JButton("Previous");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new QuestionManagement(ID, temp, selectedSubjectID, selectedExamID).setVisible(true);
				WrittenAnswersReview.this.dispose();
			}
		});
		btnPrevious.setForeground(Color.WHITE);
		btnPrevious.setFont(new Font("Product Sans", Font.BOLD, 20));
		btnPrevious.setBackground(new Color(51, 153, 51));
		btnPrevious.setBounds(12, 599, 150, 35);
		contentPane.add(btnPrevious);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String[][] results = new String[1000][6];
					boolean break1 = false;
					
					for(int i=0; i<table.getRowCount(); i++) {
						if (break1) {
							break;
						} 
				        for(int j=0 ; j<table.getColumnCount() ; j++) {
				        	if (table.getModel().getValueAt(i, 5) == null || table.getModel().getValueAt(i, 5).equals("")) {
				        		/*JOptionPane.showMessageDialog(null, "Please review every answer!", "Error", JOptionPane.WARNING_MESSAGE);
				        		break1 = true;
				        		break;*/
							}
				        	results[i][0] = table.getModel().getValueAt(i, 0).toString(); // studentID
				        	results[i][1] = table.getModel().getValueAt(i, 2).toString(); // questionID
				        	results[i][2] = table.getModel().getValueAt(i, 5).toString(); // status
				        }
				    }
					if (!break1) {
						temp.WrittenAnswerReviewSubmission(results);
						JOptionPane.showMessageDialog(null, "Reviews submitted successfully!"); 
					}
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnSubmit.setForeground(Color.WHITE);
		btnSubmit.setFont(new Font("Product Sans", Font.BOLD, 20));
		btnSubmit.setBackground(new Color(51, 153, 51));
		btnSubmit.setBounds(1146, 599, 150, 35);
		contentPane.add(btnSubmit);
		
		JButton btnViewResults = new JButton("View Results");
		btnViewResults.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new FinalResults(ID, clientX, selectedSubjectID, selectedExamID).setVisible(true);
				WrittenAnswersReview.this.dispose();
			}
		});
		btnViewResults.setForeground(Color.WHITE);
		btnViewResults.setFont(new Font("Product Sans", Font.BOLD, 20));
		btnViewResults.setBackground(new Color(240, 128, 128));
		btnViewResults.setBounds(1060, 647, 236, 35);
		contentPane.add(btnViewResults);
		table.getColumnModel().getColumn(5).setCellEditor(new DefaultCellEditor(AnswerStatus));
		
		setResizable(false);
	}
	
	private void modTable(JTable table1) {
		DefaultTableModel model = (DefaultTableModel) table1.getModel();
		model.setRowCount(0);
		try {
			String[][] results = new String[1000][6];
			results = this.temp.WrittenAnswerReview(this.selectedExamID); // change this later
			for (int i = 0; i < results.length; i++) {
				if(results[i][0] == null) {
					break;
				} 
				model.addRow(new Object[] {results[i][0], results[i][1], results[i][2], results[i][3], results[i][4], results[i][5]});
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
