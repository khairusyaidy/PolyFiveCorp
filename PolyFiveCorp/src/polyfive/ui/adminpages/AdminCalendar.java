package polyfive.ui.adminpages;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.TitledBorder;

import polyfive.ui.*;
import polyfive.entities.Member;
import polyfive.entities.dao.DBConnectionManager;
import polyfive.ui.master.MainFrame;
import polyfive.ui.master.MasterPanel;
import polyfive.ui.memberpages.AccountDetails;
import polyfive.ui.memberpages.LoginPanel;
import polyfive.ui.memberpages.SearchEvents;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.EtchedBorder;

public class AdminCalendar extends MasterPanel {

	private MainFrame f = null;
	/**
	 * Create the panel.
	 */
	public AdminCalendar(MainFrame frame) {
		f = frame;
		DBConnectionManager.connect();
		
		setSize(new Dimension(1366, 768));
		setBackground(Color.WHITE);
		setLayout(null);
		
		JButton logout = new JButton("Log Out");
		logout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			  LoginPanel loginPanel= new LoginPanel(f);
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
			  AdminSearchEvents adminSearchEvents = new AdminSearchEvents(f);
			    f.getContentPane().removeAll();
			    f.getContentPane().add(adminSearchEvents);
			    f.repaint();
			    f.revalidate();
			    f.setVisible(true);
				}
		});
		btnFindEvents.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFindEvents.setForeground(Color.DARK_GRAY);
		btnFindEvents.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnFindEvents.setFocusPainted(false);
		btnFindEvents.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, null));
		btnFindEvents.setBackground(new Color(255, 165, 0));
		btnFindEvents.setBounds(985, 93, 170, 50);
		add(btnFindEvents);
		logout.setForeground(Color.DARK_GRAY);
		logout.setFont(new Font("Tahoma", Font.PLAIN, 30));
		logout.setFocusPainted(false);
		logout.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, null));
		logout.setBackground(new Color(255, 165, 0));
		logout.setBounds(21, 664, 150, 75);
		add(logout);
				
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setIcon(new ImageIcon(AdminCalendar.class.getResource("/polyfive/ui/images/p5cicon7575.png")));
		button.setBorder(null);
		button.setBounds(21, 21, 75, 75);
		add(button);
		
		
		
		Member user = new Member();
		user = f.getSession();
		int rank = user.getRank();
		String rankName = null;
		
		JLabel lblNewLabel = new JLabel();
		switch (rank){
		case 0: lblNewLabel.setForeground(Color.BLACK);
		rankName = "Regular Member";
		break;
		case 1: lblNewLabel.setForeground(Color.BLUE);
		rankName = "Basic";
		break;
		case 2: lblNewLabel.setForeground(new Color(210, 105, 30));
		rankName = "Bronze";
		break;
		case 3: lblNewLabel.setForeground(new Color(105, 105, 105));
		rankName = "Silver";
		break;
		case 4: lblNewLabel.setForeground(new Color(184, 134, 11));
		rankName = "Gold";
		break;
		case 5: lblNewLabel.setForeground(new Color(255, 165, 0));
		rankName = "Admin";
		break;
		}
		lblNewLabel.setText("Welcome "+ user.getFirstName()+ " " + user.getLastName()+" (" + rankName + ")");
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AccountDetails accountDetails = new AccountDetails(f);
				f.getContentPane().removeAll();
				f.getContentPane().add(accountDetails);
				f.repaint();
				f.revalidate();
				f.setVisible(true);

		
			}
		});
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(587, 11, 395, 35);
		add(lblNewLabel);
		
		org.freixas.jcalendar.JCalendar calendar = new org.freixas.jcalendar.JCalendar();
		calendar.setDayOfWeekFont(new Font("Tahoma", Font.PLAIN, 18));
		calendar.setDayFont(new Font("Tahoma", Font.PLAIN, 18));
		calendar.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		calendar.setBounds(166, 191, 989, 427);
		add(calendar);
		
		JButton addEvent = new JButton("Add Event");
		addEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddEvent addEvent = new AddEvent(f);
			    f.getContentPane().removeAll();
			    f.getContentPane().add(addEvent);
			    f.repaint();
			    f.revalidate();
			    f.setVisible(true);
				
			}
		});
		addEvent.setForeground(Color.DARK_GRAY);
		addEvent.setFont(new Font("Tahoma", Font.PLAIN, 30));
		addEvent.setFocusPainted(false);
		addEvent.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, null));
		addEvent.setBackground(new Color(255, 165, 0));
		addEvent.setBounds(212, 664, 160, 75);
		add(addEvent);
		
		JButton btnUserSettings = new JButton("User Settings");
		btnUserSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserSetting userSetting= new UserSetting(f);
			    f.getContentPane().removeAll();
			    f.getContentPane().add(userSetting);
			    f.repaint();
			    f.revalidate();
			    f.setVisible(true);
			}
		});
		btnUserSettings.setForeground(Color.DARK_GRAY);
		btnUserSettings.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnUserSettings.setFocusPainted(false);
		btnUserSettings.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, null));
		btnUserSettings.setBackground(new Color(255, 165, 0));
		btnUserSettings.setBounds(786, 93, 170, 50);
		add(btnUserSettings);
		

		
		
		
	
		
		super.setLayout();
	
	}
}
