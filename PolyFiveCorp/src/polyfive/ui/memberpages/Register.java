package polyfive.ui.memberpages;
import polyfive.ui.adminpages.*;
import polyfive.ui.images.*;
import polyfive.ui.master.*;
import polyfive.ui.publicpages.*;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.util.ResourceBundle;

public class Register extends MasterPanel {
	private JTextField accountName;
	private JTextField phoneNumber;
	private JTextField email;
	private JTextField confirmEmail;
	private JTextField passport_IC;
	private JTextField captcha;
	private JTextField enterCaptcha;
	private JLabel lblPassword;
	private JLabel lblConfirmPassword;
	private JLabel lblPhone;
	private JLabel lblCaptcha;
	private JLabel lblEmail;
	private JLabel lblConfirmEmail;
	private JLabel lblPassport_IC;
	private JComboBox membershipType;
	private JLabel lblChooseYourMembership;
	private MainFrame f = null;
	private JButton btnNewButton;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Create the panel.
	 */
	public Register() {
		setBackground(new Color(255, 255, 255));
		setSize(new Dimension(1366, 768));
		setLayout(null);
		
		JPanel registerDetails = new JPanel();
		registerDetails.setBounds(319, 342, 730, 324);
		registerDetails.setOpaque(false);
		add(registerDetails);
		registerDetails.setLayout(null);
		
		accountName = new JTextField();
		accountName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		accountName.setBounds(0, 20, 350, 45);
		registerDetails.add(accountName);
		accountName.setColumns(10);
		
		phoneNumber = new JTextField();
		phoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		phoneNumber.setBounds(0, 245, 350, 45);
		phoneNumber.setColumns(10);
		registerDetails.add(phoneNumber);
		
		email = new JTextField();
		email.setFont(new Font("Tahoma", Font.PLAIN, 15));
		email.setBounds(380, 20, 350, 45);
		email.setColumns(10);
		registerDetails.add(email);
		
		confirmEmail = new JTextField();
		confirmEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		confirmEmail.setBounds(380, 95, 350, 45);
		confirmEmail.setColumns(10);
		registerDetails.add(confirmEmail);
		
		passport_IC = new JTextField();
		passport_IC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passport_IC.setBounds(380, 170, 350, 45);
		passport_IC.setColumns(10);
		registerDetails.add(passport_IC);
		
		captcha = new JTextField();
		captcha.setBounds(380, 245, 170, 45);
		captcha.setColumns(10);
		registerDetails.add(captcha);
		
		enterCaptcha = new JTextField();
		enterCaptcha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		enterCaptcha.setBounds(560, 245, 170, 45);
		enterCaptcha.setColumns(10);
		registerDetails.add(enterCaptcha);
		
		JLabel lblAccountName = new JLabel("Enter your account name here:");
		lblAccountName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAccountName.setBounds(10, 0, 230, 20);
		registerDetails.add(lblAccountName);
		
		lblPassword = new JLabel("Enter your password here:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(10, 76, 211, 20);
		registerDetails.add(lblPassword);
		
		lblConfirmPassword = new JLabel("Confirm your password:");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblConfirmPassword.setBounds(10, 151, 170, 20);
		registerDetails.add(lblConfirmPassword);
		
		lblPhone = new JLabel("Enter your phone number here:");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPhone.setBounds(10, 226, 211, 20);
		registerDetails.add(lblPhone);
		
		lblCaptcha = new JLabel("Enter captcha here:");
		lblCaptcha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCaptcha.setBounds(570, 226, 160, 20);
		registerDetails.add(lblCaptcha);
		
		lblEmail = new JLabel("Enter your email address here:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmail.setBounds(390, 0, 211, 20);
		registerDetails.add(lblEmail);
		
		lblConfirmEmail = new JLabel("Confirm your email address here:");
		lblConfirmEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblConfirmEmail.setBounds(390, 75, 230, 20);
		registerDetails.add(lblConfirmEmail);
		
		lblPassport_IC = new JLabel("Enter your passport/IC here:");
		lblPassport_IC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassport_IC.setBounds(390, 150, 211, 20);
		registerDetails.add(lblPassport_IC);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordField.setBounds(0, 95, 350, 45);
		registerDetails.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordField_1.setBounds(0, 170, 350, 45);
		registerDetails.add(passwordField_1);
		
		membershipType = new JComboBox();
		membershipType.setFont(new Font("Tahoma", Font.PLAIN, 20));
		membershipType.setBounds(580, 274, 225, 45);
		membershipType.setModel(new DefaultComboBoxModel(new String[] {"Basic", "Bronze", "Silver", "Gold"}));
		add(membershipType);
		
		lblChooseYourMembership = new JLabel("Choose your membership type:");
		lblChooseYourMembership.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblChooseYourMembership.setBounds(551, 228, 291, 35);
		add(lblChooseYourMembership);
		
		JButton backButton = new JButton("Back");
		backButton.setFocusPainted(false);
		backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    FirstTimeUsers firstTimeUsers= f.getFirstTimeUsers();
			    f.getContentPane().removeAll();
			    f.getContentPane().add(firstTimeUsers);
			    f.repaint();
			    f.validate();
			    f.setVisible(true);
			}
		});
		backButton.setBackground(new Color(255, 165, 0));
		backButton.setBorder(null);
		backButton.setForeground(new Color(255, 255, 255));
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		backButton.setBounds(21, 664, 150, 75);
		add(backButton);
		
		JButton registerButton = new JButton("Register");
		registerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		registerButton.setFocusPainted(false);
		registerButton.setBackground(new Color(255, 165, 0));
		registerButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		registerButton.setForeground(new Color(255, 255, 255));
		registerButton.setBorder(null);
		registerButton.setBounds(1188, 664, 150, 75);
		add(registerButton);
		
		btnNewButton = new JButton("");
		btnNewButton.setBounds(21, 21, 75, 75);
		add(btnNewButton);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    WelcomePanel welcomePanel = f.getWelcomePanel();
			    f.getContentPane().removeAll();
			    f.getContentPane().add(welcomePanel);
			    f.repaint();
			    f.revalidate();
			    f.setVisible(true);
			}
		});
		btnNewButton.setIcon(new ImageIcon(Register.class.getResource("/polyFive/ui/images/p5cicon7575.png")));
		btnNewButton.setBorder(null);
		
		super.setLayout();

	}
	
	public Register(MainFrame frame) {
		this();
		f = frame;
		// TODO Auto-generated constructor stub
	}
}
