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
import java.awt.Font;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
;

public class AddEvent extends MasterPanel {
	private JTextField txtWaypoint;
	private JTextField txtEventName;
	private JTextField txtAddress;
	private JTextField txtDateOfEvent;
	private JTextField txtDescription;
	private JTextField txtX;
	private JTextField txtY;
	private JTextField tfEventName;
	private JTextField tfAddress;
	private MainFrame f = null;
	
	
	
	public AddEvent(MainFrame frame) {
		f = frame;
		setBackground(Color.WHITE);
		setLayout(null);
		
		JButton button = new JButton("");
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setIcon(new ImageIcon(AddEvent.class.getResource("/polyfive/ui/images/p5cicon7575.png")));
		button.setBorder(null);
		button.setBounds(21, 21, 75, 75);
		add(button);
		
		txtWaypoint = new JTextField();
		txtWaypoint.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtWaypoint.setEditable(false);
		txtWaypoint.setText("WayPoint");
		txtWaypoint.setBounds(411, 142, 219, 49);
		add(txtWaypoint);
		txtWaypoint.setColumns(10);
		
		txtEventName = new JTextField();
		txtEventName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtEventName.setEditable(false);
		txtEventName.setText("Event Name");
		txtEventName.setBounds(411, 202, 219, 49);
		add(txtEventName);
		txtEventName.setColumns(10);
		
		txtAddress = new JTextField();
		txtAddress.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtAddress.setEditable(false);
		txtAddress.setText("Address");
		txtAddress.setBounds(411, 262, 219, 50);
		add(txtAddress);
		txtAddress.setColumns(10);
		
		txtDateOfEvent = new JTextField();
		txtDateOfEvent.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtDateOfEvent.setEditable(false);
		txtDateOfEvent.setText("Date of Event");
		txtDateOfEvent.setBounds(411, 323, 218, 49);
		add(txtDateOfEvent);
		txtDateOfEvent.setColumns(10);
		
		txtDescription = new JTextField();
		txtDescription.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtDescription.setEditable(false);
		txtDescription.setText("Description");
		txtDescription.setBounds(411, 383, 219, 49);
		add(txtDescription);
		txtDescription.setColumns(10);
		
		txtX = new JTextField();
		txtX.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtX.setText("X");
		txtX.setBounds(708, 142, 109, 49);
		add(txtX);
		txtX.setColumns(10);
		
		txtY = new JTextField();
		txtY.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtY.setText("Y");
		txtY.setBounds(820, 142, 109, 49);
		add(txtY);
		txtY.setColumns(10);
		
		tfEventName = new JTextField();
		tfEventName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tfEventName.setBounds(708, 202, 221, 49);
		add(tfEventName);
		tfEventName.setColumns(10);
		
		tfAddress = new JTextField();
		tfAddress.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tfAddress.setBounds(708, 262, 221, 50);
		add(tfAddress);
		tfAddress.setColumns(10);
		
		JTextArea taDescription = new JTextArea();
		taDescription.setBounds(708, 383, 221, 201);
		add(taDescription);
		
		JComboBox cbDay = new JComboBox();
		cbDay.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbDay.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		cbDay.setBounds(707, 323, 50, 49);
		add(cbDay);
		
		JComboBox cbMonth = new JComboBox();
		cbMonth.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbMonth.setModel(new DefaultComboBoxModel(new String[] {"Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sept", "Oct", "Nov", "Dec"}));
		cbMonth.setBounds(767, 323, 78, 49);
		add(cbMonth);
		
		JComboBox cbYear = new JComboBox();
		cbYear.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbYear.setModel(new DefaultComboBoxModel(new String[] {"2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022"}));
		cbYear.setBounds(855, 323, 74, 49);
		add(cbYear);
		
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
		
		JButton AddEvent = new JButton("Add Event");
		AddEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				adminAddEvent adminAddEvent = new adminAddEvent(f);
				f.getContentPane().removeAll();
				f.getContentPane().add(adminAddEvent);
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
		AddEvent.setBounds(779, 603, 150, 75);
		add(AddEvent);

		
		super.setLayout();

	}
}
