package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.rmi.RemoteException;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import Connectivity.ClientX;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.awt.event.ActionEvent;

public class FinalResults extends JFrame {

	private JPanel contentPane;
	private JTable table;
	String ID = null;
	ClientX temp = null;
	String selectedSubjectID = null;
	String selectedExamID = null;
	
	/*String tempExamID = "IT2030MID1";
	ClientX temp = new ClientX();*/
	
	int[][] grades4piechart = new int[5][1];
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String ID = null;
					ClientX clientX = null;
					String selectedSubjectID = null;
					String selectedExamID = null;
					FinalResults frame = new FinalResults(ID, clientX, selectedSubjectID, selectedExamID);
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
	public FinalResults(String ID, ClientX clientX, String selectedSubjectID, String selectedExamID) {

		this.ID = ID;
		this.temp = clientX;
		this.selectedSubjectID = selectedSubjectID;
		this.selectedExamID = selectedExamID;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1180, 827);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSubjectname = new JLabel("subjectName");
		lblSubjectname.setBounds(12, 13, 1150, 31);
		lblSubjectname.setHorizontalAlignment(SwingConstants.LEFT);
		lblSubjectname.setFont(new Font("Product Sans", Font.PLAIN, 25));
		contentPane.add(lblSubjectname);
		
		JLabel lblExamname = new JLabel("examName");
		lblExamname.setHorizontalAlignment(SwingConstants.LEFT);
		lblExamname.setFont(new Font("Product Sans", Font.PLAIN, 25));
		lblExamname.setBounds(12, 57, 1150, 31);
		contentPane.add(lblExamname);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 101, 538, 631);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Product Sans", Font.PLAIN, 20));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"ID", "Name", "Marks(Out of 30)"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(35);
		table.setRowHeight(30);
		scrollPane.setViewportView(table);
		table.setBackground(Color.LIGHT_GRAY);
		this.modTable(table);
		
		JButton btnExportAsPdf = new JButton("Export as PDF");
		btnExportAsPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String output = "C:\\Users\\Vishwa\\Desktop\\XAM output\\results.pdf";
		            Document doc = new Document();
		            PdfWriter.getInstance(doc, new FileOutputStream(output));
		            doc.open();
		            PdfPTable pdfTable = new PdfPTable(table.getColumnCount());
		            //adding table headers
		            for (int i = 0; i < table.getColumnCount(); i++) {
		                pdfTable.addCell(table.getColumnName(i));
		            }
		            //extracting data from the JTable and inserting it to PdfPTable
		            for (int rows = 0; rows < 1000; rows++) {
		                for (int cols = 0; cols < table.getColumnCount(); cols++) {
		                	if (table.getModel().getValueAt(rows, cols) != null) {
			                    pdfTable.addCell(table.getModel().getValueAt(rows, cols).toString());
							}

		                }
		            }
		            doc.add(pdfTable);
		            doc.close();
		            System.out.println("done");
		        } catch (DocumentException e) {
		            e.printStackTrace();
		        } catch (FileNotFoundException e) {
		            e.printStackTrace();
		        }

		    }
		});
		btnExportAsPdf.setForeground(Color.WHITE);
		btnExportAsPdf.setFont(new Font("Product Sans", Font.BOLD, 20));
		btnExportAsPdf.setBackground(new Color(240, 128, 128));
		btnExportAsPdf.setBounds(314, 745, 236, 35);
		contentPane.add(btnExportAsPdf);
		
		JPanel panelPie = new JPanel();
		panelPie.setBounds(562, 101, 600, 631);
		contentPane.add(panelPie);
		
		DefaultPieDataset pieDataset = new DefaultPieDataset();
		pieDataset.setValue("A (100 - 70)", grades4piechart[0][0]);
		pieDataset.setValue("B (69 - 60)", grades4piechart[1][0]);
		pieDataset.setValue("C (59 - 50)", grades4piechart[2][0]);
		pieDataset.setValue("D (49 - 40)", grades4piechart[3][0]);
		pieDataset.setValue("E (39 - 0)", grades4piechart[4][0]);
		
		JFreeChart chart = ChartFactory.createPieChart(
				"Results summary", //Title
				pieDataset, //dataset
				true, //legend
				true, //tooltip
				false //use to generate URLs?
		);
		
		panelPie.setLayout(new BorderLayout());
		ChartPanel cPanel = new ChartPanel(chart);
		panelPie.add(cPanel, BorderLayout.CENTER);
		panelPie.validate();
		
		JButton button = new JButton("Previous");
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Product Sans", Font.BOLD, 20));
		button.setBackground(new Color(51, 153, 51));
		button.setBounds(12, 745, 150, 35);
		contentPane.add(button);
		
		JButton btnSavePieChart = new JButton("Save Pie Chart");
		btnSavePieChart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ChartUtilities.saveChartAsJPEG(new File("C:\\Users\\Vishwa\\Desktop\\XAM output\\chart.jpeg"), chart, 600, 631);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		btnSavePieChart.setForeground(Color.WHITE);
		btnSavePieChart.setFont(new Font("Product Sans", Font.BOLD, 20));
		btnSavePieChart.setBackground(new Color(240, 128, 128));
		btnSavePieChart.setBounds(926, 745, 236, 35);
		contentPane.add(btnSavePieChart);
		
		setResizable(false);
	}
	
	private void modTable(JTable table1) {
		DefaultTableModel model = (DefaultTableModel) table1.getModel();
		model.setRowCount(0);
		try {
			String[][] results = new String[30][6];
			results = temp.finalResults(this.selectedExamID);
			for(int i = 0; i < results.length; i++) {
				model.addRow(new Object[] {results[i][0], results[i][1], results[i][2]});
				if (results[i][2] != null) {

					if (Integer.parseInt(results[i][2]) >= ((70 * 30)/100)) { //A
						this.grades4piechart[0][0]++;
					} else if (Integer.parseInt(results[i][2]) >= ((60 * 30)/100)) { //B
						this.grades4piechart[1][0]++;
					} else if (Integer.parseInt(results[i][2]) >= ((50 * 30)/100)) { //C
						this.grades4piechart[2][0]++;
					} else if (Integer.parseInt(results[i][2]) >= ((40 * 30)/100)) { //D
						this.grades4piechart[3][0]++;
					} else if (Integer.parseInt(results[i][2]) > 0){ //E
						this.grades4piechart[4][0]++;
					} 
				}
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
