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
import polyfive.ui.memberpages.CreateSeatPanel;
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
import javax.swing.JCheckBox;
import javax.swing.JSeparator;
import javax.swing.JLabel;
;

public class AddEvent extends MasterPanel {
	private JTextField tfEventName;
	private JTextField tfAddress;
	private MainFrame f = null;
	private JTextField tfPrice;
	private JTextField tfNoOfTickets;
	private JTextField tfMapFileName;
	
	
	
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
		
		final JLabel lblPriceOfTickets = new JLabel("Price of Ticket :   $");
		lblPriceOfTickets.setVisible(false);
		lblPriceOfTickets.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPriceOfTickets.setBounds(726, 623, 175, 40);
		add(lblPriceOfTickets);
		
		JLabel lblMapFileName = new JLabel("Map File Name :");
		lblMapFileName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMapFileName.setBounds(418, 519, 175, 35);
		add(lblMapFileName);
		
		JLabel lblDescription = new JLabel("Description :");
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDescription.setBounds(441, 400, 175, 35);
		add(lblDescription);
		
		JLabel lblTypeOfEvent = new JLabel("Type of Event :");
		lblTypeOfEvent.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTypeOfEvent.setBounds(418, 344, 175, 35);
		add(lblTypeOfEvent);
		
		JLabel lblDateOfEvent = new JLabel("Date of Event :");
		lblDateOfEvent.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDateOfEvent.setBounds(418, 287, 175, 35);
		add(lblDateOfEvent);
		
		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAddress.setBounds(471, 223, 175, 35);
		add(lblAddress);
		
		JLabel lblEventName = new JLabel("Event Name :");
		lblEventName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEventName.setBounds(430, 163, 175, 35);
		add(lblEventName);
		
		JLabel lblMap = new JLabel("*Place map file in ' C:/maps ' after creating it");
		lblMap.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMap.setBounds(590, 577, 357, 35);
		add(lblMap);
		
		final JLabel lblTickets = new JLabel("*Enter only whole numbers");
		lblTickets.setVisible(false);
		lblTickets.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTickets.setBounds(490, 664, 357, 35);
		add(lblTickets);
		
		final JLabel lblPrice = new JLabel("*Only accepts whole numbers or with 2 decimal places");
		lblPrice.setVisible(false);
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrice.setBounds(739, 664, 357, 35);
		add(lblPrice);
		
		final JLabel lblNoOfTicketsSelling = new JLabel("No of Tickets Selling :");
		lblNoOfTicketsSelling.setVisible(false);
		lblNoOfTicketsSelling.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNoOfTicketsSelling.setBounds(358, 619, 210, 49);
		add(lblNoOfTicketsSelling);
		
		tfEventName = new JTextField();
		tfEventName.setBorder(new LineBorder(Color.BLACK));
		tfEventName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfEventName.setBounds(593, 163, 283, 35);
		add(tfEventName);
		tfEventName.setColumns(10);
		
		tfAddress = new JTextField();
		tfAddress.setBorder(new LineBorder(Color.BLACK));
		tfAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfAddress.setBounds(593, 223, 283, 35);
		add(tfAddress);
		tfAddress.setColumns(10);
		
		final JTextArea taDescription = new JTextArea();
		taDescription.setBorder(new LineBorder(new Color(0, 0, 0)));
		taDescription.setFont(new Font("Tahoma", Font.PLAIN, 20));
		taDescription.setBounds(590, 404, 423, 91);
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
		Back.setBounds(21, 664, 150, 75);
		add(Back);


		
	
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBorder(null);
		panel.setBounds(574, 277, 273, 59);
		add(panel);
		panel.setLayout(null);
		
		
		
		
		
