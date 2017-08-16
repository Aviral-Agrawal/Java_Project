package student_management;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class Forgot_Password extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Forgot_Password frame = new Forgot_Password();
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
	public Forgot_Password() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 389);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 204, 255));
		panel.setBounds(0, 0, 434, 350);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblForgotPassword = new JLabel("Forgot Password");
		lblForgotPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblForgotPassword.setVerticalAlignment(SwingConstants.TOP);
		lblForgotPassword.setFont(new Font("Century Gothic", Font.BOLD, 25));
		lblForgotPassword.setBounds(10, 0, 414, 32);
		panel.add(lblForgotPassword);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblUsername.setBounds(10, 35, 414, 20);
		panel.add(lblUsername);
		
		textField = new JTextField();
		textField.setBounds(119, 58, 196, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Security Question");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblPassword.setBounds(10, 81, 414, 20);
		panel.add(lblPassword);
		
		JLabel lblSecurityAnswer = new JLabel("Security Answer");
		lblSecurityAnswer.setHorizontalAlignment(SwingConstants.CENTER);
		lblSecurityAnswer.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblSecurityAnswer.setBounds(10, 130, 414, 20);
		panel.add(lblSecurityAnswer);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(119, 153, 196, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Century Gothic", Font.BOLD, 13));
		btnSubmit.setBounds(171, 180, 89, 23);
		panel.add(btnSubmit);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(10, 105, 414, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewPassword.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblNewPassword.setBounds(10, 214, 414, 20);
		panel.add(lblNewPassword);
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setBounds(119, 237, 196, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirmPassword.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblConfirmPassword.setBounds(10, 258, 414, 20);
		panel.add(lblConfirmPassword);
		
		textField_4 = new JTextField();
		textField_4.setBounds(119, 280, 196, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnUpdatePassword = new JButton("Update Password");
		btnUpdatePassword.setFont(new Font("Century Gothic", Font.BOLD, 13));
		btnUpdatePassword.setBounds(119, 316, 196, 23);
		panel.add(btnUpdatePassword);
	}
}
