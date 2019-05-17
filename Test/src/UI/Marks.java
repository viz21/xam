package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

/*Not important / Useless
 * 
 * */

public class Marks {

	private JFrame frame;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Marks window = new Marks();
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
	public Marks() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1065, 756);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 1047, 715);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(23, 205, 998, 249);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 998, 249);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Malinda Bandara", "13215", "75", "Pass"},
				{"Pushpa Kumara", "13135", "58", "Pass"},
				{"Tharindu Perera", "46456", "34", "Fail"},
				{"Ushan Wijesgihne", "54654", "80", "Pass"},
				{"Udith De Silva", "34643", "31", null},
			},
			new String[] {
				"Student Name", "Student ID", "Marks", "Pass/Fail"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("X-AM! Marks");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setBounds(426, 24, 183, 27);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		panel.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.textHighlight);
		panel_2.setBounds(12, 74, 1023, 102);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Teacher :");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(12, 13, 77, 26);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Course Name :");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(428, 18, 121, 16);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Period/Time :");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(428, 61, 121, 16);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Date :");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setBounds(803, 19, 65, 16);
		panel_2.add(lblNewLabel_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Course...", "Object Oriented Programming ", "Software Engineering", "Data Management Systems", "Information System Analysis", "Computer Networks", "Mobile Applications Development"}));
		comboBox.setBounds(561, 16, 211, 22);
		panel_2.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(864, 16, 147, 22);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Log out");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(938, 28, 97, 25);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Export to pdf");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBounds(871, 621, 150, 30);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2.setBounds(22, 621, 110, 30);
		panel.add(btnNewButton_2);
	}
}
