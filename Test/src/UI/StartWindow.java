package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.security.ntlm.Client;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;

import Connectivity.*;

/*Starts the system using this class
 * 
 * Referenced Libraries and .jar files to this system are 
 * 
 * mysql-connector-java-8.0.12.jar
 * jcommon-1.0.23.jar
 * jfreechart-1.0.19.jar
 * itextpdf-5.4.2.jar
 * 
 * @author Vishwa
 * */

public class StartWindow extends JFrame {

	private JPanel contentPane;
	private JTextField txtUID;
	private JPasswordField passwordField;
	ClientX clientx = new ClientX(); //This is where the ClientX object is first created. This object is passed through all the other classes

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartWindow frame = new StartWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws RemoteException 
	 */
	public StartWindow() throws RemoteException {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, -12, 420, 512);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(StartWindow.class.getResource("/Resources/2_edited.jpg")));
		panel.add(label);
		
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.setFont(new Font("Product Sans", Font.BOLD, 20));
		btnSignIn.setForeground(Color.WHITE);
		btnSignIn.setBackground(new Color(51, 153, 51));
		btnSignIn.setBounds(480, 362, 151, 36);
		contentPane.add(btnSignIn);
		
		txtUID = new JTextField();
		txtUID.setBounds(480, 228, 311, 36);
		contentPane.add(txtUID);
		txtUID.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(480, 262, 311, 2);
		contentPane.add(separator);
		
		JLabel lblUserId = new JLabel("User ID");
		lblUserId.setFont(new Font("Product Sans", Font.BOLD, 15));
		lblUserId.setBounds(480, 192, 76, 23);
		contentPane.add(lblUserId);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(480, 347, 311, 2);
		contentPane.add(separator_1);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Product Sans", Font.BOLD, 15));
		lblPassword.setBounds(480, 277, 76, 23);
		contentPane.add(lblPassword);
		
		JButton btnToNewAccountWindow = new JButton("Change password here");
		btnToNewAccountWindow.setHorizontalAlignment(SwingConstants.RIGHT);
		btnToNewAccountWindow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new SignUpWindow().setVisible(true);
				StartWindow.this.dispose();
			}
		});
		btnToNewAccountWindow.setForeground(Color.BLUE);
		btnToNewAccountWindow.setFont(new Font("Product Sans", Font.ITALIC, 13));
		btnToNewAccountWindow.setBackground(new Color(51, 153, 51));
		btnToNewAccountWindow.setBounds(640, 411, 151, 36);
		btnToNewAccountWindow.setFocusPainted(false);
		btnToNewAccountWindow.setMargin(new Insets(0, 0, 0, 0));
		btnToNewAccountWindow.setContentAreaFilled(false);
		btnToNewAccountWindow.setBorderPainted(false);
		btnToNewAccountWindow.setOpaque(false);
		
		btnToNewAccountWindow.setVisible(false);
		
		contentPane.add(btnToNewAccountWindow);
		
		
		
		
		
		JLabel lblWelcomeToXam = new JLabel(clientx.welcomeBanner());
		lblWelcomeToXam.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToXam.setFont(new Font("Product Sans", Font.BOLD, 30));
		lblWelcomeToXam.setBounds(480, 33, 311, 52);
		contentPane.add(lblWelcomeToXam);
		
		JLabel lblIAmA = new JLabel("I am a");
		lblIAmA.setFont(new Font("Product Sans", Font.BOLD, 15));
		lblIAmA.setBounds(480, 141, 50, 23);
		contentPane.add(lblIAmA);
		
		JComboBox ComboUser = new JComboBox();
		ComboUser.setFont(new Font("Product Sans", Font.PLAIN, 15));
		ComboUser.setModel(new DefaultComboBoxModel(new String[] {"Teacher", "Student"}));
		ComboUser.setBounds(529, 141, 133, 22);
		contentPane.add(ComboUser);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(480, 311, 311, 38);
		contentPane.add(passwordField);
		

		/*The button click triggers the method signIn in ClientX
		 * which triggers the method signIn in the stub object, ServerConnection
		 * */
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String type = ComboUser.getSelectedItem().toString();
				String uid = txtUID.getText();
				String password = new String(passwordField.getPassword());
				
				try {

					String ID = clientx.signIn(type, uid, password); // calls signin method in the SeverConnection Object via clientX object
					if (!ID.equals("Error")) {
						new ModuleSelection(uid, clientx).setVisible(true); //Next class, ModuleSelection
						StartWindow.this.dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "Invalid Login", "Error", JOptionPane.WARNING_MESSAGE);
					}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		setResizable(false);
	}
}
