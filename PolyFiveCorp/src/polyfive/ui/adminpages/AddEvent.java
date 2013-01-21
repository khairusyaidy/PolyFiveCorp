package polyfive.ui.adminpages;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import polyfive.ui.master.MainFrame;
import polyfive.ui.master.MasterPanel;
import polyfive.ui.memberpages.MemberCalendar;
import polyfive.ui.memberpages.SearchEvents;
import polyfive.entities.EventAttributes;
import polyfive.entities.Member;
import polyfive.entities.dao.EventDetailsDao;

import java.awt.Font;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JPanel;
;

public class AddEvent extends MasterPanel {
	private JTextField txtEventName;
	private JTextField txtDateOfEvent;
	private JTextField txtDescription;
	private JTextField tfEventName;
	private JTextField tfAddress;
	private JTextField tfAddress_1;
	private MainFrame f = null;
	
	
	
	public AddEvent(MainFrame frame) {
		f = frame;
		setBackground(Color.WHITE);
		setLayout(null);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Member user = new Member();
				user = f.getSession();
				if(user.getRank() <= 4 ){
				MemberCalendar memberCalendar = new MemberCalendar(f);
				f.getContentPane().removeAll();
				f.getContentPane().add(memberCalendar);
				f.repaint();
				f.revalidate();
				f.setVisible(true);
				}
				else {
					AdminCalendar adminCalendar = new AdminCalendar(f);
					f.getContentPane().removeAll();
					f.getContentPane().add(adminCalendar);
					f.repaint();
					f.revalidate();
					f.setVisible(true);
				}
			}
		});
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setIcon(new ImageIcon(AddEvent.class.getResource("/polyfive/ui/images/p5cicon7575.png")));
		button.setBorder(null);
		button.setBounds(21, 21, 75, 75);
		add(button);
		
		txtEventName = new JTextField();
		txtEventName.setOpaque(false);
		txtEventName.setBorder(null);
		txtEventName.setHorizontalAlignment(SwingConstants.CENTER);
		txtEventName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtEventName.setEditable(false);
		txtEventName.setText("Event Name :");
		txtEventName.setBounds(435, 156, 219, 49);
		add(txtEventName);
		txtEventName.setColumns(10);
		
		tfAddress = new JTextField();
		tfAddress.setBorder(null);
		tfAddress.setOpaque(false);
		tfAddress.setHorizontalAlignment(SwingConstants.CENTER);
		tfAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfAddress.setEditable(false);
		tfAddress.setText("Address       :");
		tfAddress.setBounds(435, 232, 219, 50);
		add(tfAddress);
		tfAddress.setColumns(10);
		
		txtDateOfEvent = new JTextField();
		txtDateOfEvent.setOpaque(false);
		txtDateOfEvent.setBorder(null);
		txtDateOfEvent.setHorizontalAlignment(SwingConstants.CENTER);
		txtDateOfEvent.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtDateOfEvent.setEditable(false);
		txtDateOfEvent.setText("Date of Event :");
		txtDateOfEvent.setBounds(424, 305, 218, 49);
		add(txtDateOfEvent);
		txtDateOfEvent.setColumns(10);
		
		txtDescription = new JTextField();
		txtDescription.setHorizontalAlignment(SwingConstants.CENTER);
		txtDescription.setOpaque(false);
		txtDescription.setBorder(null);
		txtDescription.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtDescription.setEditable(false);
		txtDescription.setText("Description :");
		txtDescription.setBounds(435, 383, 219, 49);
		add(txtDescription);
		txtDescription.setColumns(10);
		
		tfEventName = new JTextField();
		tfEventName.setBorder(new LineBorder(Color.BLACK));
		tfEventName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfEventName.setBounds(657, 157, 221, 49);
		add(tfEventName);
		tfEventName.setColumns(10);
		
		tfAddress_1 = new JTextField();
		tfAddress_1.setBorder(new LineBorder(Color.BLACK));
		tfAddress_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfAddress_1.setBounds(657, 234, 221, 50);
		add(tfAddress_1);
		tfAddress_1.setColumns(10);
		
		final JTextArea taDescription = new JTextArea();
		taDescription.setBorder(new LineBorder(new Color(0, 0, 0)));
		taDescription.setFont(new Font("Tahoma", Font.PLAIN, 20));
		taDescription.setBounds(657, 383, 307, 201);
		add(taDescription);
		
		JButton Back = new JButton("Back");
		Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminCalendar adminCalendar = new AdminCalendar(f);
				f.getContentPane().removeAll();
				f.getContentPane().add(adminCalendar);
				f.repaint();
				f.revalidate();
				f.setVisible(true);
			}
		});
		Back.setForeground(Color.DARK_GRAY);
		Back.setFont(new Font("Tahoma", Font.PLAIN, 30));
		Back.setFocusPainted(false);
		Back.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, null));
		Back.setBackground(new Color(255, 165, 0));
		Back.setBounds(243, 603, 150, 75);
		add(Back);


		
	
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBorder(null);
		panel.setBounds(657, 305, 273, 59);
		add(panel);
		panel.setLayout(null);
		
		final JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(188, 11, 75, 34);
		panel.add(comboBox_2);
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"2012", "2013", "2014"}));
		comboBox_2.setSelectedIndex(0);
		
		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(81, 11, 97, 34);
		panel.add(comboBox_1);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		comboBox_1.setSelectedIndex(0);
		
		
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(20, 11, 42, 34);
		panel.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox.setSelectedIndex(0);
		
		
		JButton AddEvent = new JButton("Add Event");
		AddEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		/*		 EventDetails eventDetails = new EventDetails();
			     eventDetails.setEventName(tfEventName.getText());
			     eventDetails.setEventAddress(tfAddress.getText());
			     	adminAddEvent adminAddEvent = new adminAddEvent(f);
			     	f.getContentPane().removeAll();
			     	f.getContentPane().add(adminAddEvent);
			     	f.repaint();
					f.revalidate();
					f.setVisible(true);
			*/

				
				
				int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to add this new event ?");
				if (reply == JOptionPane.YES_OPTION){
					String eventName = tfEventName.getText();
					String eventAdd = tfAddress_1.getText();
					String des = taDescription.getText();
					EventAttributes addEvent = new EventAttributes();
					
					String date = (String)comboBox.getSelectedItem();
					String month = (String)comboBox_1.getSelectedItem();
					String year = (String)comboBox_2.getSelectedItem();
					
					final String fullDate = date+ " " +month+ " " + year ;
					
					addEvent.setEventName(eventName);
					addEvent.setEventAddress(eventAdd);
					addEvent.setEventDate(fullDate);
					addEvent.setDescription(des);
					
					EventDetailsDao.insertEventDetails(addEvent);
					JOptionPane.showMessageDialog(null, "Event is added");
					SearchEvents searchEvents= new SearchEvents(f);
					f.getContentPane().removeAll();
					f.getContentPane().add(searchEvents);
					f.repaint();
					f.revalidate();
					f.setVisible(true);
					
				}
				else 
					JOptionPane.showMessageDialog(null, "Event is not added");
				SearchEvents searchEvents= new SearchEvents(f);
				f.getContentPane().removeAll();
				f.getContentPane().add(searchEvents);
				f.repaint();
				f.revalidate();
				f.setVisible(true);
				
				}
			});
		AddEvent.setForeground(Color.DARK_GRAY);
		AddEvent.setFont(new Font("Tahoma", Font.PLAIN, 30));
		AddEvent.setFocusPainted(false);
		AddEvent.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, null));
		AddEvent.setBackground(new Color(255, 165, 0));
		AddEvent.setBounds(822, 603, 150, 75);
		add(AddEvent);
		

		
		
		
		

		
		super.setLayout();

	}
}

