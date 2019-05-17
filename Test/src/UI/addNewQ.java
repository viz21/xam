package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Connectivity.ClientX;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;

/*@author Vishwa
 * 
 * */

public class addNewQ extends JFrame {

	private JPanel contentPane;
	ClientX temp;
	String selectedExamID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientX clientx = null;
					String selectedExamID = null;
					addNewQ frame = new addNewQ(clientx, selectedExamID);
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
	public addNewQ(ClientX clientx, String selectedExamID) {
		
		this.temp = clientx;
		this.selectedExamID = selectedExamID;
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1145, 663);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(220, 220, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Question");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Product Sans", Font.PLAIN, 20));
		lblNewLabel.setBounds(12, 13, 221, 35);
		contentPane.add(lblNewLabel);
		
		JTextArea txtQ = new JTextArea();
		txtQ.setFont(new Font("SansSerif", Font.PLAIN, 15));
		txtQ.setBackground(Color.WHITE);
		txtQ.setBounds(245, 13, 870, 80);
		contentPane.add(txtQ);
		
		JLabel lblCorrectAnswer = new JLabel("Correct Answer");
		lblCorrectAnswer.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCorrectAnswer.setFont(new Font("Product Sans", Font.PLAIN, 20));
		lblCorrectAnswer.setBounds(12, 106, 221, 35);
		contentPane.add(lblCorrectAnswer);
		
		JTextArea txtCA = new JTextArea();
		txtCA.setFont(new Font("SansSerif", Font.PLAIN, 15));
		txtCA.setBackground(Color.WHITE);
		txtCA.setBounds(245, 106, 870, 80);
		contentPane.add(txtCA);
		
		JLabel lblAlternativeAnswer = new JLabel("Alternative Answer 1");
		lblAlternativeAnswer.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAlternativeAnswer.setFont(new Font("Product Sans", Font.PLAIN, 20));
		lblAlternativeAnswer.setBounds(12, 199, 221, 35);
		contentPane.add(lblAlternativeAnswer);
		
		JTextArea txtAA1 = new JTextArea();
		txtAA1.setFont(new Font("SansSerif", Font.PLAIN, 15));
		txtAA1.setBackground(Color.WHITE);
		txtAA1.setBounds(245, 199, 870, 80);
		contentPane.add(txtAA1);
		
		JLabel lblAlternativeAnswer_1 = new JLabel("Alternative Answer 2");
		lblAlternativeAnswer_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAlternativeAnswer_1.setFont(new Font("Product Sans", Font.PLAIN, 20));
		lblAlternativeAnswer_1.setBounds(12, 292, 221, 35);
		contentPane.add(lblAlternativeAnswer_1);
		
		JTextArea txtAA2 = new JTextArea();
		txtAA2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		txtAA2.setBackground(Color.WHITE);
		txtAA2.setBounds(245, 292, 870, 80);
		contentPane.add(txtAA2);
		
		JLabel lblAlternativeAnswer_2 = new JLabel("Alternative Answer 3");
		lblAlternativeAnswer_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAlternativeAnswer_2.setFont(new Font("Product Sans", Font.PLAIN, 20));
		lblAlternativeAnswer_2.setBounds(12, 385, 221, 35);
		contentPane.add(lblAlternativeAnswer_2);
		
		JTextArea txtAA3 = new JTextArea();
		txtAA3.setFont(new Font("SansSerif", Font.PLAIN, 15));
		txtAA3.setBackground(Color.WHITE);
		txtAA3.setBounds(245, 385, 870, 80);
		contentPane.add(txtAA3);
		
		JButton btnAddQuestion = new JButton("Add Question");
		btnAddQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					temp.addNewQ(selectedExamID, txtQ.getText(), txtCA.getText(), txtAA1.getText(), txtAA2.getText(), txtAA3.getText()); //calls addNewQ method in the SeverConnection Object via clientX object
				} catch (RemoteException e) { 
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				addNewQ.this.dispose();
			}
		});
		btnAddQuestion.setForeground(Color.WHITE);
		btnAddQuestion.setFont(new Font("Product Sans", Font.BOLD, 20));
		btnAddQuestion.setBackground(new Color(51, 153, 51));
		btnAddQuestion.setBounds(879, 524, 236, 35);
		contentPane.add(btnAddQuestion);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
	}
}
