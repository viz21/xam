package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Panel;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;
import javax.swing.JTree;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import java.awt.Choice;
import java.awt.List;
import javax.swing.JMenu;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JList;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;

public class AdminPanel {

	private JFrame frame;
	private JTextField sid;
	private JTextField sfname;
	private JTextField slname;
	private JTextField sbday;
	private JTextField sphne;
	private JTextField saddress;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPanel window = new AdminPanel();
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
	public AdminPanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(248, 248, 255));
		frame.setBounds(100, 100, 1354, 1007);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Remove");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(220, 20, 60));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBounds(218, 907, 135, 30);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setForeground(new Color(255, 255, 255));
		btnEdit.setBackground(new Color(70, 130, 180));
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnEdit.setBounds(393, 907, 135, 30);
		frame.getContentPane().add(btnEdit);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBackground(new Color(0, 255, 0));
		btnAdd.setForeground(new Color(255, 255, 255));
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnAdd.setBounds(744, 907, 135, 30);
		frame.getContentPane().add(btnAdd);
		
		Panel panel = new Panel();
		panel.setBackground(new Color(0, 153, 204));
		panel.setBounds(0, 0, 1336, 86);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblXam = new JLabel("   X-AM! - Admin Panel");
		lblXam.setBounds(484, 16, 418, 46);
		panel.add(lblXam);
		lblXam.setForeground(new Color(255, 255, 255));
		lblXam.setBackground(new Color(255, 255, 255));
		lblXam.setFont(new Font("Tahoma", Font.BOLD, 32));
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBackground(Color.WHITE);
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLogout.setBounds(1215, 34, 97, 25);
		panel.add(btnLogout);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(new Color(220, 220, 220));
		panel_1.setBounds(10, 168, 551, 706);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblUserId = new JLabel("User ID");
		lblUserId.setBounds(50, 110, 56, 16);
		panel_1.add(lblUserId);
		lblUserId.setFont(new Font("Calibri", Font.BOLD, 17));
		
		sid = new JTextField();
		sid.setBounds(172, 100, 175, 35);
		panel_1.add(sid);
		sid.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(50, 185, 99, 16);
		panel_1.add(lblFirstName);
		lblFirstName.setFont(new Font("Calibri", Font.BOLD, 17));
		
		sfname = new JTextField();
		sfname.setBounds(171, 175, 325, 35);
		panel_1.add(sfname);
		sfname.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(50, 255, 99, 25);
		panel_1.add(lblLastName);
		lblLastName.setFont(new Font("Calibri", Font.BOLD, 17));
		
		slname = new JTextField();
		slname.setBounds(171, 249, 325, 35);
		panel_1.add(slname);
		slname.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(50, 340, 56, 16);
		panel_1.add(lblGender);
		lblGender.setFont(new Font("Calibri", Font.BOLD, 17));
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBounds(171, 335, 127, 25);
		panel_1.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBounds(354, 335, 127, 25);
		panel_1.add(rdbtnFemale);
		
		JLabel lblBirthday = new JLabel("Birthdate");
		lblBirthday.setBounds(50, 417, 99, 16);
		panel_1.add(lblBirthday);
		lblBirthday.setFont(new Font("Calibri", Font.BOLD, 17));
		
		sbday = new JTextField();
		sbday.setBounds(171, 407, 200, 35);
		panel_1.add(sbday);
		sbday.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Phone");
		lblNewLabel.setBounds(50, 494, 56, 16);
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 17));
		
		sphne = new JTextField();
		sphne.setBounds(171, 484, 200, 35);
		panel_1.add(sphne);
		sphne.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(50, 562, 85, 16);
		panel_1.add(lblAddress);
		lblAddress.setFont(new Font("Calibri", Font.BOLD, 17));
		
		saddress = new JTextField();
		saddress.setBounds(171, 562, 325, 118);
		panel_1.add(saddress);
		saddress.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(60, 179, 113));
		panel_4.setBounds(12, 13, 527, 34);
		panel_1.add(panel_4);
		
		JLabel lblIAmA = new JLabel("Student");
		lblIAmA.setForeground(Color.WHITE);
		panel_4.add(lblIAmA);
		lblIAmA.setFont(new Font("Calibri Light", Font.BOLD, 20));
		
		Panel panel_2 = new Panel();
		panel_2.setBackground(new Color(0, 102, 153));
		panel_2.setBounds(10, 97, 551, 54);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnTeacher = new JButton("Teacher");
		btnTeacher.setForeground(Color.WHITE);
		btnTeacher.setBackground(Color.LIGHT_GRAY);
		btnTeacher.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnTeacher.setBounds(85, 13, 125, 25);
		panel_2.add(btnTeacher);
		
		JButton btnStudent = new JButton("Student");
		btnStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnStudent.setBackground(Color.LIGHT_GRAY);
		btnStudent.setForeground(Color.WHITE);
		btnStudent.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnStudent.setBounds(330, 13, 125, 25);
		panel_2.add(btnStudent);
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.setBackground(new Color(0, 153, 255));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton_1.setBounds(572, 907, 135, 30);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBackground(Color.LIGHT_GRAY);
		btnClear.setForeground(Color.WHITE);
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnClear.setBounds(40, 907, 135, 30);
		frame.getContentPane().add(btnClear);
		
		Panel panel_3 = new Panel();
		panel_3.setBounds(572, 97, 793, 777);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 738, 777);
		panel_3.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"123434", "Lasith", "Perera", "Male", "12.12.1997", "0114654985"},
				{"435234", "Nipuni", "Pieris", "Female", "08.11.1999", "0716464611"},
				{"324234", "Udara", "De Silva", "Male", "06.07.1999", "0775123112"},
			},
			new String[] {
				"User ID", "First Name", "Last Name", "Gender", "Birthdate", "Phone no."
			}
		));
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
