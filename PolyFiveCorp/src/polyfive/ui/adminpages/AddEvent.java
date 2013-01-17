package polyfive.ui.adminpages;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import polyfive.ui.master.MainFrame;
import polyfive.ui.master.MasterPanel;
;

public class AddEvent extends MasterPanel {
	private JTextField txtWaypoint;
	private JTextField txtEventName;
	private JTextField txtAddress;
	private JTextField txtCostOfTicket;
	private JTextField txtDateOfEvent;
	private JTextField txtDescription;
	private JTextField txtX;
	private JTextField txtY;
	private JTextField tfEventName;
	private JTextField tfAddress;
	private JTextField tfCostOfTicket;
	
	
	
	public AddEvent(MainFrame frame) {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JButton button = new JButton("");
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setIcon(new ImageIcon(AddEvent.class.getResource("/polyfive/ui/images/p5cicon7575.png")));
		button.setBorder(null);
		button.setBounds(21, 21, 75, 75);
		add(button);
		
		txtWaypoint = new JTextField();
		txtWaypoint.setEditable(false);
		txtWaypoint.setText("WayPoint");
		txtWaypoint.setBounds(459, 203, 171, 25);
		add(txtWaypoint);
		txtWaypoint.setColumns(10);
		
		txtEventName = new JTextField();
		txtEventName.setEditable(false);
		txtEventName.setText("Event Name");
		txtEventName.setBounds(459, 239, 171, 25);
		add(txtEventName);
		txtEventName.setColumns(10);
		
		txtAddress = new JTextField();
		txtAddress.setEditable(false);
		txtAddress.setText("Address");
		txtAddress.setBounds(459, 275, 171, 25);
		add(txtAddress);
		txtAddress.setColumns(10);
		
		txtCostOfTicket = new JTextField();
		txtCostOfTicket.setEditable(false);
		txtCostOfTicket.setText("Cost of Ticket");
		txtCostOfTicket.setBounds(459, 311, 171, 25);
		add(txtCostOfTicket);
		txtCostOfTicket.setColumns(10);
		
		txtDateOfEvent = new JTextField();
		txtDateOfEvent.setEditable(false);
		txtDateOfEvent.setText("Date of Event");
		txtDateOfEvent.setBounds(459, 347, 171, 25);
		add(txtDateOfEvent);
		txtDateOfEvent.setColumns(10);
		
		txtDescription = new JTextField();
		txtDescription.setEditable(false);
		txtDescription.setText("Description");
		txtDescription.setBounds(459, 383, 171, 25);
		add(txtDescription);
		txtDescription.setColumns(10);
		
		txtX = new JTextField();
		txtX.setText("X");
		txtX.setBounds(708, 205, 86, 23);
		add(txtX);
		txtX.setColumns(10);
		
		txtY = new JTextField();
		txtY.setText("Y");
		txtY.setBounds(820, 205, 86, 23);
		add(txtY);
		txtY.setColumns(10);
		
		tfEventName = new JTextField();
		tfEventName.setBounds(708, 239, 198, 25);
		add(tfEventName);
		tfEventName.setColumns(10);
		
		tfAddress = new JTextField();
		tfAddress.setBounds(708, 277, 198, 23);
		add(tfAddress);
		tfAddress.setColumns(10);
		
		tfCostOfTicket = new JTextField();
		tfCostOfTicket.setBounds(708, 313, 198, 23);
		add(tfCostOfTicket);
		tfCostOfTicket.setColumns(10);
		
		JTextArea taDescription = new JTextArea();
		taDescription.setBounds(708, 383, 198, 180);
		add(taDescription);
		
		JComboBox cbDay = new JComboBox();
		cbDay.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		cbDay.setBounds(708, 349, 50, 25);
		add(cbDay);
		
		JComboBox cbMonth = new JComboBox();
		cbMonth.setModel(new DefaultComboBoxModel(new String[] {"Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sept", "Oct", "Nov", "Dec"}));
		cbMonth.setBounds(766, 349, 78, 23);
		add(cbMonth);
		
		JComboBox cbYear = new JComboBox();
		cbYear.setModel(new DefaultComboBoxModel(new String[] {"2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022"}));
		cbYear.setBounds(854, 349, 50, 23);
		add(cbYear);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(317, 604, 89, 23);
		add(btnBack);

		
		super.setLayout();

	}
}
