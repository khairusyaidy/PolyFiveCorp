package polyfive.ui.adminpages;

import polyfive.entities.Member;
import polyfive.entities.dao.DBConnectionManager;
import polyfive.ui.adminpages.*;
import polyfive.ui.images.*;
import polyfive.ui.master.*;
import polyfive.ui.publicpages.*;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.sql.SQLException;

import javax.swing.JPasswordField;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;

public class AdminAccountDetails extends JPanel {
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
	private JTextField feedbackText;
	private JTextField feedbackText2;

	/**
	 * Create the panel.
	 */

	public AdminAccountDetails(MainFrame frame) {
		f = frame;
		DBConnectionManager.getConnection();

		Member editUser = new Member();
		editUser = f.getEditAccountSession();
		String username = editUser.getUsername();
		int rankNo = editUser.getRank();
		String rankName = editUser.setRankName(rankNo);

		String sql = "select * from Users where Username = '" + username + "'";
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
		panel.setBounds(445, 471, 400, 204);
		add(panel);
		panel.setLayout(null);

		JButton btnGoldMember = new JButton("Gold Member\r\n");
		btnGoldMember.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				Color.DARK_GRAY, null));
		btnGoldMember.setFont(new Font("Tahoma", Font.PLAIN, 13));
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
		currentMember.setText("Basic Member\r\n");
		currentMember.setBounds(140, 147, 240, 20);
		panel.add(currentMember);
		currentMember.setColumns(10);

		JLabel lblCurrentMember = new JLabel("You are currently a:");
		lblCurrentMember.setBounds(15, 147, 115, 14);
		panel.add(lblCurrentMember);

		upgradingTo = new JTextField();
		upgradingTo.setText("Basic Member\r\n");
		upgradingTo.setEditable(false);
		upgradingTo.setColumns(10);
		upgradingTo.setBounds(140, 173, 240, 20);
		panel.add(upgradingTo);

		JLabel lblUpgradingTo = new JLabel("Upgrading to:");
		lblUpgradingTo.setBounds(15, 176, 115, 14);
		panel.add(lblUpgradingTo);

		JPanel accountManagement = new JPanel();
		accountManagement.setBorder(new LineBorder(new Color(0, 0, 0)));
		accountManagement.setBounds(35, 559, 400, 116);
		add(accountManagement);
		accountManagement.setLayout(null);

		JLabel lblConfirmNew = new JLabel("Warning ! Once account is deleted, it cannot be retrieved.");
		lblConfirmNew.setForeground(Color.RED);
		lblConfirmNew.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblConfirmNew.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirmNew.setBounds(10, 24, 368, 35);
		accountManagement.add(lblConfirmNew);

		JButton confirmPasswords = new JButton("Delete");
		confirmPasswords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int reply = JOptionPane.showConfirmDialog(null,  " Are you sure you want to delete this account ? ");
				if (reply == JOptionPane.YES_OPTION){
					Member deleteUser = new Member();
					deleteUser = f.getEditAccountSession();
					String username = deleteUser.getUsername();
					String sql = "DELETE FROM users WHERE username ='"+username+"'";
					try {
						//DBConnectionManager.rs = DBConnectionManager.stmt.execute(sql);
						DBConnectionManager.pstmt = DBConnectionManager.con
								.prepareStatement(sql);
						DBConnectionManager.pstmt.execute();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						System.out.println(e1);
						e1.printStackTrace();
					}	
					JOptionPane.showMessageDialog(null, "User is deleted");
					
					UserSetting userSetting= new UserSetting(f);
					f.getContentPane().removeAll();
					f.getContentPane().add(userSetting);
					f.repaint();
					f.revalidate();
					f.setVisible(true);
					
					
				}
				
			}
		});


		confirmPasswords.setForeground(Color.DARK_GRAY);
		confirmPasswords.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				Color.DARK_GRAY, null));
		confirmPasswords.setBackground(new Color(255, 165, 0));
		confirmPasswords.setBounds(244, 70, 146, 35);
		accountManagement.add(confirmPasswords);

		JLabel lblPasswords = new JLabel("Delete Account");
		lblPasswords.setBounds(10, 11, 116, 14);
		accountManagement.add(lblPasswords);

		JLabel lblPoly5Corp = new JLabel("POLYFIVE CORP");
		lblPoly5Corp.setBounds(35, 30, 185, 35);
		lblPoly5Corp.setFont(new Font("Tahoma", Font.PLAIN, 24));
		add(lblPoly5Corp);

		JComboBox chooseLanguage = new JComboBox();
		chooseLanguage.setBounds(1120, 30, 225, 45);
		chooseLanguage.setModel(new DefaultComboBoxModel(new String[] {
				"Select Language", "English", "Tamil", "Malay", "Mandarin" }));
		add(chooseLanguage);

		JPanel topBar = new JPanel();
		topBar.setBounds(35, 90, 1292, 45);
		add(topBar);
		topBar.setLayout(null);

		JLabel lblYouAreLogged = new JLabel("You are editing : "
				+ editUser.getFirstName() + " " + editUser.getLastName() + "'s ("
				+ rankName + ") account");
		lblYouAreLogged.setBounds(5, 5, 800, 35);
		topBar.add(lblYouAreLogged);
		lblYouAreLogged.setFont(new Font("Tahoma", Font.PLAIN, 24));

		JButton LogOutButton = new JButton("Log Out");
		LogOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WelcomePanel welcomePanel = new WelcomePanel(f);
				f.getContentPane().removeAll();
				f.getContentPane().add(welcomePanel);
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
		ReturnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserSetting userSetting = new UserSetting(f);
				f.getContentPane().removeAll();
				f.getContentPane().add(userSetting);
				f.repaint();
				f.revalidate();
				f.setVisible(true);
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
		account.setBounds(35, 175, 400, 373);
		add(account);
		account.setLayout(null);

		JLabel lblAccountDetails = new JLabel("Account Details:");
		lblAccountDetails.setBounds(10, 10, 120, 20);
		account.add(lblAccountDetails);

		JLabel lblCreationDate = new JLabel("Creation Date:");
		lblCreationDate.setBounds(10, 50, 90, 20);
		account.add(lblCreationDate);

		creationDate = new JTextField();
		creationDate.setText(editUser.getCreationDate());
		creationDate.setEditable(false);
		creationDate.setBounds(157, 50, 220, 20);
		account.add(creationDate);
		creationDate.setColumns(10);

		JLabel lblRank = new JLabel("Rank:");
		lblRank.setBounds(10, 81, 90, 20);
		account.add(lblRank);

		rank = new JTextField();
		rank.setText(rankName + "\r\n");
		rank.setEditable(false);
		rank.setColumns(10);
		rank.setBounds(157, 81, 220, 20);
		account.add(rank);

		phoneNumber = new JTextField();
		phoneNumber.setText(editUser.getPhoneNumber() + "\r\n");
		phoneNumber.setEditable(false);
		phoneNumber.setColumns(10);
		phoneNumber.setBounds(157, 112, 220, 20);
		account.add(phoneNumber);

		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setBounds(10, 112, 90, 20);
		account.add(lblPhoneNumber);

		email = new JTextField();
		email.setText(editUser.getEmail());
		email.setEditable(false);
		email.setColumns(10);
		email.setBounds(157, 143, 220, 20);
		account.add(email);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 143, 90, 20);
		account.add(lblEmail);

		passportIC = new JTextField();
		passportIC.setText(editUser.getPass_icNo());
		passportIC.setEditable(false);
		passportIC.setColumns(10);
		passportIC.setBounds(157, 174, 220, 20);
		account.add(passportIC);

		JLabel lblPassportIC = new JLabel("Passport/IC:");
		lblPassportIC.setBounds(10, 174, 90, 20);
		account.add(lblPassportIC);

		paymentMethod = new JTextField();
		paymentMethod.setText("Credit Card");
		paymentMethod.setEditable(false);
		paymentMethod.setColumns(10);
		paymentMethod.setBounds(157, 205, 220, 20);
		account.add(paymentMethod);

		JLabel lblPaymentMethod = new JLabel("Payment Method:");
		lblPaymentMethod.setBounds(10, 205, 90, 20);
		account.add(lblPaymentMethod);

		JButton changeDetails = new JButton("Change Details");
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
		changeDetails.setBounds(10, 301, 185, 35);
		account.add(changeDetails);

		JButton lockChanges = new JButton("Refresh");
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
				userRefresh = f.getEditAccountSession();
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
		lockChanges.setBounds(205, 301, 185, 35);
		account.add(lockChanges);

		JPanel editDetails = new JPanel();
		editDetails.setBorder(new LineBorder(new Color(0, 0, 0)));
		editDetails.setLayout(null);
		editDetails.setBounds(445, 175, 400, 285);
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
		lblNewPaymentMethod.setBounds(10, 205, 90, 20);
		editDetails.add(lblNewPaymentMethod);

		JButton confirmChanges = new JButton("Confirm Changes");
		confirmChanges.setFocusPainted(false);
		confirmChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// String date = newCreationDate.getText();
				// creationDate.setText(date);
				// String ra = newRank.getText();
				// rank.setText(ra);

				String telNo = newPhoneNumber.getText();
				// phoneNumber.setText(phoneNum);
				String em = newEmail.getText();
				// email.setText(em);
				String passIC = newPassportIC.getText();
				// passportIC.setText(passIC);
				String pay = newPaymentMethod.getText();
				// paymentMethod.setText(pay);

				try {
					Member userChangeDetails = new Member();
					userChangeDetails = f.getEditAccountSession();

					String sql3 = "update Users set telNo='" + telNo
							+ "' , email='" + em + "', pass_IcNo='" + passIC
							+ "' where username='"
							+ userChangeDetails.getUsername() + "' ";
					DBConnectionManager.pstmt = DBConnectionManager.con
							.prepareStatement(sql3);
					DBConnectionManager.pstmt.execute();
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, e);
					e.printStackTrace();
				}
				feedbackText.setText("Your new details have been changed.");

				// update Member variable
				Member userUpdateDetails = new Member();
				userUpdateDetails = f.getEditAccountSession();
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

						f.setEditAccountSession(userUpdateDetails);

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
		resetChanges.setFocusPainted(false);
		resetChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newPhoneNumber.setText("");
				newEmail.setText("");
				newPassportIC.setText("");
				newPaymentMethod.setText("");
				feedbackText
						.setText("Successfully cleared all new details entered.");
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
		miscDetails.setBounds(855, 175, 470, 500);
		add(miscDetails);
		miscDetails.setLayout(null);

		JLabel lblTransactionHistory = new JLabel("Transaction History:");
		lblTransactionHistory.setBounds(20, 11, 145, 14);
		miscDetails.add(lblTransactionHistory);

		JLabel lblCurrentBookings = new JLabel("Current Bookings:");
		lblCurrentBookings.setBounds(20, 201, 120, 14);
		miscDetails.add(lblCurrentBookings);

		JPanel transactionHistory = new JPanel();
		transactionHistory.setBorder(new LineBorder(new Color(0, 0, 0)));
		transactionHistory.setBounds(20, 36, 425, 154);
		miscDetails.add(transactionHistory);
		transactionHistory.setLayout(null);

		JPanel currentBookings = new JPanel();
		currentBookings.setBorder(new LineBorder(new Color(0, 0, 0)));
		currentBookings.setBounds(20, 226, 425, 154);
		miscDetails.add(currentBookings);
		currentBookings.setLayout(new GridLayout(1, 0, 0, 0));

		feedbackText = new JTextField();
		feedbackText.setEditable(false);
		feedbackText.setBounds(20, 391, 425, 20);
		miscDetails.add(feedbackText);
		feedbackText.setColumns(10);
		
		feedbackText2 = new JTextField();
		feedbackText2.setEditable(false);
		feedbackText2.setColumns(10);
		feedbackText2.setBounds(20, 422, 425, 20);
		miscDetails.add(feedbackText2);

		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(AdminAccountDetails.class
				.getResource("/polyfive/ui/images/p5cbg.png")));
		background.setBounds(0, 0, 1366, 768);
		add(background);

	}
}
