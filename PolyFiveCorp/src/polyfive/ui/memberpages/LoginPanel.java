package polyfive.ui.memberpages;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import polyfive.entities.ChangeLanguage;
import polyfive.entities.Member;
import polyfive.entities.dao.DBConnectionManager;
import polyfive.ui.adminpages.AdminCalendar;
import polyfive.ui.master.MainFrame;
import polyfive.ui.master.MasterPanel;
import polyfive.ui.master.WelcomePanel;
import javax.swing.SwingConstants;

public class LoginPanel extends MasterPanel {
	private JTextField UsernameField;
	private JPanel panel;
	private JPasswordField PasswordField;
	private JButton btnBack;
	private MainFrame f;
	private JPanel panel_1;
	private JButton Login;
	private JButton btnResetPassword;
	private JButton button;

	/**
	 * Create the panel.
	 * 
	 * @throws Exception
	 */

	/*/test
	 * public void connect(){
	 * 
	 * try { con =
	 * DriverManager.getConnection("jdbc:mysql://localhost:8888/PolyFiveCorp"
	 * ,"root",""); } catch (SQLException e) { // TODO Auto-generated catch
	 * block e.printStackTrace(); }
	 * 
	 * 
	 * try { stmt = con.createStatement(); } catch (SQLException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); }
	 * 
	 * 
	 * try { rs = stmt.executeQuery("select * from users"); } catch
	 * (SQLException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * 
	 * 
	 * 
	 * String driver = "com.mysql.jdbc.Driver"; try { Class.forName(driver); }
	 * catch (Exception ex) { // TODO Auto-generated catch block
	 * ex.printStackTrace(); }
	 * 
	 * try { while(rs.next()) { System.out.println(rs.getString("Username") +
	 * " " + rs.getString("Password")); } } catch (SQLException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } }
	 */

	public LoginPanel(MainFrame frame) {
		ChangeLanguage changeLanguage= new ChangeLanguage();
		changeLanguage = f.getStoreLanguage();
		int language = changeLanguage.getChangeLanguage();
		
		
		f = frame;
		DBConnectionManager.connect();
		setSize(new Dimension(1366, 768));
		setBackground(SystemColor.text);
		setLayout(null);

		panel = new JPanel();
		panel.setOpaque(false);
		panel.setBackground(SystemColor.text);
		panel.setBounds(372, 438, 622, 234);
		add(panel);
		panel.setLayout(null);

		UsernameField = new JTextField();
		UsernameField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		UsernameField.setToolTipText("");
		UsernameField.setBounds(224, 118, 350, 45);
		panel.add(UsernameField);
		UsernameField.setColumns(10);

		JLabel lblPassword = new JLabel("Password\r\n");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblPassword.setBounds(32, 181, 182, 45);
		panel.add(lblPassword);

		JLabel lblName = new JLabel("Username");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblName.setBounds(32, 118, 182, 45);
		panel.add(lblName);

		PasswordField = new JPasswordField();
		PasswordField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		PasswordField.setBounds(224, 179, 350, 45);
		panel.add(PasswordField);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(LoginPanel.class
				.getResource("/polyFive/ui/images/p5cicon.png")));
		label.setAutoscrolls(true);
		label.setBounds(444, 40, 500, 500);
		add(label);

