package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.ImageIcon;

public class ExamSummary {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExamSummary window = new ExamSummary();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ExamSummary() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1268, 865);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1250, 818);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 153, 204));
		panel_1.setBounds(23, 13, 1199, 62);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblExamSummary = new JLabel("Exam Summary");
		lblExamSummary.setForeground(Color.WHITE);
		lblExamSummary.setBounds(12, 13, 188, 29);
		lblExamSummary.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel_1.add(lblExamSummary);
		
		JPanel panel_2 = new JPanel();
		panel_2.setForeground(Color.WHITE);
		panel_2.setBackground(new Color(0, 51, 204));
		panel_2.setBounds(24, 105, 620, 168);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblObjectOrientedProgramming = new JLabel("Object Oriented Programming");
		lblObjectOrientedProgramming.setForeground(Color.WHITE);
		lblObjectOrientedProgramming.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblObjectOrientedProgramming.setBounds(149, 30, 225, 26);
		panel_2.add(lblObjectOrientedProgramming);
		
		JLabel lblOopMid = new JLabel("OOP - Mid Semester Exam (Online)");
		lblOopMid.setForeground(Color.WHITE);
		lblOopMid.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblOopMid.setBounds(149, 99, 267, 26);
		panel_2.add(lblOopMid);
		
		JLabel lblModule = new JLabel("Module :");
		lblModule.setForeground(Color.WHITE);
		lblModule.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblModule.setBounds(12, 32, 78, 22);
		panel_2.add(lblModule);
		
		JLabel lblExam = new JLabel("Exam  :");
		lblExam.setForeground(Color.WHITE);
		lblExam.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblExam.setBounds(12, 101, 90, 22);
		panel_2.add(lblExam);
		
		JLabel lblOverallResult = new JLabel("Overall Result");
		lblOverallResult.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblOverallResult.setBounds(23, 297, 211, 25);
		panel.add(lblOverallResult);
		
		JButton btnPrevious = new JButton("Previous");
		btnPrevious.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnPrevious.setBounds(23, 775, 120, 30);
		panel.add(btnPrevious);
		
		JButton btnCheckResultIndividually = new JButton("Check Result Individually");
		btnCheckResultIndividually.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCheckResultIndividually.setBounds(979, 775, 243, 30);
		panel.add(btnCheckResultIndividually);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(23, 352, 1199, 410);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ExamSummary.class.getResource("/Resources/graph.png")));
		label.setBounds(0, 0, 1199, 632);
		panel_3.add(label);
	}
}
