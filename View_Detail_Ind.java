package student_management;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;

public class View_Detail_Ind extends JFrame {

	private JPanel contentPane;
	
	private JTextField name_textField;
	private JTextField dob_textField;
	private JTextField phno_textField;
	private JTextField feesPaid_textField;
	private JTextField remainingAmt_textField;
	private JTextField ID_textField;
	private JTextField gender_textField;
	private JTextField course_textField;
	private JTextField fees_textField;
	private JTextField doj_textField;
	private	JTextArea address_textArea = new JTextArea();
	private JTextField moj_textField;
	private JTextField yoj_textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)throws Exception {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_Detail_Ind frame = new View_Detail_Ind();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
private static int id;
	
	public static void setID(int id1)
	{
		id=id1;
	}

	void updateDet(int id, String name, String address, String dob, String gender, String phoneNo, String course, String fees, String feespaid, String remainingAmt, String joiningDate, String joiningMonth, String joiningYear) throws Exception
	{
		//Connecting to the database
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "root");
		Statement stmt = conn.createStatement();
		stmt.executeUpdate("update student_det set ID = "+id+", Name = '"+name+"', Address = '"+address+"', DOB = '"+dob+"', Gender = '"+gender+"', `Phone Number` = '"+phoneNo+"', Course = '"+course+"', Fees = '"+fees+"', `Fees Paid` = '"+feespaid+"', `Remaining Amount` = '"+remainingAmt+"', `Date of Joining` = '"+joiningDate+"', `Month of Joining` = '"+joiningMonth+"', `Year of Joining` = '"+joiningYear+"' where ID = "+id+"");
	}
	/**
	 * Create the frame.
	 */
	void setText()throws Exception
	{
		//Connecting to the database
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "root");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from student_det");
		while(rs.next())
		{
			if(id==rs.getInt(1))
			{
				ID_textField.setText(String.valueOf(rs.getInt(1)));
				name_textField.setText(rs.getString(2));
				address_textArea.setText(rs.getString(3));
				dob_textField.setText(rs.getString(4));
				gender_textField.setText(rs.getString(5));
				phno_textField.setText(rs.getString(6));
				course_textField.setText(rs.getString(7));
				fees_textField.setText(rs.getString(8));
				feesPaid_textField.setText(rs.getString(9));
				remainingAmt_textField.setText(rs.getString(10));
				doj_textField.setText(rs.getString(11));
				moj_textField.setText(rs.getString(12));
				yoj_textField.setText(rs.getString(13));
			}
		}
	}
	public View_Detail_Ind() throws Exception {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 385, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.info);
		panel.setBounds(0, 0, 369, 541);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblStudentDetail = new JLabel("Student Detail");
		lblStudentDetail.setFont(new Font("Century Gothic", Font.BOLD, 25));
		lblStudentDetail.setBounds(101, 5, 170, 32);
		panel.add(lblStudentDetail);
		
		JLabel label = new JLabel("ID");
		label.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label.setBounds(10, 48, 16, 20);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Name");
		label_1.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_1.setBounds(10, 78, 46, 14);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Address");
		label_2.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_2.setBounds(10, 108, 86, 14);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Course");
		label_3.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_3.setBounds(10, 298, 57, 14);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("Fees");
		label_4.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_4.setBounds(10, 328, 46, 14);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("Remaining Amount");
		label_5.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_5.setBounds(10, 383, 137, 20);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("Date of Birth");
		label_6.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_6.setBounds(10, 208, 90, 14);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("Gender");
		label_7.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_7.setBounds(10, 238, 57, 14);
		panel.add(label_7);
		
		JLabel label_8 = new JLabel("Phone Number");
		label_8.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_8.setBounds(10, 268, 109, 14);
		panel.add(label_8);
		
		JLabel label_9 = new JLabel("Fees Paid");
		label_9.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_9.setBounds(10, 358, 69, 14);
		panel.add(label_9);
		
		JLabel label_10 = new JLabel("Date of Joining");
		label_10.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_10.setBounds(10, 414, 154, 20);
		panel.add(label_10);
		
		name_textField = new JTextField();
		name_textField.setColumns(10);
		name_textField.setBounds(253, 78, 109, 20);
		panel.add(name_textField);
		
		address_textArea.setBounds(157, 105, 205, 89);
		panel.add(address_textArea);
		
		dob_textField = new JTextField();
		dob_textField.setColumns(10);
		dob_textField.setBounds(253, 207, 109, 20);
		panel.add(dob_textField);
		
		phno_textField = new JTextField();
		phno_textField.setColumns(10);
		phno_textField.setBounds(253, 267, 109, 20);
		panel.add(phno_textField);
		
		remainingAmt_textField = new JTextField();
		remainingAmt_textField.setColumns(10);
		remainingAmt_textField.setBounds(253, 385, 109, 20);
		panel.add(remainingAmt_textField);
		
		ID_textField = new JTextField();
		ID_textField.setBounds(253, 48, 109, 20);
		panel.add(ID_textField);
		ID_textField.setColumns(10);
		
		gender_textField = new JTextField();
		gender_textField.setBounds(253, 237, 109, 20);
		panel.add(gender_textField);
		gender_textField.setColumns(10);
		
		course_textField = new JTextField();
		course_textField.setBounds(253, 297, 109, 20);
		panel.add(course_textField);
		course_textField.setColumns(10);
		
		fees_textField = new JTextField();
		fees_textField.setBounds(253, 327, 109, 20);
		panel.add(fees_textField);
		fees_textField.setColumns(10);
		
		feesPaid_textField = new JTextField();
		feesPaid_textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = Integer.parseInt(fees_textField.getText());
				int y = Integer.parseInt(feesPaid_textField.getText());
				int fees = x-y;
				String fees1 = Integer.toString(fees);
				remainingAmt_textField.setText(fees1);
			}
		});
		feesPaid_textField.setColumns(10);
		feesPaid_textField.setBounds(253, 357, 109, 20);
		panel.add(feesPaid_textField);
		
		doj_textField = new JTextField();
		doj_textField.setBounds(253, 416, 109, 20);
		panel.add(doj_textField);
		doj_textField.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Get_ID g = new Get_ID();
				g.setVisible(true);
			}
		});
		btnBack.setBounds(75, 507, 89, 23);
		panel.add(btnBack);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(ID_textField.getText());
				String name = name_textField.getText();
				String address = address_textArea.getText();
				String dob = dob_textField.getText();
				String gender=gender_textField.getText();
				String phoneNo = phno_textField.getText();
				String course = course_textField.getText();
				String fees = fees_textField.getText();
				String feespaid = feesPaid_textField.getText();
				String remainingAmt = remainingAmt_textField.getText();
				String joining_date = doj_textField.getText();
				String joining_month = moj_textField.getText();
				String joining_year = yoj_textField.getText();
				try {
					updateDet(id, name, address, dob, gender, phoneNo, course, fees, feespaid, remainingAmt, joining_date, joining_month, joining_year);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				setVisible(false);
				Menues menu = new Menues();
				menu.change_label();
				menu.setButtonTrue();
				menu.setTrue();
			}
		});
		btnUpdate.setBounds(201, 508, 89, 23);
		panel.add(btnUpdate);
		
		JLabel lblMonthOfJoining = new JLabel("Month of Joining");
		lblMonthOfJoining.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblMonthOfJoining.setBounds(10, 445, 122, 20);
		panel.add(lblMonthOfJoining);
		
		moj_textField = new JTextField();
		moj_textField.setBounds(253, 447, 109, 20);
		panel.add(moj_textField);
		moj_textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Year of Joining");
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 476, 122, 20);
		panel.add(lblNewLabel);
		
		yoj_textField = new JTextField();
		yoj_textField.setBounds(253, 478, 109, 20);
		panel.add(yoj_textField);
		yoj_textField.setColumns(10);
		
		setText();
	}
}
