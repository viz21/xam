package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class adminTeacher {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminTeacher window = new adminTeacher();
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
	public adminTeacher() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1347, 962);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(0, 0, 1336, 86);
		panel.setLayout(null);
		panel.setBackground(new Color(0, 153, 204));
		frame.getContentPane().add(panel);
		
		JLabel label = new JLabel("   X-AM! - Admin Panel");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 32));
		label.setBackground(Color.WHITE);
		label.setBounds(484, 16, 418, 46);
		panel.add(label);
		
		JButton button = new JButton("Logout");
		button.setFont(new Font("Tahoma", Font.BOLD, 15));
		button.setBackground(Color.WHITE);
		button.setBounds(1215, 34, 97, 25);
		panel.add(button);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(579, 100, 738, 709);
		frame.getContentPane().add(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"235435", "Jehan", "Kumar", "Male", "14.02.1966", "0146466545", "therin@gmail.com"},
				{"265346", "Sadani", "Perera", "Female", "26.03.1956", "0156513151", "Herein@gmail.com"},
				{"56756", "Jagath", "Jayasinghe", "Male", "23.01.1977", "0456546456", null},
			},
			new String[] {
				"User ID", "First Name", "Last Name", "Gender", "Birthdate", "Phone", "E-mail"
			}
		));
		table.getColumnModel().getColumn(6).setPreferredWidth(145);
		scrollPane.setViewportView(table);
		
		Panel panel_1 = new Panel();
		panel_1.setBounds(11, 99, 551, 54);
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 102, 153));
		frame.getContentPane().add(panel_1);
		
		JButton button_1 = new JButton("Teacher");
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		button_1.setBackground(Color.LIGHT_GRAY);
		button_1.setBounds(85, 13, 125, 25);
		panel_1.add(button_1);
		
		JButton button_2 = new JButton("Student");
		button_2.addActionListener(new ActionListener() {
			 
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		button_2.addMouseListener(new MouseAdapter() {
			
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		button_2.setBackground(Color.LIGHT_GRAY);
		button_2.setBounds(330, 13, 125, 25);
		panel_1.add(button_2);
		
		Panel panel_2 = new Panel();
		panel_2.setBounds(11, 171, 551, 638);
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(220, 220, 220));
		frame.getContentPane().add(panel_2);
		
		JLabel label_1 = new JLabel("User ID");
		label_1.setFont(new Font("Calibri", Font.BOLD, 17));
		label_1.setBounds(50, 110, 56, 16);
		panel_2.add(label_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(172, 100, 175, 35);
		panel_2.add(textField);
		
		JLabel label_2 = new JLabel("First Name");
		label_2.setFont(new Font("Calibri", Font.BOLD, 17));
		label_2.setBounds(50, 185, 99, 16);
		panel_2.add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(171, 175, 325, 35);
		panel_2.add(textField_1);
		
		JLabel label_3 = new JLabel("Last Name");
		label_3.setFont(new Font("Calibri", Font.BOLD, 17));
		label_3.setBounds(50, 255, 99, 25);
		panel_2.add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(171, 249, 325, 35);
		panel_2.add(textField_2);
		
		JLabel label_4 = new JLabel("Gender");
		label_4.setFont(new Font("Calibri", Font.BOLD, 17));
		label_4.setBounds(50, 340, 56, 16);
		panel_2.add(label_4);
		
		JRadioButton radioButton = new JRadioButton("Male");
		radioButton.setBounds(171, 335, 127, 25);
		panel_2.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("Female");
		radioButton_1.setBounds(354, 335, 127, 25);
		panel_2.add(radioButton_1);
		
		JLabel label_5 = new JLabel("Birthdate");
		label_5.setFont(new Font("Calibri", Font.BOLD, 17));
		label_5.setBounds(50, 417, 99, 16);
		panel_2.add(label_5);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(171, 407, 200, 35);
		panel_2.add(textField_3);
		
		JLabel label_6 = new JLabel("Phone");
		label_6.setFont(new Font("Calibri", Font.BOLD, 17));
		label_6.setBounds(50, 494, 56, 16);
		panel_2.add(label_6);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(171, 484, 200, 35);
		panel_2.add(textField_4);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Calibri", Font.BOLD, 17));
		lblEmail.setBounds(50, 571, 85, 16);
		panel_2.add(lblEmail);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(172, 561, 250, 35);
		panel_2.add(textField_5);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(60, 179, 113));
		panel_3.setBounds(12, 13, 527, 34);
		panel_2.add(panel_3);
		
		JLabel lblTeacher = new JLabel("Teacher");
		lblTeacher.setForeground(Color.WHITE);
		lblTeacher.setFont(new Font("Calibri Light", Font.BOLD, 20));
		panel_3.add(lblTeacher);
		
		JButton button_3 = new JButton("Clear");
		button_3.setBounds(41, 842, 135, 30);
		button_3.setForeground(Color.WHITE);
		button_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		button_3.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(button_3);
		
		JButton button_4 = new JButton("Remove");
		button_4.setBounds(219, 842, 135, 30);
		button_4.setForeground(Color.WHITE);
		button_4.setFont(new Font("Tahoma", Font.BOLD, 17));
		button_4.setBackground(new Color(220, 20, 60));
		frame.getContentPane().add(button_4);
		
		JButton button_5 = new JButton("Edit");
		button_5.setBounds(394, 842, 135, 30);
		button_5.setForeground(Color.WHITE);
		button_5.setFont(new Font("Tahoma", Font.BOLD, 17));
		button_5.setBackground(new Color(70, 130, 180));
		frame.getContentPane().add(button_5);
		
		JButton button_6 = new JButton("Search");
		button_6.setBounds(573, 842, 135, 30);
		button_6.setForeground(Color.WHITE);
		button_6.setFont(new Font("Tahoma", Font.BOLD, 17));
		button_6.setBackground(new Color(0, 153, 255));
		frame.getContentPane().add(button_6);
		
		JButton button_7 = new JButton("Add");
		button_7.setBounds(745, 842, 135, 30);
		button_7.setForeground(Color.WHITE);
		button_7.setFont(new Font("Tahoma", Font.BOLD, 17));
		button_7.setBackground(Color.GREEN);
		frame.getContentPane().add(button_7);
	}
}
