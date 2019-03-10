package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.text.*;

public class Exam_Window {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exam_Window window = new Exam_Window();
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
	public Exam_Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(240, 248, 255));
		frame.setBounds(100, 100, 1019, 669);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Which of the following is true about private access modifier?");
		lblNewLabel.setBounds(232, 148, 637, 35);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		frame.getContentPane().add(lblNewLabel);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Variables, methods and constructors which are declared \r\nprivate can be accessed only by ");
		rdbtnNewRadioButton.setBounds(236, 256, 703, 23);
		rdbtnNewRadioButton.setToolTipText("");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JLabel lblNewLabel_1 = new JLabel("Select One");
		lblNewLabel_1.setBounds(236, 227, 118, 25);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		frame.getContentPane().add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 22, 204, 609);
		panel.setBorder(null);
		panel.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(250, 250, 210));
		panel_1.setBounds(9, 7, 186, 594);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Question");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(8, 6, 88, 22);
		panel_1.add(lblNewLabel_2);
		
		JLabel label = new JLabel("05");
		label.setFont(new Font("Tahoma", Font.BOLD, 23));
		label.setBounds(84, 8, 44, 21);
		panel_1.add(label);
		
		JButton button = new JButton("01");
		button.setBounds(14, 148, 52, 23);
		panel_1.add(button);
		
		JButton button_1 = new JButton("02");
		button_1.setBounds(68, 148, 52, 23);
		panel_1.add(button_1);
		
		JButton button_2 = new JButton("03");
		button_2.setBounds(122, 148, 52, 23);
		panel_1.add(button_2);
		
		JButton button_3 = new JButton("04");
		button_3.setBounds(14, 172, 52, 23);
		panel_1.add(button_3);
		
		JButton button_4 = new JButton("05");
		button_4.setBounds(68, 172, 52, 23);
		panel_1.add(button_4);
		
		JButton button_5 = new JButton("06");
		button_5.setBounds(122, 172, 52, 23);
		panel_1.add(button_5);
		
		JButton button_6 = new JButton("10");
		button_6.setBounds(14, 218, 52, 23);
		panel_1.add(button_6);
		
		JButton button_7 = new JButton("11");
		button_7.setBounds(68, 218, 52, 23);
		panel_1.add(button_7);
		
		JButton button_8 = new JButton("12");
		button_8.setBounds(122, 218, 52, 23);
		panel_1.add(button_8);
		
		JButton button_9 = new JButton("07");
		button_9.setBounds(14, 194, 52, 23);
		panel_1.add(button_9);
		
		JButton button_10 = new JButton("08");
		button_10.setBounds(68, 194, 52, 23);
		panel_1.add(button_10);
		
		JButton button_11 = new JButton("09");
		button_11.setBounds(122, 194, 52, 23);
		panel_1.add(button_11);
		
		JButton button_12 = new JButton("13");
		button_12.setBounds(14, 242, 52, 23);
		panel_1.add(button_12);
		
		JButton button_13 = new JButton("14");
		button_13.setBounds(68, 242, 52, 23);
		panel_1.add(button_13);
		
		JButton button_14 = new JButton("15");
		button_14.setBounds(122, 242, 52, 23);
		panel_1.add(button_14);
		
		JButton button_15 = new JButton("18");
		button_15.setBounds(122, 266, 52, 23);
		panel_1.add(button_15);
		
		JButton button_16 = new JButton("17");
		button_16.setBounds(68, 266, 52, 23);
		panel_1.add(button_16);
		
		JButton button_17 = new JButton("16");
		button_17.setBounds(14, 266, 52, 23);
		panel_1.add(button_17);
		
		JButton button_18 = new JButton("19");
		button_18.setBounds(14, 288, 52, 23);
		panel_1.add(button_18);
		
		JButton button_19 = new JButton("20");
		button_19.setBounds(68, 288, 52, 23);
		panel_1.add(button_19);
		
		JButton button_20 = new JButton("21");
		button_20.setBounds(122, 288, 52, 23);
		panel_1.add(button_20);
		
		JButton button_21 = new JButton("24");
		button_21.setBounds(122, 312, 52, 23);
		panel_1.add(button_21);
		
		JButton button_22 = new JButton("23");
		button_22.setBounds(68, 312, 52, 23);
		panel_1.add(button_22);
		
		JButton button_23 = new JButton("22");
		button_23.setBounds(14, 312, 52, 23);
		panel_1.add(button_23);
		
		JButton button_24 = new JButton("30");
		button_24.setBounds(122, 359, 52, 23);
		panel_1.add(button_24);
		
		JButton button_25 = new JButton("29");
		button_25.setBounds(68, 359, 52, 23);
		panel_1.add(button_25);
		
		JButton button_26 = new JButton("28");
		button_26.setBounds(14, 359, 52, 23);
		panel_1.add(button_26);
		
		JButton button_27 = new JButton("25");
		button_27.setBounds(14, 335, 52, 23);
		panel_1.add(button_27);
		
		JButton button_28 = new JButton("26");
		button_28.setBounds(68, 335, 52, 23);
		panel_1.add(button_28);
		
		JButton button_29 = new JButton("27");
		button_29.setBounds(122, 335, 52, 23);
		panel_1.add(button_29);
		
		JButton btnFlagQuection = new JButton("Flag this Question");
		btnFlagQuection.setBounds(14, 393, 160, 23);
		panel_1.add(btnFlagQuection);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Variables, methods and constructors which are declared private can be accessed by any ");
		rdbtnNewRadioButton_1.setBounds(236, 311, 705, 23);
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnVariablesMethodsAnd = new JRadioButton("Variables, methods and constructors which are declared private in the superclass can be ");
		rdbtnVariablesMethodsAnd.setBounds(236, 367, 706, 23);
		rdbtnVariablesMethodsAnd.setFont(new Font("Tahoma", Font.PLAIN, 17));
		frame.getContentPane().add(rdbtnVariablesMethodsAnd);
		
		JRadioButton rdbtnNoneOfThe = new JRadioButton("None of the mentioned.");
		rdbtnNoneOfThe.setBounds(236, 422, 703, 23);
		rdbtnNoneOfThe.setFont(new Font("Tahoma", Font.PLAIN, 17));
		frame.getContentPane().add(rdbtnNoneOfThe);
		
		JLabel lblNewLabel_3 = new JLabel("the members of the same class");
		lblNewLabel_3.setBounds(258, 281, 256, 23);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("class lying in same package. ");
		lblNewLabel_4.setBounds(258, 337, 223, 23);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("accessed only by its child class ");
		lblNewLabel_5.setBounds(258, 391, 256, 23);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		frame.getContentPane().add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("Next");
		btnNewButton.setBounds(850, 567, 118, 35);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Fazaal\\Pictures\\Actions-go-next-view-icon.png"));
		frame.getContentPane().add(btnNewButton);
		
		JButton btnPrevious = new JButton("Previous");
		btnPrevious.setBounds(719, 567, 121, 35);
		btnPrevious.setIcon(new ImageIcon("C:\\Users\\Fazaal\\Pictures\\good.png"));
		frame.getContentPane().add(btnPrevious);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(591, 567, 118, 35);
		btnSubmit.setIcon(new ImageIcon("C:\\Users\\Fazaal\\Pictures\\Submit.png"));
		frame.getContentPane().add(btnSubmit);
		
		JLabel lblNewLabel_Timer = new JLabel("  28:33:51");
		lblNewLabel_Timer.setBounds(719, 22, 132, 44);
		frame.getContentPane().add(lblNewLabel_Timer);
		lblNewLabel_Timer.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		JLabel lblNewLabel_6 = new JLabel("Midterm Exam");
		lblNewLabel_6.setForeground(Color.RED);
		lblNewLabel_6.setFont(new Font("Century Gothic", Font.BOLD, 27));
		lblNewLabel_6.setBounds(232, 97, 246, 40);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Time Remaining");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_7.setBounds(850, 37, 139, 23);
		frame.getContentPane().add(lblNewLabel_7);
	}
}
