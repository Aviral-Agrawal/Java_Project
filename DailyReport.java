package student_management;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.awt.event.ActionEvent;

public class DailyReport extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DailyReport frame = new DailyReport();
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
	public DailyReport() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 336);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 204));
		panel.setBounds(0, 0, 434, 297);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblReport = new JLabel("Daily Report");
		lblReport.setFont(new Font("Century Gothic", Font.BOLD, 25));
		lblReport.setBounds(146, 5, 149, 32);
		panel.add(lblReport);
		
		JLabel lblDate = new JLabel("Date  ->  ");
		lblDate.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblDate.setBounds(58, 48, 66, 20);
		panel.add(lblDate);
		
		JComboBox date_comboBox = new JComboBox();
		for(int i=1; i<=31; i++)
			date_comboBox.addItem(i);
		date_comboBox.setBounds(134, 50, 44, 20);
		panel.add(date_comboBox);
		
		JComboBox month_comboBox = new JComboBox();
		for(int i=1; i<=12; i++)
			month_comboBox.addItem(i);
		month_comboBox.setBounds(187, 50, 44, 20);
		panel.add(month_comboBox);
		
		JComboBox year_comboBox = new JComboBox();
		for(int i=2017; i<=2025; i++)
			year_comboBox.addItem(i);
		year_comboBox.setBounds(241, 50, 58, 20);
		panel.add(year_comboBox);
		
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Menues menu = new Menues();
				menu.change_label();
				menu.setButtonTrue();
				menu.setTrue();
			}
		});
		btnBack.setBounds(172, 263, 89, 23);
		panel.add(btnBack);
		
		JTable t1=new JTable();
		JScrollPane scrollPane = new JScrollPane();
		JButton btnShow = new JButton("Show");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String date = date_comboBox.getSelectedItem().toString();
					String month = month_comboBox.getSelectedItem().toString();
					String year = year_comboBox.getSelectedItem().toString();
					scrollPane.getViewport().add(getTable("student_det", date, month, year,t1));
					scrollPane.setBounds(10, 81, 414, 171);
					panel.add(scrollPane);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnShow.setBounds(309, 49, 76, 23);
		panel.add(btnShow);
	}
	private JTable getTable(String table, String date, String month, String year, JTable t1)throws Exception 
	{
		t1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);	
		DefaultTableModel dm=new DefaultTableModel();
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "root");
		java.sql.Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from "+table+" where `Date of Joining` = '"+date+"' and `Month of Joining` = '"+month+"' and `Year of Joining` = '"+year+"'");
		ResultSetMetaData rsmd=rs.getMetaData();
		int cols=rsmd.getColumnCount();
		String c[]=new String[cols];
		for(int i=0;i<cols;i++){
			c[i]=rsmd.getColumnName(i+1);
			dm.addColumn(c[i]);
		}
		Object row[]=new Object[cols];
		while(rs.next()){
			for(int i=0;i<cols;i++){
				row[i]=rs.getString(i+1);
               	}
			dm.addRow(row);
		}
		t1.setModel(dm);	
		conn.close();
		return t1;
	}
}
