package polyfive.ui.publicpages;

import polyfive.ui.adminpages.*;
import polyfive.ui.images.*;
import polyfive.ui.master.*;
import polyfive.ui.memberpages.*;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Cursor;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Insets;
import java.awt.Component;
import java.awt.SystemColor;
import java.awt.Dimension;
import javax.swing.border.EtchedBorder;

public class FirstTimeUsers extends MasterPanel {
	private MainFrame f;

	/**
	 * Create the panel.
	 */
	public FirstTimeUsers(MainFrame frame) {
		f = frame;
		setSize(new Dimension(1366, 768));
		setBorder(null);
		setBackground(Color.WHITE);
		setLayout(null);

		JPanel panel_5 = new JPanel();
		panel_5.setOpaque(false);
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(155, 95, 1166, 571);
		add(panel_5);
		panel_5.setLayout(null);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(859, 31, 250, 500);
		panel_5.add(panel_4);
		panel_4.setLayout(null);

		JFormattedTextField frmtdtxtfldBasic = new JFormattedTextField();
		frmtdtxtfldBasic.setEditable(false);
		frmtdtxtfldBasic.setText("BASIC");
		frmtdtxtfldBasic.setForeground(Color.BLUE);
		frmtdtxtfldBasic.setHorizontalAlignment(SwingConstants.CENTER);
		frmtdtxtfldBasic.setFont(new Font("Tahoma", Font.PLAIN, 25));
		frmtdtxtfldBasic.setBounds(32, 11, 175, 31);
		panel_4.add(frmtdtxtfldBasic);

		JTextArea BasicTextArea = new JTextArea();
		BasicTextArea.setWrapStyleWord(true);
		BasicTextArea.setText("  \u2022 Advance Booking");
		BasicTextArea.setLineWrap(true);
		BasicTextArea.setForeground(new Color(0, 0, 255));
		BasicTextArea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		BasicTextArea.setEditable(false);
		BasicTextArea.setBorder(new LineBorder(new Color(0, 0, 0)));
		BasicTextArea.setBounds(32, 68, 175, 312);
		panel_4.add(BasicTextArea);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(583, 31, 250, 500);
		panel_5.add(panel_3);
		panel_3.setLayout(null);

		JFormattedTextField frmtdtxtfldBronze = new JFormattedTextField();
		frmtdtxtfldBronze.setEditable(false);
		frmtdtxtfldBronze.setForeground(new Color(210, 105, 30));
		frmtdtxtfldBronze.setText("BRONZE");
		frmtdtxtfldBronze.setHorizontalAlignment(SwingConstants.CENTER);
		frmtdtxtfldBronze.setFont(new Font("Tahoma", Font.PLAIN, 25));
		frmtdtxtfldBronze.setBounds(32, 11, 175, 31);
		panel_3.add(frmtdtxtfldBronze);

		JTextArea BronzeTextArea = new JTextArea();
		BronzeTextArea.setCursor(Cursor
				.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		BronzeTextArea.setWrapStyleWord(true);
		BronzeTextArea
				.setText("  \u2022 Advance Booking\r\n\r\n  \u2022 Discount(5%)");
		BronzeTextArea.setLineWrap(true);
		BronzeTextArea.setForeground(new Color(210, 105, 30));
		BronzeTextArea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		BronzeTextArea.setEditable(false);
		BronzeTextArea.setBorder(new LineBorder(new Color(0, 0, 0)));
		BronzeTextArea.setBounds(32, 69, 175, 312);
		panel_3.add(BronzeTextArea);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(310, 31, 250, 500);
		panel_5.add(panel_2);
		panel_2.setLayout(null);

		JFormattedTextField frmtdtxtfldSilver = new JFormattedTextField();
		frmtdtxtfldSilver.setEditable(false);
		frmtdtxtfldSilver.setForeground(new Color(105, 105, 105));
		frmtdtxtfldSilver.setText("SILVER");
		frmtdtxtfldSilver.setHorizontalAlignment(SwingConstants.CENTER);
		frmtdtxtfldSilver.setFont(new Font("Tahoma", Font.PLAIN, 25));
		frmtdtxtfldSilver.setBounds(32, 11, 175, 31);
		panel_2.add(frmtdtxtfldSilver);

		JTextArea SilverTextArea = new JTextArea();
		SilverTextArea.setEditable(false);
		SilverTextArea.setCursor(Cursor
				.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		SilverTextArea.setWrapStyleWord(true);
		SilverTextArea
				.setText("  \u2022 Free Signed \r\n     Merchandise\r\n\r\n  \u2022 Advance Booking\r\n\r\n  \u2022 Discount(10%)");
		SilverTextArea.setLineWrap(true);
		SilverTextArea.setForeground(new Color(105, 105, 105));
		SilverTextArea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		SilverTextArea.setBorder(new LineBorder(new Color(0, 0, 0)));
		SilverTextArea.setBounds(32, 71, 175, 312);
		panel_2.add(SilverTextArea);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(24, 31, 250, 500);
		panel_5.add(panel_1);
		panel_1.setLayout(null);

		JFormattedTextField frmtdtxtfldGold = new JFormattedTextField();
		frmtdtxtfldGold.setEditable(false);
		frmtdtxtfldGold.setForeground(new Color(184, 134, 11));
		frmtdtxtfldGold.setFont(new Font("Tahoma", Font.PLAIN, 25));
		frmtdtxtfldGold.setHorizontalAlignment(SwingConstants.CENTER);
		frmtdtxtfldGold.setText("GOLD");
		frmtdtxtfldGold.setBounds(32, 11, 175, 31);
		panel_1.add(frmtdtxtfldGold);

		JTextArea GoldTextArea = new JTextArea();
		GoldTextArea.setWrapStyleWord(true);
		GoldTextArea
				.setText("  \u2022 Meet and Greet\r\n    Session\r\n\r\n  \u2022 Priority Entrance\r\n\r\n  \u2022 Free Signed \r\n     Merchandise\r\n\r\n  \u2022 Advance Booking\r\n\r\n  \u2022 Discount(10%)");
		GoldTextArea.setLineWrap(true);
		GoldTextArea.setForeground(new Color(184, 134, 11));
		GoldTextArea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GoldTextArea.setEditable(false);
		GoldTextArea.setBorder(new LineBorder(new Color(0, 0, 0)));
		GoldTextArea.setBounds(32, 73, 175, 312);
		panel_1.add(GoldTextArea);

		JButton btnNewButton = new JButton("Back");
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				Color.DARK_GRAY, null));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WelcomePanel welcomePanel = new WelcomePanel(f);
				f.getContentPane().removeAll();
				f.getContentPane().add(welcomePanel);
				f.repaint();
				f.revalidate();
				f.setVisible(true);
			}
		});
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBackground(new Color(255, 165, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setBounds(21, 664, 150, 75);
		add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Register\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register register = new Register(f);
				f.getContentPane().removeAll();
				f.getContentPane().add(register);
				f.repaint();
				f.validate();
				f.setVisible(true);
			}
		});
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setForeground(Color.DARK_GRAY);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton_1.setBackground(new Color(255, 165, 0));
		btnNewButton_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				Color.DARK_GRAY, null));
		btnNewButton_1
				.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setBounds(1188, 664, 150, 75);
		add(btnNewButton_1);

		JPanel panel = new JPanel();
		panel.setBounds(21, 21, 75, 75);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberCalendar memberCalendar = new MemberCalendar(f);
				f.getContentPane().removeAll();
				f.getContentPane().add(memberCalendar);
				f.repaint();
				f.revalidate();
				f.setVisible(true);
			}
		});
		btnNewButton_2.setBorder(null);
		btnNewButton_2.setFocusPainted(false);
		btnNewButton_2
				.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_2.setIcon(new ImageIcon(FirstTimeUsers.class
				.getResource("/polyFive/ui/images/p5cicon7575.png")));
		panel.add(btnNewButton_2, BorderLayout.CENTER);

		super.setLayout();
	}

}
