package polyfive.ui.memberpages;

import polyfive.entities.Member;
import polyfive.ui.adminpages.*;
import polyfive.ui.images.*;
import polyfive.ui.master.*;
import polyfive.ui.publicpages.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.border.EtchedBorder;

public class EventDetails extends MasterPanel {
	private JTextField txtDisneyLiveMickeys;
	private JTextField txtHitTheRoad;
	private MainFrame f = null;

	/**
	 * Create the panel.
	 */
	public EventDetails(MainFrame frame) {
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

		txtDisneyLiveMickeys = new JTextField();
		txtDisneyLiveMickeys.setEditable(false);
		txtDisneyLiveMickeys.setBackground(new Color(255, 255, 255));
		txtDisneyLiveMickeys.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtDisneyLiveMickeys
				.setText("Disney Live! Mickey's Rockin' Road Show\r\n27 November - 2 December 2012, Marina Bay Sands\r\n(Seating)");
		txtDisneyLiveMickeys.setBounds(37, 168, 1200, 50);
		panel.add(txtDisneyLiveMickeys);
		txtDisneyLiveMickeys.setColumns(10);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(EventDetails.class
				.getResource("/polyFive/ui/images/Map.PNG")));
		lblNewLabel.setBounds(37, 11, 1200, 120);
		panel.add(lblNewLabel);

		txtHitTheRoad = new JTextField();
		txtHitTheRoad.setBackground(new Color(255, 255, 255));
		txtHitTheRoad.setForeground(new Color(0, 0, 0));
		txtHitTheRoad.setEditable(false);
		txtHitTheRoad.setHorizontalAlignment(SwingConstants.LEFT);
		txtHitTheRoad.setAlignmentY(Component.TOP_ALIGNMENT);
		txtHitTheRoad.setAlignmentX(Component.LEFT_ALIGNMENT);
		txtHitTheRoad.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtHitTheRoad
				.setText("Hit the road with Mickey Mouse and your favorite Disney friends!");
		txtHitTheRoad.setBounds(37, 257, 1200, 200);
		panel.add(txtHitTheRoad);
		txtHitTheRoad.setColumns(10);

		JButton btnProceedToPayment = new JButton("Buy Ticket(s)");
		btnProceedToPayment.setFocusPainted(false);
		btnProceedToPayment.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				Color.DARK_GRAY, null));
		btnProceedToPayment.setCursor(Cursor
				.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnProceedToPayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SeatAllocation seatAllocation = new SeatAllocation(f);
				f.getContentPane().removeAll();
				f.getContentPane().add(seatAllocation);
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
				MemberCalendar memberCalendar = new MemberCalendar(f);
				f.getContentPane().removeAll();
				f.getContentPane().add(memberCalendar);
				f.repaint();
				f.revalidate();
				f.setVisible(true);
			}
		});
		button_1.setIcon(new ImageIcon(EventDetails.class
				.getResource("/polyFive/ui/images/p5cicon7575.png")));
		button_1.setBorder(null);
		button_1.setBounds(21, 21, 75, 75);
		add(button_1);

		super.setLayout();

	}

	
}
