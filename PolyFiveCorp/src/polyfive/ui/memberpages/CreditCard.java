package polyfive.ui.memberpages;

import polyfive.entities.Member;
import polyfive.ui.adminpages.*;
import polyfive.ui.images.*;
import polyfive.ui.master.*;
import polyfive.ui.publicpages.*;

import java.awt.Cursor;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class CreditCard extends MasterPanel {
	private MainFrame f;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public CreditCard(MainFrame frame) {
		f = frame;
		setSize(new Dimension(1366, 768));
		setLayout(null);

		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Member user = new Member();
				user = f.getSession();
				if(user.getRank() <= 4 ){
				MemberCalendar memberCalendar = new MemberCalendar(f);
				f.getContentPane().removeAll();
				f.getContentPane().add(memberCalendar);
				f.repaint();
				f.revalidate();
				f.setVisible(true);
				}
				else {
					AdminCalendar adminCalendar = new AdminCalendar(f);
					f.getContentPane().removeAll();
					f.getContentPane().add(adminCalendar);
					f.repaint();
					f.revalidate();
					f.setVisible(true);
				}
			}
		});
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setIcon(new ImageIcon(CreditCard.class
				.getResource("/polyFive/ui/images/p5cicon7575.png")));
		button.setBorder(null);
		button.setBounds(21, 21, 75, 75);
		add(button);

		JButton btnBack = new JButton("Back");
		btnBack.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				Color.DARK_GRAY, null));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SeatAllocation seatAllocation = new SeatAllocation(f);
				f.getContentPane().removeAll();
				f.getContentPane().add(seatAllocation);
				f.repaint();
				f.revalidate();
				f.setVisible(true);
			}
		});
		btnBack.setForeground(Color.DARK_GRAY);
		btnBack.setBackground(new Color(255, 165, 0));
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnBack.setBounds(21, 664, 150, 75);
		add(btnBack);

		JButton btnMakePayment = new JButton("Make Payment");
		btnMakePayment.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				Color.DARK_GRAY, null));
		btnMakePayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PaymentPanel paymentPanel = new PaymentPanel(f);
				f.getContentPane().removeAll();
				f.getContentPane().add(paymentPanel);
				f.repaint();
				f.revalidate();
				f.setVisible(true);
			}
		});
		btnMakePayment.setForeground(Color.DARK_GRAY);
		btnMakePayment.setBackground(new Color(255, 165, 0));
		btnMakePayment.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnMakePayment.setBounds(1040, 637, 225, 102);
		add(btnMakePayment);
		
		textField = new JTextField();
		textField.setBounds(632, 252, 321, 35);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNameOnCreditcard = new JLabel("Name on CreditCard:");
		lblNameOnCreditcard.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNameOnCreditcard.setBounds(488, 251, 134, 35);
		add(lblNameOnCreditcard);
		
		JLabel lblCreditcardNumber = new JLabel("CreditCard Number:");
		lblCreditcardNumber.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCreditcardNumber.setBounds(488, 297, 134, 35);
		add(lblCreditcardNumber);
		
		textField_1 = new JTextField();
		textField_1.setBounds(632, 298, 321, 35);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblDateOfExpiry = new JLabel("Date Of Expiry:");
		lblDateOfExpiry.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDateOfExpiry.setBounds(488, 343, 134, 35);
		add(lblDateOfExpiry);
		
		textField_2 = new JTextField();
		textField_2.setBounds(632, 344, 321, 35);
		add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblCvvcvv = new JLabel("CVV/CVV2:");
		lblCvvcvv.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCvvcvv.setBounds(488, 389, 134, 40);
		add(lblCvvcvv);
		
		textField_3 = new JTextField();
		textField_3.setBounds(632, 390, 321, 35);
		add(textField_3);
		textField_3.setColumns(10);

		super.setLayout();

	}
}
