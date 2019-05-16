package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.org.apache.bcel.internal.generic.Select;

import Connectivity.ClientX;
import Other.tempResults;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.rmi.RemoteException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class ExamWindow1 extends JFrame{

	private JPanel contentPane;
	//ClientX temp = new ClientX(); //This is temporary
	String[][] QNAs = new String[30][6];
	static String realQNum = null;
	String selectedAnswer[][] = new String[5000][6];
	static JPanel QPanel = null;

	String uid = null;
	ClientX temp = null;
	String selectedExamID = null;
	
	String tempID = "IT123";
	
	static JRadioButton rbtnA1 = null; //Miight wanna remove static from these variables
	static JRadioButton rbtnA2 = null;
	static JRadioButton rbtnA3 = null;
	static JRadioButton rbtnA4 = null;
	static JTextArea textArea = null;
	static JLabel lblQID = null;
	static JLabel label_Qnum = null;
	static int btnNumberMain = 0; // cuz lblQID and this is not the same
	
	static JButton[] QButtons = new JButton[31];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String ID = null;
					String selectedExamID = null;
					ClientX clientX = null;
					ExamWindow1 frame = new ExamWindow1(ID, clientX, selectedExamID);
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
	public ExamWindow1(String ID, ClientX clientX, String selectedExamID) {
		this.uid = ID;
		this.temp = clientX;
		this.selectedExamID = selectedExamID;
		
		try {
			this.QNAs = temp.viewQsNAns("IT2030MID1"); //examID must be a parameter passed from a different window
		
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		//QButtons = null;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1224, 696);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(12, 13, 204, 609);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(250, 250, 210));
		panel_1.setBounds(9, 7, 186, 594);
		panel.add(panel_1);
		

		
		JPanel QPanel = new JPanel();
		QPanel.setBounds(228, 66, 978, 498);
		contentPane.add(QPanel);
		QPanel.setLayout(null);
		
		this.QPanel = QPanel;
		
		//Below is one of the most important methods of the code
		this.QPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (rbtnA1 == null && rbtnA2 == null && rbtnA3 == null && rbtnA4 == null && textArea == null) {
					//Do nothing
				} 
				else {
					Boolean check = false;
					
					selectedAnswer[Integer.parseInt(lblQID.getText())][5] = realQNum;
					System.out.println(realQNum);
					
					if (textArea != null) {
						if (textArea.getText().length() > 0) {
							//System.out.println("not empty");
							selectedAnswer[Integer.parseInt(lblQID.getText())][0] = textArea.getText();
							selectedAnswer[Integer.parseInt(lblQID.getText())][1] = null;
							selectedAnswer[Integer.parseInt(lblQID.getText())][2] = null;
							selectedAnswer[Integer.parseInt(lblQID.getText())][3] = null;
							selectedAnswer[Integer.parseInt(lblQID.getText())][4] = null;
							check = true;
						} else {
							//System.out.println("empty");
							selectedAnswer[Integer.parseInt(lblQID.getText())][0] = null; // has been changed the value from 'textArea.getText()' to null;
							selectedAnswer[Integer.parseInt(lblQID.getText())][1] = null;
							selectedAnswer[Integer.parseInt(lblQID.getText())][2] = null;
							selectedAnswer[Integer.parseInt(lblQID.getText())][3] = null;
							selectedAnswer[Integer.parseInt(lblQID.getText())][4] = null;
							//check = false;
						}
						
					} else if (textArea == null) {
						
						selectedAnswer[Integer.parseInt(lblQID.getText())][0] = null;
						
						if (rbtnA1 != null && rbtnA1.isSelected()) {
							selectedAnswer[Integer.parseInt(lblQID.getText())][1] = "1";
							selectedAnswer[Integer.parseInt(lblQID.getText())][2] = null;
							selectedAnswer[Integer.parseInt(lblQID.getText())][3] = null;
							selectedAnswer[Integer.parseInt(lblQID.getText())][4] = null;
							//System.out.println(selectedAnswer[Integer.parseInt(lblQID.getText())][1]);
							check = true;
						} else if (rbtnA2 != null && rbtnA2.isSelected()) {
							selectedAnswer[Integer.parseInt(lblQID.getText())][1] = null;
							selectedAnswer[Integer.parseInt(lblQID.getText())][2] = "2";
							selectedAnswer[Integer.parseInt(lblQID.getText())][3] = null;
							selectedAnswer[Integer.parseInt(lblQID.getText())][4] = null;
							check = true;
							
						} else if (rbtnA3 != null && rbtnA3.isSelected()) {
							selectedAnswer[Integer.parseInt(lblQID.getText())][1] = null;
							selectedAnswer[Integer.parseInt(lblQID.getText())][2] = null;
							selectedAnswer[Integer.parseInt(lblQID.getText())][3] = "3";
							selectedAnswer[Integer.parseInt(lblQID.getText())][4] = null;
							check = true;
							
						} else if (rbtnA4 != null && rbtnA4.isSelected()) {
							selectedAnswer[Integer.parseInt(lblQID.getText())][1] = null;
							selectedAnswer[Integer.parseInt(lblQID.getText())][2] = null;
							selectedAnswer[Integer.parseInt(lblQID.getText())][3] = null;
							selectedAnswer[Integer.parseInt(lblQID.getText())][4] = "4";
							check = true;
							
						} 
						
					} 
					
					if (check) {
						QButtons[btnNumberMain].setForeground(Color.WHITE);
						QButtons[btnNumberMain].setBackground(new Color(51, 153, 51));
					} else {
						QButtons[btnNumberMain].setForeground(new Color(0, 0, 0));
						QButtons[btnNumberMain].setBackground(new Color(240, 240, 240));
					}
				}
			}
		});
		
		JLabel lblQID = new JLabel("New label");
		lblQID.setBounds(12, 469, 56, 16);
		QPanel.add(lblQID);
		
		this.lblQID = lblQID;
		
		lblQID.setVisible(false);
		
		JLabel label = new JLabel("Question");
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(8, 6, 88, 22);
		panel_1.add(label);
		
		JLabel label_Qnum = new JLabel("0");
		label_Qnum.setFont(new Font("Tahoma", Font.BOLD, 23));
		label_Qnum.setBounds(82, 7, 44, 21);
		panel_1.add(label_Qnum);
		
		ExamWindow1.label_Qnum = label_Qnum;
		
		//Initial question at the start of the window. Let's set it as 1st question
		assignQs(1);
		
		JButton button_1 = new JButton("01");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				assignQs(1);
			}
		});
		button_1.setBounds(14, 148, 52, 23);
		panel_1.add(button_1);
		ExamWindow1.QButtons[1] = button_1;
		
		JButton button_2 = new JButton("02");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				assignQs(2);
			}
		});
		button_2.setBounds(68, 148, 52, 23);
		panel_1.add(button_2);
		QButtons[2] = button_2;
		
		JButton button_3 = new JButton("03");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				assignQs(3);
			}
		});
		button_3.setBounds(122, 148, 52, 23);
		panel_1.add(button_3);
		QButtons[3] = button_3;
		
		JButton button_4 = new JButton("04");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				assignQs(4);
			}
		});
		button_4.setBounds(14, 172, 52, 23);
		panel_1.add(button_4);
		QButtons[4] = button_4;
		
		JButton button_5 = new JButton("05");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				assignQs(5);
			}
		});
		button_5.setBounds(68, 172, 52, 23);
		panel_1.add(button_5);
		QButtons[5] = button_5;
		
		JButton button_6 = new JButton("06");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				assignQs(6);
			}
		});
		button_6.setBounds(122, 172, 52, 23);
		panel_1.add(button_6);
		QButtons[6] = button_6;
		
		JButton button_10 = new JButton("10");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				assignQs(10);
			}
		});
		button_10.setBounds(14, 218, 52, 23);
		panel_1.add(button_10);
		QButtons[10] = button_10;
		
		JButton button_11 = new JButton("11");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				assignQs(11);
			}
		});
		button_11.setBounds(68, 218, 52, 23);
		panel_1.add(button_11);
		QButtons[11] = button_11;
		
		JButton button_12 = new JButton("12");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				assignQs(12);
			}
		});
		button_12.setBounds(122, 218, 52, 23);
		panel_1.add(button_12);
		QButtons[12] = button_12;
		
		JButton button_7 = new JButton("07");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				assignQs(7);
			}
		});
		button_7.setBounds(14, 194, 52, 23);
		panel_1.add(button_7);
		QButtons[7] = button_7;
		
		JButton button_8 = new JButton("08");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				assignQs(8);
			}
		});
		button_8.setBounds(68, 194, 52, 23);
		panel_1.add(button_8);
		QButtons[8] = button_8;
		
		JButton button_9 = new JButton("09");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				assignQs(9);
			}
		});
		button_9.setBounds(122, 194, 52, 23);
		panel_1.add(button_9);
		QButtons[9] = button_9;
		
		JButton button_13 = new JButton("13");
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				assignQs(13);
			}
		});
		button_13.setBounds(14, 242, 52, 23);
		panel_1.add(button_13);
		QButtons[13] = button_13;
		
		JButton button_14 = new JButton("14");
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				assignQs(14);
			}
		});
		button_14.setBounds(68, 242, 52, 23);
		panel_1.add(button_14);
		QButtons[14] = button_14;
		
		JButton button_15 = new JButton("15");
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				assignQs(15);
			}
		});
		button_15.setBounds(122, 242, 52, 23);
		panel_1.add(button_15);
		QButtons[15] = button_15;
		
		JButton button_18 = new JButton("18");
		button_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				assignQs(18);
			}
		});
		button_18.setBounds(122, 266, 52, 23);
		panel_1.add(button_18);
		QButtons[18] = button_18;
		
		JButton button_17 = new JButton("17");
		button_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				assignQs(17);
			}
		});
		button_17.setBounds(68, 266, 52, 23);
		panel_1.add(button_17);
		QButtons[17] = button_17;
		
		JButton button_16 = new JButton("16");
		button_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				assignQs(16);
			}
		});
		button_16.setBounds(14, 266, 52, 23);
		panel_1.add(button_16);
		QButtons[16] = button_16;
		
		JButton button_19 = new JButton("19");
		button_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				assignQs(19);
			}
		});
		button_19.setBounds(14, 288, 52, 23);
		panel_1.add(button_19);
		QButtons[19] = button_19;
		
		JButton button_20 = new JButton("20");
		button_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				assignQs(20);
			}
		});
		button_20.setBounds(68, 288, 52, 23);
		panel_1.add(button_20);
		QButtons[20] = button_20;
		
		JButton button_21 = new JButton("21");
		button_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				assignQs(21);
			}
		});
		button_21.setBounds(122, 288, 52, 23);
		panel_1.add(button_21);
		QButtons[21] = button_21;
		
		JButton button_24 = new JButton("24");
		button_24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				assignQs(24);
			}
		});
		button_24.setBounds(122, 312, 52, 23);
		panel_1.add(button_24);
		QButtons[24] = button_24;
		
		JButton button_23 = new JButton("23");
		button_23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				assignQs(23);
			}
		});
		button_23.setBounds(68, 312, 52, 23);
		panel_1.add(button_23);
		QButtons[23] = button_23;
		
		JButton button_22 = new JButton("22");
		button_22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				assignQs(22);
			}
		});
		button_22.setBounds(14, 312, 52, 23);
		panel_1.add(button_22);
		QButtons[22] = button_22;
		
		JButton button_30 = new JButton("30");
		button_30.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				assignQs(30);
			}
		});
		button_30.setBounds(122, 359, 52, 23);
		panel_1.add(button_30);
		QButtons[30] = button_30;
		
		JButton button_29 = new JButton("29");
		button_29.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				assignQs(29);
			}
		});
		button_29.setBounds(68, 359, 52, 23);
		panel_1.add(button_29);
		QButtons[29] = button_29;
		
		JButton button_28 = new JButton("28");
		button_28.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				assignQs(28);
			}
		});
		button_28.setBounds(14, 359, 52, 23);
		panel_1.add(button_28);
		QButtons[28] = button_28;
		
		JButton button_25 = new JButton("25");
		button_25.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				assignQs(25);
			}
		});
		button_25.setBounds(14, 335, 52, 23);
		panel_1.add(button_25);
		QButtons[25] = button_25;
		
		JButton button_26 = new JButton("26");
		button_26.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				assignQs(26);
			}
		});
		button_26.setBounds(68, 335, 52, 23);
		panel_1.add(button_26);
		QButtons[26] = button_26;
		
		JButton button_27 = new JButton("27");
		button_27.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				assignQs(27);
			}
		});
		button_27.setBounds(122, 335, 52, 23);
		panel_1.add(button_27);
		QButtons[27] = button_27;
		
		JButton button_flag = new JButton("Flag this Question");
		button_flag.setBounds(14, 393, 160, 23);
		panel_1.add(button_flag);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					temp.ExamSubmission(uid, selectedExamID, selectedAnswer);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnSubmit.setForeground(Color.WHITE);
		btnSubmit.setFont(new Font("Dialog", Font.BOLD, 20));
		btnSubmit.setBackground(new Color(51, 153, 51));
		btnSubmit.setBounds(34, 431, 126, 35);
		panel_1.add(btnSubmit);
		
		
		JButton btnPrevious = new JButton("Previous");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (ExamWindow1.label_Qnum.getText().equals("1")) {
					//Do nothing
				}
				else {
					assignQs(Integer.parseInt(ExamWindow1.label_Qnum.getText()) - 1);
				}
			}
		});
		btnPrevious.setForeground(Color.WHITE);
		btnPrevious.setFont(new Font("Product Sans", Font.BOLD, 20));
		btnPrevious.setBackground(new Color(51, 153, 51));
		btnPrevious.setBounds(894, 587, 150, 35);
		contentPane.add(btnPrevious);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				assignQs(Integer.parseInt(ExamWindow1.label_Qnum.getText()) + 1);
			}
		});
		btnNext.setForeground(Color.WHITE);
		btnNext.setFont(new Font("Product Sans", Font.BOLD, 20));
		btnNext.setBackground(new Color(51, 153, 51));
		btnNext.setBounds(1056, 587, 150, 35);
		contentPane.add(btnNext);
		
		JLabel label_2 = new JLabel("Midterm Exam");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("Century Gothic", Font.BOLD, 27));
		label_2.setBounds(228, 13, 246, 40);
		contentPane.add(label_2);
		
		JLabel lblNewLabel = new JLabel("*Please use the mouse to shift among questions");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel.setBounds(228, 606, 346, 16);
		contentPane.add(lblNewLabel);
		
		setResizable(false);
		
	}
	
	private void assignQs(int btnNumber) {
		
		ExamWindow1.label_Qnum.setText(Integer.toString(btnNumber));
		
		String qID = QNAs[btnNumber - 1][0];
		String question = QNAs[btnNumber - 1][1];
		String answer1 = QNAs[btnNumber - 1][2];
		String answer2 = QNAs[btnNumber - 1][3];
		String answer3 = QNAs[btnNumber - 1][4];
		String answer4 = QNAs[btnNumber - 1][5];
		
		this.realQNum = qID;
		
		this.QPanel.removeAll();
		this.QPanel.updateUI();
		
		ExamWindow1.lblQID.setText(qID);
		ExamWindow1.btnNumberMain = btnNumber;
		
		JLabel lblQuestion = new JLabel("New label");
		lblQuestion.setFont(new Font("Arial", Font.BOLD, 15));
		lblQuestion.setVerticalAlignment(SwingConstants.TOP);
		lblQuestion.setBounds(12, 13, 954, 86);
		QPanel.add(lblQuestion);

		lblQuestion.setText(btnNumber + ". " + question);
		
		if (answer2 == null && answer3 == null && answer4 == null) {
			textArea = new JTextArea();
			textArea.setFont(new Font("Arial", Font.PLAIN, 18));
			textArea.setBounds(8, 108, 480, 150);
			QPanel.add(textArea);
			
			this.rbtnA1 = null;
			this.rbtnA2 = null;
			this.rbtnA3 = null;
			this.rbtnA4 = null;
			
		} else {
			textArea = null;
			
			ExamWindow1.rbtnA1 = new JRadioButton("Radio1");
			rbtnA1.setFont(new Font("Arial", Font.PLAIN, 15));
			rbtnA1.setVerticalAlignment(SwingConstants.TOP);
			rbtnA1.setBounds(8, 108, 958, 68);
			QPanel.add(rbtnA1);
			
			rbtnA1.setText(answer1);
			
			if (answer2 != null && answer2 != "") {
				rbtnA2 = new JRadioButton("Radio1");
				rbtnA2.setVerticalAlignment(SwingConstants.TOP);
				rbtnA2.setFont(new Font("Arial", Font.PLAIN, 15));
				rbtnA2.setBounds(8, 181, 958, 68);
				QPanel.add(rbtnA2);

				rbtnA2.setText(answer2);
				
				if (answer3 != null && answer3 != "") {
					rbtnA3 = new JRadioButton("Radio2");
					rbtnA3.setVerticalAlignment(SwingConstants.TOP);
					rbtnA3.setFont(new Font("Arial", Font.PLAIN, 15));
					rbtnA3.setBounds(8, 254, 958, 68);
					QPanel.add(rbtnA3);

					rbtnA3.setText(answer3);
					
					if (answer4 != null && answer4 != "") {
						rbtnA4 = new JRadioButton("Radio3");
						rbtnA4.setVerticalAlignment(SwingConstants.TOP);
						rbtnA4.setFont(new Font("Arial", Font.PLAIN, 15));
						rbtnA4.setBounds(8, 327, 958, 68);
						QPanel.add(rbtnA4);

						rbtnA4.setText(answer4);
					}
				}
			}
		}
		
		ButtonGroup rbnAnswers = new ButtonGroup();
		rbnAnswers.add(rbtnA1);
		rbnAnswers.add(rbtnA2);
		rbnAnswers.add(rbtnA3);
		rbnAnswers.add(rbtnA4);

		if (selectedAnswer[Integer.parseInt(lblQID.getText())][1] != null) {
			rbtnA1.setSelected(true);
			
		} else if (selectedAnswer[Integer.parseInt(lblQID.getText())][2] != null) {
			rbtnA2.setSelected(true);
		} else if (selectedAnswer[Integer.parseInt(lblQID.getText())][3] != null) {
			rbtnA3.setSelected(true);
		} else if (selectedAnswer[Integer.parseInt(lblQID.getText())][4] != null) {
			rbtnA4.setSelected(true);
		} else if (selectedAnswer[Integer.parseInt(lblQID.getText())][0] != null) {
			textArea.setText(selectedAnswer[Integer.parseInt(lblQID.getText())][0]);
		}
		//textArea.setText(selectedAnswer[Integer.parseInt(lblQID.getText())][0]);
		
	}  
}
