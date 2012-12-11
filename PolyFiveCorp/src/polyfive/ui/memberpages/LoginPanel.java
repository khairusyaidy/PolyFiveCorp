package polyfive.ui.memberpages;
import polyfive.ui.adminpages.*;
import polyfive.ui.images.*;
import polyfive.ui.master.*;
import polyfive.ui.misc.DigitalClock;
import polyfive.ui.publicpages.*;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.Dimension;
import com.javaswingcomponents.clock.analog.JSCAnalogClock;
import com.javaswingcomponents.clock.analog.plaf.darksteel.DarkSteelAnalogClockUI;
import javax.swing.border.EtchedBorder;

public class LoginPanel extends MasterPanel {
	private JTextField txtEnterUsername;
	private JPanel panel;
	private JPasswordField passwordField;
	private JButton btnBack;
	private MainFrame f;
	private JPanel panel_1;
	private JButton btnNewButton;
	private JButton btnResetPassword;
	private JButton button;
	/**
	 * Create the panel.
	 */
	public LoginPanel() {
		setSize(new Dimension(1366, 768));
		setBackground(SystemColor.text);
		setLayout(null);
		
		panel = new JPanel();
		panel.setOpaque(false);
		panel.setBackground(SystemColor.text);
		panel.setBounds(372, 438, 622, 234);
		add(panel);
		panel.setLayout(null);
		
		txtEnterUsername = new JTextField();
		txtEnterUsername.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtEnterUsername.setToolTipText("Enter username");
		txtEnterUsername.setBounds(224, 118, 350, 45);
		panel.add(txtEnterUsername);
		txtEnterUsername.setColumns(10);
		
		JLabel lblNric = new JLabel("Password\r\n");
		lblNric.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNric.setBounds(72, 181, 100, 45);
		panel.add(lblNric);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName.setBounds(72, 118, 100, 45);
		panel.add(lblName);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		passwordField.setBounds(224, 179, 350, 45);
		panel.add(passwordField);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(LoginPanel.class.getResource("/polyFive/ui/images/p5cicon.png")));
		label.setAutoscrolls(true);
		label.setBounds(444, 40, 500, 500);
		add(label);
		
		btnBack = new JButton("Back");
		btnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    WelcomePanel welcomePanel = f.getWelcomePanel();
			    f.getContentPane().removeAll();
			    f.getContentPane().add(welcomePanel);
			    f.repaint();
			    f.revalidate();
			    f.setVisible(true);
				

			}
		});
		btnBack.setForeground(Color.DARK_GRAY);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnBack.setFocusPainted(false);
		btnBack.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, null));
		btnBack.setBackground(new Color(255, 165, 0));
		btnBack.setAlignmentX(1.0f);
		btnBack.setBounds(21, 664, 150, 75);
		add(btnBack);
		
		panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel_1.setBounds(476, 683, 546, 56);
		add(panel_1);
		panel_1.setLayout(null);
		
		btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    MemberCalendar memberCalendar = f.getMemberCalendar();
			    f.getContentPane().removeAll();
			    f.getContentPane().add(memberCalendar);
			    f.repaint();
			    f.revalidate();
			    f.setVisible(true);
			}
		});
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setFocusPainted(false);
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBackground(new Color(255, 165, 0));
		btnNewButton.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, null));
		btnNewButton.setBounds(120, 0, 170, 50);
		panel_1.add(btnNewButton);
		
		btnResetPassword = new JButton("Reset Password");
		btnResetPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnResetPassword.setFocusPainted(false);
		btnResetPassword.setForeground(Color.DARK_GRAY);
		btnResetPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnResetPassword.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, null));
		btnResetPassword.setBackground(new Color(255, 165, 0));
		btnResetPassword.setBounds(299, 0, 170, 50);
		panel_1.add(btnResetPassword);
		
		button = new JButton("");
		button.setIcon(new ImageIcon(LoginPanel.class.getResource("/polyFive/ui/images/p5cicon7575.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    WelcomePanel welcomePanel = f.getWelcomePanel();
			    f.getContentPane().removeAll();
			    f.getContentPane().add(welcomePanel);
			    f.repaint();
			    f.revalidate();
			    f.setVisible(true);
			}
		});
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setBorder(null);
		button.setBounds(21, 21, 75, 75);
		add(button);
		
		
		super.setLayout();

	}

	public LoginPanel(MainFrame frame) {
		this();
		f = frame;
		// TODO Auto-generated constructor stub
	}
}
