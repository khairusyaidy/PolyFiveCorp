/* 
 * Program Name : EventDetails.java
 * Purpose : Display all the details of the particular event
 * 
 * Authour: Muhammad Khairyl Rusyaidy, Tinesh
 * Admin No: 120258L, 122691N
 * Module Group : IS1201
 * Last Modified: 29/1/2013
 * 
 */

package polyfive.ui.publicpages;

import polyfive.entities.ChangeLanguage;
import polyfive.entities.CheckDate;
import polyfive.entities.EventAttributes;
import polyfive.entities.Member;
import polyfive.entities.dao.DBConnectionManager;
import polyfive.entities.dao.Seat;
import polyfive.ui.adminpages.*;
import polyfive.ui.images.*;
import polyfive.ui.master.*;
import polyfive.ui.memberpages.MemberCalendar;
import polyfive.ui.memberpages.SearchEvents;
import polyfive.ui.publicpages.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
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
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.border.EtchedBorder;
import javax.swing.JTextPane;
import javax.swing.JSeparator;

public class EventDetails extends MasterPanel {
	private JTextField eventAddressTf;
	private MainFrame f = null;
	private JTextField eventDateTf;
	private JTextField eventPriceTf;

	/**
	 * 
	 * 
	 * Create the panel.
	 */
	public EventDetails(MainFrame frame) {
		// DBConnectionManager.getConnection();
		boolean disableButton = false;

		CheckDate checkDate = new CheckDate();
		checkDate = f.getCheckDate();
		disableButton = checkDate.isCheckDate();

		ChangeLanguage changeLanguage = new ChangeLanguage();
		changeLanguage = f.getStoreLanguage();
		int language = changeLanguage.getChangeLanguage();

		Member user = new Member();
		user = f.getSession();
		f.setSession(user);

		EventAttributes eventAttributes = new EventAttributes();
		eventAttributes = f.getStoreEvents();

		f = frame;
		setSize(new Dimension(1366, 768));

		setForeground(Color.BLACK);
		setBorder(new LineBorder(new Color(0, 0, 0), 0));
		setBackground(Color.WHITE);
		setLayout(null);

		DBConnectionManager.getConnection();
		String eventName = eventAttributes.getEventName();
		String eventDate = eventAttributes.getEventDate();
		String sql = "select * from Events where eventName= '" + eventName
				+ "' and eventDate='" + eventDate + "'";

		try {

			DBConnectionManager.rs = DBConnectionManager.stmt.executeQuery(sql);
			while (DBConnectionManager.rs.next()) {
				eventAttributes.setEventAddress(DBConnectionManager.rs
						.getString("eventAdd"));
				eventAttributes.setDescription(DBConnectionManager.rs
						.getString("eventDes"));
				eventAttributes.setEventName(DBConnectionManager.rs
						.getString("eventName"));
				eventAttributes.setEventDate(DBConnectionManager.rs
						.getString("eventDate"));
				eventAttributes.setEventPrice(DBConnectionManager.rs
						.getFloat("eventPrice"));
				eventAttributes.setEventType(DBConnectionManager.rs
						.getString("eventType"));
				eventAttributes.setEventNoOfTickets(DBConnectionManager.rs
						.getInt("eventNoOfTickets"));
				eventAttributes.setMapFileName(DBConnectionManager.rs
						.getString("eventMapFileName"));

				f.setStoreEvents(eventAttributes);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1);
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

		String eventPrice = Double.toString(eventAttributes.getEventPrice());
		eventPriceTf = new JTextField();
		eventPriceTf.setHorizontalAlignment(SwingConstants.CENTER);
		eventPriceTf.setText(eventPrice);
		eventPriceTf.setFont(new Font("Tahoma", Font.PLAIN, 20));
		eventPriceTf.setEditable(false);
		eventPriceTf.setDisabledTextColor(Color.BLACK);
		eventPriceTf.setColumns(10);
		eventPriceTf.setBorder(new LineBorder(Color.BLACK));
		eventPriceTf.setBackground(Color.WHITE);
		eventPriceTf.setBounds(200, 258, 86, 40);
		panel.add(eventPriceTf);

		eventAddressTf = new JTextField();
		eventAddressTf.setHorizontalAlignment(SwingConstants.CENTER);
		eventAddressTf.setDisabledTextColor(Color.BLACK);
		eventAddressTf.setEditable(false);
		eventAddressTf.setBorder(new LineBorder(Color.BLACK));
		eventAddressTf.setBackground(new Color(255, 255, 255));
		eventAddressTf.setFont(new Font("Tahoma", Font.PLAIN, 20));
		eventAddressTf.setText(eventAttributes.getEventAddress());
		eventAddressTf.setBounds(200, 207, 996, 40);
		panel.add(eventAddressTf);
		eventAddressTf.setColumns(10);

		JButton btnProceedToPayment = new JButton("Buy Ticket(s)");
		btnProceedToPayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TicketsPurchase ticketsPurchase = new TicketsPurchase(f);
				f.getContentPane().removeAll();
				f.getContentPane().add(ticketsPurchase);
				f.repaint();
				f.revalidate();
				f.setVisible(true);
			}
		});
		if (user.getRank() >= 5)
			btnProceedToPayment.setVisible(false);
		btnProceedToPayment.setFocusPainted(false);
		btnProceedToPayment.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				Color.DARK_GRAY, null));
		btnProceedToPayment.setCursor(Cursor
				.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnProceedToPayment.setForeground(Color.DARK_GRAY);
		btnProceedToPayment.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnProceedToPayment.setBackground(new Color(255, 165, 0));
		btnProceedToPayment.setBounds(510, 468, 254, 55);
		panel.add(btnProceedToPayment);

		final JTextArea eventDesTf = new JTextArea();
		eventDesTf.setDisabledTextColor(Color.BLACK);
		eventDesTf.setBorder(new LineBorder(new Color(0, 0, 0)));
		eventDesTf.setEditable(false);
		eventDesTf.setText(eventAttributes.getDescription());
		eventDesTf.setRows(10);
		eventDesTf.setFont(new Font("Tahoma", Font.PLAIN, 20));
		eventDesTf.setBounds(200, 367, 996, 90);
		panel.add(eventDesTf);

		eventDateTf = new JTextField();
		eventDateTf.setHorizontalAlignment(SwingConstants.CENTER);
		eventDateTf.setText(eventAttributes.getEventDate());
		eventDateTf.setFont(new Font("Tahoma", Font.PLAIN, 20));
		eventDateTf.setEditable(false);
		eventDateTf.setDisabledTextColor(Color.BLACK);
		eventDateTf.setColumns(10);
		eventDateTf.setBorder(new LineBorder(Color.BLACK));
		eventDateTf.setBackground(Color.WHITE);
		eventDateTf.setBounds(200, 156, 162, 40);
		panel.add(eventDateTf);

		final JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setOpaque(false);
		panel_1.setBorder(null);
		panel_1.setVisible(false);
		panel_1.setBounds(470, 152, 426, 59);
		panel.add(panel_1);

		final JComboBox comboBox3 = new JComboBox();
		comboBox3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox3.setModel(new DefaultComboBoxModel(new String[] { "2013",
				"2014" }));
		comboBox3.setSelectedIndex(0);
		comboBox3.setBounds(169, 11, 75, 34);
		panel_1.add(comboBox3);

		final JComboBox comboBox2 = new JComboBox();
		comboBox2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox2.setModel(new DefaultComboBoxModel(new String[] { "Jan",
				"Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct",
				"Nov", "Dec" }));
		comboBox2.setSelectedIndex(0);
		comboBox2.setBounds(62, 11, 97, 34);
		panel_1.add(comboBox2);

		final JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "1", "2",
				"3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13",
				"14", "15", "16", "17", "18", "19", "20", "21", "22", "23",
				"24", "25", "26", "27", "28", "29", "30", "31" }));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(10, 11, 42, 34);
		panel_1.add(comboBox);

		JButton btnSetDate = new JButton("Set Date");
		btnSetDate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSetDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String date = (String) comboBox.getSelectedItem();
				String month = (String) comboBox2.getSelectedItem();
				String year = (String) comboBox3.getSelectedItem();

				final String fullDate = date + " " + month + " " + year;

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

		JLabel lblNewLabel = new JLabel("Date :");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblNewLabel.setBounds(40, 163, 71, 25);
		panel.add(lblNewLabel);

		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblAddress.setBounds(40, 214, 116, 25);
		panel.add(lblAddress);

		JLabel lblDescription = new JLabel("Description :");
		lblDescription.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblDescription.setBounds(40, 368, 150, 25);
		panel.add(lblDescription);

		JLabel lblPrice = new JLabel("Price :");
		lblPrice.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblPrice.setBounds(40, 265, 116, 25);
		panel.add(lblPrice);

		JLabel lblEventType = new JLabel("Event Type :");
		lblEventType.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblEventType.setBounds(40, 317, 116, 25);
		panel.add(lblEventType);

		JLabel lblEventTypeDynamic = new JLabel(eventAttributes.getEventType());
		lblEventTypeDynamic.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEventTypeDynamic.setBounds(200, 317, 116, 25);
		panel.add(lblEventTypeDynamic);

		JLabel lblTicketsLeft = new JLabel("Tickets Left :");
		lblTicketsLeft.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblTicketsLeft.setBounds(326, 317, 167, 25);
		panel.add(lblTicketsLeft);

		if (eventAttributes.getEventNoOfTickets() == 0) {
			btnProceedToPayment.setEnabled(false);
		}
		String eventNoOfTickets = Integer.toString(eventAttributes
				.getEventNoOfTickets());
		JLabel lblTicketsLeftDynamic = new JLabel(eventNoOfTickets);
		lblTicketsLeftDynamic.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTicketsLeftDynamic.setBounds(503, 317, 116, 25);
		panel.add(lblTicketsLeftDynamic);

		final JButton btnNewButton = new JButton("");
		btnNewButton.setDisabledIcon(new ImageIcon(EventDetails.class
				.getResource("/polyfive/ui/images/Map.PNG")));
		if (eventAttributes.getMapFileName().equals("")) {
			btnNewButton.setEnabled(false);
		}
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventAttributes eventAttributes = new EventAttributes();
				eventAttributes = f.getStoreEvents();
				String[] cmd = new String[4];
				cmd[0] = "cmd.exe";
				cmd[1] = "/C";
				cmd[2] = "start";
				cmd[3] = "C:/maps/" + eventAttributes.getMapFileName()
						+ ".html";
				try {
					Process p = Runtime.getRuntime().exec(cmd);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
		btnNewButton.setIcon(new ImageIcon(EventDetails.class
				.getResource("/polyfive/ui/images/Map.PNG")));
		btnNewButton.setBounds(66, 11, 1130, 120);
		panel.add(btnNewButton);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFocusPainted(false);
		btnCancel.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				Color.DARK_GRAY, null));
		btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Member user = new Member();
				user = f.getSession();
				if (user.getRank() == 0) {
					PublicCalendar publicCalendar = new PublicCalendar(f);
					f.getContentPane().removeAll();
					f.getContentPane().add(publicCalendar);
					f.repaint();
					f.revalidate();
					f.setVisible(true);
				} else if (user.getRank() <= 4) {
					MemberCalendar memberCalendar = new MemberCalendar(f);
					f.getContentPane().removeAll();
					f.getContentPane().add(memberCalendar);
					f.repaint();
					f.revalidate();
					f.setVisible(true);
				} else {
					AdminCalendar adminCalendar = new AdminCalendar(f);
					f.getContentPane().removeAll();
					f.getContentPane().add(adminCalendar);
					f.repaint();
					f.revalidate();
					f.setVisible(true);
				}
			}
		});
		btnCancel.setBounds(21, 664, 150, 75);
		add(btnCancel);
		btnCancel.setForeground(Color.DARK_GRAY);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnCancel.setBackground(new Color(255, 165, 0));

		JButton button_1 = new JButton("");
		button_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Member user = new Member();
				user = f.getSession();

				if (user.getRank() == 0) {
					PublicCalendar publicCalendar = new PublicCalendar(f);
					f.getContentPane().removeAll();
					f.getContentPane().add(publicCalendar);
					f.repaint();
					f.revalidate();
					f.setVisible(true);
				} else if (user.getRank() <= 4) {
					MemberCalendar memberCalendar = new MemberCalendar(f);
					f.getContentPane().removeAll();
					f.getContentPane().add(memberCalendar);
					f.repaint();
					f.revalidate();
					f.setVisible(true);
				} else {
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
		btnUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		final JButton modify = new JButton("Modify");
		modify.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		modify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventAttributes eventAttributes = new EventAttributes();
				eventAttributes = f.getStoreEvents();
				System.out.println("test" + eventAttributes.getEventName());

				eventAddressTf.setEditable(true);
				eventDesTf.setEditable(true);
				eventPriceTf.setEditable(true);

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

				String price = eventPriceTf.getText();
				String expression = "^\\d{1,5}(\\.\\d{0,2})?$";
				if (price.matches(expression)) {
					int reply = JOptionPane.showConfirmDialog(null,
							"Are you sure you want to update?");
					if (reply == JOptionPane.YES_OPTION) {
						String eventAddNew = eventAddressTf.getText();
						String eventDesNew = eventDesTf.getText();
						String eventDate = eventDateTf.getText();
						String eventPrice = eventPriceTf.getText();
						// String to double
						double eventPriceInt = Double.parseDouble(eventPrice);

						try {

							String sql3 = "update Events set eventAdd='"
									+ eventAddNew + "' , eventDes='"
									+ eventDesNew + "', eventDate='"
									+ eventDate + "', eventPrice='"
									+ eventPrice + "' where eventName='"
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
						eventPriceTf.setEditable(false);

						panel_1.setVisible(false);
						btnUpdate.setVisible(false);
						modify.setVisible(true);

						JOptionPane.showMessageDialog(null, "Event is updated");

						Member user = new Member();
						user = f.getSession();

						if (user.getRank() == 0) {
							PublicCalendar publicCalendar = new PublicCalendar(
									f);
							f.getContentPane().removeAll();
							f.getContentPane().add(publicCalendar);
							f.repaint();
							f.revalidate();
							f.setVisible(true);
						} else if (user.getRank() <= 4) {
							MemberCalendar memberCalendar = new MemberCalendar(
									f);
							f.getContentPane().removeAll();
							f.getContentPane().add(memberCalendar);
							f.repaint();
							f.revalidate();
							f.setVisible(true);
						} else {
							AdminCalendar adminCalendar = new AdminCalendar(f);
							f.getContentPane().removeAll();
							f.getContentPane().add(adminCalendar);
							f.repaint();
							f.revalidate();
							f.setVisible(true);
						}

					}

					else if (reply == JOptionPane.NO_OPTION) {

						eventAddressTf.setEditable(false);
						eventDesTf.setEditable(false);

						btnUpdate.setVisible(false);
						panel_1.setVisible(false);
						modify.setVisible(true);
					}
				} else {
					JOptionPane
							.showMessageDialog(
									null,
									"Please enter only integers or with decimal points for text field 'Price' \n(Two decimal points only)");
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
						eventAttributes.setEventPrice(DBConnectionManager.rs
								.getFloat("eventPrice"));

						eventAddressTf.setText(eventAttributes
								.getEventAddress());
						eventDesTf.setText(eventAttributes.getDescription());
						eventDateTf.setText(eventAttributes.getEventDate());

						String eventPriceString = Double
								.toString(eventAttributes.getEventPrice());
						eventPriceTf.setText(eventPriceString);

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

		if (user.getRank() >= 5) {
			modify.setVisible(true);
		} else
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
		delete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int reply = JOptionPane.showConfirmDialog(null,
						"Warning! Are you sure you want to delete the event?");
				if (reply == JOptionPane.YES_OPTION) {
					EventAttributes eventAttributes = new EventAttributes();
					eventAttributes = f.getStoreEvents();
					String eventName = eventAttributes.getEventName();
					String eventDate = eventAttributes.getEventDate();
					String eventAdd = eventAttributes.getEventAddress();
					Seat seat = new Seat();
					// seat.
					String sql = "DELETE FROM events WHERE eventName ='"
							+ eventName + "' and eventDate='" + eventDate
							+ "' and eventAdd='" + eventAdd + "'";
					try {
						// DBConnectionManager.rs =
						// DBConnectionManager.stmt.execute(sql);
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

				} else {
					JOptionPane.showMessageDialog(null, "Event is not deleted");
				}

				return;

			}
		});
		if (user.getRank() >= 5) {
			delete.setVisible(true);
		} else
			delete.setVisible(false);
		delete.setForeground(Color.DARK_GRAY);
		delete.setFont(new Font("Tahoma", Font.PLAIN, 30));
		delete.setFocusPainted(false);
		delete.setBorder(new EtchedBorder(EtchedBorder.LOWERED,

		Color.DARK_GRAY, null));
		delete.setBackground(new Color(255, 165, 0));
		delete.setBounds(407, 662, 150, 75);
		add(delete);

		JLabel eventHeader = new JLabel();
		eventHeader.setHorizontalAlignment(SwingConstants.CENTER);
		eventHeader.setFont(new Font("Monotype Corsiva", Font.PLAIN, 40));
		eventHeader.setText(eventAttributes.getEventName());
		eventHeader.setBounds(407, 41, 405, 43);
		add(eventHeader);

		JSeparator separator = new JSeparator();
		separator.setBounds(446, 86, 353, 10);
		add(separator);

		if (disableButton == true) {
			btnProceedToPayment.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane
							.showMessageDialog(null,
									"Guest are only allowed to book tickets within one month range from today.");

				}
			});
		}

		else {
			btnProceedToPayment.setEnabled(true);
			btnProceedToPayment.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					TicketsPurchase ticketsPurchase = new TicketsPurchase(f);
					f.getContentPane().removeAll();
					f.getContentPane().add(ticketsPurchase);
					f.repaint();
					f.revalidate();
					f.setVisible(true);

				}
			});
		}

		if (language == 0) {
			lblNewLabel.setText(WelcomePanel.BUNDLE
					.getString("EventDetails.lblNewLabel.text"));
			lblAddress.setText(WelcomePanel.BUNDLE
					.getString("EventDetails.lblAddress.text"));
			lblPrice.setText(WelcomePanel.BUNDLE
					.getString("EventDetails.lblPrice.text"));
			lblEventType.setText(WelcomePanel.BUNDLE
					.getString("EventDetails.lblEventType.text"));
			lblTicketsLeft.setText(WelcomePanel.BUNDLE
					.getString("EventDetails.lblTicketsLeft.text"));
			lblDescription.setText(WelcomePanel.BUNDLE
					.getString("EventDetails.lblDescription.text"));
			btnProceedToPayment.setText(WelcomePanel.BUNDLE
					.getString("EventDetails.btnProceedToPayment.text"));
			btnCancel.setText(WelcomePanel.BUNDLE
					.getString("EventDetails.btnCancel.text"));

		} else if (language == 1) {
			lblNewLabel.setText(WelcomePanel.BUNDLE2
					.getString("EventDetails.lblNewLabel.text"));
			lblAddress.setText(WelcomePanel.BUNDLE2
					.getString("EventDetails.lblAddress.text"));
			lblPrice.setText(WelcomePanel.BUNDLE2
					.getString("EventDetails.lblPrice.text"));
			lblEventType.setText(WelcomePanel.BUNDLE2
					.getString("EventDetails.lblEventType.text"));
			lblTicketsLeft.setText(WelcomePanel.BUNDLE2
					.getString("EventDetails.lblTicketsLeft.text"));
			lblDescription.setText(WelcomePanel.BUNDLE2
					.getString("EventDetails.lblDescription.text"));
			btnProceedToPayment.setText(WelcomePanel.BUNDLE2
					.getString("EventDetails.btnProceedToPayment.text"));
			btnCancel.setText(WelcomePanel.BUNDLE2
					.getString("EventDetails.btnCancel.text"));
		}

		super.setLayout();

	}
}
