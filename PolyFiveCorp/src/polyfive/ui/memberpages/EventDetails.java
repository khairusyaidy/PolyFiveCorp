package polyfive.ui.memberpages;

import polyfive.entities.EventAttributes;
import polyfive.entities.Member;
import polyfive.entities.dao.DBConnectionManager;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.sql.SQLException;

import javax.swing.border.EtchedBorder;
import javax.swing.JTextPane;

public class EventDetails extends MasterPanel {
	private JTextField eventAddressTf;
	private MainFrame f = null;
	private JTextField eventDateTf;

	/**
	 * Create the panel.
	 */
	public EventDetails(MainFrame frame) {
		DBConnectionManager.getConnection();
		Member user = new Member();
		user = f.getSession();
		
		EventAttributes eventAttributes = new EventAttributes();
		eventAttributes = f.getStoreEvents();
		
		f = frame;
		setSize(new Dimension(1366, 768));

		setForeground(Color.BLACK);
		setBorder(new LineBorder(new Color(0, 0, 0), 0));
		setBackground(Color.WHITE);
		setLayout(null);

		

		String eventName = eventAttributes.getEventName();
		String sql = "select * from Events where eventName= '" + eventName + "'";

		try {
			DBConnectionManager.rs = DBConnectionManager.stmt.executeQuery(sql);
			while (DBConnectionManager.rs.next()){
				eventAttributes.setEventAddress(DBConnectionManager.rs.getString("eventAdd"));
				eventAttributes.setDescription(DBConnectionManager.rs.getString("eventDes"));
				eventAttributes.setEventName(DBConnectionManager.rs.getString("eventName"));
				eventAttributes.setEventDate(DBConnectionManager.rs.getString("eventDate"));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setLayout(null);
		panel.setForeground(new Color(255, 165, 0));
		panel.setBorder(null);
		panel.setBackground(Color.BLACK);
		panel.setBounds(62, 117, 1247, 534);

		add(panel);

		eventAddressTf = new JTextField();
		eventAddressTf.setDisabledTextColor(Color.BLACK);
		eventAddressTf.setEditable(false);
		eventAddressTf.setBorder(new LineBorder(Color.BLACK));
		eventAddressTf.setBackground(new Color(255, 255, 255));
		eventAddressTf.setFont(new Font("Tahoma", Font.PLAIN, 20));
		eventAddressTf
				.setText("Address: "+ eventAttributes.getEventAddress());
		eventAddressTf.setBounds(37, 222, 1200, 50);
		panel.add(eventAddressTf);
		eventAddressTf.setColumns(10);

		JLabel eventMap = new JLabel("");
		eventMap.setBorder(new LineBorder(new Color(0, 0, 0)));
		eventMap.setHorizontalAlignment(SwingConstants.CENTER);
		eventMap.setIcon(new ImageIcon(EventDetails.class
				.getResource("/polyFive/ui/images/Map.PNG")));
		eventMap.setBounds(37, 11, 1200, 120);
		panel.add(eventMap);

		JButton btnProceedToPayment = new JButton("Buy Ticket(s)");
		if(user.getRank() >= 5)
			btnProceedToPayment.setVisible(false);
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
		
		final JTextArea eventDesTf = new JTextArea();
		eventDesTf.setDisabledTextColor(Color.BLACK);
		eventDesTf.setBorder(new LineBorder(new Color(0, 0, 0)));
		eventDesTf.setEditable(false);
		eventDesTf.setText("Description: "+ eventAttributes.getDescription());
		eventDesTf.setRows(10);
		eventDesTf.setFont(new Font("Tahoma", Font.PLAIN, 20));
		eventDesTf.setBounds(37, 295, 1200, 162);
		panel.add(eventDesTf);
		
		eventDateTf = new JTextField();
		eventDateTf.setText("Date : " + eventAttributes.getEventDate());
		eventDateTf.setFont(new Font("Tahoma", Font.PLAIN, 20));
		eventDateTf.setEditable(false);
		eventDateTf.setDisabledTextColor(Color.BLACK);
		eventDateTf.setColumns(10);
		eventDateTf.setBorder(new LineBorder(Color.BLACK));
		eventDateTf.setBackground(Color.WHITE);
		eventDateTf.setBounds(37, 156, 312, 50);
		panel.add(eventDateTf);
		
		final JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setOpaque(false);
		panel_1.setBorder(null);
		panel_1.setVisible(false);
		panel_1.setBounds(373, 152, 426, 59);
		panel.add(panel_1);
		
		final JComboBox comboBox3 = new JComboBox();
		comboBox3.setModel(new DefaultComboBoxModel(new String[] {"2012", "2013", "2014"}));
		comboBox3.setSelectedIndex(0);
		comboBox3.setBounds(169, 11, 75, 34);
		panel_1.add(comboBox3);
		
		final JComboBox comboBox2 = new JComboBox();
		comboBox2.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		comboBox2.setSelectedIndex(0);
		comboBox2.setBounds(62, 11, 97, 34);
		panel_1.add(comboBox2);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(10, 11, 42, 34);
		panel_1.add(comboBox);
		
		JButton btnSetDate = new JButton("Set Date");
		btnSetDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String date = (String)comboBox.getSelectedItem();
				String month = (String)comboBox2.getSelectedItem();
				String year = (String)comboBox3.getSelectedItem();
				
				final String fullDate = date+ " " +month+ " " + year ;
				
				eventDateTf.setText(fullDate);
				
			}
		});
		btnSetDate.setBounds(283, 11, 115, 34);
		panel_1.add(btnSetDate);
		btnSetDate.setForeground(Color.DARK_GRAY);
		btnSetDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSetDate.setFocusPainted(false);
		btnSetDate.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
						Color.DARK_GRAY, null));
		btnSetDate.setBackground(new Color(255, 165, 0));

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
		button_1.setIcon(new ImageIcon(EventDetails.class
				.getResource("/polyFive/ui/images/p5cicon7575.png")));
		button_1.setBorder(null);
		button_1.setBounds(21, 21, 75, 75);
		add(button_1);
		
		
		final JButton btnUpdate = new JButton("Update");
		final JButton modify = new JButton("Modify");
		
		modify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventAttributes eventAttributes = new EventAttributes();
				eventAttributes = f.getStoreEvents();
				
				eventAddressTf.setEditable(true);
				eventDesTf.setEditable(true);
				
				eventAddressTf.setText(eventAttributes.getEventAddress());
				eventDesTf.setText(eventAttributes.getDescription());
				eventDateTf.setText(eventAttributes.getEventDate());

				modify.setVisible(false);
				btnUpdate.setVisible(true);
				panel_1.setVisible(true);
			}
		});
		
		

		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventAttributes eventAttributes = new EventAttributes();
				eventAttributes = f.getStoreEvents();
				int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to update?");
				if (reply == JOptionPane.YES_OPTION){
					String eventAddNew = eventAddressTf.getText();
					String eventDesNew = eventDesTf.getText();
					String eventDate = eventDateTf.getText();

					try {


						String sql3 = "update Events set eventAdd='" + eventAddNew
								+ "' , eventDes='" + eventDesNew + "', eventDate='"+eventDate
								+ "' where eventName='"
								+ eventAttributes.getEventName() + "' ";
						DBConnectionManager.pstmt = DBConnectionManager.con
								.prepareStatement(sql3);
						DBConnectionManager.pstmt.execute();
					} catch (SQLException ex) {
						JOptionPane.showMessageDialog(null, ex);
						ex.printStackTrace();
					}
					

					
					eventAddressTf.setEditable(false);
					eventDesTf.setEditable(false);
					
					panel_1.setVisible(false);
					btnUpdate.setVisible(false);
					modify.setVisible(true);
					
				}
				else {


					eventAddressTf.setEditable(false);
					eventDesTf.setEditable(false);
					
					btnUpdate.setVisible(false);
					panel_1.setVisible(false);
					modify.setVisible(true);
				}
				
				
				
				String sql2 = "select * from Events where eventName = '"
						+ eventAttributes.getEventName() + "'";
				
				try {
					DBConnectionManager.rs = DBConnectionManager.stmt
							.executeQuery(sql2);
					while (DBConnectionManager.rs.next()) {
						// userUpdateDetails.setFirstName(DBConnectionManager.rs.getString("firstName"));
						// userUpdateDetails.setLastName(DBConnectionManager.rs.getString("lastName"));
						eventAttributes.setEventAddress(DBConnectionManager.rs
								.getString("eventAdd"));
						eventAttributes.setDescription(DBConnectionManager.rs
								.getString("eventDes"));
						eventAttributes.setEventName(DBConnectionManager.rs
								.getString("eventName"));
						eventAttributes.setEventDate(DBConnectionManager.rs
								.getString("eventDate"));

						eventAddressTf.setText("Address: "+ eventAttributes.getEventAddress());
						eventDesTf.setText("Description: "+ eventAttributes.getDescription());
						eventDateTf.setText("Date: "+ eventAttributes.getEventDate());
						f.setStoreEvents(eventAttributes);

					}
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				
				
				
				
				
			}
		});
		btnUpdate.setVisible(false);
		btnUpdate.setForeground(Color.DARK_GRAY);
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnUpdate.setFocusPainted(false);
		btnUpdate.setBorder(new EtchedBorder(EtchedBorder.LOWERED,


								Color.DARK_GRAY, null));
		btnUpdate.setBackground(new Color(255, 165, 0));
		btnUpdate.setBounds(213, 664, 150, 75);
		add(btnUpdate);
		
		
		
		
		if(user.getRank()>=5){
			modify.setVisible(true);
		}
		else
			modify.setVisible(false);
		modify.setForeground(Color.DARK_GRAY);
		modify.setFont(new Font("Tahoma", Font.PLAIN, 30));
		modify.setFocusPainted(false);
		modify.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
						Color.DARK_GRAY, null));
		modify.setBackground(new Color(255, 165, 0));
		modify.setBounds(213, 664, 150, 75);
		add(modify);
		
		JButton delete = new JButton("Delete");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			int reply =	JOptionPane.showConfirmDialog(null, "Warning! Are you sure you want to delete the event?");
				if (reply == JOptionPane.YES_OPTION){
					EventAttributes eventAttributes = new EventAttributes();
					eventAttributes = f.getStoreEvents();
					String eventName = eventAttributes.getEventName();
					System.out.println(eventName);
					String sql = "DELETE FROM events WHERE eventName ='"+eventName+"'";
					try {
						//DBConnectionManager.rs = DBConnectionManager.stmt.execute(sql);
						DBConnectionManager.pstmt = DBConnectionManager.con
								.prepareStatement(sql);
						DBConnectionManager.pstmt.execute();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						System.out.println(e1);
						e1.printStackTrace();
					}	
					JOptionPane.showMessageDialog(null, "Event is deleted");
					
					SearchEvents searchEvents = new SearchEvents(f);
					f.getContentPane().removeAll();
					f.getContentPane().add(searchEvents);
					f.repaint();
					f.revalidate();
					f.setVisible(true);
					
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Event is not deleted");
				}
					
					return;

				
			}
		});
		if(user.getRank()>=5){
			delete.setVisible(true);
		}
		else
			delete.setVisible(false);
		delete.setForeground(Color.DARK_GRAY);
		delete.setFont(new Font("Tahoma", Font.PLAIN, 30));
		delete.setFocusPainted(false);
		delete.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
						Color.DARK_GRAY, null));
		delete.setBackground(new Color(255, 165, 0));
		delete.setBounds(407, 662, 150, 75);
		add(delete);
		
		JTextPane txtpnA = new JTextPane();
		txtpnA.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtpnA.setText(eventAttributes.getEventName());
		txtpnA.setBounds(321, 62, 459, 58);
		add(txtpnA);
		


		super.setLayout();

	}
}
