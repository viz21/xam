package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import com.mysql.cj.MysqlConnection;

import Connectivity.ClientX;
import Connectivity.ConnectInterface;
//import JPanelSlider.JPanelSlider;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.text.*;
import javax.swing.JTextField;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import java.sql.Connection;
import java.sql.DriverManager;

public class Exam_Window extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JLayeredPane layeredPane_1;
	ConnectInterface temp;
	JLabel lbl1;
	private static Connection connection;
	ClientX clientx = null;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exam_Window frame = new Exam_Window();
					frame.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void switchPanels(JPanel panel) {
		layeredPane_1.removeAll();
		layeredPane_1.add(panel);
		layeredPane_1.repaint();
		layeredPane_1.revalidate();
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
		frame.setVisible(true);
		frame.getContentPane().setBackground(new Color(240, 248, 255));
		frame.setBounds(100, 100, 1019, 669);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBounds(224, 112, 765, 508);
		frame.getContentPane().add(layeredPane_1);
		layeredPane_1.setLayout(new CardLayout(0, 0));
		
		JPanel panel1 = new JPanel();
		layeredPane_1.add(panel1, "name_56358260830458");
		panel1.setLayout(null);
		
		JLabel lbl1 = new JLabel("Which of the following is true about private access modifier?");
		lbl1.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lbl1.setBounds(20, 11, 745, 38);
		panel1.add(lbl1);
		
		JLabel lblNewLabel = new JLabel("Select One");
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblNewLabel.setBounds(20, 104, 160, 26);
		panel1.add(lblNewLabel);
		
		JRadioButton rdbtnVariablesMethodsAnd = new JRadioButton("Variables, methods and constructors whichh are declared private  can\r\n be access only by");
		rdbtnVariablesMethodsAnd.setToolTipText("");
		rdbtnVariablesMethodsAnd.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		rdbtnVariablesMethodsAnd.setBounds(65, 150, 694, 23);
		panel1.add(rdbtnVariablesMethodsAnd);
		
		JButton btnNext = new JButton("Next");
		btnNext.setForeground(Color.WHITE);
		btnNext.setFont(new Font("Dialog", Font.BOLD, 20));
		btnNext.setBackground(new Color(51, 153, 51));
		btnNext.setBounds(629, 462, 126, 35);
		panel1.add(btnNext);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		rdbtnNewRadioButton.setBounds(71, 195, 109, 23);
		panel1.add(rdbtnNewRadioButton);
		
		JPanel panel2 = new JPanel();
		layeredPane_1.add(panel2, "name_56417374604870");
		panel2.setLayout(null);
		
		JLabel lblPanel = new JLabel("Panel 2");
		lblPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblPanel.setBounds(269, 170, 99, 54);
		panel2.add(lblPanel);
		
		JButton button_30 = new JButton("Previous");
		button_30.setForeground(Color.WHITE);
		button_30.setFont(new Font("Dialog", Font.BOLD, 20));
		button_30.setBackground(new Color(51, 153, 51));
		button_30.setBounds(493, 462, 126, 35);
		panel2.add(button_30);
		
		JButton button_32 = new JButton("Next");
		button_32.setForeground(Color.WHITE);
		button_32.setFont(new Font("Dialog", Font.BOLD, 20));
		button_32.setBackground(new Color(51, 153, 51));
		button_32.setBounds(629, 462, 126, 35);
		panel2.add(button_32);
		
		JPanel panel3 = new JPanel();
		layeredPane_1.add(panel3, "name_56419756782686");
		panel3.setLayout(null);
		
		JLabel lblPanel_1 = new JLabel("Panel 3");
		lblPanel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPanel_1.setBounds(280, 165, 99, 54);
		panel3.add(lblPanel_1);
		
		JButton button_33 = new JButton("Previous");
		button_33.setForeground(Color.WHITE);
		button_33.setFont(new Font("Dialog", Font.BOLD, 20));
		button_33.setBackground(new Color(51, 153, 51));
		button_33.setBounds(493, 462, 126, 35);
		panel3.add(button_33);
		
		JButton button_34 = new JButton("Next");
		
		button_34.setForeground(Color.WHITE);
		button_34.setFont(new Font("Dialog", Font.BOLD, 20));
		button_34.setBackground(new Color(51, 153, 51));
		button_34.setBounds(629, 462, 126, 35);
		panel3.add(button_34);
		
		JPanel panel4 = new JPanel();
		layeredPane_1.add(panel4, "name_56441595404259");
		panel4.setLayout(null);
		
		JButton button_35 = new JButton("Previous");
		button_35.setForeground(Color.WHITE);
		button_35.setFont(new Font("Dialog", Font.BOLD, 20));
		button_35.setBackground(new Color(51, 153, 51));
		button_35.setBounds(493, 462, 126, 35);
		panel4.add(button_35);
		
		JButton button_36 = new JButton("Next");
		button_36.setForeground(Color.WHITE);
		button_36.setFont(new Font("Dialog", Font.BOLD, 20));
		button_36.setBackground(new Color(51, 153, 51));
		button_36.setBounds(629, 462, 126, 35);
		panel4.add(button_36);
		
		JLabel lblPanel_2 = new JLabel("Panel 4");
		lblPanel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPanel_2.setBounds(272, 193, 99, 54);
		panel4.add(lblPanel_2);
		
		JPanel panel5 = new JPanel();
		layeredPane_1.add(panel5, "name_56443926507897");
		panel5.setLayout(null);
		
		JButton button_37 = new JButton("Previous");
		button_37.setForeground(Color.WHITE);
		button_37.setFont(new Font("Dialog", Font.BOLD, 20));
		button_37.setBackground(new Color(51, 153, 51));
		button_37.setBounds(493, 462, 126, 35);
		panel5.add(button_37);
		
		JButton button_38 = new JButton("Next");
		button_38.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		button_38.setForeground(Color.WHITE);
		button_38.setFont(new Font("Dialog", Font.BOLD, 20));
		button_38.setBackground(new Color(51, 153, 51));
		button_38.setBounds(629, 462, 126, 35);
		panel5.add(button_38);
		
		JLabel lblPanel_3 = new JLabel("Panel 5");
		lblPanel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblPanel_3.setBounds(313, 195, 99, 54);
		panel5.add(lblPanel_3);
		
		JPanel panel6 = new JPanel();
		layeredPane_1.add(panel6, "name_56445678684909");
		panel6.setLayout(null);
		
		JButton button_39 = new JButton("Previous");
		button_39.setForeground(Color.WHITE);
		button_39.setFont(new Font("Dialog", Font.BOLD, 20));
		button_39.setBackground(new Color(51, 153, 51));
		button_39.setBounds(493, 462, 126, 35);
		panel6.add(button_39);
		
		JButton button_40 = new JButton("Next");
		button_40.setForeground(Color.WHITE);
		button_40.setFont(new Font("Dialog", Font.BOLD, 20));
		button_40.setBackground(new Color(51, 153, 51));
		button_40.setBounds(629, 462, 126, 35);
		panel6.add(button_40);
		
		JLabel lblPanel_4 = new JLabel("Panel 6");
		lblPanel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblPanel_4.setBounds(289, 228, 99, 54);
		panel6.add(lblPanel_4);
		
		JPanel panel7 = new JPanel();
		layeredPane_1.add(panel7, "name_56447335743386");
		panel7.setLayout(null);
		
		JButton button_41 = new JButton("Previous");
		button_41.setForeground(Color.WHITE);
		button_41.setFont(new Font("Dialog", Font.BOLD, 20));
		button_41.setBackground(new Color(51, 153, 51));
		button_41.setBounds(493, 462, 126, 35);
		panel7.add(button_41);
		
		JButton button_42 = new JButton("Next");
		button_42.setForeground(Color.WHITE);
		button_42.setFont(new Font("Dialog", Font.BOLD, 20));
		button_42.setBackground(new Color(51, 153, 51));
		button_42.setBounds(629, 462, 126, 35);
		panel7.add(button_42);
		
		JLabel lblPanel_5 = new JLabel("Panel 7");
		lblPanel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblPanel_5.setBounds(302, 200, 99, 54);
		panel7.add(lblPanel_5);
		
		JPanel panel8 = new JPanel();
		layeredPane_1.add(panel8, "name_56554901614921");
		panel8.setLayout(null);
		
		JButton button_43 = new JButton("Previous");
		button_43.setForeground(Color.WHITE);
		button_43.setFont(new Font("Dialog", Font.BOLD, 20));
		button_43.setBackground(new Color(51, 153, 51));
		button_43.setBounds(493, 462, 126, 35);
		panel8.add(button_43);
		
		JButton button_44 = new JButton("Next");
		button_44.setForeground(Color.WHITE);
		button_44.setFont(new Font("Dialog", Font.BOLD, 20));
		button_44.setBackground(new Color(51, 153, 51));
		button_44.setBounds(629, 462, 126, 35);
		panel8.add(button_44);
		
		JLabel lblPanel_6 = new JLabel("Panel 8");
		lblPanel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblPanel_6.setBounds(309, 220, 99, 54);
		panel8.add(lblPanel_6);
		
		JPanel panel9 = new JPanel();
		layeredPane_1.add(panel9, "name_56558166389699");
		panel9.setLayout(null);
		
		JButton button_45 = new JButton("Previous");
		button_45.setForeground(Color.WHITE);
		button_45.setFont(new Font("Dialog", Font.BOLD, 20));
		button_45.setBackground(new Color(51, 153, 51));
		button_45.setBounds(493, 462, 126, 35);
		panel9.add(button_45);
		
		JButton button_46 = new JButton("Next");
		button_46.setForeground(Color.WHITE);
		button_46.setFont(new Font("Dialog", Font.BOLD, 20));
		button_46.setBackground(new Color(51, 153, 51));
		button_46.setBounds(629, 462, 126, 35);
		panel9.add(button_46);
		
		JLabel lblPanel_7 = new JLabel("Panel 9");
		lblPanel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblPanel_7.setBounds(296, 199, 99, 54);
		panel9.add(lblPanel_7);
		
		JPanel panel10 = new JPanel();
		layeredPane_1.add(panel10, "name_56560948243940");
		panel10.setLayout(null);
		
		JButton button_47 = new JButton("Previous");
		button_47.setForeground(Color.WHITE);
		button_47.setFont(new Font("Dialog", Font.BOLD, 20));
		button_47.setBackground(new Color(51, 153, 51));
		button_47.setBounds(493, 462, 126, 35);
		panel10.add(button_47);
		
		JButton button_48 = new JButton("Next");
		button_48.setForeground(Color.WHITE);
		button_48.setFont(new Font("Dialog", Font.BOLD, 20));
		button_48.setBackground(new Color(51, 153, 51));
		button_48.setBounds(629, 462, 126, 35);
		panel10.add(button_48);
		
		JLabel lblPanel_8 = new JLabel("Panel10");
		lblPanel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblPanel_8.setBounds(330, 200, 99, 54);
		panel10.add(lblPanel_8);
		
		JPanel panel11 = new JPanel();
		layeredPane_1.add(panel11, "name_56563346124730");
		panel11.setLayout(null);
		
		JButton button_49 = new JButton("Previous");
		button_49.setForeground(Color.WHITE);
		button_49.setFont(new Font("Dialog", Font.BOLD, 20));
		button_49.setBackground(new Color(51, 153, 51));
		button_49.setBounds(493, 462, 126, 35);
		panel11.add(button_49);
		
		JButton button_50 = new JButton("Next");
		button_50.setForeground(Color.WHITE);
		button_50.setFont(new Font("Dialog", Font.BOLD, 20));
		button_50.setBackground(new Color(51, 153, 51));
		button_50.setBounds(629, 462, 126, 35);
		panel11.add(button_50);
		
		JLabel lblPanel_9 = new JLabel("Panel11");
		lblPanel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblPanel_9.setBounds(337, 210, 99, 54);
		panel11.add(lblPanel_9);
		
		JPanel panel12 = new JPanel();
		layeredPane_1.add(panel12, "name_56566539996173");
		panel12.setLayout(null);
		
		JButton button_51 = new JButton("Previous");
		button_51.setForeground(Color.WHITE);
		button_51.setFont(new Font("Dialog", Font.BOLD, 20));
		button_51.setBackground(new Color(51, 153, 51));
		button_51.setBounds(493, 462, 126, 35);
		panel12.add(button_51);
		
		JButton button_52 = new JButton("Next");
		button_52.setForeground(Color.WHITE);
		button_52.setFont(new Font("Dialog", Font.BOLD, 20));
		button_52.setBackground(new Color(51, 153, 51));
		button_52.setBounds(629, 462, 126, 35);
		panel12.add(button_52);
		
		JLabel lblPanel_10 = new JLabel("Panel 12");
		lblPanel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblPanel_10.setBounds(331, 197, 99, 54);
		panel12.add(lblPanel_10);
		
		JPanel panel13 = new JPanel();
		layeredPane_1.add(panel13, "name_56594024625314");
		panel13.setLayout(null);
		
		JButton button_53 = new JButton("Previous");
		button_53.setForeground(Color.WHITE);
		button_53.setFont(new Font("Dialog", Font.BOLD, 20));
		button_53.setBackground(new Color(51, 153, 51));
		button_53.setBounds(493, 462, 126, 35);
		panel13.add(button_53);
		
		JButton button_54 = new JButton("Next");
		button_54.setForeground(Color.WHITE);
		button_54.setFont(new Font("Dialog", Font.BOLD, 20));
		button_54.setBackground(new Color(51, 153, 51));
		button_54.setBounds(629, 462, 126, 35);
		panel13.add(button_54);
		
		JLabel lblPanel_11 = new JLabel("Panel 13");
		lblPanel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblPanel_11.setBounds(341, 198, 99, 54);
		panel13.add(lblPanel_11);
		
		JPanel panel14 = new JPanel();
		layeredPane_1.add(panel14, "name_56600396795363");
		panel14.setLayout(null);
		
		JButton button_55 = new JButton("Previous");
		button_55.setForeground(Color.WHITE);
		button_55.setFont(new Font("Dialog", Font.BOLD, 20));
		button_55.setBackground(new Color(51, 153, 51));
		button_55.setBounds(493, 462, 126, 35);
		panel14.add(button_55);
		
		JButton button_56 = new JButton("Next");
		button_56.setForeground(Color.WHITE);
		button_56.setFont(new Font("Dialog", Font.BOLD, 20));
		button_56.setBackground(new Color(51, 153, 51));
		button_56.setBounds(629, 462, 126, 35);
		panel14.add(button_56);
		
		JLabel lblPanel_12 = new JLabel("Panel 14");
		lblPanel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblPanel_12.setBounds(365, 184, 99, 54);
		panel14.add(lblPanel_12);
		
		JPanel panel15 = new JPanel();
		layeredPane_1.add(panel15, "name_56629319474298");
		panel15.setLayout(null);
		
		JButton button_57 = new JButton("Previous");
		button_57.setForeground(Color.WHITE);
		button_57.setFont(new Font("Dialog", Font.BOLD, 20));
		button_57.setBackground(new Color(51, 153, 51));
		button_57.setBounds(493, 462, 126, 35);
		panel15.add(button_57);
		
		JButton button_58 = new JButton("Next");
		button_58.setForeground(Color.WHITE);
		button_58.setFont(new Font("Dialog", Font.BOLD, 20));
		button_58.setBackground(new Color(51, 153, 51));
		button_58.setBounds(629, 462, 126, 35);
		panel15.add(button_58);
		
		JLabel lblPanel_13 = new JLabel("Panel 15");
		lblPanel_13.setHorizontalAlignment(SwingConstants.CENTER);
		lblPanel_13.setBounds(314, 236, 99, 54);
		panel15.add(lblPanel_13);
		
		JPanel panel16 = new JPanel();
		layeredPane_1.add(panel16, "name_56634608839496");
		panel16.setLayout(null);
		
		JButton button_59 = new JButton("Previous");
		button_59.setForeground(Color.WHITE);
		button_59.setFont(new Font("Dialog", Font.BOLD, 20));
		button_59.setBackground(new Color(51, 153, 51));
		button_59.setBounds(493, 462, 126, 35);
		panel16.add(button_59);
		
		JButton button_60 = new JButton("Next");
		button_60.setForeground(Color.WHITE);
		button_60.setFont(new Font("Dialog", Font.BOLD, 20));
		button_60.setBackground(new Color(51, 153, 51));
		button_60.setBounds(629, 462, 126, 35);
		panel16.add(button_60);
		
		JLabel lblPanel_14 = new JLabel("Panel 16");
		lblPanel_14.setHorizontalAlignment(SwingConstants.CENTER);
		lblPanel_14.setBounds(298, 199, 99, 54);
		panel16.add(lblPanel_14);
		
		JPanel panel17 = new JPanel();
		layeredPane_1.add(panel17, "name_56640321242427");
		panel17.setLayout(null);
		
		JButton button_61 = new JButton("Previous");
		button_61.setForeground(Color.WHITE);
		button_61.setFont(new Font("Dialog", Font.BOLD, 20));
		button_61.setBackground(new Color(51, 153, 51));
		button_61.setBounds(493, 462, 126, 35);
		panel17.add(button_61);
		
		JButton button_62 = new JButton("Next");
		button_62.setForeground(Color.WHITE);
		button_62.setFont(new Font("Dialog", Font.BOLD, 20));
		button_62.setBackground(new Color(51, 153, 51));
		button_62.setBounds(629, 462, 126, 35);
		panel17.add(button_62);
		
		JLabel lblPanel_15 = new JLabel("Panel 17");
		lblPanel_15.setHorizontalAlignment(SwingConstants.CENTER);
		lblPanel_15.setBounds(308, 207, 99, 54);
		panel17.add(lblPanel_15);
		
		JPanel panel18 = new JPanel();
		layeredPane_1.add(panel18, "name_56645078075198");
		panel18.setLayout(null);
		
		JButton button_63 = new JButton("Previous");
		button_63.setForeground(Color.WHITE);
		button_63.setFont(new Font("Dialog", Font.BOLD, 20));
		button_63.setBackground(new Color(51, 153, 51));
		button_63.setBounds(493, 462, 126, 35);
		panel18.add(button_63);
		
		JButton button_64 = new JButton("Next");
		button_64.setForeground(Color.WHITE);
		button_64.setFont(new Font("Dialog", Font.BOLD, 20));
		button_64.setBackground(new Color(51, 153, 51));
		button_64.setBounds(629, 462, 126, 35);
		panel18.add(button_64);
		
		JLabel lblPanel_16 = new JLabel("Panel 18");
		lblPanel_16.setHorizontalAlignment(SwingConstants.CENTER);
		lblPanel_16.setBounds(283, 222, 99, 54);
		panel18.add(lblPanel_16);
		
		JPanel panel19 = new JPanel();
		layeredPane_1.add(panel19, "name_56651246673930");
		panel19.setLayout(null);
		
		JButton button_65 = new JButton("Previous");
		button_65.setForeground(Color.WHITE);
		button_65.setFont(new Font("Dialog", Font.BOLD, 20));
		button_65.setBackground(new Color(51, 153, 51));
		button_65.setBounds(493, 462, 126, 35);
		panel19.add(button_65);
		
		JButton button_66 = new JButton("Next");
		button_66.setForeground(Color.WHITE);
		button_66.setFont(new Font("Dialog", Font.BOLD, 20));
		button_66.setBackground(new Color(51, 153, 51));
		button_66.setBounds(629, 462, 126, 35);
		panel19.add(button_66);
		
		JLabel lblPanel_17 = new JLabel("Panel 19");
		lblPanel_17.setHorizontalAlignment(SwingConstants.CENTER);
		lblPanel_17.setBounds(317, 222, 99, 54);
		panel19.add(lblPanel_17);
		
		JPanel panel20 = new JPanel();
		layeredPane_1.add(panel20, "name_56663808812155");
		panel20.setLayout(null);
		
		JButton button_67 = new JButton("Previous");
		button_67.setForeground(Color.WHITE);
		button_67.setFont(new Font("Dialog", Font.BOLD, 20));
		button_67.setBackground(new Color(51, 153, 51));
		button_67.setBounds(493, 462, 126, 35);
		panel20.add(button_67);
		
		JButton button_68 = new JButton("Next");
		button_68.setForeground(Color.WHITE);
		button_68.setFont(new Font("Dialog", Font.BOLD, 20));
		button_68.setBackground(new Color(51, 153, 51));
		button_68.setBounds(629, 462, 126, 35);
		panel20.add(button_68);
		
		JLabel lblPanel_18 = new JLabel("Panel 20");
		lblPanel_18.setHorizontalAlignment(SwingConstants.CENTER);
		lblPanel_18.setBounds(299, 216, 99, 54);
		panel20.add(lblPanel_18);
		
		JPanel panel21 = new JPanel();
		layeredPane_1.add(panel21, "name_56674017613555");
		panel21.setLayout(null);
		
		JButton button_69 = new JButton("Previous");
		button_69.setForeground(Color.WHITE);
		button_69.setFont(new Font("Dialog", Font.BOLD, 20));
		button_69.setBackground(new Color(51, 153, 51));
		button_69.setBounds(493, 462, 126, 35);
		panel21.add(button_69);
		
		JButton button_70 = new JButton("Next");
		button_70.setForeground(Color.WHITE);
		button_70.setFont(new Font("Dialog", Font.BOLD, 20));
		button_70.setBackground(new Color(51, 153, 51));
		button_70.setBounds(629, 462, 126, 35);
		panel21.add(button_70);
		
		JLabel lblPanel_19 = new JLabel("Panel 21");
		lblPanel_19.setHorizontalAlignment(SwingConstants.CENTER);
		lblPanel_19.setBounds(328, 202, 99, 54);
		panel21.add(lblPanel_19);
		
		JPanel panel22 = new JPanel();
		layeredPane_1.add(panel22, "name_56680700075290");
		panel22.setLayout(null);
		
		JButton button_71 = new JButton("Previous");
		button_71.setForeground(Color.WHITE);
		button_71.setFont(new Font("Dialog", Font.BOLD, 20));
		button_71.setBackground(new Color(51, 153, 51));
		button_71.setBounds(493, 462, 126, 35);
		panel22.add(button_71);
		
		JButton button_72 = new JButton("Next");
		button_72.setForeground(Color.WHITE);
		button_72.setFont(new Font("Dialog", Font.BOLD, 20));
		button_72.setBackground(new Color(51, 153, 51));
		button_72.setBounds(629, 462, 126, 35);
		panel22.add(button_72);
		
		JLabel lblPanel_20 = new JLabel("Panel 22");
		lblPanel_20.setHorizontalAlignment(SwingConstants.CENTER);
		lblPanel_20.setBounds(280, 234, 99, 54);
		panel22.add(lblPanel_20);
		
		JPanel panel23 = new JPanel();
		layeredPane_1.add(panel23, "name_56697195458941");
		panel23.setLayout(null);
		
		JButton button_73 = new JButton("Previous");
		button_73.setForeground(Color.WHITE);
		button_73.setFont(new Font("Dialog", Font.BOLD, 20));
		button_73.setBackground(new Color(51, 153, 51));
		button_73.setBounds(493, 462, 126, 35);
		panel23.add(button_73);
		
		JButton button_74 = new JButton("Next");
		button_74.setForeground(Color.WHITE);
		button_74.setFont(new Font("Dialog", Font.BOLD, 20));
		button_74.setBackground(new Color(51, 153, 51));
		button_74.setBounds(629, 462, 126, 35);
		panel23.add(button_74);
		
		JLabel lblPanel_21 = new JLabel("Panel 23");
		lblPanel_21.setHorizontalAlignment(SwingConstants.CENTER);
		lblPanel_21.setBounds(321, 208, 99, 54);
		panel23.add(lblPanel_21);
		
		JPanel panel24 = new JPanel();
		layeredPane_1.add(panel24, "name_56702908385702");
		panel24.setLayout(null);
		
		JButton button_75 = new JButton("Previous");
		button_75.setForeground(Color.WHITE);
		button_75.setFont(new Font("Dialog", Font.BOLD, 20));
		button_75.setBackground(new Color(51, 153, 51));
		button_75.setBounds(493, 462, 126, 35);
		panel24.add(button_75);
		
		JButton button_76 = new JButton("Next");
		button_76.setForeground(Color.WHITE);
		button_76.setFont(new Font("Dialog", Font.BOLD, 20));
		button_76.setBackground(new Color(51, 153, 51));
		button_76.setBounds(629, 462, 126, 35);
		panel24.add(button_76);
		
		JLabel lblPanel_22 = new JLabel("Panel 24");
		lblPanel_22.setHorizontalAlignment(SwingConstants.CENTER);
		lblPanel_22.setBounds(319, 228, 99, 54);
		panel24.add(lblPanel_22);
		
		JPanel panel25 = new JPanel();
		layeredPane_1.add(panel25, "name_56709074259372");
		panel25.setLayout(null);
		
		JButton button_77 = new JButton("Previous");
		button_77.setForeground(Color.WHITE);
		button_77.setFont(new Font("Dialog", Font.BOLD, 20));
		button_77.setBackground(new Color(51, 153, 51));
		button_77.setBounds(493, 462, 126, 35);
		panel25.add(button_77);
		
		JButton button_78 = new JButton("Next");
		button_78.setForeground(Color.WHITE);
		button_78.setFont(new Font("Dialog", Font.BOLD, 20));
		button_78.setBackground(new Color(51, 153, 51));
		button_78.setBounds(629, 462, 126, 35);
		panel25.add(button_78);
		
		JLabel lblPanel_23 = new JLabel("Panel 25");
		lblPanel_23.setHorizontalAlignment(SwingConstants.CENTER);
		lblPanel_23.setBounds(297, 205, 99, 54);
		panel25.add(lblPanel_23);
		
		JPanel panel26 = new JPanel();
		layeredPane_1.add(panel26, "name_56721822019140");
		panel26.setLayout(null);
		
		JButton button_79 = new JButton("Previous");
		button_79.setForeground(Color.WHITE);
		button_79.setFont(new Font("Dialog", Font.BOLD, 20));
		button_79.setBackground(new Color(51, 153, 51));
		button_79.setBounds(493, 462, 126, 35);
		panel26.add(button_79);
		
		JButton button_80 = new JButton("Next");
		button_80.setForeground(Color.WHITE);
		button_80.setFont(new Font("Dialog", Font.BOLD, 20));
		button_80.setBackground(new Color(51, 153, 51));
		button_80.setBounds(629, 462, 126, 35);
		panel26.add(button_80);
		
		JLabel lblPanel_24 = new JLabel("Panel 26");
		lblPanel_24.setHorizontalAlignment(SwingConstants.CENTER);
		lblPanel_24.setBounds(375, 217, 99, 54);
		panel26.add(lblPanel_24);
		
		JPanel panel27 = new JPanel();
		layeredPane_1.add(panel27, "name_56728873383970");
		panel27.setLayout(null);
		
		JButton button_81 = new JButton("Previous");
		button_81.setForeground(Color.WHITE);
		button_81.setFont(new Font("Dialog", Font.BOLD, 20));
		button_81.setBackground(new Color(51, 153, 51));
		button_81.setBounds(493, 462, 126, 35);
		panel27.add(button_81);
		
		JButton button_82 = new JButton("Next");
		button_82.setForeground(Color.WHITE);
		button_82.setFont(new Font("Dialog", Font.BOLD, 20));
		button_82.setBackground(new Color(51, 153, 51));
		button_82.setBounds(629, 462, 126, 35);
		panel27.add(button_82);
		
		JLabel lblPanel_25 = new JLabel("Panel 27");
		lblPanel_25.setHorizontalAlignment(SwingConstants.CENTER);
		lblPanel_25.setBounds(319, 225, 99, 54);
		panel27.add(lblPanel_25);
		
		JPanel panel28 = new JPanel();
		layeredPane_1.add(panel28, "name_56738816031639");
		panel28.setLayout(null);
		
		JButton button_83 = new JButton("Previous");
		button_83.setForeground(Color.WHITE);
		button_83.setFont(new Font("Dialog", Font.BOLD, 20));
		button_83.setBackground(new Color(51, 153, 51));
		button_83.setBounds(493, 462, 126, 35);
		panel28.add(button_83);
		
		JButton button_84 = new JButton("Next");
		button_84.setForeground(Color.WHITE);
		button_84.setFont(new Font("Dialog", Font.BOLD, 20));
		button_84.setBackground(new Color(51, 153, 51));
		button_84.setBounds(629, 462, 126, 35);
		panel28.add(button_84);
		
		JLabel lblPanel_26 = new JLabel("Panel 28");
		lblPanel_26.setHorizontalAlignment(SwingConstants.CENTER);
		lblPanel_26.setBounds(239, 245, 99, 54);
		panel28.add(lblPanel_26);
		
		JPanel panel29 = new JPanel();
		layeredPane_1.add(panel29, "name_56745360147427");
		panel29.setLayout(null);
		
		JButton button_85 = new JButton("Previous");
		button_85.setForeground(Color.WHITE);
		button_85.setFont(new Font("Dialog", Font.BOLD, 20));
		button_85.setBackground(new Color(51, 153, 51));
		button_85.setBounds(493, 462, 126, 35);
		panel29.add(button_85);
		
		JButton button_86 = new JButton("Next");
		button_86.setForeground(Color.WHITE);
		button_86.setFont(new Font("Dialog", Font.BOLD, 20));
		button_86.setBackground(new Color(51, 153, 51));
		button_86.setBounds(629, 462, 126, 35);
		panel29.add(button_86);
		
		JLabel lblPanel_27 = new JLabel("Panel 29");
		lblPanel_27.setHorizontalAlignment(SwingConstants.CENTER);
		lblPanel_27.setBounds(320, 227, 99, 54);
		panel29.add(lblPanel_27);
		
		JPanel panel30 = new JPanel();
		layeredPane_1.add(panel30, "name_71814401096018");
		panel30.setLayout(null);
		
		JButton button_87 = new JButton("Previous");
		button_87.setForeground(Color.WHITE);
		button_87.setFont(new Font("Dialog", Font.BOLD, 20));
		button_87.setBackground(new Color(51, 153, 51));
		button_87.setBounds(629, 462, 126, 35);
		panel30.add(button_87);
		
		JLabel lblPanel_28 = new JLabel("Panel 30");
		lblPanel_28.setHorizontalAlignment(SwingConstants.CENTER);
		lblPanel_28.setBounds(323, 217, 99, 54);
		panel30.add(lblPanel_28);
		
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
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				layeredPane_1.removeAll();
				layeredPane_1.add(panel1);
				layeredPane_1.repaint();
				layeredPane_1.revalidate();
			}
		});
		button.setBounds(14, 148, 52, 23);
		panel_1.add(button);
		
		JButton button_1 = new JButton("02");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				layeredPane_1.removeAll();
				layeredPane_1.add(panel2);
				layeredPane_1.repaint();
				layeredPane_1.revalidate();	
			}
		});
		button_1.setBounds(68, 148, 52, 23);
		panel_1.add(button_1);
		
		JButton button_2 = new JButton("03");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane_1.removeAll();
				layeredPane_1.add(panel3);
				layeredPane_1.repaint();
				layeredPane_1.revalidate();
			}
		});
		button_2.setBounds(122, 148, 52, 23);
		panel_1.add(button_2);
		
		JButton button_3 = new JButton("04");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
						layeredPane_1.removeAll();
						layeredPane_1.add(panel4);
						layeredPane_1.repaint();
						layeredPane_1.revalidate();
					}
				});
			
		button_3.setBounds(14, 172, 52, 23);
		panel_1.add(button_3);
		
		JButton button_4 = new JButton("05");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
						layeredPane_1.removeAll();
						layeredPane_1.add(panel5);
						layeredPane_1.repaint();
						layeredPane_1.revalidate();
					}
				});
		
		button_4.setBounds(68, 172, 52, 23);
		panel_1.add(button_4);
		
		JButton button_5 = new JButton("06");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
						layeredPane_1.removeAll();
						layeredPane_1.add(panel6);
						layeredPane_1.repaint();
						layeredPane_1.revalidate();
					}
				});
		
		button_5.setBounds(122, 172, 52, 23);
		panel_1.add(button_5);
		
		JButton button_6 = new JButton("10");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane_1.removeAll();
				layeredPane_1.add(panel10);
				layeredPane_1.repaint();
				layeredPane_1.revalidate();
			}
		});
		button_6.setBounds(14, 218, 52, 23);
		panel_1.add(button_6);
		
		JButton button_7 = new JButton("11");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane_1.removeAll();
				layeredPane_1.add(panel11);
				layeredPane_1.repaint();
				layeredPane_1.revalidate();
			}
		});
		button_7.setBounds(68, 218, 52, 23);
		panel_1.add(button_7);
		
		JButton button_8 = new JButton("12");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane_1.removeAll();
				layeredPane_1.add(panel12);
				layeredPane_1.repaint();
				layeredPane_1.revalidate();
			}
		});
		button_8.setBounds(122, 218, 52, 23);
		panel_1.add(button_8);
		
		JButton button_9 = new JButton("07");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane_1.removeAll();
				layeredPane_1.add(panel7);
				layeredPane_1.repaint();
				layeredPane_1.revalidate();
			}
		});
		button_9.setBounds(14, 194, 52, 23);
		panel_1.add(button_9);
		
		JButton button_10 = new JButton("08");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane_1.removeAll();
				layeredPane_1.add(panel8);
				layeredPane_1.repaint();
				layeredPane_1.revalidate();
			}
		});
		button_10.setBounds(68, 194, 52, 23);
		panel_1.add(button_10);
		
		JButton button_11 = new JButton("09");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane_1.removeAll();
				layeredPane_1.add(panel9);
				layeredPane_1.repaint();
				layeredPane_1.revalidate();
			}
		});
		button_11.setBounds(122, 194, 52, 23);
		panel_1.add(button_11);
		
		JButton button_12 = new JButton("13");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane_1.removeAll();
				layeredPane_1.add(panel13);
				layeredPane_1.repaint();
				layeredPane_1.revalidate();
			}
		});
		button_12.setBounds(14, 242, 52, 23);
		panel_1.add(button_12);
		
		JButton button_13 = new JButton("14");
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane_1.removeAll();
				layeredPane_1.add(panel14);
				layeredPane_1.repaint();
				layeredPane_1.revalidate();
			}
		});
		button_13.setBounds(68, 242, 52, 23);
		panel_1.add(button_13);
		
		JButton button_14 = new JButton("15");
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane_1.removeAll();
				layeredPane_1.add(panel15);
				layeredPane_1.repaint();
				layeredPane_1.revalidate();
			}
		});
		button_14.setBounds(122, 242, 52, 23);
		panel_1.add(button_14);
		
		JButton button_15 = new JButton("18");
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane_1.removeAll();
				layeredPane_1.add(panel18);
				layeredPane_1.repaint();
				layeredPane_1.revalidate();
			}
		});
		button_15.setBounds(122, 266, 52, 23);
		panel_1.add(button_15);
		
		JButton button_16 = new JButton("17");
		button_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane_1.removeAll();
				layeredPane_1.add(panel17);
				layeredPane_1.repaint();
				layeredPane_1.revalidate();
			}
		});
		button_16.setBounds(68, 266, 52, 23);
		panel_1.add(button_16);
		
		JButton button_17 = new JButton("16");
		button_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane_1.removeAll();
				layeredPane_1.add(panel16);
				layeredPane_1.repaint();
				layeredPane_1.revalidate();
			}
		});
		button_17.setBounds(14, 266, 52, 23);
		panel_1.add(button_17);
		
		JButton button_18 = new JButton("19");
		button_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane_1.removeAll();
				layeredPane_1.add(panel19);
				layeredPane_1.repaint();
				layeredPane_1.revalidate();
			}
		});
		button_18.setBounds(14, 288, 52, 23);
		panel_1.add(button_18);
		
		JButton button_19 = new JButton("20");
		button_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane_1.removeAll();
				layeredPane_1.add(panel20);
				layeredPane_1.repaint();
				layeredPane_1.revalidate();
			}
		});
		button_19.setBounds(68, 288, 52, 23);
		panel_1.add(button_19);
		
		JButton button_20 = new JButton("21");
		button_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane_1.removeAll();
				layeredPane_1.add(panel21);
				layeredPane_1.repaint();
				layeredPane_1.revalidate();
			}
		});
		button_20.setBounds(122, 288, 52, 23);
		panel_1.add(button_20);
		
		JButton button_21 = new JButton("24");
		button_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane_1.removeAll();
				layeredPane_1.add(panel24);
				layeredPane_1.repaint();
				layeredPane_1.revalidate();
			}
		});
		button_21.setBounds(122, 312, 52, 23);
		panel_1.add(button_21);
		
		JButton button_22 = new JButton("23");
		button_22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane_1.removeAll();
				layeredPane_1.add(panel23);
				layeredPane_1.repaint();
				layeredPane_1.revalidate();
			}
		});
		button_22.setBounds(68, 312, 52, 23);
		panel_1.add(button_22);
		
		JButton button_23 = new JButton("22");
		button_23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane_1.removeAll();
				layeredPane_1.add(panel22);
				layeredPane_1.repaint();
				layeredPane_1.revalidate();
			}
		});
		button_23.setBounds(14, 312, 52, 23);
		panel_1.add(button_23);
		
		JButton button_24 = new JButton("30");
		button_24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane_1.removeAll();
				layeredPane_1.add(panel30);
				layeredPane_1.repaint();
				layeredPane_1.revalidate();
			}
		});
		button_24.setBounds(122, 359, 52, 23);
		panel_1.add(button_24);
		
		JButton button_25 = new JButton("29");
		button_25.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane_1.removeAll();
				layeredPane_1.add(panel29);
				layeredPane_1.repaint();
				layeredPane_1.revalidate();
			}
		});
		button_25.setBounds(68, 359, 52, 23);
		panel_1.add(button_25);
		
		JButton button_26 = new JButton("28");
		button_26.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane_1.removeAll();
				layeredPane_1.add(panel28);
				layeredPane_1.repaint();
				layeredPane_1.revalidate();
			}
		});
		button_26.setBounds(14, 359, 52, 23);
		panel_1.add(button_26);
		
		JButton button_27 = new JButton("25");
		button_27.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane_1.removeAll();
				layeredPane_1.add(panel25);
				layeredPane_1.repaint();
				layeredPane_1.revalidate();
			}
		});
		button_27.setBounds(14, 335, 52, 23);
		panel_1.add(button_27);
		
		JButton button_28 = new JButton("26");
		button_28.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane_1.removeAll();
				layeredPane_1.add(panel26);
				layeredPane_1.repaint();
				layeredPane_1.revalidate();
			}
		});
		button_28.setBounds(68, 335, 52, 23);
		panel_1.add(button_28);
		
		JButton button_29 = new JButton("27");
		button_29.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane_1.removeAll();
				layeredPane_1.add(panel27);
				layeredPane_1.repaint();
				layeredPane_1.revalidate();
			}
		});
		button_29.setBounds(122, 335, 52, 23);
		panel_1.add(button_29);
		
		JButton btnFlagQuection = new JButton("Flag this Question");
		btnFlagQuection.setBounds(14, 393, 160, 23);
		panel_1.add(btnFlagQuection);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(34, 431, 126, 35);
		panel_1.add(btnSubmit);
		btnSubmit.setForeground(Color.WHITE);
		btnSubmit.setFont(new Font("Dialog", Font.BOLD, 20));
		btnSubmit.setBackground(new Color(51, 153, 51));
		
		JLabel lblNewLabel_Timer = new JLabel("  28:33:51");
		lblNewLabel_Timer.setBounds(719, 22, 132, 44);
		frame.getContentPane().add(lblNewLabel_Timer);
		lblNewLabel_Timer.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		JLabel lblNewLabel_7 = new JLabel("Time Remaining");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_7.setBounds(850, 37, 139, 23);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_6 = new JLabel("Midterm Exam");
		lblNewLabel_6.setForeground(Color.RED);
		lblNewLabel_6.setFont(new Font("Century Gothic", Font.BOLD, 27));
		lblNewLabel_6.setBounds(224, 26, 246, 40);
		frame.getContentPane().add(lblNewLabel_6);
		
		
		
		setResizable(false);
		
		
		// Next and Previous Button set
		
		button_34.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				layeredPane_1.removeAll();
				layeredPane_1.add(panel4);
				layeredPane_1.repaint();
				layeredPane_1.revalidate();	
			}
		});
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				layeredPane_1.removeAll();
				
				layeredPane_1.repaint();
				layeredPane_1.revalidate();	
				layeredPane_1.add(panel2);
				
			}
		});
		
		button_32.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				layeredPane_1.removeAll();
				layeredPane_1.add(panel3);
				layeredPane_1.repaint();
				layeredPane_1.revalidate();
				
			}
		});
		button_36.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane_1.removeAll();
				layeredPane_1.add(panel5);
				layeredPane_1.repaint();
				layeredPane_1.revalidate();
				
			}
		});
		
		button_38.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane_1.removeAll();
				layeredPane_1.add(panel6);
				layeredPane_1.repaint();
				layeredPane_1.revalidate();
				
			}
		});
		
		button_40.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane_1.removeAll();
				layeredPane_1.add(panel7);
				layeredPane_1.repaint();
				layeredPane_1.revalidate();
				
			}
		});
		
		button_42.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane_1.removeAll();
				layeredPane_1.add(panel8);
				layeredPane_1.repaint();
				layeredPane_1.revalidate();
				
			}
		});
		
		button_44.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane_1.removeAll();
				layeredPane_1.add(panel9);
				layeredPane_1.repaint();
				layeredPane_1.revalidate();
				
			}
		});
		
		button_46.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane_1.removeAll();
				layeredPane_1.add(panel10);
				layeredPane_1.repaint();
				layeredPane_1.revalidate();
				
			}
		});
		
		//Panel previous button set
		button_30.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				layeredPane_1.removeAll();
				layeredPane_1.add(panel1);
				layeredPane_1.repaint();
				layeredPane_1.revalidate();	
			}
		});
		button_33.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				layeredPane_1.removeAll();
				layeredPane_1.add(panel2);
				layeredPane_1.repaint();
				layeredPane_1.revalidate();	
				
				
			}
		});
		
		button_35.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				layeredPane_1.removeAll();
				layeredPane_1.add(panel3);
				layeredPane_1.repaint();
				layeredPane_1.revalidate();
				
			}
		});
		button_37.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane_1.removeAll();
				layeredPane_1.add(panel4);
				layeredPane_1.repaint();
				layeredPane_1.revalidate();
				
			}
		});
		
		button_39.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane_1.removeAll();
				layeredPane_1.add(panel5);
				layeredPane_1.repaint();
				layeredPane_1.revalidate();
				
			}
		});
		
		button_41.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane_1.removeAll();
				layeredPane_1.add(panel6);
				layeredPane_1.repaint();
				layeredPane_1.revalidate();
				
			}
		});
		
		button_43.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane_1.removeAll();
				layeredPane_1.add(panel7);
				layeredPane_1.repaint();
				layeredPane_1.revalidate();
				
			}
		});
		
		button_45.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane_1.removeAll();
				layeredPane_1.add(panel8);
				layeredPane_1.repaint();
				layeredPane_1.revalidate();
				
			}
		});
		
		button_47.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane_1.removeAll();
				layeredPane_1.add(panel9);
				layeredPane_1.repaint();
				layeredPane_1.revalidate();
				
			}
		});
		
		
		
		
			
			
				
			}
		}
	
	
	
