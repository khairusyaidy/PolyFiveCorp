package polyfive.ui.adminpages;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import polyfive.ui.master.MainFrame;
import polyfive.ui.master.MasterPanel;
import polyfive.ui.memberpages.SearchEvents;

import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class adminAddEvent extends MasterPanel {
	private JTextField txtSearchKeyword;
	private MainFrame f = null;



	public adminAddEvent(MainFrame frame) {
		f = frame;
		
		
		setLayout(null);
		
		JButton button = new JButton("");
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setIcon(new ImageIcon(adminAddEvent.class.getResource("/Images/p5cicon7575.png")));
		button.setBorder(null);
		button.setBounds(21, 21, 75, 75);
		add(button);
		
		
		txtSearchKeyword = new JTextField();
		txtSearchKeyword.setBackground(new Color(255, 255, 255));
		txtSearchKeyword.setText("Search Keyword...");
		txtSearchKeyword.setBounds(465, 208, 493, 31);
		add(txtSearchKeyword);
		txtSearchKeyword.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBackground(new Color(255, 165, 0));
		btnSearch.setBounds(968, 212, 89, 23);
		add(btnSearch);
		
		JTextArea txtrEventName = new JTextArea();
		txtrEventName.setEditable(false);
		txtrEventName.setBackground(new Color(255, 255, 255));
		txtrEventName.setText("Event Name\r\nTuesday , 20 November 2012 at 1600\r\nMarina Bay Sands - 10 Bayfront Avenue, Singapore 018956");
		txtrEventName.setBounds(465, 250, 493, 287);
		add(txtrEventName);
		
		JButton btnModifyEvent = new JButton("Modify Event");
		btnModifyEvent.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnModifyEvent.setBounds(968, 278, 109, 23);
		add(btnModifyEvent);
		
		JButton Add_Event = new JButton("Add Event");
		Add_Event.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  adminAddEvent adminAddEvent = new adminAddEvent(f);
				    f.getContentPane().removeAll();
				    f.getContentPane().add(adminAddEvent);
				    f.repaint();
				    f.revalidate();
				    f.setVisible(true);
			}
		});
		Add_Event.setForeground(Color.DARK_GRAY);
		Add_Event.setFont(new Font("Tahoma", Font.PLAIN, 30));
		Add_Event.setFocusPainted(false);
		Add_Event.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, null));
		Add_Event.setBackground(new Color(255, 165, 0));
		Add_Event.setBounds(808, 548, 150, 75);
		add(Add_Event);
		
		JButton button_1 = new JButton("Back");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  SearchEvents searchEvents = new SearchEvents(f);
				    f.getContentPane().removeAll();
				    f.getContentPane().add(searchEvents);
				    f.repaint();
				    f.revalidate();
				    f.setVisible(true);
			}
		});
		button_1.setForeground(Color.DARK_GRAY);
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		button_1.setFocusPainted(false);
		button_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, null));
		button_1.setBackground(new Color(255, 165, 0));
		button_1.setBounds(465, 548, 150, 75);
		add(button_1);

		super.setLayout();
		
	}
}
