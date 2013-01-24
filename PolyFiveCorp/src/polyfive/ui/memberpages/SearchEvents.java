package polyfive.ui.memberpages;

import polyfive.entities.EventAttributes;
import polyfive.entities.Member;
import polyfive.entities.dao.DBConnectionManager;
import polyfive.entities.dao.EventDetailsDao;
import polyfive.ui.adminpages.AdminCalendar;
import polyfive.ui.master.*;
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


public class SearchEvents extends MasterPanel {
	
	
	private JTextField filterText;
	private JButton button;
	private static MainFrame f = null;
	private JTable table;
	private int numberOfUsers;
	private JTextArea textArea;
	private JButton button_1;
	private JTextField statusText;

	/**
	 * Create the panel.
	 */
	
	public SearchEvents(MainFrame frame) {
		setEnabled(false);
		
		f = frame;
		setSize(new Dimension(1366, 768));
		setFocusable(false);
		setBackground(Color.BLACK);

		setLayout(null);

		filterText = new JTextField();
		filterText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		filterText.setBounds(359, 77, 470, 31);
		add(filterText);
		filterText.setColumns(10);

		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				Color.DARK_GRAY, null));
		btnNewButton_1
				.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setBackground(new Color(255, 165, 0));
		btnNewButton_1.setForeground(Color.DARK_GRAY);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.setBounds(839, 75, 130, 36);
		add(btnNewButton_1);

		button = new JButton("");
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
		button.setIcon(new ImageIcon(SearchEvents2.class
				.getResource("/polyFive/ui/images/p5cicon7575.png")));
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
		scrollPane.setBounds(359, 208, 660, 397);
		add(scrollPane);
		table.setFillsViewportHeight(true);
		
	    

		TableCellRenderer buttonRenderer = new JTableButtonRenderer();
		table.getColumn("Event Details").setCellRenderer(buttonRenderer);
		// table.getColumn("Button2").setCellRenderer(buttonRenderer);
		table.addMouseListener(new JTableButtonMouseListener(table));
		table.setRowHeight(60);
		
		
		



		table.getSelectionModel().addListSelectionListener(
				new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent event) {
						int viewRow = table.getSelectedRow();
						if (viewRow < 0) {
							// Selection got filtered away.
							statusText.setText("");
						} else {
							int modelRow = table
									.convertRowIndexToModel(viewRow);
							statusText.setText(String.format(
									"Selected Row in view: %d. "
											+ "Selected Row in model: %d.",
									viewRow, modelRow));
						}
					}
				});
		
/*		List <RowSorter.SortKey> sortKeys 
	    = new ArrayList<RowSorter.SortKey>();
	sortKeys.add(new RowSorter.SortKey(1, SortOrder.ASCENDING));
	RowSorter sorter = null;
	sorter.setSortKeys(sortKeys); 
	table.setRowSorter(sorter);
	*/	// Whenever filterText changes, invoke newFilter.

		//

		button_1 = new JButton("Back");
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
		button_1.setForeground(Color.DARK_GRAY);
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		button_1.setFocusPainted(false);
		button_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				Color.DARK_GRAY, null));
		button_1.setBackground(new Color(255, 165, 0));
		button_1.setBounds(21, 664, 150, 75);
		add(button_1);

		statusText = new JTextField();
		statusText.setBounds(359, 119, 470, 31);
		add(statusText);
		statusText.setColumns(10);

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
				"Event Names", "Date of Events",  "Event Details" };
		private static final Class<?>[] COLUMN_TYPES = new Class<?>[] {
				String.class, Date.class, JButton.class };

		ArrayList<EventAttributes> eventDetails = EventDetailsDao
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
						
						String eventName = eventDetails.get(rowIndex).getEventName();
						String eventDate = eventDetails.get(rowIndex).getEventDate();
						String eventAdd = eventDetails.get(rowIndex).getEventAddress();
						EventAttributes eventAttributes = new EventAttributes();
						eventAttributes.setEventName(eventName);
						eventAttributes.setEventDate(eventDate);
						eventAttributes.setEventAddress(eventAdd);
						f.setStoreEvents(eventAttributes);
						
						
						EventDetails eventDetailsPage = new EventDetails(f);
						f.getContentPane().removeAll();
						f.getContentPane().add(eventDetailsPage);
						f.repaint();
						f.revalidate();
						f.setVisible(true);
						
					/*	EventDetailsRNR eventDetailsRNR = new EventDetailsRNR(f);
						/*EventDetails eventDetails = new EventDetails(f);
						if (rowIndex == 0) {
							f.getContentPane().removeAll();
							f.getContentPane().add(eventDetailsRNR);
							f.repaint();
							f.revalidate();
							f.setVisible(true);
						} else {
							f.getContentPane().removeAll();
							f.getContentPane().add(eventDetails);
							f.repaint();
							f.revalidate();
							f.setVisible(true);
						
						}
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