		final JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_2.setBounds(188, 11, 75, 34);
		panel.add(comboBox_2);
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"2013", "2014"}));
		comboBox_2.setSelectedIndex(0);
		
		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_1.setBounds(81, 11, 97, 34);
		panel.add(comboBox_1);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}));
		comboBox_1.setSelectedIndex(0);
		
		
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setBounds(20, 11, 42, 34);
		panel.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox.setSelectedIndex(0);
		
		
		final JButton AddEvent = new JButton("Add Event");
		AddEvent.setVisible(false);
	
		AddEvent.setForeground(Color.DARK_GRAY);
		AddEvent.setFont(new Font("Tahoma", Font.PLAIN, 30));
		AddEvent.setFocusPainted(false);
		AddEvent.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, null));
		AddEvent.setBackground(new Color(255, 165, 0));
		AddEvent.setBounds(1188, 664, 150, 75);
		add(AddEvent);
		
		tfPrice = new JTextField();
		tfPrice.setVisible(false);
		tfPrice.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfPrice.setColumns(10);
		tfPrice.setBorder(new LineBorder(Color.BLACK));
		tfPrice.setBounds(911, 626, 80, 35);
		add(tfPrice);
		
		
		
		
		final JCheckBox chckbxStanding = new JCheckBox("Standing");
		chckbxStanding.setFocusPainted(false);
		chckbxStanding.setOpaque(false);
		chckbxStanding.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chckbxStanding.setBounds(593, 352, 97, 23);
		add(chckbxStanding);
		
		final JCheckBox chckbxSitting = new JCheckBox("Sitting");
		chckbxSitting.setFocusPainted(false);
		chckbxSitting.setOpaque(false);
		chckbxSitting.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chckbxSitting.setBounds(692, 352, 97, 23);
		add(chckbxSitting);
		
		final JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateSeatPanel createSeatPanel= new CreateSeatPanel(f);
				f.getContentPane().removeAll();
				f.getContentPane().add(createSeatPanel);
				f.repaint();
				f.revalidate();
				f.setVisible(true);
				////
			}
		});
		btnNext.setVisible(false);
		btnNext.setForeground(Color.DARK_GRAY);
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNext.setFocusPainted(false);
		btnNext.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, null));
		btnNext.setBackground(new Color(255, 165, 0));
		btnNext.setBounds(1188, 664, 150, 75);
		add(btnNext);
		
		
		
		chckbxStanding.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean check = chckbxStanding.isSelected();
				if(check == true){
				AddEvent.setVisible(true);
				chckbxSitting.setEnabled(false);
				lblPriceOfTickets.setVisible(true);
				tfPrice.setVisible(true);
				lblNoOfTicketsSelling.setVisible(true);
				tfNoOfTickets.setVisible(true);
				lblTickets.setVisible(true);
				lblPrice.setVisible(true);
				
				
				}
				else if(check == false){
					AddEvent.setVisible(false);
				chckbxSitting.setEnabled(true);
				lblPriceOfTickets.setVisible(false);
				tfPrice.setVisible(false);
				lblNoOfTicketsSelling.setVisible(false);
				tfNoOfTickets.setVisible(false);
				lblTickets.setVisible(false);
				lblPrice.setVisible(false);
				}
			}
		});
		
		
		chckbxSitting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean check = chckbxSitting.isSelected();
				if(check == true){
				chckbxStanding.setEnabled(false);
				btnNext.setVisible(true);
				}
				else if (check == false){
				btnNext.setVisible(false);
				chckbxStanding.setEnabled(true);
				}
			}
		});
		
		
		
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
				String price = tfPrice.getText();
				String expression = "^\\d{1,5}(\\.\\d{0,2})?$";
				
				String noOfTickets = tfNoOfTickets.getText();
				String expression2 = "^(0|[1-9][0-9]*)$";
				
				String eventMapFileName = tfMapFileName.getText();
				String expression3 = "^[a-zA-Z]+$";
				
				// && (eventMapFileName.matches(expression3)) asd
				 
				if ((price.matches(expression)) && (noOfTickets.matches(expression2)) ){
					int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to add this new event ?");
					if (reply == JOptionPane.YES_OPTION){
						String eventName = tfEventName.getText();
						String eventAdd = tfAddress.getText();
						String des = taDescription.getText();
						
						//Change string to double
						String eventPrice = tfPrice.getText();
						float eventPriceInt = Float.parseFloat(eventPrice);
						
						String eventNoOfTickets = tfNoOfTickets.getText();
						int eventNoOfTicketsInt = Integer.parseInt(eventNoOfTickets);
						
				//		String eventNoOfTickets = tfEventNoOFtickets.
						String eventType = null;
						
						if(chckbxSitting.isSelected()){
							eventType = chckbxSitting.getText();
						}
						else if (chckbxStanding.isSelected()){
							eventType = chckbxStanding.getText();
						}
						

						EventAttributes addEvent = new EventAttributes();
						
						String date = (String)comboBox.getSelectedItem();
						String month = (String)comboBox_1.getSelectedItem();
						String year = (String)comboBox_2.getSelectedItem();
						
						final String fullDate = date+ " " +month+ " " + year ;
						
						
						
						
						addEvent.setEventName(eventName);
						addEvent.setEventAddress(eventAdd);
						addEvent.setEventDate(fullDate);
						addEvent.setDescription(des);
						addEvent.setEventPrice(eventPriceInt);
						addEvent.setEventType(eventType);
						addEvent.setEventNoOfTickets(eventNoOfTicketsInt);
						addEvent.setMapFileName(eventMapFileName);
						
						try{
						EventDetailsDao.insertEventDetails(addEvent);
						
						}
						catch(Exception ex){
						JOptionPane.showMessageDialog(null, "Event is not added \n" +ex);
						SearchEvents searchEvents= new SearchEvents(f);
						f.getContentPane().removeAll();
						f.getContentPane().add(searchEvents);
						f.repaint();
						f.revalidate();
						f.setVisible(true);
						
						}
						
						JOptionPane.showMessageDialog(null, "Event is added");
						SearchEvents searchEvents= new SearchEvents(f);
						f.getContentPane().removeAll();
						f.getContentPane().add(searchEvents);
						f.repaint();
						f.revalidate();
						f.setVisible(true);

						
					}
					else if (reply == JOptionPane.NO_OPTION){
						JOptionPane.showMessageDialog(null, "Event is not added");
					SearchEvents searchEvents= new SearchEvents(f);
					f.getContentPane().removeAll();
					f.getContentPane().add(searchEvents);
					f.repaint();
					f.revalidate();
					f.setVisible(true);
					}
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Please make sure that you filled in accurately");

				}

				}
			});
		
		JSeparator separator = new JSeparator();
		separator.setBounds(374, 111, 299, 10);
		add(separator);
		
		JLabel lblNewLabel = new JLabel("Add Event");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(392, 69, 243, 35);
		add(lblNewLabel);
		
		tfNoOfTickets = new JTextField();
		tfNoOfTickets.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfNoOfTickets.setVisible(false);
		tfNoOfTickets.setColumns(10);
		tfNoOfTickets.setBorder(new LineBorder(Color.BLACK));
		tfNoOfTickets.setBounds(590, 626, 80, 35);
		add(tfNoOfTickets);
		
		tfMapFileName = new JTextField();
		tfMapFileName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfMapFileName.setColumns(10);
		tfMapFileName.setBorder(new LineBorder(Color.BLACK));
		tfMapFileName.setBounds(590, 519, 283, 35);
		add(tfMapFileName);
		
		JLabel lblonlyLettersWith = new JLabel("*Only letters with no spaces");
		lblonlyLettersWith.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblonlyLettersWith.setBounds(590, 553, 357, 35);
		add(lblonlyLettersWith);
		

		

		

		
		super.setLayout();
		

	}
}

