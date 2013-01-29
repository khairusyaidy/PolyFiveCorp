package polyfive.ui.publicpages;

import polyfive.entities.ChangeLanguage;
import polyfive.entities.CheckDate;
import polyfive.entities.EventAttributes;
import polyfive.entities.Member;
import polyfive.entities.dao.DBConnectionManager;
import polyfive.entities.dao.EventDetailsDao;
import polyfive.ui.adminpages.*;
import polyfive.ui.images.*;
import polyfive.ui.master.*;
import polyfive.ui.memberpages.*;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.DropMode;
import javax.swing.JOptionPane;
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
import java.util.Calendar;
import java.util.Date;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import org.freixas.jcalendar.DateEvent;
import org.freixas.jcalendar.DateListener;
import org.freixas.jcalendar.JCalendarCombo;
import java.text.SimpleDateFormat;
import org.freixas.jcalendar.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PublicCalendar extends MasterPanel {

	private MainFrame f = null;

	/**
	 * Create the panel.
	 */
	public PublicCalendar(MainFrame frame) {
		f = frame;
		
		DBConnectionManager.connect();
		Member user = new Member ();
		user = f.getSession();
		int rank = user.getRank();
		//System.out.println(rank);
		String rankName = null;
		
		
		ChangeLanguage changeLanguage= new ChangeLanguage();
		changeLanguage = f.getStoreLanguage();
		int language = changeLanguage.getChangeLanguage();

		
		setSize(new Dimension(1366, 768));
		setBackground(Color.WHITE);
		setLayout(null);

		JButton btnBack = new JButton("Back");
		btnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WelcomePanel welcomePanel = new WelcomePanel(f);
				f.getContentPane().removeAll();
				f.getContentPane().add(welcomePanel);
				f.repaint();
				f.revalidate();
				f.setVisible(true);
			}
		});
		btnBack.setForeground(Color.DARK_GRAY);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnBack.setFocusPainted(false);
		btnBack.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				Color.DARK_GRAY, null));
		btnBack.setBackground(new Color(255, 165, 0));
		btnBack.setBounds(21, 664, 150, 75);
		add(btnBack);

		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setIcon(new ImageIcon(PublicCalendar.class
				.getResource("/polyFive/ui/images/p5cicon7575.png")));
		button.setBorder(null);
		button.setBounds(21, 21, 75, 75);
		add(button);

		final JCalendar calendar = new JCalendar();
		calendar.setDayOfWeekFont(new Font("Tahoma", Font.PLAIN, 18));
		calendar.setDayFont(new Font("Tahoma", Font.PLAIN, 18));
		calendar.setBorder(new TitledBorder(null, "", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		calendar.setBounds(166, 191, 989, 427);
		calendar.addDateListener(new DateListener() {
			
			
			public void dateChanged(DateEvent arg0) {
				CheckDate checkDate = new CheckDate();
				
			Calendar currentDateAfter1Month = Calendar.getInstance();
			currentDateAfter1Month.add(Calendar.MONTH, 1);
			Date dateNow = new Date();
			Date onClickDate = calendar.getDate();
			
			
			if (onClickDate.before(dateNow)){
				
				checkDate.setCheckDate(true);
				f.setCheckDate(checkDate);
			}
			else {
				checkDate.setCheckDate(false);
				f.setCheckDate(checkDate);
			}
			
			if (onClickDate.after(currentDateAfter1Month.getTime())){
				JOptionPane.showMessageDialog(null, "Guest are only allowed to buy tickets withing 1 month range from today");
			}
			else {
				
				
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
			}
		});
		add(calendar);
		
		if(rank == 0){
			rankName = "Guest";
		}
		
		JLabel lblWelcome = new JLabel();
		lblWelcome.setText("Welcome " + rankName);
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("Monotype Corsiva", Font.PLAIN, 40));
		lblWelcome.setBounds(616, 21, 469, 59);
		add(lblWelcome);
		
		JLabel lblclickOnThe = new JLabel("*Click on the date to find the events for that particular date");
		lblclickOnThe.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblclickOnThe.setBounds(166, 161, 421, 19);
		add(lblclickOnThe);

		if (language == 0){
			lblclickOnThe.setText(WelcomePanel.BUNDLE.getString("PublicCalendar.lblclickOnThe.text"));
			btnBack.setText (WelcomePanel.BUNDLE.getString("PublicCalendar.btnBack.text") );
		}
		else if (language == 1){
			lblclickOnThe.setText(WelcomePanel.BUNDLE2.getString("PublicCalendar.lblclickOnThe.text"));
			btnBack.setText (WelcomePanel.BUNDLE2.getString("PublicCalendar.btnBack.text") );

			
		}

		
		
		super.setLayout();
	}


}
