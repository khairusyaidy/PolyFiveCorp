/* 
 * Program Name : AccountDetails.java
 * Purpose : Display the user details
 * 
 * Author: Muhammad Khairyl Rusyaidy (Database)/Logic  ,  Nicholas (UI/Logic)
 * Admin No: 120258L, 122130G
 * Module Group : IS1201
 * Last Modified: 4/2/2013
 * 
 */

package polyfive.ui.memberpages;

import polyfive.encryption.RailFence;
import polyfive.entities.Member;
import polyfive.entities.dao.DBConnectionManager;
import polyfive.ui.adminpages.*;
import polyfive.ui.master.*;
import polyfive.ui.publicpages.PublicCalendar;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.sql.SQLException;

import javax.swing.JPasswordField;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextArea;

public class AccountDetails extends MasterPanel {
	private JTextField creationDate;
	private JTextField rank;
	private JTextField phoneNumber;
	private JTextField email;
	private JTextField passportIC;
	private JTextField paymentMethod;
	private JTextField newCreationDate;
	private JTextField newRank;
	private JTextField newPhoneNumber;
	private JTextField newEmail;
	private JTextField newPassportIC;
	private JTextField newPaymentMethod;
	private MainFrame f = null;
	private JTextField currentMember;
	private JTextField upgradingTo;
	private JPasswordField oldPass;
	private JPasswordField newPass;
	private JPasswordField confirmNew;

	/**
	 * Create the panel.
	 */

