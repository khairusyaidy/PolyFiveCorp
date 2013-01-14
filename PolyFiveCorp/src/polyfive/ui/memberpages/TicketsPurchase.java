package polyfive.ui.memberpages;

import polyfive.ui.adminpages.*;
import polyfive.ui.images.*;
import polyfive.ui.master.*;
import polyfive.ui.publicpages.*;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextPane;
import javax.swing.JSeparator;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.JProgressBar;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.Dimension;

public class TicketsPurchase extends MasterPanel {
	private JTextField textField;
	private JButton btnBack;
	private JTextField txtPrice;
	private MainFrame f = null;

	/**
	 * Create the panel.
	 */
	public TicketsPurchase(MainFrame frame) {
		f = frame;
		setSize(new Dimension(1366, 768));
		setBorder(new LineBorder(new Color(255, 140, 0), 0));
		setBackground(Color.WHITE);
		setForeground(new Color(255, 255, 255));
		setLayout(null);
		this.setBounds(0, 0, 1367, 750);

		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBorder(null);
		panel.setBackground(new Color(255, 255, 255));
		panel.setForeground(Color.WHITE);
		panel.setBounds(57, 120, 1288, 516);
		add(panel);
		panel.setLayout(null);

		JLabel lblEnterTransactionId = new JLabel("No.of Tickets:");
		lblEnterTransactionId.setHorizontalAlignment(SwingConstants.LEFT);
		lblEnterTransactionId.setBounds(38, 116, 359, 61);
		lblEnterTransactionId.setFont(new Font("Tahoma", Font.PLAIN, 50));
		panel.add(lblEnterTransactionId);

		JLabel lblTicketsLeft = new JLabel("Tickets Left:\r\n");
		lblTicketsLeft.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblTicketsLeft.setBounds(70, 224, 359, 97);
		panel.add(lblTicketsLeft);

		textField = new JTextField();
		textField.setBackground(new Color(255, 255, 255));
		textField.setEditable(false);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 40));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(368, 252, 216, 48);
		panel.add(textField);
		textField.setColumns(10);

		txtPrice = new JTextField();
		txtPrice.setEditable(false);
		txtPrice.setBackground(new Color(255, 255, 255));
		txtPrice.setHorizontalAlignment(SwingConstants.LEFT);
		txtPrice.setForeground(new Color(0, 0, 0));
		txtPrice.setFont(new Font("Tahoma", Font.PLAIN, 40));
		txtPrice.setBounds(885, 124, 225, 52);
		panel.add(txtPrice);
		txtPrice.setColumns(10);

		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblPrice.setBounds(735, 122, 154, 48);
		panel.add(lblPrice);

		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 30));
		spinner.setModel(new SpinnerNumberModel(1, 1, 8, 1));
		spinner.setBounds(368, 124, 216, 48);
		panel.add(spinner);

		btnBack = new JButton("Cancel");
		btnBack.setFocusPainted(false);
		btnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBack.setBorder(null);
		btnBack.setBounds(21, 664, 150, 75);
		add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SearchEvents searchEvents = new SearchEvents(f);
				f.getContentPane().removeAll();
				f.getContentPane().add(searchEvents);
				f.repaint();
				f.revalidate();
				f.setVisible(true);
			}
		});
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.setBackground(new Color(255, 165, 0));
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 30));

		JButton btnNewButton = new JButton("Proceed to payment\r\n");
		btnNewButton.setFocusPainted(false);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBorder(null);
		btnNewButton.setBounds(1115, 664, 230, 75);
		add(btnNewButton);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 165, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JButton button = new JButton("");
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberCalendar memberCalendar = new MemberCalendar(f);
				f.getContentPane().removeAll();
				f.getContentPane().add(memberCalendar);
				f.repaint();
				f.revalidate();
				f.setVisible(true);
			}
		});
		button.setIcon(new ImageIcon(TicketsPurchase.class
				.getResource("/polyFive/ui/images/p5cicon7575.png")));
		button.setBorder(null);
		button.setBounds(21, 21, 75, 75);
		add(button);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		super.setLayout();

	}



}
