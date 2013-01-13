package polyfive.ui.memberpages;

import polyfive.entities.Member;
import polyfive.ui.adminpages.*;
import polyfive.ui.images.*;
import polyfive.ui.master.*;
import polyfive.ui.publicpages.*;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.DropMode;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Rectangle;
import java.awt.GridLayout;
import java.util.Date;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import org.freixas.jcalendar.JCalendarCombo;
import java.text.SimpleDateFormat;
import org.freixas.jcalendar.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.javaswingcomponents.clock.analog.JSCAnalogClock;

public class MemberCalendar extends MasterPanel {

	private MainFrame f = null;


	/**
	 * Create the panel.
	 */
	public MemberCalendar() {
		setSize(new Dimension(1366, 768));
		setBackground(Color.WHITE);
		setLayout(null);

		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPanel loginPanel = f.getLoginPanel();
				f.getContentPane().removeAll();
				f.getContentPane().add(loginPanel);
				f.repaint();
				f.revalidate();
				f.setVisible(true);
			}
		});

		JButton btnFindEvents = new JButton("Find Events");
		btnFindEvents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchEvents searchEvents = f.getSearchEvents();
				f.getContentPane().removeAll();
				f.getContentPane().add(searchEvents);
				f.repaint();
				f.revalidate();
				f.setVisible(true);
			}
		});
		btnFindEvents.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFindEvents.setForeground(Color.DARK_GRAY);
		btnFindEvents.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnFindEvents.setFocusPainted(false);
		btnFindEvents.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				Color.DARK_GRAY, null));
		btnFindEvents.setBackground(new Color(255, 165, 0));
		btnFindEvents.setBounds(849, 95, 170, 50);
		add(btnFindEvents);
		btnLogOut.setForeground(Color.DARK_GRAY);
		btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnLogOut.setFocusPainted(false);
		btnLogOut.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				Color.DARK_GRAY, null));
		btnLogOut.setBackground(new Color(255, 165, 0));
		btnLogOut.setBounds(21, 664, 150, 75);
		add(btnLogOut);

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
		button.setIcon(new ImageIcon(MemberCalendar.class
				.getResource("/polyFive/ui/images/p5cicon7575.png")));
		button.setBorder(null);
		button.setBounds(21, 21, 75, 75);
		add(button);
		
		

		JLabel lblNewLabel = new JLabel("Welcome, Khai ! ");
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AccountDetails accountDetails = f.getAccountDetails();
				f.getContentPane().removeAll();
				f.getContentPane().add(accountDetails);
				f.repaint();
				f.revalidate();
				f.setVisible(true);
				// /Nichola's Account Manager

			}
		});
		lblNewLabel.setForeground(new Color(210, 105, 30));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(812, 11, 170, 35);
		add(lblNewLabel);

		org.freixas.jcalendar.JCalendar calendar = new org.freixas.jcalendar.JCalendar();
		calendar.setDayOfWeekFont(new Font("Tahoma", Font.PLAIN, 18));
		calendar.setDayFont(new Font("Tahoma", Font.PLAIN, 18));
		calendar.setBorder(new TitledBorder(null, "", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		calendar.setBounds(268, 197, 887, 421);
		add(calendar);

		super.setLayout();
	}

	public MemberCalendar(MainFrame frame) {
		this();
		f = frame;
		// TODO Auto-generated constructor stub
	}
}
