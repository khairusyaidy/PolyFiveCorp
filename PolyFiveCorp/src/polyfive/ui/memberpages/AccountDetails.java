package polyfive.ui.memberpages;

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
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.border.EtchedBorder;

public class AccountDetails extends MasterPanel {
	private JTextField creationDate;
	private JTextField rank;
	private JTextField phoneNumber;
	private JTextField email;
	private JTextField passport_IC;
	private JTextField paymentMethod;
	private JTextField newDetails;
	private JTextField newRank;
	private JTextField newPhoneNumber;
	private JTextField newEmail;
	private JTextField newPassport_IC;
	private JTextField newPaymentMethod;
	private MainFrame f = null;

	/**
	 * Create the panel.
	 */
	public AccountDetails(MainFrame frame) {
		f = frame;
		setSize(new Dimension(1366, 768));
		setLayout(null);

		JPanel topBar = new JPanel();
		topBar.setBounds(19, 105, 1292, 45);
		add(topBar);
		topBar.setLayout(null);

		JLabel lblYouAreLogged = new JLabel("You are logged in as:");
		lblYouAreLogged.setBounds(10, 5, 790, 35);
		topBar.add(lblYouAreLogged);
		lblYouAreLogged.setFont(new Font("Tahoma", Font.PLAIN, 24));

		JButton LogOutButton = new JButton("Log Out");
		LogOutButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		LogOutButton.setFocusPainted(false);
		LogOutButton.setForeground(Color.DARK_GRAY);
		LogOutButton.setBackground(new Color(255, 165, 0));
		LogOutButton.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				Color.DARK_GRAY, null));
		LogOutButton.setBounds(1177, 5, 100, 35);
		topBar.add(LogOutButton);

		JLabel lblNewLabel = new JLabel("Khai");
		lblNewLabel.setForeground(new Color(210, 105, 30));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(233, 2, 73, 40);
		topBar.add(lblNewLabel);

		JPanel Account = new JPanel();
		Account.setBorder(new LineBorder(new Color(0, 0, 0)));
		Account.setBounds(21, 175, 400, 469);
		add(Account);
		Account.setLayout(null);

		JLabel lblAccountDetails = new JLabel("Account Details:");
		lblAccountDetails.setBounds(10, 10, 120, 20);
		Account.add(lblAccountDetails);

		JLabel lblCreationDate = new JLabel("Creation Date:");
		lblCreationDate.setBounds(10, 50, 90, 20);
		Account.add(lblCreationDate);

		creationDate = new JTextField();
		creationDate.setText("2 November 2011");
		creationDate.setEditable(false);
		creationDate.setBounds(118, 50, 259, 20);
		Account.add(creationDate);
		creationDate.setColumns(10);

		JLabel lblRank = new JLabel("Rank:");
		lblRank.setBounds(10, 81, 90, 20);
		Account.add(lblRank);

		rank = new JTextField();
		rank.setText("Bronze\r\n");
		rank.setEditable(false);
		rank.setColumns(10);
		rank.setBounds(118, 81, 259, 20);
		Account.add(rank);

		phoneNumber = new JTextField();
		phoneNumber.setText("81590435\r\n");
		phoneNumber.setEditable(false);
		phoneNumber.setColumns(10);
		phoneNumber.setBounds(118, 112, 259, 20);
		Account.add(phoneNumber);

		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setBounds(10, 112, 90, 20);
		Account.add(lblPhoneNumber);

		email = new JTextField();
		email.setText("p5c@polyfive.org");
		email.setEditable(false);
		email.setColumns(10);
		email.setBounds(118, 143, 259, 20);
		Account.add(email);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 143, 90, 20);
		Account.add(lblEmail);

		passport_IC = new JTextField();
		passport_IC.setText("S12345678K");
		passport_IC.setEditable(false);
		passport_IC.setColumns(10);
		passport_IC.setBounds(118, 174, 259, 20);
		Account.add(passport_IC);

		JLabel lblPassport_IC = new JLabel("Passport/IC:");
		lblPassport_IC.setBounds(10, 174, 90, 20);
		Account.add(lblPassport_IC);

		paymentMethod = new JTextField();
		paymentMethod.setText("Credit Card");
		paymentMethod.setEditable(false);
		paymentMethod.setColumns(10);
		paymentMethod.setBounds(118, 205, 259, 20);
		Account.add(paymentMethod);

		JButton changeDetails = new JButton("Change Details");
		changeDetails.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		changeDetails.setForeground(Color.DARK_GRAY);
		changeDetails.setFocusPainted(false);
		changeDetails.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				Color.DARK_GRAY, null));
		changeDetails.setBackground(new Color(255, 165, 0));
		changeDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		changeDetails.setBounds(10, 423, 185, 35);
		Account.add(changeDetails);

		JButton lockChanges = new JButton("Lock Changes");
		lockChanges.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lockChanges.setFocusPainted(false);
		lockChanges.setForeground(Color.DARK_GRAY);
		lockChanges.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				Color.DARK_GRAY, null));
		lockChanges.setBackground(new Color(255, 165, 0));
		lockChanges.setBounds(205, 423, 185, 35);
		Account.add(lockChanges);

		JLabel label = new JLabel("Payment Method:");
		label.setBounds(10, 205, 108, 20);
		Account.add(label);

		JPanel editDetails = new JPanel();
		editDetails.setBorder(new LineBorder(new Color(0, 0, 0)));
		editDetails.setLayout(null);
		editDetails.setBounds(431, 175, 400, 469);
		add(editDetails);

		JLabel lblNewDetails = new JLabel("New Account Details:");
		lblNewDetails.setBounds(10, 10, 120, 20);
		editDetails.add(lblNewDetails);

		JLabel lblNewCreationDate = new JLabel("Creation Date:");
		lblNewCreationDate.setBounds(10, 50, 90, 20);
		editDetails.add(lblNewCreationDate);

		newDetails = new JTextField();
		newDetails.setText("2 November 2011\r\n");
		newDetails.setEditable(false);
		newDetails.setColumns(10);
		newDetails.setBounds(120, 50, 259, 20);
		editDetails.add(newDetails);

		JLabel lblNewRank = new JLabel("Rank:");
		lblNewRank.setBounds(10, 81, 90, 20);
		editDetails.add(lblNewRank);

		newRank = new JTextField();
		newRank.setText("Bronze");
		newRank.setEditable(false);
		newRank.setColumns(10);
		newRank.setBounds(120, 81, 259, 20);
		editDetails.add(newRank);

		newPhoneNumber = new JTextField();
		newPhoneNumber.setColumns(10);
		newPhoneNumber.setBounds(120, 112, 259, 20);
		editDetails.add(newPhoneNumber);

		JLabel lblNewPhoneNumber = new JLabel("Phone Number:");
		lblNewPhoneNumber.setBounds(10, 112, 90, 20);
		editDetails.add(lblNewPhoneNumber);

		newEmail = new JTextField();
		newEmail.setColumns(10);
		newEmail.setBounds(120, 143, 259, 20);
		editDetails.add(newEmail);

		JLabel lblNewEmail = new JLabel("Email:");
		lblNewEmail.setBounds(10, 143, 90, 20);
		editDetails.add(lblNewEmail);

		newPassport_IC = new JTextField();
		newPassport_IC.setColumns(10);
		newPassport_IC.setBounds(118, 174, 259, 20);
		editDetails.add(newPassport_IC);

		JLabel lblNewPassport_IC = new JLabel("Passport/IC:");
		lblNewPassport_IC.setBounds(10, 174, 90, 20);
		editDetails.add(lblNewPassport_IC);

		newPaymentMethod = new JTextField();
		newPaymentMethod.setColumns(10);
		newPaymentMethod.setBounds(120, 205, 259, 20);
		editDetails.add(newPaymentMethod);

		JLabel lblNewPaymentMethod = new JLabel("Payment Method:");
		lblNewPaymentMethod.setBounds(10, 205, 108, 20);
		editDetails.add(lblNewPaymentMethod);

		JButton button = new JButton("Confirm Changes");
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setFocusPainted(false);
		button.setForeground(Color.DARK_GRAY);
		button.setBackground(new Color(255, 165, 0));
		button.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				Color.DARK_GRAY, null));
		button.setBounds(205, 425, 185, 35);
		editDetails.add(button);

		JButton button_1 = new JButton("Reset Changes");
		button_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_1.setFocusPainted(false);
		button_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				Color.DARK_GRAY, null));
		button_1.setBackground(new Color(255, 165, 0));
		button_1.setForeground(Color.DARK_GRAY);
		button_1.setBounds(10, 425, 185, 35);
		editDetails.add(button_1);

		JPanel miscDetails = new JPanel();
		miscDetails.setBorder(new LineBorder(new Color(0, 0, 0)));
		miscDetails.setBounds(841, 175, 470, 469);
		add(miscDetails);
		miscDetails.setLayout(null);

		JButton btnTransactionHistory = new JButton("Transaction History");
		btnTransactionHistory.setCursor(Cursor
				.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnTransactionHistory.setFocusPainted(false);
		btnTransactionHistory.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				Color.DARK_GRAY, null));
		btnTransactionHistory.setBackground(new Color(255, 165, 0));
		btnTransactionHistory.setForeground(Color.DARK_GRAY);
		btnTransactionHistory.setBounds(20, 11, 205, 35);
		miscDetails.add(btnTransactionHistory);

		JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.setCursor(Cursor
				.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnChangePassword.setFocusPainted(false);
		btnChangePassword.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				Color.DARK_GRAY, null));
		btnChangePassword.setBackground(new Color(255, 165, 0));
		btnChangePassword.setForeground(Color.DARK_GRAY);
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnChangePassword.setBounds(235, 11, 205, 35);
		miscDetails.add(btnChangePassword);

		JButton btnCurrentBookings = new JButton("Current Bookings\r\n");
		btnCurrentBookings.setCursor(Cursor
				.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCurrentBookings.setFocusPainted(false);
		btnCurrentBookings.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				Color.DARK_GRAY, null));
		btnCurrentBookings.setBackground(new Color(255, 165, 0));
		btnCurrentBookings.setForeground(Color.DARK_GRAY);
		btnCurrentBookings.setBounds(20, 70, 205, 35);
		miscDetails.add(btnCurrentBookings);

		JButton btnUpgradeAccount = new JButton("Upgrade Account\r\n");
		btnUpgradeAccount.setCursor(Cursor
				.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpgradeAccount.setFocusPainted(false);
		btnUpgradeAccount.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				Color.DARK_GRAY, null));
		btnUpgradeAccount.setBackground(new Color(255, 165, 0));
		btnUpgradeAccount.setForeground(Color.DARK_GRAY);
		btnUpgradeAccount.setBounds(235, 70, 205, 35);
		miscDetails.add(btnUpgradeAccount);

		JPanel dynamicArea = new JPanel();
		dynamicArea.setBounds(20, 179, 420, 252);
		miscDetails.add(dynamicArea);
		dynamicArea.setLayout(null);

		JTextArea textArea = new JTextArea();
		textArea.setText("Displays an advertisement at first, but dynamically changes area to a table/graph for transaction history, three text boxes and a button for password changes, a table for current bookings, and radio buttons and a button for upgrading account.");
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setBorder(new LineBorder(new Color(0, 0, 0)));
		textArea.setBounds(0, 0, 420, 250);
		dynamicArea.add(textArea);

		JButton button_2 = new JButton("Back");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberCalendar memberCalendar = new MemberCalendar(f);
				f.getContentPane().removeAll();
				f.getContentPane().add(memberCalendar);
				f.repaint();
				f.revalidate();
				f.setVisible(true);

			}
		});
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		button_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_2.setForeground(Color.DARK_GRAY);
		button_2.setFocusPainted(false);
		button_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				Color.DARK_GRAY, null));
		button_2.setBackground(new Color(255, 165, 0));
		button_2.setBounds(21, 664, 150, 75);
		add(button_2);

		JButton button_3 = new JButton("");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberCalendar memberCalendar =new MemberCalendar(f);
				f.getContentPane().removeAll();
				f.getContentPane().add(memberCalendar);
				f.repaint();
				f.revalidate();
				f.setVisible(true);
			}
		});
		button_3.setIcon(new ImageIcon(AccountDetails.class
				.getResource("/polyFive/ui/images/p5cicon7575.png")));
		button_3.setBorder(null);
		button_3.setBounds(21, 21, 75, 75);
		add(button_3);

		super.setLayout();

	}


}
