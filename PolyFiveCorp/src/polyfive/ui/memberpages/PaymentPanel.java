/*
 *Program Name : AddEvent.Java 
 *Purpose : Allows the User to choose the mode of payment.
 *
 *Authour: Timothy Yeo
 *Admin Number: 121107R
 *Module Group : IS1201
 *Last Modified : 29/1/2013
 *
 */
package polyfive.ui.memberpages;

import polyfive.entities.Member;
import polyfive.ui.adminpages.*;
import polyfive.ui.images.*;
import polyfive.ui.master.*;
import polyfive.ui.publicpages.*;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;

public class PaymentPanel extends MasterPanel {
	private MainFrame f = null;

	public PaymentPanel(MainFrame frame) {
		f = frame;
		setSize(new Dimension(1366, 768));
		setLayout(null);

		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WelcomePanel welcomePanel = new WelcomePanel(f);
				f.getContentPane().removeAll();
				f.getContentPane().add(welcomePanel);
				f.repaint();
				f.revalidate();
				f.setVisible(true);
			}
		});

		JButton btnCreditCard = new JButton("");
		btnCreditCard.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCreditCard.setBorder(null);
		btnCreditCard.setIcon(new ImageIcon(PaymentPanel.class
				.getResource("/polyFive/ui/images/rsz_credit-card-icon.jpg")));
		btnCreditCard.setForeground(Color.WHITE);
		btnCreditCard.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnCreditCard.setBackground(Color.WHITE);
		btnCreditCard.setBounds(347, 296, 350, 220);
		add(btnCreditCard);

		JButton btnNets = new JButton("");
		btnNets.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNets.setBorder(null);
		btnNets.setIcon(new ImageIcon(PaymentPanel.class
				.getResource("/polyFive/ui/images/large-news_2755.jpg")));
		btnNets.setForeground(Color.WHITE);
		btnNets.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNets.setBackground(Color.WHITE);
		btnNets.setBounds(759, 296, 360, 220);
		add(btnNets);

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
		button.setIcon(new ImageIcon(PaymentPanel.class
				.getResource("/polyFive/ui/images/p5cicon7575.png")));
		button.setBorder(null);
		button.setBounds(21, 21, 75, 75);
		add(button);

		JButton btnCancel = new JButton("Cancel");
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
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnCancel.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				Color.DARK_GRAY, null));
		btnCancel.setBackground(new Color(255, 165, 0));
		btnCancel.setBounds(21, 664, 150, 75);
		add(btnCancel);

		JLabel lblPleaseChooseYour = new JLabel(
				"Please choose your payment modes: ");
		lblPleaseChooseYour.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblPleaseChooseYour.setBounds(490, 200, 522, 45);
		add(lblPleaseChooseYour);

		super.setLayout();

	}
}
