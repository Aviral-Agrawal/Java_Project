package student_management;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.l2fprod.common.swing.JLinkButton;
import javax.swing.SwingConstants;

public class Login_Page extends JFrame {

	private JPanel contentPane;
	private JTextField user_textField;
	private JPasswordField pass_passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_Page frame = new Login_Page();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public boolean check_login(String user, String pass) throws Exception
	{
		boolean b = false;
		//Connecting to database
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "root");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from login_credentials");
		while(rs.next())
		{
			if(rs.getString(1).equals(user)&&rs.getString(2).equals(pass))
			{
				b=true;
				break;
			}
		}
		return b;
	}
	
	public Login_Page() {
		setTitle("Login Page");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(60, 179, 113));
		panel.setBounds(0, 0, 434, 305);
		getContentPane().add(panel);
		
		JLabel lblLoginPage = new JLabel("Login Page");
		lblLoginPage.setBounds(155, 5, 136, 32);
		lblLoginPage.setFont(new Font("Century Gothic", Font.BOLD, 25));
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(182, 46, 74, 20);
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(184, 108, 70, 20);
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		
		user_textField = new JTextField();
		user_textField.setBounds(151, 77, 136, 20);
		user_textField.setColumns(10);
		
		pass_passwordField = new JPasswordField();
		pass_passwordField.setBounds(151, 139, 136, 20);
		panel.setLayout(null);
		panel.add(lblLoginPage);
		panel.add(lblNewLabel);
		panel.add(user_textField);
		panel.add(lblNewLabel_1);
		panel.add(pass_passwordField);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(122, 43, 196, 190);
		panel_1.setBackground(new Color(102, 255, 153));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton login_button = new JButton("Login");
		login_button.setAlignmentY(Component.TOP_ALIGNMENT);
		login_button.setBounds(61, 130, 70, 23);
		panel_1.add(login_button);
		
		JLinkButton forgotPass = new JLinkButton("Forgot Password!");
		forgotPass.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 13));
		forgotPass.setForeground(Color.RED);
		forgotPass.setHorizontalAlignment(SwingConstants.CENTER);
		forgotPass.setText("\tForgot Password!");
		forgotPass.setBounds(0, 164, 196, 18);
		panel_1.add(forgotPass);
		
		JLabel confirmation_label = new JLabel("");
		confirmation_label.setBounds(122, 254, 302, 14);
		panel.add(confirmation_label);
		
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Menues menu = new Menues();
				menu.setTrue();
			}
		});
		btnBack.setBounds(182, 271, 70, 23);
		panel.add(btnBack);
		login_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					boolean b = check_login(user_textField.getText(), String.valueOf(pass_passwordField.getPassword()));
					if(b)
					{
						setVisible(false);
						Menues menu = new Menues();
						menu.setButtonTrue();
						menu.change_label();
						menu.setTrue();
					}
					else
					{
						confirmation_label.setText("Username or Password not Found!!");
						user_textField.setText("");
						pass_passwordField.setText("");
					}
				}
				catch(Exception p){System.out.println(p);}
			}
		});
	}
}