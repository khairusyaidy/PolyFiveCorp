/*
 *Program Name : AddEvent.Java 
 *Purpose : Allows the customer to have a breif view of their purchase.
 *
 *Authour: Muhammad Khairyl Rusyaidy, Timothy Yeo
 *Admin Number: 120258L, 121107R
 *Module Group : IS1201
 *Last Modified : 29/1/2013
 *
 */
package polyfive.ui.memberpages;

import polyfive.entities.*;
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
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PaymentDetails extends MasterPanel {
	private MainFrame f;
	private JTextField tfEventName;
	private JTextField tfNumberOfTickets;
	private JTextField tfTotalCost;

	/**
	 * Create the panel.
	 */
	public PaymentDetails(MainFrame frame) {
		f = frame;
		setSize(new Dimension(1366, 768));
		setLayout(null);

		BuyTickets buyTickets = new BuyTickets();
		buyTickets = f.getBuyTickets();

		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Member user = new Member();
				user = f.getSession();
				if (user.getRank() <= 4) {
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
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setIcon(new ImageIcon(PaymentDetails.class
				.getResource("/polyFive/ui/images/p5cicon7575.png")));
		button.setBorder(null);
		button.setBounds(21, 21, 75, 75);
		add(button);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				Color.DARK_GRAY, null));
		btnCancel.addActionListener(new ActionListener() {
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
		btnCancel.setForeground(Color.DARK_GRAY);
		btnCancel.setBackground(new Color(255, 165, 0));
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnCancel.setBounds(21, 664, 150, 75);
		add(btnCancel);

		JButton btnNext = new JButton("Next");
		btnNext.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				Color.DARK_GRAY, null));
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PaymentPanel paymentPanel = new PaymentPanel(f);
				f.getContentPane().removeAll();
				f.getContentPane().add(paymentPanel);
				f.repaint();
				f.revalidate();
				f.setVisible(true);
			}
		});
		btnNext.setForeground(Color.DARK_GRAY);
		btnNext.setBackground(new Color(255, 165, 0));
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNext.setBounds(1202, 656, 150, 75);
		add(btnNext);

		JLabel lblPaymentDetails = new JLabel("Payment Details");
		lblPaymentDetails.setForeground(new Color(0, 0, 0));
		lblPaymentDetails.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblPaymentDetails.setBounds(447, 261, 292, 47);
		add(lblPaymentDetails);

		JLabel lblEventName = new JLabel("Event Name:");
		lblEventName.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblEventName.setBounds(447, 363, 208, 47);
		add(lblEventName);

		JLabel lblNumberOfTickets = new JLabel("Number of Tickets:");
		lblNumberOfTickets.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNumberOfTickets.setBounds(447, 421, 208, 47);
		add(lblNumberOfTickets);

		JLabel lblTotalCost = new JLabel("Total Cost:");
		lblTotalCost.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblTotalCost.setBounds(447, 479, 208, 47);
		add(lblTotalCost);

		EventAttributes eventAttributes = new EventAttributes();
		eventAttributes = f.getStoreEvents();
		final int eventId = eventAttributes.getEventId();
		String name = eventAttributes.getEventName();
		tfEventName = new JTextField(name);
		tfEventName.setFont(new Font("Tahoma", Font.PLAIN, 19));
		tfEventName.setEditable(false);
		tfEventName.setBounds(665, 363, 344, 47);
		add(tfEventName);
		tfEventName.setColumns(10);

		tfNumberOfTickets = new JTextField();
		tfNumberOfTickets.setText(buyTickets.getGetTickets());
		tfNumberOfTickets.setFont(new Font("Tahoma", Font.PLAIN, 19));
		tfNumberOfTickets.setEditable(false);
		tfNumberOfTickets.setBounds(665, 421, 344, 47);
		add(tfNumberOfTickets);
		tfNumberOfTickets.setColumns(10);

		tfTotalCost = new JTextField();
		tfTotalCost.setText(buyTickets.getGetPRice());
		tfTotalCost.setFont(new Font("Tahoma", Font.PLAIN, 19));
		tfTotalCost.setEditable(false);
		tfTotalCost.setBounds(665, 483, 344, 47);
		add(tfTotalCost);
		tfTotalCost.setColumns(10);

		super.setLayout();

	}
}
