package polyfive.ui.publicpages;

import polyfive.ui.adminpages.*;
import polyfive.ui.images.*;
import polyfive.ui.master.*;
import polyfive.ui.memberpages.*;

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

public class PublicCalendar extends MasterPanel {

	private MainFrame f = null;

	/**
	 * Create the panel.
	 */
	public PublicCalendar(MainFrame frame) {
		f = frame;
		setSize(new Dimension(1366, 768));
		setBackground(Color.WHITE);
		setLayout(null);

		JButton button_1 = new JButton("Back");
		button_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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

		JButton btnFindEvents = new JButton("Find Events");
		btnFindEvents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// insert eventhandler
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
		button_1.setForeground(Color.DARK_GRAY);
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		button_1.setFocusPainted(false);
		button_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				Color.DARK_GRAY, null));
		button_1.setBackground(new Color(255, 165, 0));
		button_1.setBounds(21, 664, 150, 75);
		add(button_1);

		JButton button = new JButton("");
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setIcon(new ImageIcon(PublicCalendar.class
				.getResource("/polyFive/ui/images/p5cicon7575.png")));
		button.setBorder(null);
		button.setBounds(21, 21, 75, 75);
		add(button);

		org.freixas.jcalendar.JCalendar calendar = new org.freixas.jcalendar.JCalendar();
		calendar.setDayOfWeekFont(new Font("Tahoma", Font.PLAIN, 18));
		calendar.setDayFont(new Font("Tahoma", Font.PLAIN, 18));
		calendar.setBorder(new TitledBorder(null, "", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		calendar.setBounds(166, 191, 989, 427);
		add(calendar);

		super.setLayout();
	}


}
