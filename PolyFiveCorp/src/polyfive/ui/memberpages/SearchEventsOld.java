package polyfive.ui.memberpages;
import polyfive.ui.adminpages.*;
import polyfive.ui.images.*;
import polyfive.ui.master.*;
import polyfive.ui.misc.MultiLineCellRenderer;
import polyfive.ui.publicpages.*;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.Cursor;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.JCheckBox;
import java.awt.Dimension;
import javax.swing.border.EtchedBorder;

public class SearchEventsOld extends MasterPanel {
	private JTextField textField;
	private JButton button;
	private MainFrame f = null;
	private JTable table;
	private int numberOfUsers;
	private JTextArea textArea;
	private JButton button_1;

	/**
	 * Create the panel.
	 */
	public SearchEventsOld() {
		setSize(new Dimension(1366, 768));
		setFocusable(false);
		setBackground(Color.BLACK);
		setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(361, 98, 470, 45);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, null));
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setBackground(new Color(255, 165, 0));
		btnNewButton_1.setForeground(Color.DARK_GRAY);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.setBounds(849, 95, 170, 50);
		add(btnNewButton_1);
		
		button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    MemberCalendar memberCalendar= f.getMemberCalendar();
			    f.getContentPane().removeAll();
			    f.getContentPane().add(memberCalendar);
			    f.repaint();
			    f.revalidate();
			    f.setVisible(true);
			}
		});
		button.setIcon(new ImageIcon(SearchEventsOld.class.getResource("/polyFive/ui/images/p5cicon7575.png")));
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setBorder(null);
		button.setBounds(21, 21, 75, 75);
		add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(359, 208, 660, 397);
		add(scrollPane);
		
		
		table = new JTable() ;
		table.setEnabled(false);
 
		scrollPane.setViewportView(table);
		table.setRowHeight(60);
		table.getTableHeader().setReorderingAllowed(false);
		table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		table.setCellSelectionEnabled(true);
		table.setDefaultRenderer(String.class, new MultiLineCellRenderer());
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Rock N Roll\n27 July 2012", "TEST"},
				{"Disney 28 July 2012", null},
				{"", null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"List of Events", ""
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(253);
		table.getColumnModel().getColumn(1).setPreferredWidth(15);
		table.getColumnModel().getColumn(1).setMinWidth(10);

		
		button_1 = new JButton("Back");
		button_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberCalendar memberCalendar = f.getMemberCalendar();
			    f.getContentPane().removeAll();
			    f.getContentPane().add(memberCalendar);
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
		button_1.setBounds(21, 664, 150, 75);
		add(button_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setOpaque(false);
		panel.setBounds(361, 161, 470, 36);
		add(panel);
		panel.setLayout(null);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Sort by Date");
		chckbxNewCheckBox.setFocusPainted(false);
		chckbxNewCheckBox.setOpaque(false);
		chckbxNewCheckBox.setBounds(191, 7, 97, 23);
		panel.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Alphabetical Order ( A - Z )");
		chckbxNewCheckBox_1.setFocusPainted(false);
		chckbxNewCheckBox_1.setOpaque(false);
		chckbxNewCheckBox_1.setBackground(Color.WHITE);
		chckbxNewCheckBox_1.setBounds(6, 7, 198, 23);
		panel.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Location");
		chckbxNewCheckBox_2.setForeground(Color.BLACK);
		chckbxNewCheckBox_2.setFocusPainted(false);
		chckbxNewCheckBox_2.setOpaque(false);
		chckbxNewCheckBox_2.setBounds(312, 7, 97, 23);
		panel.add(chckbxNewCheckBox_2);
		
		JButton btnNewButton = new JButton("Disney");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setFocusPainted(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    EventDetails eventDetails = f.getEventDetails();
			    f.getContentPane().removeAll();
			    f.getContentPane().add(eventDetails);
			    f.repaint();
			    f.revalidate();
			    f.setVisible(true);
			}
		});
		btnNewButton.setBorder(null);
		btnNewButton.setBounds(930, 630, 89, 23);
		add(btnNewButton);
		
		JButton btnRockNRoll = new JButton("Rock N Roll");
		btnRockNRoll.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRockNRoll.setFocusPainted(false);
		btnRockNRoll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventDetailsRNR eventDetailsRNR = f.getEventDetailsRNR();
			    f.getContentPane().removeAll();
			    f.getContentPane().add(eventDetailsRNR);
			    f.repaint();
			    f.revalidate();
			    f.setVisible(true);
			}
		});
		btnRockNRoll.setBorder(null);
		btnRockNRoll.setBounds(818, 630, 89, 23);
		add(btnRockNRoll);

	
		
		

		
		
		super.setLayout();

	}
	
	
	
	
	public SearchEventsOld(MainFrame frame) {
		this();
		f = frame;
		// TODO Auto-generated constructor stub
	}
}
