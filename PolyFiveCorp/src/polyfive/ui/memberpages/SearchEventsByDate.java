package polyfive.ui.memberpages;

import polyfive.entities.EventAttributes;
import polyfive.entities.Member;
import polyfive.entities.dao.DBConnectionManager;
import polyfive.entities.dao.EventDetailsDao;
import polyfive.ui.adminpages.AdminCalendar;
import polyfive.ui.master.*;
import polyfive.ui.publicpages.PublicCalendar;

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
	private JButton button_1;
	public static String Date;

	/**
	 * Create the panel.
	 */

	public SearchEventsByDate(MainFrame frame) {

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
		button.setIcon(new ImageIcon(SearchEventsByDate.class
				.getResource("/polyfive/ui/images/p5cicon7575.png")));
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setBorder(null);
		button.setBounds(21, 21, 75, 75);
		add(button);

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
		table.getColumn("Event Details").setCellRenderer(buttonRenderer);
		// table.getColumn("Button2").setCellRenderer(buttonRenderer);
		table.addMouseListener(new JTableButtonMouseListener(table));
		table.setRowHeight(60);


		/*
		 * List <RowSorter.SortKey> sortKeys = new
		 * ArrayList<RowSorter.SortKey>(); sortKeys.add(new RowSorter.SortKey(1,
		 * SortOrder.ASCENDING)); RowSorter sorter = null;
		 * sorter.setSortKeys(sortKeys); table.setRowSorter(sorter);
		 */// Whenever filterText changes, invoke newFilter.

		//

		button_1 = new JButton("Back");
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
		button_1.setForeground(Color.DARK_GRAY);
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		button_1.setFocusPainted(false);
		button_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				Color.DARK_GRAY, null));
		button_1.setBackground(new Color(255, 165, 0));
		button_1.setBounds(21, 664, 150, 75);
		add(button_1);
		
		JLabel lblListOfEvents = new JLabel("List of Events by Date");
		lblListOfEvents.setFont(new Font("Monotype Corsiva", Font.PLAIN, 40));
		lblListOfEvents.setBounds(459, 58, 351, 57);
		add(lblListOfEvents);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(425, 113, 420, 2);
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

				// case 2: // fall through
			case 2:
				final JButton button = new JButton(COLUMN_NAMES[columnIndex]);
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						String eventName = eventDetails.get(rowIndex)
								.getEventName();
						String eventDate = eventDetails.get(rowIndex)
								.getEventDate();
						int eventId = eventDetails.get(rowIndex).getEventId();
						
						EventAttributes eventAttributes = new EventAttributes();
						eventAttributes.setEventName(eventName);
						eventAttributes.setEventDate(eventDate);
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
