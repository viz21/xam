package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ExamSelectionWindowStudent extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExamSelectionWindowStudent frame = new ExamSelectionWindowStudent();
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
	public ExamSelectionWindowStudent() {
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
				{"Online Exam 1", "Complete"},
				{"Online Exam 2", "Complete"},
				{"OOP - Mid Semester Exam (Online)", "Not Complete"},
				{"Online Exam 3", "Not Complete"},
				{"Online Exam 4", "Not Complete"},
			},
			new String[] {
				"Assignment Title", "Status"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(650);
		table.setRowHeight(40);
		table.setFont(new Font("Product Sans", Font.PLAIN, 20));
		table.setBackground(Color.LIGHT_GRAY);
		scrollPane.setViewportView(table);
		
		JButton btnEnroll = new JButton("Start");
		btnEnroll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Exam_Window().setVisible(true);
				ExamSelectionWindowStudent.this.dispose();
			}
		});
		btnEnroll.setForeground(Color.WHITE);
		btnEnroll.setFont(new Font("Product Sans", Font.BOLD, 20));
		btnEnroll.setBackground(new Color(51, 153, 51));
		btnEnroll.setBounds(752, 449, 150, 35);
		contentPane.add(btnEnroll);
		
		textField = new JTextField();
		textField.setBounds(565, 449, 175, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
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
}
