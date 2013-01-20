package polyfive.ui.memberpages;

import polyfive.entities.Member;
import polyfive.entities.dao.DBConnectionManager;
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
import javax.swing.border.TitledBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

import org.freixas.jcalendar.DateListener;
import org.freixas.jcalendar.DateEvent;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDayChooser;

import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;


public class MemberCalendar extends MasterPanel {

	private MainFrame f = null;
	private JTextField eventDate;


	/**
	 * Create the panel.
	 */
	public MemberCalendar(MainFrame frame) {
		f = frame;
		
		DBConnectionManager.connect();
		
		
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
		
		
		
		
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(513, 11, 469, 35);
		add(lblNewLabel);
		System.out.println();
		
		eventDate = new JTextField();
		eventDate.setBounds(268, 95, 543, 50);
		add(eventDate);
		eventDate.setColumns(10);

		super.setLayout();
	}
}
