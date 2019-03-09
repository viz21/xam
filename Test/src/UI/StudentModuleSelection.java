package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JSeparator;

public class StudentModuleSelection extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentModuleSelection frame = new StudentModuleSelection();
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
	public StudentModuleSelection() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 920, 590);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome Vishwa!");
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
				{"Object Oriented Programming", "IT2030"},
				{"Database Management Systems", "IT2040"},
				{"Software Engineering", "IT2020"},
				{"Operating Systems and System Administration", "IT2060"},
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
		
		JButton btnNext = new JButton("Next");
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
}
