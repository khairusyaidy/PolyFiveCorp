package polyfive.ui.memberpages;

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

	public PaymentPanel() {
		setSize(new Dimension(1366, 768));
		setLayout(null);

		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WelcomePanel welcomePanel = f.getWelcomePanel();
				f.getContentPane().removeAll();
				f.getContentPane().add(welcomePanel);
				f.repaint();
				f.revalidate();
				f.setVisible(true);
			}
		});

		JButton btnPayPal = new JButton("");
		btnPayPal.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPayPal.setBorder(null);
		btnPayPal.setIcon(new ImageIcon(PaymentPanel.class
				.getResource("/polyFive/ui/images/paypallogo.jpg")));
		btnPayPal.setForeground(Color.WHITE);
		btnPayPal.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnPayPal.setBackground(Color.WHITE);
		btnPayPal.setBounds(154, 224, 350, 220);
		add(btnPayPal);

		JButton btnCreditCard = new JButton("");
		btnCreditCard.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCreditCard.setBorder(null);
		btnCreditCard.setIcon(new ImageIcon(PaymentPanel.class
				.getResource("/polyFive/ui/images/rsz_credit-card-icon.jpg")));
		btnCreditCard.setForeground(Color.WHITE);
		btnCreditCard.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnCreditCard.setBackground(Color.WHITE);
		btnCreditCard.setBounds(514, 224, 350, 220);
		add(btnCreditCard);

		JButton btnNets = new JButton("");
		btnNets.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNets.setBorder(null);
		btnNets.setIcon(new ImageIcon(PaymentPanel.class
				.getResource("/polyFive/ui/images/large-news_2755.jpg")));
		btnNets.setForeground(Color.WHITE);
		btnNets.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNets.setBackground(Color.WHITE);
		btnNets.setBounds(874, 224, 360, 220);
		add(btnNets);

		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberCalendar memberCalendar = f.getMemberCalendar();
				f.getContentPane().removeAll();
				f.getContentPane().add(memberCalendar);
				f.repaint();
				f.revalidate();
				f.setVisible(true);
			}
		});
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setIcon(new ImageIcon(PaymentPanel.class
				.getResource("/polyFive/ui/images/p5cicon7575.png")));
		button.setBorder(null);
		button.setBounds(21, 21, 75, 75);
		add(button);

		JButton button_2 = new JButton("Back");
		button_2.setForeground(Color.DARK_GRAY);
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		button_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				Color.DARK_GRAY, null));
		button_2.setBackground(new Color(255, 165, 0));
		button_2.setBounds(21, 664, 150, 75);
		add(button_2);

		JLabel lblPleaseChooseYour = new JLabel(
				"Please choose your payment modes: ");
		lblPleaseChooseYour.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblPleaseChooseYour.setBounds(411, 153, 522, 45);
		add(lblPleaseChooseYour);

		super.setLayout();

	}

	public PaymentPanel(MainFrame frame) {
		this();
		f = frame;
		// TODO Auto-generated constructor stub
	}
}
