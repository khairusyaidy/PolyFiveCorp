package polyfive.ui.memberpages;

import polyfive.entities.BuyTickets;
import polyfive.entities.EventAttributes;
import polyfive.entities.JSpinnerAttributes;
import polyfive.entities.Member;
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
import java.awt.geom.AffineTransform;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JSeparator;

public class TicketsPurchaseMember extends MasterPanel {
	private JTextField txtTicketsLeft;
	private JButton btnCancel;
	private JTextField txtPrice;
	private MainFrame f = null;
	private JTextField txtPriceAfterDiscount;

	/**
	 * Create the panel.
	 */
	public TicketsPurchaseMember(MainFrame frame) {
		f = frame;

		Member user = new Member();
		user = f.getSession();
		int rank = user.getRank();

		EventAttributes eventAttributes = new EventAttributes();
		eventAttributes = f.getStoreEvents();

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
		panel.setBounds(21, 141, 1288, 516);
		add(panel);
		panel.setLayout(null);

		JLabel lblEnterTransactionId = new JLabel("No.of Tickets :");
		lblEnterTransactionId.setHorizontalAlignment(SwingConstants.LEFT);
		lblEnterTransactionId.setBounds(177, 206, 230, 61);
		lblEnterTransactionId.setFont(new Font("Tahoma", Font.ITALIC, 25));
		panel.add(lblEnterTransactionId);

		JLabel lblTicketsLeft = new JLabel("Tickets Left :\r\n");
		lblTicketsLeft.setFont(new Font("Tahoma", Font.ITALIC, 25));
		lblTicketsLeft.setBounds(177, 289, 210, 78);

		// final JSpinner spinner1 = new JSpinner();
		// spinner.setEditor(new JSpinner.DefaultEditor(spinner));

		int min = 0;
		int max = 8;
		int step = 1;
		int initValue = 0;

		// spinner.setValue(0);
		// change int to stirng

		if (eventAttributes.getEventNoOfTickets() < 8) {
			max = eventAttributes.getEventNoOfTickets();

		}

		final SpinnerModel model = new SpinnerNumberModel(initValue, min, max,
				step);
		final JSpinner spinner = new JSpinner(model);
		spinner.setEditor(new JSpinner.DefaultEditor(spinner));
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 30));
		// spinner.setModel(new SpinnerNumberModel(new Integer(0), new
		// Integer(0), null, new Integer(1)));
		spinner.setBounds(367, 211, 225, 48);
		panel.add(spinner);

		String evetNoOfTicketsString = Integer.toString(eventAttributes
				.getEventNoOfTickets());

		txtTicketsLeft = new JTextField();
		txtTicketsLeft.setText(evetNoOfTicketsString);
		txtTicketsLeft.setBackground(new Color(255, 255, 255));
		txtTicketsLeft.setEditable(false);
		txtTicketsLeft.setFont(new Font("Tahoma", Font.PLAIN, 40));
		txtTicketsLeft.setHorizontalAlignment(SwingConstants.CENTER);
		txtTicketsLeft.setBounds(367, 298, 225, 48);
		panel.add(txtTicketsLeft);

		panel.add(lblTicketsLeft);
		txtTicketsLeft.setColumns(10);

		txtPrice = new JTextField();
		String currentValueString = Double.toString(eventAttributes
				.getEventPrice());
		// txtPrice.setText(currentValueString);
		txtPrice.setEditable(false);
		txtPrice.setBackground(new Color(255, 255, 255));
		txtPrice.setHorizontalAlignment(SwingConstants.LEFT);
		txtPrice.setForeground(new Color(0, 0, 0));
		txtPrice.setFont(new Font("Tahoma", Font.PLAIN, 40));
		txtPrice.setBounds(367, 388, 225, 52);

		panel.add(txtPrice);
		txtPrice.setColumns(10);

		JLabel lblPrice = new JLabel("Price(SGD) :  $");
		lblPrice.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrice.setFont(new Font("Tahoma", Font.ITALIC, 25));
		lblPrice.setBounds(177, 388, 253, 48);
		panel.add(lblPrice);

		JSeparator separator = new JSeparator();
		separator.setBounds(354, 358, 253, 19);
		panel.add(separator);

		JLabel lblPriceAfterDiscount = new JLabel("Price(SGD) :  $");
		lblPriceAfterDiscount.setHorizontalAlignment(SwingConstants.LEFT);
		lblPriceAfterDiscount.setFont(new Font("Tahoma", Font.ITALIC, 25));
		lblPriceAfterDiscount.setBounds(640, 388, 253, 48);
		panel.add(lblPriceAfterDiscount);
		// get member discount

		txtPriceAfterDiscount = new JTextField();
		// txtPriceAfterDiscount.setText(currentValueString);
		txtPriceAfterDiscount.setHorizontalAlignment(SwingConstants.LEFT);
		txtPriceAfterDiscount.setForeground(Color.BLACK);
		txtPriceAfterDiscount.setFont(new Font("Tahoma", Font.PLAIN, 40));
		txtPriceAfterDiscount.setEditable(false);
		txtPriceAfterDiscount.setColumns(10);
		txtPriceAfterDiscount.setBackground(Color.WHITE);
		txtPriceAfterDiscount.setBounds(826, 388, 225, 52);
		panel.add(txtPriceAfterDiscount);

		JLabel lblAfterDiscount = new JLabel("After discount");
		lblAfterDiscount.setHorizontalAlignment(SwingConstants.CENTER);
		lblAfterDiscount.setFont(new Font("Monotype Corsiva", Font.PLAIN, 30));
		lblAfterDiscount.setBounds(801, 91, 263, 52);
		panel.add(lblAfterDiscount);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(781, 137, 309, 19);
		panel.add(separator_2);
		
		JLabel label = new JLabel("Please select the number of tickets you are purchasing and then click on proceed to payment. ( Max = 8 Tickets )");
		label.setBounds(167, 34, 1027, 48);
		panel.add(label);
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblBeforeDiscount = new JLabel("Before discount");
		lblBeforeDiscount.setHorizontalAlignment(SwingConstants.CENTER);
		lblBeforeDiscount.setFont(new Font("Monotype Corsiva", Font.PLAIN, 30));
		lblBeforeDiscount.setBounds(344, 91, 263, 52);
		panel.add(lblBeforeDiscount);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(315, 137, 309, 19);
		panel.add(separator_3);

		final JSpinnerAttributes jspinnerValue = new JSpinnerAttributes();
		final int currentValue = (int) spinner.getValue();
		jspinnerValue.setValue(currentValue);

		final String ticketsLeft = txtTicketsLeft.getText();
		int ticketsLeftInt = Integer.parseInt(ticketsLeft);

		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				float value = (int) spinner.getValue();
				int ticketsLeftInt = Integer.parseInt(ticketsLeft);
				EventAttributes eventAttributes = new EventAttributes();
				eventAttributes = f.getStoreEvents();
				Member member = new Member();
				member = f.getSession();
				float discount = member.getDisount(member.getRank());

				// System.out.println()

				if (value > jspinnerValue.getValue()) {
					// up was pressed
					jspinnerValue.setValue(jspinnerValue.getValue() + 1);
					String ticketsLeft = txtTicketsLeft.getText();
					ticketsLeftInt = Integer.parseInt(ticketsLeft) - 1;
					String ticketsLeftAfterString = Integer
							.toString(ticketsLeftInt);
					txtTicketsLeft.setText(ticketsLeftAfterString);

					// default price
					float totalPriceFloat = (((jspinnerValue.getValue()) * (eventAttributes
							.getEventPrice())));
					String totalPrice = String.format("%.2f", totalPriceFloat);
					txtPrice.setText(totalPrice);
					// ///////

					// discounted price 2 d.c
					float totalPriceAfterDiscountFloat = (((jspinnerValue
							.getValue()) * (eventAttributes.getEventPrice()) * discount));
					String totalPriceAfterDiscount = String.format("%.2f",
							totalPriceAfterDiscountFloat);
					txtPriceAfterDiscount.setText(totalPriceAfterDiscount);
					// /////////////

					value = jspinnerValue.getValue();

					txtPrice.updateUI();
					txtPriceAfterDiscount.updateUI();

				} else if (value < jspinnerValue.getValue()) {
					// down was pressed
					jspinnerValue.setValue(jspinnerValue.getValue() - 1);
					String ticketsLeft = txtTicketsLeft.getText();
					ticketsLeftInt = Integer.parseInt(ticketsLeft) + 1;
					String ticketsLeftAfterString = Integer
							.toString(ticketsLeftInt);
					txtTicketsLeft.setText(ticketsLeftAfterString);

					// default price
					float totalPriceFloat = (((jspinnerValue.getValue()) * (eventAttributes
							.getEventPrice())));
					String totalPrice = String.format("%.2f", totalPriceFloat);
					txtPrice.setText(totalPrice);
					// ///////

					// discounted price 2 d.c
					float totalPriceAfterDiscountFloat = (((jspinnerValue
							.getValue()) * (eventAttributes.getEventPrice()) * discount));
					String totalPriceAfterDiscount = String.format("%.2f",
							totalPriceAfterDiscountFloat);
					txtPriceAfterDiscount.setText(totalPriceAfterDiscount);
					// //////////

					value = jspinnerValue.getValue();

					txtPrice.updateUI();
					txtPriceAfterDiscount.updateUI();
				}

				String ticketsLeftAfterString = Integer
						.toString(ticketsLeftInt);
				txtTicketsLeft.setText(ticketsLeftAfterString);
				txtTicketsLeft.updateUI();
				txtPrice.updateUI();

			}
		});

		btnCancel = new JButton("Cancel");
		btnCancel.setFocusPainted(false);
		btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancel.setBorder(new LineBorder(Color.DARK_GRAY));
		btnCancel.setBounds(21, 664, 150, 75);
		add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		btnCancel.setForeground(Color.DARK_GRAY);
		btnCancel.setBackground(new Color(255, 165, 0));
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 30));

		JButton btnProceedToPayment = new JButton("Proceed to Payment\r\n");
		btnProceedToPayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				BuyTickets buyTickets = new BuyTickets();
				int tickets = (int) spinner.getValue();
				String ticketsString = Integer.toString(tickets);
				buyTickets.setGetTickets(ticketsString);

				String ticketsPrice = txtPriceAfterDiscount.getText();
				buyTickets.setGetPRice(ticketsPrice);

				f.setBuyTickets(buyTickets);

				PaymentDetails paymentDetails = new PaymentDetails(f);
				f.getContentPane().removeAll();
				f.getContentPane().add(paymentDetails);
				f.repaint();
				f.revalidate();
				f.setVisible(true);

				EventAttributes eventAttributes = new EventAttributes();
				eventAttributes = f.getStoreEvents();

				String noOfTickets = txtTicketsLeft.getText();
				int noOfTicketsInt = Integer.parseInt(noOfTickets);

				eventAttributes.setEventNoOfTickets(noOfTicketsInt);

				f.setStoreEvents(eventAttributes);

			}
		});
		btnProceedToPayment.setFocusPainted(false);
		btnProceedToPayment.setCursor(Cursor
				.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnProceedToPayment.setBorder(new LineBorder(Color.DARK_GRAY));
		btnProceedToPayment.setBounds(1115, 664, 230, 75);
		btnProceedToPayment.setForeground(Color.DARK_GRAY);
		btnProceedToPayment.setBackground(new Color(255, 165, 0));
		btnProceedToPayment.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(btnProceedToPayment);

		JButton button = new JButton("");
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
		button.setIcon(new ImageIcon(TicketsPurchaseMember.class
				.getResource("/polyFive/ui/images/p5cicon7575.png")));
		button.setBorder(null);
		button.setBounds(21, 21, 75, 75);
		add(button);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(374, 111, 309, 19);
		add(separator_1);

		JLabel lblNewLabel = new JLabel("Tickets Purchase");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Monotype Corsiva", Font.PLAIN, 40));
		lblNewLabel.setBounds(393, 59, 263, 52);
		add(lblNewLabel);

		if (rank == 0) {
			lblAfterDiscount.setVisible(false);
			separator_2.setVisible(false);
			lblPriceAfterDiscount.setVisible(false);
			txtPriceAfterDiscount.setVisible(false);
		} else {
			lblAfterDiscount.setVisible(true);
			separator_2.setVisible(true);
			lblPriceAfterDiscount.setVisible(true);
			txtPriceAfterDiscount.setVisible(true);
		}

		super.setLayout();

	}
}
