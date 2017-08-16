package student_management;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Registration extends JFrame {

	private JPanel contentPane;
	private JTextField user_textField;
	private JPasswordField pass_passwordField;
	private JPasswordField confirmpass_passwordField;
	private JTextField SecAns_textField;
	private JComboBox SecQues_comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration frame = new Registration();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public boolean check_user(String user) throws Exception
	{
		boolean b = true;
		//Connecting to the database
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "root");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from login_credentials");
		while(rs.next())
		{
			String user1 = rs.getString(1);
			if(user1.equals(user))
			{
				b=false;
				break;
			}
		}
		return b;
	}
	public boolean get_details(String user, String pass, String ques, String ans)throws Exception
	{
		boolean b = check_user(user);
		if(b)
		{
			//Connecting to the database
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "root");
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("Insert into login_credentials values('"+user+"','"+pass+"','"+ques+"','"+ans+"')");
		}	
		return b;
	}
	/**
	 * Create the frame.
	 */
	public Registration() {
		setTitle("Registration");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 204, 153));
		panel.setBounds(0, 0, 484, 429);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblRegistration = new JLabel("Registration");
		lblRegistration.setFont(new Font("Century Gothic", Font.BOLD, 25));
		lblRegistration.setBounds(172, 7, 143, 32);
		panel.add(lblRegistration);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 255, 255));
		panel_1.setBounds(80, 50, 327, 303);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblUsername.setBounds(124, 11, 74, 20);
		panel_1.add(lblUsername);
		
		user_textField = new JTextField();
		user_textField.setBounds(95, 31, 138, 20);
		panel_1.add(user_textField);
		user_textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblPassword.setBounds(124, 61, 74, 20);
		panel_1.add(lblPassword);
		
		pass_passwordField = new JPasswordField();
		pass_passwordField.setBounds(95, 82, 138, 20);
		panel_1.add(pass_passwordField);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblConfirmPassword.setBounds(99, 104, 131, 20);
		panel_1.add(lblConfirmPassword);
		
		confirmpass_passwordField = new JPasswordField();
		confirmpass_passwordField.setBounds(95, 125, 138, 20);
		panel_1.add(confirmpass_passwordField);
		
		JCheckBox agree_checkBox = new JCheckBox("I Agree The T/C");
		agree_checkBox.setBackground(new Color(204, 255, 255));
		agree_checkBox.setBounds(95, 245, 138, 23);
		panel_1.add(agree_checkBox);
		
		JLabel confirmation_label = new JLabel("");
		confirmation_label.setBounds(80, 371, 327, 14);
		panel.add(confirmation_label);
		
		JLabel lblSecurityQuestion = new JLabel("Security Question");
		lblSecurityQuestion.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblSecurityQuestion.setBounds(102, 150, 126, 20);
		panel_1.add(lblSecurityQuestion);
		
		SecQues_comboBox = new JComboBox();
		try {
			initSec();
			SecQues_comboBox.setBounds(10, 173, 307, 20);
			panel_1.add(SecQues_comboBox);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JLabel lblSecurityAnswer = new JLabel("Security Answer");
		lblSecurityAnswer.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblSecurityAnswer.setBounds(108, 194, 116, 23);
		panel_1.add(lblSecurityAnswer);
		
		SecAns_textField = new JTextField();
		SecAns_textField.setBounds(95, 216, 138, 20);
		panel_1.add(SecAns_textField);
		SecAns_textField.setColumns(10);
		
		JButton Register_Button = new JButton("Register");
		Register_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				try
				{
					boolean b = false;
					if((String.valueOf(pass_passwordField.getPassword())).equals(String.valueOf(confirmpass_passwordField.getPassword())))
					{
						if(agree_checkBox.isSelected()){
						b = get_details(user_textField.getText(), String.valueOf(pass_passwordField.getPassword()), SecQues_comboBox.getSelectedItem().toString(), SecAns_textField.getText());
						if(b)
						{
							Menues menu = new Menues();
							menu.setButtonTrue();
							menu.change_label();
							menu.setTrue();
							setVisible(false);
						}
						else
						{
							confirmation_label.setText("Username Already Exists!!");
							user_textField.setText("");
							pass_passwordField.setText("");
							confirmpass_passwordField.setText("");
							agree_checkBox.setSelected(false);
						}}
						else
						{
							confirmation_label.setText("T/C not Agreed!!");
						}
					}
					else
					{
						confirmation_label.setText("Passwords Don't Match!!");
						pass_passwordField.setText("");
						confirmpass_passwordField.setText("");
						agree_checkBox.setSelected(false);
					}	
				}
				catch(Exception p){System.out.println(p);}
			}
		});
		Register_Button.setBounds(117, 269, 93, 23);
		panel_1.add(Register_Button);
		
		JButton back_button = new JButton("Back");
		back_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Menues menu = new Menues();
				menu.change_label();
				menu.setButtonTrue();
				menu.setTrue();
			}
		});
		back_button.setBounds(197, 395, 93, 23);
		panel.add(back_button);
	}

	private void initSec()throws Exception {
		//Connecting to the database
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "root");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from secret_questions");
		while(rs.next())
			SecQues_comboBox.addItem(rs.getString(1));
	}
}
