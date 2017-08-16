package student_management;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Window.Type;

public class Insert_Details extends JFrame {

	private JPanel contentPane;
	private JTextField id_textField;
	private JTextField name_textField;
	private JTextField dob_textField;
	private JTextField phno_textField;
	private JTextField fees_textField;
	private JTextField feespaid_textField;
	private JTextField remainingAmount_textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Insert_Details frame = new Insert_Details();
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
	int getID()throws Exception
	{
		//Connecting to the database
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "root");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from student_det");
		int id=100;
		if(rs.next()==false)
			id=100;
		else
		{
			while(rs.next())
				id=rs.getInt(1);
			id++;
		}
		return id;
	}
	String getFees(String course)throws Exception
	{
		String fees = null;
		//Connecting to the database
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "root");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from fees_details");
		while(rs.next())
		{
			if(rs.getString(1).equals(course))
			{
				fees = rs.getString(2);
			}
		}
		return fees;
	}
	void enter(int id, String name, String address, String dob, String gender, String phoneNo, String course, String fees, String feespaid, String remainingAmt, String joiningDate, String joiningMonth, String joiningYear) throws Exception
	{
		//Connecting to the database
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "root");
		Statement stmt = conn.createStatement();
		stmt.executeUpdate("Insert into student_det values("+id+",'"+name+"','"+address+"','"+dob+"','"+gender+"','"+phoneNo+"','"+course+"','"+fees+"','"+feespaid+"','"+remainingAmt+"','"+joiningDate+"','"+joiningMonth+"','"+joiningYear+"')");
	}
	
	public Insert_Details() {
		setAlwaysOnTop(true);
		setTitle("Insert Details");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 421, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(250, 250, 210));
		panel.setBounds(0, 0, 405, 480);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblInsertDetails = new JLabel("Insert Details");
		lblInsertDetails.setFont(new Font("Century Gothic", Font.BOLD, 25));
		lblInsertDetails.setBounds(129, 5, 154, 32);
		panel.add(lblInsertDetails);
		
		id_textField = new JTextField();
		try{int id = getID();
		id_textField.setText(String.valueOf(id));}catch(Exception P){System.out.println(P);}
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblId.setBounds(29, 45, 16, 20);
		panel.add(lblId);
		id_textField.setBounds(277, 45, 109, 20);
		panel.add(id_textField);
		id_textField.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblName.setBounds(29, 75, 46, 14);
		panel.add(lblName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblAddress.setBounds(29, 105, 86, 14);
		panel.add(lblAddress);
		
		JLabel lblCourse = new JLabel("Course");
		lblCourse.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblCourse.setBounds(29, 295, 57, 14);
		panel.add(lblCourse);
		
		JLabel lblFees = new JLabel("Fees");
		lblFees.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblFees.setBounds(29, 325, 46, 14);
		panel.add(lblFees);
		
		JLabel lblRemainingAmount = new JLabel("Remaining Amount");
		lblRemainingAmount.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblRemainingAmount.setBounds(29, 380, 137, 20);
		panel.add(lblRemainingAmount);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblDateOfBirth.setBounds(29, 205, 90, 14);
		panel.add(lblDateOfBirth);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblGender.setBounds(29, 235, 57, 14);
		panel.add(lblGender);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblPhoneNumber.setBounds(29, 265, 109, 14);
		panel.add(lblPhoneNumber);
		
		JLabel lblFeesPaid = new JLabel("Fees Paid");
		lblFeesPaid.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblFeesPaid.setBounds(29, 355, 69, 14);
		panel.add(lblFeesPaid);
		
		name_textField = new JTextField();
		name_textField.setBounds(277, 75, 109, 20);
		panel.add(name_textField);
		name_textField.setColumns(10);
		
		dob_textField = new JTextField();
		dob_textField.setForeground(new Color(0, 0, 0));
		dob_textField.setBounds(277, 204, 109, 20);
		panel.add(dob_textField);
		dob_textField.setColumns(10);
		
		JRadioButton male_rdbtn = new JRadioButton("Male");
		male_rdbtn.setBackground(new Color(250, 250, 210));
		male_rdbtn.setBounds(271, 235, 57, 23);
		
		JRadioButton female_rdbtn = new JRadioButton("Female");
		female_rdbtn.setBackground(new Color(250, 250, 210));
		female_rdbtn.setBounds(330, 235, 69, 23);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(male_rdbtn);
		bg.add(female_rdbtn);
		
		panel.add(male_rdbtn);
		panel.add(female_rdbtn);
		
		phno_textField = new JTextField();
		phno_textField.setBounds(277, 264, 109, 20);
		panel.add(phno_textField);
		phno_textField.setColumns(10);
		
		fees_textField = new JTextField("8000");
		fees_textField.setBounds(277, 324, 109, 20);
		panel.add(fees_textField);
		fees_textField.setColumns(10);
		
		JComboBox<String> course_comboBox = new JComboBox();
		course_comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String fees;
				try 
				{
					fees = getFees(course_comboBox.getSelectedItem().toString());
					fees_textField.setText(fees);
				} 
				catch (Exception e1) 
				{
					e1.printStackTrace();
				}
			}
		});
		course_comboBox.setBounds(277, 294, 109, 20);
		course_comboBox.addItem("Core Java");
		course_comboBox.addItem("Advanced Java");
		course_comboBox.addItem(".Net");
		course_comboBox.addItem("C");
		course_comboBox.addItem("C++");
		course_comboBox.addItem("Android");
		panel.add(course_comboBox);
		
		remainingAmount_textField = new JTextField();
		remainingAmount_textField.setBounds(277, 382, 109, 20);
		panel.add(remainingAmount_textField);
		remainingAmount_textField.setColumns(10);
		
		feespaid_textField = new JTextField();
		feespaid_textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int fees = Integer.parseInt(getFees(course_comboBox.getSelectedItem().toString()));
					remainingAmount_textField.setText(String.valueOf(fees-(Integer.parseInt(feespaid_textField.getText()))));
				} catch (NumberFormatException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		feespaid_textField.setBounds(277, 354, 109, 20);
		panel.add(feespaid_textField);
		feespaid_textField.setColumns(10);
		
		JTextArea address_textArea = new JTextArea();
		Border b = BorderFactory.createLineBorder(Color.GRAY);
		address_textArea.setBorder(b);
		address_textArea.setForeground(new Color(0, 0, 0));
		address_textArea.setToolTipText("");
		address_textArea.setBackground(new Color(255, 255, 255));
		address_textArea.setLineWrap(true);
		address_textArea.setBounds(181, 102, 205, 89);
		panel.add(address_textArea);
		
		JLabel lblNewLabel = new JLabel("Date of Joining");
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblNewLabel.setBounds(29, 411, 154, 20);
		panel.add(lblNewLabel);
		
		JComboBox date_comboBox = new JComboBox();
		date_comboBox.setBounds(223, 413, 41, 20);
		for(int i = 1; i<=31; i++)
			date_comboBox.addItem(i);
		panel.add(date_comboBox);
		
		JComboBox month_comboBox = new JComboBox();
		month_comboBox.setBounds(274, 413, 41, 20);
		for(int i = 1; i<=12; i++)
			month_comboBox.addItem(i);
		panel.add(month_comboBox);
		
		JComboBox year_comboBox = new JComboBox();
		year_comboBox.setBounds(325, 413, 61, 20);
		for(int i = 2017; i<=2025; i++)
			year_comboBox.addItem(i);
		panel.add(year_comboBox);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				int id = getID();
				String name = name_textField.getText();
				String address = address_textArea.getText();
				String dob = dob_textField.getText();
				String gender=null;
				if(male_rdbtn.isSelected())
					gender = "male";
				else if(female_rdbtn.isSelected())
					gender = "female";
				String phoneNo = phno_textField.getText();
				String course = course_comboBox.getSelectedItem().toString();
				String fees = fees_textField.getText();
				String feespaid = feespaid_textField.getText();
				String remainingAmt = remainingAmount_textField.getText();
				String joining_date = date_comboBox.getSelectedItem().toString();
				String joining_month = month_comboBox.getSelectedItem().toString();
				String joining_year = year_comboBox.getSelectedItem().toString();
					enter(id, name, address, dob, gender, phoneNo, course, fees, feespaid, remainingAmt, joining_date, joining_month, joining_year);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Menues menu = new Menues();
				menu.change_label();
				menu.setButtonTrue();
				setVisible(false);
				menu.setTrue();
			}
		});
		btnSubmit.setFont(new Font("Century Gothic", Font.BOLD, 14));
		btnSubmit.setBounds(212, 446, 89, 23);
		panel.add(btnSubmit);
		
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
		btnBack.setFont(new Font("Century Gothic", Font.BOLD, 14));
		btnBack.setBounds(106, 446, 89, 23);
		panel.add(btnBack);
	}
}
