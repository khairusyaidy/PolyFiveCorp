/* 
 * Program Name : AdminSearchEvents.java
 * Purpose : List all events
 * 
 * Authour: Muhammad Khairyl Rusyaidy
 * Admin No: 120258L
 * Module Group : IS1201
 * Last Modified: 29/1/2013
 * 
 */

package polyfive.ui.adminpages;

import polyfive.entities.EventAttributes;
import polyfive.entities.Member;
import polyfive.entities.dao.DBConnectionManager;
import polyfive.entities.dao.EventDetailsDao;
import polyfive.ui.adminpages.AdminCalendar;
import polyfive.ui.master.*;

import polyfive.ui.memberpages.MemberCalendar;
import polyfive.ui.publicpages.EventDetails;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Component;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Cursor;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.JCheckBox;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.border.EtchedBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import javax.swing.JSeparator;

public class AdminSearchEvents extends MasterPanel {
	private JButton button;
	private static MainFrame f = null;
	private JTable table;
	private int numberOfUsers;
	private JTextArea textArea;
	private JButton button_1;

	/**
	 * Create the panel.
	 */

	public AdminSearchEvents(MainFrame frame) {

		f = frame;
		setSize(new Dimension(1366, 768));
		setFocusable(false);
		setBackground(Color.BLACK);

		setLayout(null);

		button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Member user = new Member();
				user = f.getSession();
				if (user.getRank() <= 4) {
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
		button.setIcon(new ImageIcon(AdminSearchEvents.class
				.getResource("/polyfive/ui/images/p5cicon7575.png")));
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setBorder(null);
		button.setBounds(21, 21, 75, 75);
		add(button);

		// adding table here + scrollpane

		final JTable table = new JTable(new JTableModel());
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(327, 178, 700, 430);
		add(scrollPane);
		table.setFillsViewportHeight(true);

		TableCellRenderer buttonRenderer = new JTableButtonRenderer();
		table.getColumn("Event Details").setCellRenderer(buttonRenderer);
		// table.getColumn("Button2").setCellRenderer(buttonRenderer);
		table.addMouseListener(new JTableButtonMouseListener(table));
		table.setRowHeight(60);

		// Whenever filterText changes, invoke newFilter.

		//

		button_1 = new JButton("Back");
		button_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Member user = new Member();
				user = f.getSession();
				if (user.getRank() <= 4) {
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
		button_1.setForeground(Color.DARK_GRAY);
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		button_1.setFocusPainted(false);
		button_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				Color.DARK_GRAY, null));
		button_1.setBackground(new Color(255, 165, 0));
		button_1.setBounds(21, 664, 150, 75);
		add(button_1);

		JLabel lblNewLabel = new JLabel("List of Events");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(357, 42, 191, 57);
		add(lblNewLabel);

		JSeparator separator = new JSeparator();
		separator.setBounds(311, 99, 296, 2);
		add(separator);

		super.setLayout();

	}

	public class JTableButtonRenderer implements TableCellRenderer {
		@Override
		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus, int row,
				int column) {
			JButton button = (JButton) value;
			if (isSelected) {
				button.setForeground(table.getSelectionForeground());
				button.setBackground(table.getSelectionBackground());
			} else {
				button.setForeground(table.getForeground());
				button.setBackground(UIManager.getColor("Button.background"));
			}
			return button;
		}
	}

	public class JTableButtonMouseListener extends MouseAdapter {
		private final JTable table;

		public JTableButtonMouseListener(JTable table) {
			this.table = table;
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			int column = table.getColumnModel().getColumnIndexAtX(e.getX());
			int row = e.getY() / table.getRowHeight();

			if (row < table.getRowCount() && row >= 0
					&& column < table.getColumnCount() && column >= 0) {
				Object value = table.getValueAt(row, column);
				if (value instanceof JButton) {
					((JButton) value).doClick();
				}
			}
		}
	}

	public static class JTableModel extends AbstractTableModel {

		private static final long serialVersionUID = 1L;
		private static final String[] COLUMN_NAMES = new String[] {
				"Event Names", "Date of Events", "Event Details" };
		private static final Class<?>[] COLUMN_TYPES = new Class<?>[] {
				String.class, String.class, JButton.class };

		ArrayList<polyfive.entities.EventAttributes> eventDetails = EventDetailsDao
				.RetrieveAll();

		@Override
		public int getColumnCount() {
			return COLUMN_NAMES.length;
		}

		@Override
		public int getRowCount() {

			int row = EventDetailsDao.getMax();
			return row;
		}

		@Override
		public String getColumnName(int columnIndex) {
			return COLUMN_NAMES[columnIndex];
		}

		@Override
		public Class<?> getColumnClass(int columnIndex) {
			return COLUMN_TYPES[columnIndex];
		}

		@Override
		public Object getValueAt(final int rowIndex, final int columnIndex) {
			switch (columnIndex) {
			case 0:
				return eventDetails.get(rowIndex).getEventName();
			case 1:
				return eventDetails.get(rowIndex).getEventDate();
				// case 2: // fall through
			case 2:
				final JButton button = new JButton(COLUMN_NAMES[columnIndex]);
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						String eventName = eventDetails.get(rowIndex)
								.getEventName();
						EventAttributes eventAttributes = new EventAttributes();
						eventAttributes.setEventName(eventName);
						f.setStoreEvents(eventAttributes);

						EventDetails eventDetailsPage = new EventDetails(f);
						f.getContentPane().removeAll();
						f.getContentPane().add(eventDetailsPage);
						f.repaint();
						f.revalidate();
						f.setVisible(true);

						/*
						 * EventDetailsRNR eventDetailsRNR = new
						 * EventDetailsRNR(f); /*EventDetails eventDetails = new
						 * EventDetails(f); if (rowIndex == 0) {
						 * f.getContentPane().removeAll();
						 * f.getContentPane().add(eventDetailsRNR); f.repaint();
						 * f.revalidate(); f.setVisible(true); } else {
						 * f.getContentPane().removeAll();
						 * f.getContentPane().add(eventDetails); f.repaint();
						 * f.revalidate(); f.setVisible(true);
						 * 
						 * }
						 */
					}

				});
				return button;

			default:
				return "Error";
			}
		}
	}
}
