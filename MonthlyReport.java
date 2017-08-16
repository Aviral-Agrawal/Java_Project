package student_management;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.awt.event.ActionEvent;

public class MonthlyReport extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MonthlyReport frame = new MonthlyReport();
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
	public MonthlyReport() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 333);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(204, 255, 204));
		panel.setBounds(0, 0, 434, 294);
		contentPane.add(panel);
		
		JLabel lblMonthlyReport = new JLabel("Monthly Report");
		lblMonthlyReport.setFont(new Font("Century Gothic", Font.BOLD, 25));
		lblMonthlyReport.setBounds(132, 5, 185, 32);
		panel.add(lblMonthlyReport);
		
		JLabel label_1 = new JLabel("Date  ->  ");
		label_1.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_1.setBounds(83, 49, 66, 20);
		panel.add(label_1);
		
		JComboBox month_comboBox = new JComboBox();
		for(int i=1; i<=12; i++)
			month_comboBox.addItem(i);
		month_comboBox.setBounds(159, 49, 44, 20);
		panel.add(month_comboBox);
		
		JComboBox year_comboBox = new JComboBox();
		for(int i=2017; i<=2025; i++)
			year_comboBox.addItem(i);
		year_comboBox.setBounds(213, 49, 58, 20);
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
		btnBack.setBounds(170, 261, 89, 23);
		panel.add(btnBack);
		
		JTable t1=new JTable();
		JScrollPane scrollPane = new JScrollPane();
				
		JButton btnShow = new JButton("Show");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String month = month_comboBox.getSelectedItem().toString();
					String year = year_comboBox.getSelectedItem().toString();
					scrollPane.getViewport().add(getTable("student_det", month, year, t1));
					scrollPane.setBounds(10, 81, 414, 171);
					panel.add(scrollPane);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnShow.setBounds(281, 48, 71, 23);
		panel.add(btnShow);
	}

private JTable getTable(String table, String month, String year, JTable t1)throws Exception {
	t1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	DefaultTableModel dm=new DefaultTableModel();
	//Connecting to the database
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "root");
	java.sql.Statement stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery("select * from "+table+" where `Month of Joining` = '"+month+"' and `Year of Joining` = '"+year+"'");
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