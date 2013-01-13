package polyfive.ui.memberpages;

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

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.JCheckBox;
import java.awt.Dimension;
import javax.swing.border.EtchedBorder;

public class SearchEvents2 extends MasterPanel {
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
	public SearchEvents2() {
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
		btnNewButton_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				Color.DARK_GRAY, null));
		btnNewButton_1
				.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setBackground(new Color(255, 165, 0));
		btnNewButton_1.setForeground(Color.DARK_GRAY);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.setBounds(849, 95, 170, 50);
		add(btnNewButton_1);

		button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberCalendar memberCalendar = f.getMemberCalendar();
				f.getContentPane().removeAll();
				f.getContentPane().add(memberCalendar);
				f.repaint();
				f.revalidate();
				f.setVisible(true);
			}
		});
		button.setIcon(new ImageIcon(SearchEvents2.class
				.getResource("/polyFive/ui/images/p5cicon7575.png")));
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setBorder(null);
		button.setBounds(21, 21, 75, 75);
		add(button);

		// adding table here + scrollpane

		JTable table = new JTable(new JTableModel());
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(359, 208, 660, 397);
		add(scrollPane);
		table.setFillsViewportHeight(true);

		TableCellRenderer buttonRenderer = new JTableButtonRenderer();
		table.getColumn("Button1").setCellRenderer(buttonRenderer);
		table.getColumn("Button2").setCellRenderer(buttonRenderer);
		table.addMouseListener(new JTableButtonMouseListener(table));
		table.setRowHeight(60);

		//

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
		button_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				Color.DARK_GRAY, null));
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

		JCheckBox chckbxNewCheckBox_1 = new JCheckBox(
				"Alphabetical Order ( A - Z )");
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

	public SearchEvents2(MainFrame frame) {
		this();
		f = frame;
		// TODO Auto-generated constructor stub

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
		private static final String[] COLUMN_NAMES = new String[] { "Id",
				"Stuff", "Button1", "Button2" };
		private static final Class<?>[] COLUMN_TYPES = new Class<?>[] {
				Integer.class, String.class, JButton.class, JButton.class };

		@Override
		public int getColumnCount() {
			return COLUMN_NAMES.length;
		}

		@Override
		public int getRowCount() {
			return 4;
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
				return rowIndex;
			case 1:
				return "Text for " + rowIndex;
			case 2: // fall through
			case 3:
				final JButton button = new JButton(COLUMN_NAMES[columnIndex]);
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						JOptionPane.showMessageDialog(
								JOptionPane.getFrameForComponent(button),
								"Button clicked for row " + rowIndex);
					}
				});
				return button;
			default:
				return "Error";
			}
		}
	}

}