	public AccountDetails(MainFrame frame) {
		f = frame;
		DBConnectionManager.getConnection();
		setLayout(null);

		Member user = new Member();
		user = f.getSession();
		String userName = user.getUsername();
		int rankNo = user.getRank();
		String rankName = user.setRankName(rankNo);

		String sql = "select * from Users where Username = '" + userName + "'";
		try {
			DBConnectionManager.rs = DBConnectionManager.stmt.executeQuery(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		setLayout(null);
		setSize(new Dimension(1366, 768));
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(927, 471, 400, 204);
		add(panel);
		panel.setLayout(null);

		JButton btnGoldMember = new JButton("Gold Member\r\n");
		btnGoldMember.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGoldMember.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				Color.DARK_GRAY, null));
		btnGoldMember.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGoldMember.setFocusPainted(false);
		btnGoldMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				upgradingTo.setText("Gold Member");
				newRank.setText("Gold Member");
			}
		});
		btnGoldMember.setBackground(new Color(255, 165, 0));
		btnGoldMember.setForeground(Color.DARK_GRAY);
		btnGoldMember.setBounds(10, 11, 120, 125);
		panel.add(btnGoldMember);

		JButton btnSilverMember = new JButton("Silver Member");
		btnSilverMember.setCursor(Cursor
				.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSilverMember.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSilverMember.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				Color.DARK_GRAY, null));
		btnSilverMember.setFocusPainted(false);
		btnSilverMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				upgradingTo.setText("Silver Member");
				newRank.setText("Silver Member");
			}
		});
		btnSilverMember.setBackground(new Color(255, 165, 0));
		btnSilverMember.setForeground(Color.DARK_GRAY);
		btnSilverMember.setBounds(140, 11, 121, 125);
		panel.add(btnSilverMember);

		JButton btnBronzeMember = new JButton("Bronze Member");
		btnBronzeMember.setCursor(Cursor
				.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBronzeMember.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBronzeMember.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				Color.DARK_GRAY, null));
		btnBronzeMember.setFocusPainted(false);
		btnBronzeMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				upgradingTo.setText("Bronze Member");
				newRank.setText("Bronze Member");
			}
		});
		btnBronzeMember.setBackground(new Color(255, 165, 0));
		btnBronzeMember.setForeground(Color.DARK_GRAY);
		btnBronzeMember.setBounds(271, 12, 123, 125);
		panel.add(btnBronzeMember);

		if (rankNo >= 4) {
			btnGoldMember.setEnabled(false);
			btnSilverMember.setEnabled(false);
			btnBronzeMember.setEnabled(false);
		} else if (rankNo >= 3) {
			btnSilverMember.setEnabled(false);
			btnBronzeMember.setEnabled(false);
		} else if (rankNo >= 2) {
			btnBronzeMember.setEnabled(false);
		}

		currentMember = new JTextField();
		currentMember.setEditable(false);
		currentMember.setText(rankName);
		currentMember.setBounds(140, 147, 240, 20);
		panel.add(currentMember);
		currentMember.setColumns(10);

		JLabel lblCurrentMember = new JLabel("You are currently a:");
		lblCurrentMember.setBounds(15, 147, 115, 14);
		panel.add(lblCurrentMember);

		upgradingTo = new JTextField();
		upgradingTo.setEditable(false);
		upgradingTo.setColumns(10);
		upgradingTo.setBounds(140, 173, 240, 20);
		panel.add(upgradingTo);

		JLabel lblUpgradingTo = new JLabel("Upgrading to:");
		lblUpgradingTo.setBounds(15, 176, 115, 14);
		panel.add(lblUpgradingTo);

		JPanel accountManagement = new JPanel();
		accountManagement.setBorder(new LineBorder(new Color(0, 0, 0)));
		accountManagement.setBounds(35, 471, 400, 204);
		add(accountManagement);
		accountManagement.setLayout(null);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(10, 37, 130, 14);
		accountManagement.add(lblPassword);

		JLabel lblNewPassword = new JLabel("New Password:");
		lblNewPassword.setBounds(10, 70, 130, 14);
		accountManagement.add(lblNewPassword);

		JLabel lblConfirmNew = new JLabel("Confirm New:");
		lblConfirmNew.setBounds(10, 99, 130, 14);
		accountManagement.add(lblConfirmNew);

		JButton resetPasswords = new JButton("Reset Changes");
		resetPasswords
				.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		resetPasswords.setFont(new Font("Tahoma", Font.BOLD, 11));
		resetPasswords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				oldPass.setText("");
				newPass.setText("");
				confirmNew.setText("");
				//feedbackText.setText("Successfully cleared passwords entered.");
				JOptionPane.showMessageDialog(null,
						"Successfully cleared passwords entered.");
			}
		});
		resetPasswords.setForeground(Color.DARK_GRAY);
		resetPasswords.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				Color.DARK_GRAY, null));
		resetPasswords.setBackground(new Color(255, 165, 0));
		resetPasswords.setBounds(10, 158, 185, 35);
		accountManagement.add(resetPasswords);

		JButton confirmPasswords = new JButton("Confirm Changes");
		confirmPasswords.setCursor(Cursor
				.getPredefinedCursor(Cursor.HAND_CURSOR));
		confirmPasswords.setFont(new Font("Tahoma", Font.BOLD, 11));
		confirmPasswords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Member userChangePass = new Member();
				userChangePass = f.getSession();

				String oldPassword = userChangePass.getPassword();
				String oldPasswordDecrypt = RailFence.decrypt(oldPassword);

				String oldPassTf = null;
				oldPassTf = oldPass.getText();

				String newPassTf = null;
				newPassTf = newPass.getText();
				String newPassTfEncrypted = RailFence.encrypt(newPassTf);

				String newPassTf2 = null;
				newPassTf2 = confirmNew.getText();
				String newPassTf2Encrypted = RailFence.encrypt(newPassTf2);

				boolean matchPassword = false;
				boolean matchPassword2 = false;

				if (!oldPassTf.isEmpty() && !newPassTf.isEmpty()
						&& !newPassTf2.isEmpty()) {
					if (!oldPassTf.equals(oldPasswordDecrypt)) {
						//feedbackText.setText("Password does not match your previous password.");
						JOptionPane.showMessageDialog(null,
								"Password does not match your previous password.");
						matchPassword = false;
					}

					if (!newPassTfEncrypted.equals(newPassTf2Encrypted)
							&& oldPassTf.equals(oldPasswordDecrypt)) {
						//feedbackText2.setText("New password does not match.");
						JOptionPane.showMessageDialog(null,
								"New password does not match.");
						//feedbackText.setText("");
						matchPassword2 = false;
					}

					else if (newPassTfEncrypted.equals(newPassTf2Encrypted)
							&& (oldPassTf.equals(oldPasswordDecrypt))) {

						try {

							String sql3 = "update Users set password='"
									+ newPassTfEncrypted + "' where username='"
									+ userChangePass.getUsername() + "' ";
							DBConnectionManager.pstmt = DBConnectionManager.con
									.prepareStatement(sql3);
							DBConnectionManager.pstmt.execute();
							//feedbackText.setText("Your password has been changed.");
							JOptionPane.showMessageDialog(null,
									"Your password has been changed.");
							//feedbackText2.setText("");
							oldPass.setText("");
							newPass.setText("");
							confirmNew.setText("");

						} catch (SQLException e1) {
							JOptionPane.showMessageDialog(null, e1);
							e1.printStackTrace();
						}

						String sql2 = "select * from Users where Username = '"
								+ userChangePass.getUsername() + "'";

						try {
							DBConnectionManager.rs = DBConnectionManager.stmt
									.executeQuery(sql2);
							while (DBConnectionManager.rs.next()) {
								userChangePass
										.setFirstName(DBConnectionManager.rs
												.getString("firstName"));
								userChangePass
										.setLastName(DBConnectionManager.rs
												.getString("lastName"));
								userChangePass
										.setPassword(DBConnectionManager.rs
												.getString("password"));
								userChangePass.setEmail(DBConnectionManager.rs
										.getString("email"));
								userChangePass
										.setPhoneNumber(DBConnectionManager.rs
												.getInt("telNo"));
								userChangePass
										.setPass_icNo(DBConnectionManager.rs
												.getString("pass_icNo"));
								userChangePass.setRank(DBConnectionManager.rs
										.getInt("rank"));

								f.setSession(userChangePass);

							}

						} catch (SQLException ex) {
							// TODO Auto-generated catch block
							ex.printStackTrace();
						}
					}
				}

				else if (oldPassTf.isEmpty() || newPassTf.isEmpty()
						|| newPassTf.isEmpty())
					//feedbackText.setText("Please complete the field.");
				JOptionPane.showMessageDialog(null,
						"Please complete the field.");

			}

		});
		confirmPasswords.setForeground(Color.DARK_GRAY);
		confirmPasswords.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				Color.DARK_GRAY, null));
		confirmPasswords.setBackground(new Color(255, 165, 0));
		confirmPasswords.setBounds(205, 158, 185, 35);
		accountManagement.add(confirmPasswords);

		JLabel lblPasswords = new JLabel("Password Changes:");
		lblPasswords.setBounds(10, 11, 116, 14);
		accountManagement.add(lblPasswords);

		oldPass = new JPasswordField();
		oldPass.setBounds(133, 34, 244, 20);
		accountManagement.add(oldPass);

		newPass = new JPasswordField();
		newPass.setBounds(133, 67, 244, 20);
		accountManagement.add(newPass);

		confirmNew = new JPasswordField();
		confirmNew.setBounds(133, 96, 244, 20);
		accountManagement.add(confirmNew);

		JPanel topBar = new JPanel();
		topBar.setBounds(35, 107, 1292, 45);
		add(topBar);
		topBar.setLayout(null);

		JLabel lblYouAreLogged = new JLabel("You are logged in as: "
				+ user.getFirstName() + " " + user.getLastName() + " ("
				+ rankName + ")");
		lblYouAreLogged.setBounds(5, 5, 800, 35);
		topBar.add(lblYouAreLogged);
		lblYouAreLogged.setFont(new Font("Tahoma", Font.ITALIC, 24));

		JButton LogOutButton = new JButton("Log Out");
		LogOutButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		LogOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPanel loginPanel = new LoginPanel(f);
				f.getContentPane().removeAll();
				f.getContentPane().add(loginPanel);
				f.repaint();
				f.revalidate();
				f.setVisible(true);
			}
		});
		LogOutButton.setFocusPainted(false);
		LogOutButton.setForeground(Color.DARK_GRAY);
		LogOutButton.setBackground(new Color(255, 165, 0));
		LogOutButton.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				Color.DARK_GRAY, null));
		LogOutButton.setBounds(1190, 5, 100, 35);
		topBar.add(LogOutButton);

		JButton ReturnButton = new JButton("Back");
		ReturnButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		ReturnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Member user = new Member();
				user = f.getSession();
				if (user.getRank() == 0) {
					PublicCalendar publicCalendar = new PublicCalendar(f);
					f.getContentPane().removeAll();
					f.getContentPane().add(publicCalendar);
					f.repaint();
					f.revalidate();
					f.setVisible(true);
				} else if (user.getRank() <= 4) {
					MemberCalendar memberCalendar = new MemberCalendar(f);
					f.getContentPane().removeAll();
					f.getContentPane().add(memberCalendar);
					f.repaint();
					f.revalidate();
					f.setVisible(true);
				} else {
					AdminCalendar adminCalendar = new AdminCalendar(f);
					f.getContentPane().removeAll();
					f.getContentPane().add(adminCalendar);
					f.repaint();
					f.revalidate();
					f.setVisible(true);
				}

			}
		});
		ReturnButton.setFocusPainted(false);
		ReturnButton.setForeground(Color.DARK_GRAY);
		ReturnButton.setBackground(new Color(255, 165, 0));
		ReturnButton.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				Color.DARK_GRAY, null));
		ReturnButton.setBounds(1085, 5, 100, 35);
		topBar.add(ReturnButton);

		JPanel account = new JPanel();
		account.setBorder(new LineBorder(new Color(0, 0, 0)));
		account.setBounds(35, 175, 400, 285);
		add(account);
		account.setLayout(null);

		JLabel lblAccountDetails = new JLabel("Account Details:");
		lblAccountDetails.setBounds(10, 10, 120, 20);
		account.add(lblAccountDetails);

		JLabel lblCreationDate = new JLabel("Creation Date:");
		lblCreationDate.setBounds(10, 50, 90, 20);
		account.add(lblCreationDate);

		creationDate = new JTextField();
		creationDate.setText(user.getCreationDate());
		creationDate.setEditable(false);
		creationDate.setBounds(127, 50, 250, 20);
		account.add(creationDate);
		creationDate.setColumns(10);

		JLabel lblRank = new JLabel("Rank:");
		lblRank.setBounds(10, 81, 90, 20);
		account.add(lblRank);

		rank = new JTextField();
		rank.setText(rankName + "\r\n");
		rank.setEditable(false);
		rank.setColumns(10);
		rank.setBounds(127, 81, 250, 20);
		account.add(rank);

		phoneNumber = new JTextField();
		phoneNumber.setText(user.getPhoneNumber() + "\r\n");
		phoneNumber.setEditable(false);
		phoneNumber.setColumns(10);
		phoneNumber.setBounds(127, 112, 250, 20);
		account.add(phoneNumber);

		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setBounds(10, 112, 90, 20);
		account.add(lblPhoneNumber);

		email = new JTextField();
		email.setText(user.getEmail());
		email.setEditable(false);
		email.setColumns(10);
		email.setBounds(127, 143, 250, 20);
		account.add(email);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 143, 90, 20);
		account.add(lblEmail);

		passportIC = new JTextField();
		passportIC.setText(RailFence.decrypt(user.getPass_icNo()));
		passportIC.setEditable(false);
		passportIC.setColumns(10);
		passportIC.setBounds(127, 174, 250, 20);
		account.add(passportIC);

		JLabel lblPassportIC = new JLabel("Passport/IC:");
		lblPassportIC.setBounds(10, 174, 90, 20);
		account.add(lblPassportIC);

		paymentMethod = new JTextField();
		paymentMethod.setText("Credit Card");
		paymentMethod.setEditable(false);
		paymentMethod.setColumns(10);
		paymentMethod.setBounds(127, 205, 250, 20);
		account.add(paymentMethod);

		JLabel lblPaymentMethod = new JLabel("Payment Method:");
		lblPaymentMethod.setBounds(10, 205, 120, 20);
		account.add(lblPaymentMethod);

		JButton changeDetails = new JButton("Change Details");
		changeDetails.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		changeDetails.setFont(new Font("Tahoma", Font.BOLD, 11));
		changeDetails.setForeground(Color.DARK_GRAY);
		changeDetails.setFocusPainted(false);
		changeDetails.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				Color.DARK_GRAY, null));
		changeDetails.setBackground(new Color(255, 165, 0));
		changeDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				newPhoneNumber.setEditable(true);
				newEmail.setEditable(true);
				newPassportIC.setEditable(true);
				newPaymentMethod.setEditable(true);

				String date = creationDate.getText();
				newCreationDate.setText(date);
				String ra = rank.getText();
				newRank.setText(ra);
				String phoneNum = phoneNumber.getText();
				newPhoneNumber.setText(phoneNum);
				String em = email.getText();
				newEmail.setText(em);
				String passIC = passportIC.getText();
				newPassportIC.setText(passIC);
				String pay = paymentMethod.getText();
				newPaymentMethod.setText(pay);

			}
		});
		changeDetails.setBounds(10, 236, 185, 35);
		account.add(changeDetails);

		JButton lockChanges = new JButton("Refresh");
		lockChanges.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lockChanges.setFont(new Font("Tahoma", Font.BOLD, 11));
		lockChanges.setFocusPainted(false);
		lockChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * newCreationDate.setEditable(false);
				 * newPhoneNumber.setEditable(false);
				 * newEmail.setEditable(false);
				 * newPassportIC.setEditable(false);
				 * newPaymentMethod.setEditable(false);
				 */
				Member userRefresh = new Member();
				userRefresh = f.getSession();
				String rankName = userRefresh.setRankName(userRefresh.getRank());
				rank.setText(rankName + "\r\n");
				phoneNumber.setText(userRefresh.getPhoneNumber() + "\r\n");
				email.setText(userRefresh.getEmail());
				passportIC.setText(userRefresh.getPass_icNo());

			}

		});
		lockChanges.setForeground(Color.DARK_GRAY);
		lockChanges.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				Color.DARK_GRAY, null));
		lockChanges.setBackground(new Color(255, 165, 0));
		lockChanges.setBounds(205, 236, 185, 35);
		account.add(lockChanges);

		JPanel editDetails = new JPanel();
		editDetails.setBorder(new LineBorder(new Color(0, 0, 0)));
		editDetails.setLayout(null);
		editDetails.setBounds(927, 175, 400, 285);
		add(editDetails);

		JLabel lblNewDetails = new JLabel("New Account Details:");
		lblNewDetails.setBounds(10, 10, 120, 20);
		editDetails.add(lblNewDetails);

		JLabel lblNewCreationDate = new JLabel("Creation Date:");
		lblNewCreationDate.setBounds(10, 50, 90, 20);
		editDetails.add(lblNewCreationDate);

		newCreationDate = new JTextField();
		newCreationDate.setEditable(false);
		newCreationDate.setColumns(10);
		newCreationDate.setBounds(127, 50, 250, 20);
		editDetails.add(newCreationDate);

		JLabel lblNewRank = new JLabel("Rank:");
		lblNewRank.setBounds(10, 81, 90, 20);
		editDetails.add(lblNewRank);

		newRank = new JTextField();
		newRank.setEditable(false);
		newRank.setColumns(10);
		newRank.setBounds(127, 81, 250, 20);
		editDetails.add(newRank);

		newPhoneNumber = new JTextField();
		newPhoneNumber.setEditable(false);
		newPhoneNumber.setColumns(10);
		newPhoneNumber.setBounds(127, 112, 250, 20);
		editDetails.add(newPhoneNumber);

		JLabel lblNewPhoneNumber = new JLabel("Phone Number:");
		lblNewPhoneNumber.setBounds(10, 112, 90, 20);
		editDetails.add(lblNewPhoneNumber);

		newEmail = new JTextField();
		newEmail.setEditable(false);
		newEmail.setColumns(10);
		newEmail.setBounds(127, 143, 250, 20);
		editDetails.add(newEmail);

		JLabel lblNewEmail = new JLabel("Email:");
		lblNewEmail.setBounds(10, 143, 90, 20);
		editDetails.add(lblNewEmail);

		newPassportIC = new JTextField();
		newPassportIC.setEditable(false);
		newPassportIC.setColumns(10);
		newPassportIC.setBounds(127, 174, 250, 20);
		editDetails.add(newPassportIC);

		JLabel lblNewPassportIC = new JLabel("Passport/IC:");
		lblNewPassportIC.setBounds(10, 174, 90, 20);
		editDetails.add(lblNewPassportIC);

		newPaymentMethod = new JTextField();
		newPaymentMethod.setEditable(false);
		newPaymentMethod.setColumns(10);
		newPaymentMethod.setBounds(127, 205, 250, 20);
		editDetails.add(newPaymentMethod);

		JLabel lblNewPaymentMethod = new JLabel("Payment Method:");
		lblNewPaymentMethod.setBounds(10, 205, 120, 20);
		editDetails.add(lblNewPaymentMethod);

		JButton confirmChanges = new JButton("Confirm Changes");
		confirmChanges
				.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		confirmChanges.setFont(new Font("Tahoma", Font.BOLD, 11));
		confirmChanges.setFocusPainted(false);
		confirmChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// String date = newCreationDate.getText();
				// creationDate.setText(date);
				// String ra = newRank.getText();
				// rank.setText(ra);

				String telNo = newPhoneNumber.getText();
				String em = newEmail.getText();
				String passIC = newPassportIC.getText();
				String passICEncrypt = RailFence.encrypt(passIC);
				String pay = newPaymentMethod.getText();

				try {
					Member userChangeDetails = new Member();
					userChangeDetails = f.getSession();

					String sql3 = "update Users set telNo='" + telNo
							+ "' , email='" + em + "', pass_IcNo='"
							+ passICEncrypt + "' where username='"
							+ userChangeDetails.getUsername() + "' ";
					DBConnectionManager.pstmt = DBConnectionManager.con
							.prepareStatement(sql3);
					DBConnectionManager.pstmt.execute();
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, e);
					e.printStackTrace();
				}
				//feedbackText.setText("Your new details have been changed.");
				JOptionPane.showMessageDialog(null,
						"Your new details have been changed.");

				// update Member variable
				Member userUpdateDetails = new Member();
				userUpdateDetails = f.getSession();
				String sql2 = "select * from Users where Username = '"
						+ userUpdateDetails.getUsername() + "'";

				try {
					DBConnectionManager.rs = DBConnectionManager.stmt
							.executeQuery(sql2);
					while (DBConnectionManager.rs.next()) {
						// userUpdateDetails.setFirstName(DBConnectionManager.rs.getString("firstName"));
						// userUpdateDetails.setLastName(DBConnectionManager.rs.getString("lastName"));
						userUpdateDetails.setEmail(DBConnectionManager.rs
								.getString("email"));
						userUpdateDetails.setPhoneNumber(DBConnectionManager.rs
								.getInt("telNo"));
						userUpdateDetails.setPass_icNo(DBConnectionManager.rs
								.getString("pass_icNo"));
						userUpdateDetails.setRank(DBConnectionManager.rs
								.getInt("rank"));

						f.setSession(userUpdateDetails);

					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		confirmChanges.setForeground(Color.DARK_GRAY);
		confirmChanges.setBackground(new Color(255, 165, 0));
		confirmChanges.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				Color.DARK_GRAY, null));
		confirmChanges.setBounds(205, 236, 185, 35);
		editDetails.add(confirmChanges);

		JButton resetChanges = new JButton("Reset Changes");
		resetChanges.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		resetChanges.setFont(new Font("Tahoma", Font.BOLD, 11));
		resetChanges.setFocusPainted(false);
		resetChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newPhoneNumber.setText("");
				newEmail.setText("");
				newPassportIC.setText("");
				newPaymentMethod.setText("");
				//feedbackText.setText("Successfully cleared all new details entered.");
				JOptionPane.showMessageDialog(null,
						"Successfully cleared all new details entered.");
			}
		});
		resetChanges.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				Color.DARK_GRAY, null));
		resetChanges.setBackground(new Color(255, 165, 0));
		resetChanges.setForeground(Color.DARK_GRAY);
		resetChanges.setBounds(10, 236, 185, 35);
		editDetails.add(resetChanges);

		JPanel miscDetails = new JPanel();
		miscDetails.setBorder(new LineBorder(new Color(0, 0, 0)));
		miscDetails.setBounds(447, 175, 470, 500);
		add(miscDetails);
		miscDetails.setLayout(null);

		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Member user = new Member();
				user = f.getSession();

				if (user.getRank() == 0) {
					PublicCalendar publicCalendar = new PublicCalendar(f);
					f.getContentPane().removeAll();
					f.getContentPane().add(publicCalendar);
					f.repaint();
					f.revalidate();
					f.setVisible(true);
				} else if (user.getRank() <= 4) {
					MemberCalendar memberCalendar = new MemberCalendar(f);
					f.getContentPane().removeAll();
					f.getContentPane().add(memberCalendar);
					f.repaint();
					f.revalidate();
					f.setVisible(true);
				} else {
					AdminCalendar adminCalendar = new AdminCalendar(f);
					f.getContentPane().removeAll();
					f.getContentPane().add(adminCalendar);
					f.repaint();
					f.revalidate();
					f.setVisible(true);
				}
			}
		});
		button.setIcon(new ImageIcon(AccountDetails.class
				.getResource("/polyfive/ui/images/p5cicon7575.png")));
		button.setBorder(null);
		button.setBounds(21, 21, 75, 75);
		add(button);

		super.setLayout();

	}
}
