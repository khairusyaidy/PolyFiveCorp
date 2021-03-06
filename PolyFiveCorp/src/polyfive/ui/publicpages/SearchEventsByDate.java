/* 
 * Program Name : SearchEventsByDate.java
 * Purpose : Users are able to find the events for that particular date clicked
 * 
 * Authour: Muhammad Khairyl Rusyaidy
 * Admin No: 120258L
 * Module Group : IS1201
 * Last Modified: 29/1/2013
 * 
 */

package polyfive.ui.publicpages;

import polyfive.entities.ChangeLanguage;
import polyfive.entities.EventAttributes;
import polyfive.entities.Member;
import polyfive.entities.dao.DBConnectionManager;
import polyfive.entities.dao.EventDetailsDao;
import polyfive.ui.adminpages.AdminCalendar;
import polyfive.ui.master.*;
import polyfive.ui.memberpages.MemberCalendar;

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
import javax.swing.RowSorter;
import javax.swing.ScrollPaneConstants;
import javax.swing.SortOrder;
import javax.swing.UIManager;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JCheckBox;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.border.EtchedBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import javax.swing.JSeparator;

public class SearchEventsByDate extends MasterPanel {
	private JButton button;
	private static MainFrame f = null;
	private JTable table;
	private int numberOfUsers;
	private JTextArea textArea;
	private JButton btnBack;
	public static String Date;
	public static String col1 = "Event Name";
	public static String col2 = "Event Date";
	public static String col3 = "Event Details";

	/**
	 * Create the panel.
	 */

	public SearchEventsByDate(MainFrame frame) {

		ChangeLanguage changeLanguage = new ChangeLanguage();
		changeLanguage = f.getStoreLanguage();
		int language = changeLanguage.getChangeLanguage();

		f = frame;
		EventAttributes event = new EventAttributes();
		event = f.getStoreEvents();
		Date = event.getEventDate();

		Member user = new Member();
		user = f.getSession();

		setSize(new Dimension(1366, 768));
		setFocusable(false);
		setBackground(Color.BLACK);

		setLayout(null);

		button = new JButton("");
		button.addActionListener(new ActionListener() {
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
		button.setIcon(new ImageIcon(SearchEventsByDate.class
				.getResource("/polyfive/ui/images/p5cicon7575.png")));
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setBorder(null);
		button.setBounds(21, 21, 75, 75);
		add(button);

		btnBack = new JButton("Back");
		btnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBack.addActionListener(new ActionListener() {
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
		btnBack.setForeground(Color.DARK_GRAY);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnBack.setFocusPainted(false);
		btnBack.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				Color.DARK_GRAY, null));
		btnBack.setBackground(new Color(255, 165, 0));
		btnBack.setBounds(21, 664, 150, 75);
		add(btnBack);

		JLabel lblListOfEvents = new JLabel("List of Events by Date");
		lblListOfEvents.setFont(new Font("Monotype Corsiva", Font.PLAIN, 40));
		lblListOfEvents.setBounds(459, 58, 547, 57);
		add(lblListOfEvents);

		JSeparator separator = new JSeparator();
		separator.setBounds(378, 113, 490, 2);
		add(separator);

		if (language == 0) {

			btnBack.setText(WelcomePanel.BUNDLE
					.getString("SearchEventsByDate.btnBack.text"));
			lblListOfEvents.setText(WelcomePanel.BUNDLE
					.getString("SearchEventsByDate.lblListOfEvents.text"));
		} else if (language == 1) {

			btnBack.setText(WelcomePanel.BUNDLE2
					.getString("SearchEventsByDate.btnBack.text"));
			lblListOfEvents.setText(WelcomePanel.BUNDLE2
					.getString("SearchEventsByDate.lblListOfEvents.text"));
			separator.setBounds(378, 113, 630, 2);
		}
		else if (language == 2){
			btnBack.setFont(new Font("Arial Unicode MS", Font.PLAIN, 30));
			lblListOfEvents.setFont(new Font("Arial Unicode MS", Font.PLAIN, 40));
			btnBack.setText(WelcomePanel.BUNDLE3
					.getString("SearchEventsByDate.btnBack.text"));
			lblListOfEvents.setText(WelcomePanel.BUNDLE3
					.getString("SearchEventsByDate.lblListOfEvents.text"));
			separator.setBounds(378, 113, 300, 2);

		}

		// adding table here + scrollpane

		final JTable table = new JTable(new JTableModel());
		table.setDragEnabled(false);

		table.setAutoCreateRowSorter(true);
		table.setGridColor(new Color(0, 0, 0));

		table.getTableHeader().setReorderingAllowed(false);
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 13));
		scrollPane
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(212, 162, 947, 443);
		add(scrollPane);
		table.setFillsViewportHeight(true);

		TableCellRenderer buttonRenderer = new JTableButtonRenderer();
		table.getColumn(col3).setCellRenderer(buttonRenderer);
		table.addMouseListener(new JTableButtonMouseListener(table));
		table.setRowHeight(60);

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
		private static final String[] COLUMN_NAMES = new String[] { col1, col2,
				col3 };
		private static final Class<?>[] COLUMN_TYPES = new Class<?>[] {
				String.class, Date.class, JButton.class };

		ArrayList<EventAttributes> eventDetails = EventDetailsDao
				.RetrieveAllByDate(Date);

		@Override
		public int getColumnCount() {
			return COLUMN_NAMES.length;
		}

		@Override
		public int getRowCount() {

			int row = EventDetailsDao.getMaxByDate(Date);
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

				String date = eventDetails.get(rowIndex).getEventDate();
				SimpleDateFormat dateFormat = new SimpleDateFormat("d MMM yyyy");
				try {
					Date convertedDate = dateFormat.parse(date);
					return convertedDate;
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			case 2:
				final JButton button = new JButton(COLUMN_NAMES[columnIndex]);
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						String eventName = eventDetails.get(rowIndex)
								.getEventName();
						String eventDate = eventDetails.get(rowIndex)
								.getEventDate();
						String eventAdd = eventDetails.get(rowIndex)
								.getEventAddress();
						int eventId = eventDetails.get(rowIndex).getEventId();

						EventAttributes eventAttributes = new EventAttributes();
						eventAttributes.setEventName(eventName);
						eventAttributes.setEventDate(eventDate);
						eventAttributes.setEventAddress(eventAdd);
						eventAttributes.setEventId(eventId);

						f.setStoreEvents(eventAttributes);

						EventDetails eventDetailsPage = new EventDetails(f);
						f.getContentPane().removeAll();
						f.getContentPane().add(eventDetailsPage);
						f.repaint();
						f.revalidate();
						f.setVisible(true);

					}

				});
				return button;
			default:
				return "Error";
			}
		}
	}

}
