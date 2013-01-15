package polyfive.ui.adminpages;

import javax.swing.JPanel;
import javax.swing.JTextPane;

import java.awt.Cursor;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;
import java.awt.Component;
import javax.swing.Box;
import polyfive.ui.master.MasterPanel;

public class adminAddEvent extends MasterPanel {
	private JTextField txtSearchKeyword;


	/**
	 * Create the panel.
	 */
	public adminAddEvent() {
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
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(467, 577, 89, 23);
		add(btnBack);
		
		JButton btnAddEvent = new JButton("Add Event");
		btnAddEvent.setBounds(868, 577, 89, 23);
		add(btnAddEvent);
		
		JButton btnModifyEvent = new JButton("Modify Event");
		btnModifyEvent.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnModifyEvent.setBounds(968, 278, 109, 23);
		add(btnModifyEvent);

		super.setLayout();
		
	}
}
