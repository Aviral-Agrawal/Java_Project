package student_management;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;

public class ViewAll extends JFrame {

	private JPanel contentPane;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAll frame = new ViewAll();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JTable getTable(String table) throws Exception
	{
		JTable t1=new JTable();
		t1.setAutoResizeMode(t1.AUTO_RESIZE_OFF);
		DefaultTableModel dm=new DefaultTableModel();
		//Connecting to the database
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "root");
		java.sql.Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from "+table);
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
	/**
	 * Create the frame.
	 */
	public ViewAll() {
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
		
		JLabel lblViewAllDetails = new JLabel("View All Details");
		lblViewAllDetails.setFont(new Font("Century Gothic", Font.BOLD, 25));
		lblViewAllDetails.setBounds(129, 5, 187, 32);
		panel.add(lblViewAllDetails);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Menues menu =  new Menues();
				menu.change_label();
				menu.setButtonTrue();
				menu.setTrue();
			}
		});
		btnBack.setBounds(170, 263, 89, 23);
		panel.add(btnBack);
		
		JScrollPane scrollPane;
		try {
			scrollPane = new JScrollPane(getTable("student_det"));
			scrollPane.setBounds(10, 47, 414, 205);
			panel.add(scrollPane);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
