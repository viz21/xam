package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;

public class SignUpWindow extends JFrame {

	private JPanel contentPane;
	private JTextField txtUID;
	private JTextField txtPW;
	private JTextField textField;

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
	 */
	public SignUpWindow() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 844, 507);
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
		label.setIcon(new ImageIcon(SignUpWindow.class.getResource("/Resources/2_edited.jpg")));
		panel.add(label);
		
		JButton btnSignIn = new JButton("Sign Up");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSignIn.setFont(new Font("Arial", Font.BOLD, 20));
		btnSignIn.setForeground(Color.WHITE);
		btnSignIn.setBackground(new Color(51, 153, 51));
		btnSignIn.setBounds(480, 362, 151, 36);
		contentPane.add(btnSignIn);
		
		txtUID = new JTextField();
		txtUID.setBounds(480, 143, 311, 36);
		contentPane.add(txtUID);
		txtUID.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(480, 177, 311, 2);
		contentPane.add(separator);
		
		JLabel lblUserId = new JLabel("User ID");
		lblUserId.setFont(new Font("Arial", Font.BOLD, 15));
		lblUserId.setBounds(480, 116, 76, 23);
		contentPane.add(lblUserId);
		
		txtPW = new JTextField();
		txtPW.setColumns(10);
		txtPW.setBounds(480, 228, 311, 36);
		contentPane.add(txtPW);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(480, 262, 311, 2);
		contentPane.add(separator_1);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Arial", Font.BOLD, 15));
		lblPassword.setBounds(480, 192, 76, 23);
		contentPane.add(lblPassword);
		
		JButton btnToNewAccountWindow = new JButton("Already have an account?");
		btnToNewAccountWindow.setHorizontalAlignment(SwingConstants.RIGHT);
		btnToNewAccountWindow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new StartWindow().setVisible(true);
				SignUpWindow.this.dispose();
			}
		});
		btnToNewAccountWindow.setForeground(Color.BLUE);
		btnToNewAccountWindow.setFont(new Font("Arial", Font.ITALIC, 13));
		btnToNewAccountWindow.setBackground(new Color(51, 153, 51));
		btnToNewAccountWindow.setBounds(630, 411, 161, 36);
		btnToNewAccountWindow.setFocusPainted(false);
		btnToNewAccountWindow.setMargin(new Insets(0, 0, 0, 0));
		btnToNewAccountWindow.setContentAreaFilled(false);
		btnToNewAccountWindow.setBorderPainted(false);
		btnToNewAccountWindow.setOpaque(false);
		
		contentPane.add(btnToNewAccountWindow);
		
		JLabel lblWelcomeToXam = new JLabel("<html>Only registerd students can create an account through this window.<br/>Teachers have to meet an admin</html>");
		lblWelcomeToXam.setVerticalAlignment(SwingConstants.TOP);
		lblWelcomeToXam.setHorizontalAlignment(SwingConstants.LEFT);
		lblWelcomeToXam.setFont(new Font("Arial", Font.BOLD, 15));
		lblWelcomeToXam.setBounds(480, 33, 311, 61);
		contentPane.add(lblWelcomeToXam);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(480, 313, 311, 36);
		contentPane.add(textField);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(480, 347, 311, 2);
		contentPane.add(separator_2);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Arial", Font.BOLD, 15));
		lblConfirmPassword.setBounds(480, 277, 129, 23);
		contentPane.add(lblConfirmPassword);
		
		setResizable(false);
	}
}
