package polyfive.ui.adminpages;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

import polyfive.entities.EventAttributes;
import polyfive.entities.Member;
import polyfive.entities.dao.EventDetailsDao;
import polyfive.entities.dao.MemberDao;
import polyfive.ui.master.*;
import polyfive.ui.memberpages.EventDetails;
import polyfive.ui.memberpages.SearchEvents.JTableButtonMouseListener;
import polyfive.ui.memberpages.SearchEvents.JTableButtonRenderer;
import polyfive.ui.memberpages.SearchEvents.JTableModel;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class UserSetting extends MasterPanel {
	private MainFrame f = null;


	public UserSetting(MainFrame frame) {
		f = frame;
		setLayout(null);
		
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    WelcomePanel welcomePanel = new WelcomePanel(f);
			    f.getContentPane().removeAll();
			    f.getContentPane().add(welcomePanel);
			    f.repaint();
			    f.revalidate();
			    f.setVisible(true);
			}
		});
		
		
		
final JTable table = new JTable(new JTableModel());
		
		table.getTableHeader().setReorderingAllowed(false);
		table.setFont(new Font("Tahoma", Font.PLAIN, 20));
		table.setEnabled(false);
		table.setFocusTraversalKeysEnabled(false);
		table.setFocusable(false);
		table.setDragEnabled(true);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(250, 208, 800, 397);
		add(scrollPane);
		table.setFillsViewportHeight(true);
		table.setAutoCreateRowSorter(true);
		TableCellRenderer buttonRenderer = new JTableButtonRenderer();
		table.getColumn("User Details").setCellRenderer(buttonRenderer);
		// table.getColumn("Button2").setCellRenderer(buttonRenderer);
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
		private static final String[] COLUMN_NAMES = new String[] {
				"Usernames", "Creation Date", "First Name", "Last Name", "Rank","User Details" };
		private static final Class<?>[] COLUMN_TYPES = new Class<?>[] {
				String.class, String.class, String.class, String.class, String.class, JButton.class };

		ArrayList<Member> allUsers = MemberDao.RetrieveAll();


		@Override
		public int getColumnCount() {
			return COLUMN_NAMES.length;
		}

		@Override
		public int getRowCount() {
			
			int row = MemberDao.getMax();
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
				return allUsers.get(rowIndex).getUsername();
			case 1:
				return allUsers.get(rowIndex).getCreationDate();
				// case 2: // fall through
			case 2:
				return allUsers.get(rowIndex).getFirstName();
				// case 2: // fall through
			case 3:
				return allUsers.get(rowIndex).getLastName();
				// case 2: // fall through
			case 4:
				return allUsers.get(rowIndex).getRankName();
				
						
				// case 2: // fall through
			case 5:
				final JButton button = new JButton(COLUMN_NAMES[columnIndex]);
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
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
