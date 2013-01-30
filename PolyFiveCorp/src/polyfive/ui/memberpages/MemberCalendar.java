/* 
 * Program Name : MemberCalendar.java
 * Purpose : Display Calendar 
 * 
 * Authour: Muhammad Khairyl Rusyaidy
 * Admin No: 120258L
 * Module Group : IS1201
 * Last Modified: 29/1/2013
 * 
 */

package polyfive.ui.memberpages;

import polyfive.entities.ChangeLanguage;
import polyfive.entities.EventAttributes;
import polyfive.entities.Member;
import polyfive.entities.dao.DBConnectionManager;
import polyfive.entities.dao.EventDetailsDao;
import polyfive.ui.master.*;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

import org.freixas.jcalendar.DateListener;
import org.freixas.jcalendar.DateEvent;



import javax.swing.JTextField;



public class MemberCalendar extends MasterPanel {

	private MainFrame f = null;


	/**
	 * Create the panel.
	 */
	public MemberCalendar(MainFrame frame) {
		f = frame;
		
		DBConnectionManager.connect();
		
		
		ChangeLanguage changeLanguage= new ChangeLanguage();
		changeLanguage = f.getStoreLanguage();
		int language = changeLanguage.getChangeLanguage();
		
		setSize(new Dimension(1366, 768));
		setBackground(Color.WHITE);
		setLayout(null);

		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPanel loginPanel = new LoginPanel(f);
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
				SearchEvents searchEvents = new SearchEvents(f);
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
		btnFindEvents.setBounds(985, 95, 170, 50);
		add(btnFindEvents);
		btnLogOut.setForeground(Color.DARK_GRAY);
		btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 25));
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
		
		
		Member user = new Member();
		user = f.getSession();
		int rank = user.getRank();
		String rankName = null;
		
		JLabel lblNewLabel = new JLabel();
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
				// /Nicholas's Account Manager

			}
		});
		switch (rank){
		case 0: lblNewLabel.setForeground(Color.BLACK);
		rankName = "Guest";
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
		
		
		
		
		lblNewLabel.setFont(new Font("Monotype Corsiva", Font.PLAIN, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(567, 21, 588, 50);
		add(lblNewLabel);
		System.out.println();
		
		final org.freixas.jcalendar.JCalendar calendar = new org.freixas.jcalendar.JCalendar();
		calendar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		calendar.setDayOfWeekFont(new Font("Tahoma", Font.PLAIN, 18));
		calendar.setDayFont(new Font("Tahoma", Font.PLAIN, 18));
		calendar.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		calendar.setBounds(166, 191, 989, 427);
		calendar.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
		calendar.addDateListener(new DateListener() {
			public void dateChanged(DateEvent arg0) {
			 String date = calendar.getDate().toString();
			 String fullDate = EventDetailsDao.fullDate(date);
			 EventAttributes event = new EventAttributes();
			 event.setEventDate(fullDate);
			 f.setStoreEvents(event);
			 
				SearchEventsByDate searchEventsByDate= new SearchEventsByDate(f);
			    f.getContentPane().removeAll();
			    f.getContentPane().add(searchEventsByDate);
			    f.repaint();
			    f.revalidate();
			    f.setVisible(true);
				
			 
			}
		});
		add(calendar);
		
		
		
		if (language == 0){
			btnFindEvents.setText (WelcomePanel.BUNDLE.getString("MemberCalendar.btnFindEvents.text") );
			btnLogOut.setText (WelcomePanel.BUNDLE.getString("MemberCalendar.btnLogOut.text") );
		}
		else if (language == 1){
			btnFindEvents.setText (WelcomePanel.BUNDLE2.getString("MemberCalendar.btnFindEvents.text") );
			btnLogOut.setText (WelcomePanel.BUNDLE2.getString("MemberCalendar.btnLogOut.text") );

			
		}
		

		super.setLayout();
	}
}
