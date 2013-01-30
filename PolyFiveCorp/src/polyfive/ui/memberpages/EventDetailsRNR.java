package polyfive.ui.memberpages;

import polyfive.entities.Member;
import polyfive.ui.adminpages.AdminCalendar;
import polyfive.ui.master.*;

import java.awt.Color;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.io.IOException;

import javax.swing.border.EtchedBorder;

public class EventDetailsRNR extends MasterPanel {
	private JTextField txtTineshsRockNRoll;
	private JTextField txtRockNRoll;
	private MainFrame f = null;

	/**
	 * Create the panel.
	 */
	public EventDetailsRNR(MainFrame frame) {
		Member user = new Member();
		user = f.getSession();
		f = frame;
		setSize(new Dimension(1366, 768));

		setForeground(Color.BLACK);
		setBorder(new LineBorder(new Color(0, 0, 0), 0));
		setBackground(Color.WHITE);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setLayout(null);
		panel.setForeground(new Color(255, 165, 0));
		panel.setBorder(null);
		panel.setBackground(new Color(255, 165, 0));
		panel.setBounds(62, 117, 1247, 534);

		add(panel);

		txtTineshsRockNRoll = new JTextField();
		txtTineshsRockNRoll.setEditable(false);
		txtTineshsRockNRoll.setBackground(new Color(255, 255, 255));
		txtTineshsRockNRoll.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTineshsRockNRoll
				.setText("Tinesh's Rock N Roll Concert\r\n27 November - 2 December 2012, Marina Bay Sands\r\n(Standing)");
		txtTineshsRockNRoll.setBounds(37, 168, 1200, 50);
		panel.add(txtTineshsRockNRoll);
		txtTineshsRockNRoll.setColumns(10);

		txtRockNRoll = new JTextField();
		txtRockNRoll.setBackground(new Color(255, 255, 255));
		txtRockNRoll.setForeground(new Color(0, 0, 0));
		txtRockNRoll.setEditable(false);
		txtRockNRoll.setHorizontalAlignment(SwingConstants.LEFT);
		txtRockNRoll.setAlignmentY(Component.TOP_ALIGNMENT);
		txtRockNRoll.setAlignmentX(Component.LEFT_ALIGNMENT);
		txtRockNRoll.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtRockNRoll.setText("Come Rock N Roll with Tinesh");
		txtRockNRoll.setBounds(37, 257, 1200, 200);
		panel.add(txtRockNRoll);
		txtRockNRoll.setColumns(10);

		JButton btnProceedToPayment = new JButton("Buy Ticket(s)");
		btnProceedToPayment.setFocusPainted(false);
		btnProceedToPayment.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				Color.DARK_GRAY, null));
		btnProceedToPayment.setCursor(Cursor
				.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnProceedToPayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TicketsPurchase ticketsPurchase = new TicketsPurchase(f);
				f.getContentPane().removeAll();
				f.getContentPane().add(ticketsPurchase);
				f.repaint();
				f.revalidate();
				f.setVisible(true);
			}
		});
		btnProceedToPayment.setForeground(Color.DARK_GRAY);
		btnProceedToPayment.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnProceedToPayment.setBackground(new Color(255, 165, 0));
		btnProceedToPayment.setBounds(510, 468, 254, 55);
		panel.add(btnProceedToPayment);

		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] cmd = new String[5];
				cmd[0] = "cmd.exe";
				cmd[1] = "/C";
				cmd[2] = "start";
				cmd[3] = "C:/Users/Khai/Desktop/Map/MapForRockAndRoll.html";
				cmd[4] = "-fullscreen";
				try {
					Process p = Runtime.getRuntime().exec(cmd);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon(EventDetailsRNR.class
				.getResource("/polyfive/ui/images/Map.PNG")));
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBounds(74, 11, 1124, 120);
		panel.add(btnNewButton);

		JButton button = new JButton("Back");
		button.setFocusPainted(false);
		button.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				Color.DARK_GRAY, null));
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchEvents searchEvents = new SearchEvents(f);
				f.getContentPane().removeAll();
				f.getContentPane().add(searchEvents);
				f.repaint();
				f.revalidate();
				f.setVisible(true);
			}
		});
		button.setBounds(21, 664, 150, 75);
		add(button);
		button.setForeground(Color.DARK_GRAY);
		button.setFont(new Font("Tahoma", Font.PLAIN, 30));
		button.setBackground(new Color(255, 165, 0));

		JButton button_1 = new JButton("");
		button_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_1.addActionListener(new ActionListener() {
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
		button_1.setIcon(new ImageIcon(EventDetailsRNR.class
				.getResource("/polyFive/ui/images/p5cicon7575.png")));
		button_1.setBorder(null);
		button_1.setBounds(21, 21, 75, 75);
		add(button_1);

		super.setLayout();

	}

}
