/* 
 * Program Name : UserSettings.java
 * Purpose : Display all the details of the particular event
 * 
 * Authour: Muhammad Khairyl Rusyaidy
 * Admin No: 120258L
 * Module Group : IS1201
 * Last Modified: 29/1/2013
 * 
 */

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
import polyfive.entities.dao.DBConnectionManager;
import polyfive.entities.dao.EventDetailsDao;
import polyfive.entities.dao.MemberDao;
import polyfive.ui.master.*;
import polyfive.ui.memberpages.AccountDetails;
import polyfive.ui.memberpages.EventDetails;
import polyfive.ui.memberpages.MemberCalendar;
import polyfive.ui.memberpages.SearchEvents.JTableButtonMouseListener;
import polyfive.ui.memberpages.SearchEvents.JTableButtonRenderer;
import polyfive.ui.memberpages.SearchEvents.JTableModel;
import polyfive.ui.publicpages.PublicCalendar;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;

public class UserSetting extends MasterPanel {
	private static MainFrame f = null;


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
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setEnabled(false);
		table.setFocusTraversalKeysEnabled(false);
		table.setFocusable(false);
		table.setDragEnabled(true);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(212, 162, 947, 443);
		add(scrollPane);
		table.setFillsViewportHeight(true);
		table.setAutoCreateRowSorter(true);
		TableCellRenderer buttonRenderer = new JTableButtonRenderer();
		table.getColumn("User Details").setCellRenderer(buttonRenderer);
		// table.getColumn("Button2").setCellRenderer(buttonRenderer);
		table.addMouseListener(new JTableButtonMouseListener(table));
		table.setRowHeight(60);
		
		JButton button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminCalendar adminCalendar = new AdminCalendar(f);
				f.getContentPane().removeAll();
				f.getContentPane().add(adminCalendar);
				f.repaint();
				f.revalidate();
				f.setVisible(true);
			}
		});
		button.setForeground(Color.DARK_GRAY);
		button.setFont(new Font("Tahoma", Font.PLAIN, 30));
		button.setFocusPainted(false);
		button.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
						Color.DARK_GRAY, null));
		button.setBackground(new Color(255, 165, 0));
		button.setAlignmentX(1.0f);
		button.setBounds(21, 664, 150, 75);
		add(button);
		
		JLabel lblNewLabel = new JLabel("User Accounts");
		lblNewLabel.setFont(new Font("Monotype Corsiva", Font.PLAIN, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(397, 60, 326, 41);
		add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(397, 113, 320, 2);
		add(separator);
		
		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
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
		button_2.setIcon(new ImageIcon(UserSetting.class.getResource("/polyfive/ui/images/p5cicon7575.png")));
		button_2.setBorder(null);
		button_2.setBounds(21, 21, 75, 75);
		add(button_2);
		
		
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
						
						String username = allUsers.get(rowIndex).getUsername();
						int telNo = allUsers.get(rowIndex).getPhoneNumber();
						String firstName = allUsers.get(rowIndex).getFirstName();
						String lastName = allUsers.get(rowIndex).getLastName();
						String creationDate = allUsers.get(rowIndex).getCreationDate();
						int rank = allUsers.get(rowIndex).getRank();
						String email = allUsers.get(rowIndex).getEmail();
						String pass_IcNo = allUsers.get(rowIndex).getPass_icNo();
						
						
						Member editUser = new Member();
						
						
						editUser.setUsername(username);
						editUser.setPhoneNumber(telNo);
						editUser.setFirstName(firstName);
						editUser.setLastName(lastName);
						editUser.setCreationDate(creationDate);
						editUser.setRank(rank);
						editUser.setEmail(email);
						editUser.setPass_icNo(pass_IcNo);
						f.setEditAccountSession(editUser);
						
						
						
						String sql = "select * from Users where Username = '" + username + "'";
						try {
							DBConnectionManager.rs = DBConnectionManager.stmt.executeQuery(sql);

						while (DBConnectionManager.rs.next()){
							editUser.setUsername(DBConnectionManager.rs.getString("username"));
							editUser.setPassword(DBConnectionManager.rs.getString("password"));
							editUser.setFirstName(DBConnectionManager.rs.getString("firstName"));
							editUser.setLastName(DBConnectionManager.rs.getString("lastName"));
							editUser.setCreationDate(DBConnectionManager.rs.getString("creationDate"));
							editUser.setEmail(DBConnectionManager.rs.getString("email"));
							editUser.setPhoneNumber(DBConnectionManager.rs.getInt("telNo"));
							editUser.setPass_icNo(DBConnectionManager.rs.getString("pass_icNo"));
							editUser.setRank(DBConnectionManager.rs.getInt("rank"));
							
							f.setEditAccountSession(editUser);
						}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						AdminAccountDetails AdminAccountDetailsPage = new AdminAccountDetails(f);
						f.getContentPane().removeAll();
						f.getContentPane().add(AdminAccountDetailsPage);
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