		btnBack = new JButton("Back");
		btnBack.setFocusPainted(false);
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
		btnBack.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				Color.DARK_GRAY, null));
		btnBack.setBackground(new Color(255, 165, 0));
		btnBack.setAlignmentX(1.0f);
		btnBack.setBounds(21, 664, 150, 75);
		add(btnBack);

		panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel_1.setBounds(476, 683, 546, 56);
		add(panel_1);
		panel_1.setLayout(null);

		Login = new JButton("Login");
		Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * MemberCalendar memberCalendar = f.getMemberCalendar();
				 * f.getContentPane().removeAll();
				 * f.getContentPane().add(memberCalendar); f.repaint();
				 * f.revalidate(); f.setVisible(true);
				 */
				try {
					String username = UsernameField.getText().trim();
					String password = PasswordField.getText();
					
					

					String sql = "select Username, Password from Users where Username = '"
							+ username + "'and Password ='" + password + "'";
					DBConnectionManager.rs = DBConnectionManager.stmt
							.executeQuery(sql);

					int count = 0;
					while (DBConnectionManager.rs.next()) {
						count = count + 1;
					}

					if (count == 1) {
						String pass_icNo = (JOptionPane
								.showInputDialog(null,"Please enter your NRIC/Passport number below: \nCase sensitive "));

						String sql2 = "select * from Users where Username = '"
								+ username
								+ "'and Password ='"
								+ password
								+ "' and pass_icNo = '"
								+ pass_icNo
								+ "'";
						DBConnectionManager.rs = DBConnectionManager.stmt
								.executeQuery(sql2);
						
						boolean checkPass_icNo = false;
						while (DBConnectionManager.rs.next()) {
							if (pass_icNo.equals(DBConnectionManager.rs.getString("pass_icNo")))
								checkPass_icNo = true;
							else
								checkPass_icNo = false;
						}

						
						
						if (checkPass_icNo == true) {
							
							JOptionPane.showMessageDialog(null,
									"User Found, Access Granted",
									"PolyFive Corp", JOptionPane.PLAIN_MESSAGE);
							
						//	Member user = new Member();
							//user.setUsername("khai");
							
							//f.setSession(user);
							
						
							DBConnectionManager.rs.beforeFirst();
							Member user = new Member();
							while (DBConnectionManager.rs.next()){
							user.setUsername(DBConnectionManager.rs.getString("username"));
							user.setPassword(DBConnectionManager.rs.getString("password"));
							user.setFirstName(DBConnectionManager.rs.getString("firstName"));
							user.setLastName(DBConnectionManager.rs.getString("lastName"));
							user.setCreationDate(DBConnectionManager.rs.getString("creationDate"));
							user.setEmail(DBConnectionManager.rs.getString("email"));
							user.setPhoneNumber(DBConnectionManager.rs.getInt("telNo"));
							user.setPass_icNo(DBConnectionManager.rs.getString("pass_icNo"));
							user.setRank(DBConnectionManager.rs.getInt("rank"));
							
							f.setSession(user);
							
							}
							
							Member checkUserRank = new Member();
							checkUserRank = f.getSession();
							int rankNo = checkUserRank.getRank();
							

							if (rankNo <= 4){
							MemberCalendar memberCalendar = new MemberCalendar(f);
							f.getContentPane().removeAll();
							f.getContentPane().add(memberCalendar);
							f.repaint();
							f.revalidate();
							f.setVisible(true);
						}
							else if (rankNo > 4){
							AdminCalendar Calendar1 = new AdminCalendar(f);
							f.getContentPane().removeAll();
							f.getContentPane().add(Calendar1);
							f.repaint();
							f.revalidate();
							f.setVisible(true);
							}
							
						}
					
						
						else {
							JOptionPane
									.showMessageDialog(
											null,
											"NRIC/Passport number is incorrect. Please try again. ",
											"PolyFive Corp",
											JOptionPane.ERROR_MESSAGE);
						}
					}

					

					else if (count > 1) {
						JOptionPane.showMessageDialog(null,
								"Duplicate User, Access Denied",
								"PolyFive Corp", JOptionPane.ERROR_MESSAGE);
					}

					else {
						JOptionPane.showMessageDialog(null,
								"User not found / Incorrect password.",
								"PolyFive Corp", JOptionPane.ERROR_MESSAGE);

					}

				} catch (Exception ex) {

					System.out.println(ex);

				}
			}
		});
		Login.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Login.setFocusPainted(false);
		Login.setForeground(Color.DARK_GRAY);
		Login.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Login.setBackground(new Color(255, 165, 0));
		Login.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY,
				null));
		Login.setBounds(120, 0, 170, 50);
		panel_1.add(Login);

		btnResetPassword = new JButton("Reset Password");
		btnResetPassword.setCursor(Cursor
				.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnResetPassword.setFocusPainted(false);
		btnResetPassword.setForeground(Color.DARK_GRAY);
		btnResetPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnResetPassword.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				Color.DARK_GRAY, null));
		btnResetPassword.setBackground(new Color(255, 165, 0));
		btnResetPassword.setBounds(299, 0, 170, 50);
		panel_1.add(btnResetPassword);

		button = new JButton("");
		button.setIcon(new ImageIcon(LoginPanel.class
				.getResource("/polyFive/ui/images/p5cicon7575.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WelcomePanel welcomePanel = new WelcomePanel(f);
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
		
		if (language == 0){
			lblName.setText (WelcomePanel.BUNDLE.getString("LoginPanel.lblName.text") );
			lblPassword.setText( WelcomePanel.BUNDLE.getString("LoginPanel.lblNric.text") );
			btnBack.setText(WelcomePanel.BUNDLE.getString("LoginPanel.btnBack.text") );
			Login.setText(WelcomePanel.BUNDLE.getString("LoginPanel.Login.text") );
		}
		else if (language == 1){
			lblName.setText (WelcomePanel.BUNDLE2.getString("LoginPanel.lblName.text") );
			lblPassword.setText( WelcomePanel.BUNDLE2.getString("LoginPanel.lblNric.text") );
			btnBack.setText(WelcomePanel.BUNDLE2.getString("LoginPanel.btnBack.text") );
			Login.setText(WelcomePanel.BUNDLE2.getString("LoginPanel.Login.text") );
			
		}

		super.setLayout();

	}

	

}

