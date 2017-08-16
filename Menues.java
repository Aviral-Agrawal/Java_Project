package student_management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Window.Type;

public class Menues {

	private JFrame frmStart;
	private JButton enterDetails_button = new JButton("Enter Details");
	private JButton viewDetailsInd_button = new JButton("View/Update Details");
	private JButton login_button = new JButton("Login");
	private JLabel lblLoginToEnable = new JLabel("Login to Enable Following Features");
	private final JButton dailyReport_button = new JButton("Daily Report");
	private JButton register_button = new JButton("Register");
	JButton monthlyReport_button = new JButton("Monthly Report");
	JButton viewAll_button = new JButton("View All");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menues window = new Menues();
					window.frmStart.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menues() {
		initialize();
	}
	
	public void setTrue()
	{
		frmStart.setVisible(true);
	}
	
	public void setFalse()
	{
		frmStart.setVisible(false);
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStart = new JFrame();
		frmStart.setTitle("Start");
		frmStart.setBounds(100, 100, 450, 379);
		frmStart.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmStart.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 51));
		panel.setBounds(0, 0, 434, 340);
		frmStart.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblStartPage = new JLabel("Start Page");
		lblStartPage.setFont(new Font("Century Gothic", Font.BOLD, 25));
		lblStartPage.setForeground(new Color(255, 255, 255));
		lblStartPage.setBounds(152, 1, 125, 32);
		panel.add(lblStartPage);
		
		register_button.setEnabled(false);
		register_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmStart.setVisible(false);
				Registration reg = new Registration();
				reg.setVisible(true);
			}
		});
		register_button.setBounds(133, 67, 162, 23);
		panel.add(register_button);
		
		login_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmStart.setVisible(false);
				Login_Page login = new Login_Page();
				login.setVisible(true);
			}
		});
		login_button.setBounds(133, 101, 162, 23);
		panel.add(login_button);
		viewDetailsInd_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Get_ID get = new Get_ID();
				get.setVisible(true);
				setFalse();
			}
		});
		
		viewDetailsInd_button.setEnabled(false);
		viewDetailsInd_button.setBounds(133, 201, 162, 23);
		panel.add(viewDetailsInd_button);
		enterDetails_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Insert_Details ins = new Insert_Details();
				ins.setVisible(true);
				frmStart.setVisible(false);
			}
		});
		
		enterDetails_button.setEnabled(false);
		enterDetails_button.setBounds(133, 167, 162, 23);
		panel.add(enterDetails_button);
		
		lblLoginToEnable.setForeground(new Color(255, 255, 255));
		lblLoginToEnable.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblLoginToEnable.setBounds(92, 135, 251, 23);
		panel.add(lblLoginToEnable);
		viewAll_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmStart.setVisible(false);
				ViewAll view = new ViewAll();
				view.setVisible(true);
			}
		});
		
		viewAll_button.setEnabled(false);
		viewAll_button.setBounds(133, 235, 162, 23);
		panel.add(viewAll_button);
		dailyReport_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmStart.setVisible(false);
				DailyReport daily = new DailyReport();
				daily.setVisible(true);
			}
		});
		dailyReport_button.setEnabled(false);
		dailyReport_button.setBounds(133, 269, 162, 23);
		
		panel.add(dailyReport_button);
		monthlyReport_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmStart.setVisible(false);
				MonthlyReport month = new MonthlyReport();
				month.setVisible(true);
			}
		});
		
		monthlyReport_button.setEnabled(false);
		monthlyReport_button.setBounds(133, 303, 162, 23);
		panel.add(monthlyReport_button);
	}
	
	public void setButtonTrue()
	{
		register_button.setEnabled(true);
		viewDetailsInd_button.setEnabled(true);
		enterDetails_button.setEnabled(true);
		login_button.setEnabled(false);
		dailyReport_button.setEnabled(true);
		viewAll_button.setEnabled(true);
		monthlyReport_button.setEnabled(true);
	}
	
	public void change_label()
	{
		lblLoginToEnable.setText("Logged In!!");
		lblLoginToEnable.setBounds(133, 135, 251, 23);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
