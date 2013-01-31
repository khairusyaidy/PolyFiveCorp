/* 
 * Program Name : WelcomePanel.java
 * Purpose : For new users, member, or public user to book tickets / Changing of language 
 * 
 * Authour: Muhammad Khairyl Rusyaidy
 * Admin No: 120258L
 * Module Group : IS1201
 * Last Modified: 29/1/2013
 * 
 */

package polyfive.ui.master;

import polyfive.entities.ChangeLanguage;
import polyfive.entities.Member;
import polyfive.ui.adminpages.*;
import polyfive.ui.images.*;
import polyfive.ui.memberpages.*;
import polyfive.ui.misc.DigitalClock;
import polyfive.ui.publicpages.*;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.SpringLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.SystemColor;
import java.awt.CardLayout;
import java.awt.Insets;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JDesktopPane;
import java.awt.Component;
import java.awt.Cursor;
import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.DropMode;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.util.ResourceBundle;

public class WelcomePanel extends MasterPanel {
	public static final ResourceBundle BUNDLE = ResourceBundle
			.getBundle("polyfive.ui.master.messages"); //$NON-NLS-1$
	public static final ResourceBundle BUNDLE2 = ResourceBundle
			.getBundle("polyfive.ui.master.messages_ms_MY");
	private final Action action = new SwingAction();
	private MainFrame f = null;

	/**
	 * Create the panel.
	 */

	public WelcomePanel(MainFrame frame) {

		ChangeLanguage changeLanguage = new ChangeLanguage();
		changeLanguage.setChangeLanguage(0);
		f.setStoreLanguage(changeLanguage);

		f = frame;
		setSize(new Dimension(1366, 768));
		setMinimumSize(new Dimension(1366, 768));
		setBackground(SystemColor.controlLtHighlight);
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setAlignmentX(Component.LEFT_ALIGNMENT);
		setLayout(null);
		setMaximumSize(new Dimension(1366, 768));

		JLabel label_1 = new JLabel("");
		label_1.setBounds(0, 0, 0, 0);
		add(label_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(111, 598, 1059, 100);
		panel_1.setOpaque(false);
		panel_1.setBackground(new Color(255, 255, 255));
		add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(74, 13, 300, 75);
		panel_1.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		final JButton btnNewButton = new JButton(
				BUNDLE.getString("WelcomePanel.btnNewButton.text")); //$NON-NLS-1$
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FirstTimeUsers firstTimeUsers = new FirstTimeUsers(f);
				f.getContentPane().removeAll();
				f.getContentPane().add(firstTimeUsers);
				f.repaint();
				f.validate();
				f.setVisible(true);
			}
		});
		btnNewButton.setIgnoreRepaint(true);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel_2.add(btnNewButton, BorderLayout.CENTER);
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				new Color(64, 64, 64), null));
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setAlignmentX(Component.RIGHT_ALIGNMENT);
		btnNewButton.setBackground(new Color(255, 165, 0));

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(404, 13, 300, 75);
		panel_1.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));

		final JButton btnNewButton_1 = new JButton(
				BUNDLE.getString("WelcomePanel.btnNewButton_1.text")); //$NON-NLS-1$
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPanel loginPanel = new LoginPanel(f);
				f.getContentPane().removeAll();
				f.getContentPane().add(loginPanel);
				f.repaint();
				f.validate();
				f.setVisible(true);
			}
		});

		panel_3.add(btnNewButton_1, BorderLayout.CENTER);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton_1.setForeground(Color.DARK_GRAY);
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1
				.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				Color.DARK_GRAY, null));
		btnNewButton_1.setBackground(new Color(255, 165, 0));

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(727, 11, 300, 75);
		panel_1.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));

		final JButton btnNewButton_2 = new JButton(
				BUNDLE.getString("WelcomePanel.btnNewButton_2.text")); //$NON-NLS-1$
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Member user = new Member();
				user.setRank(0);
				f.setSession(user);

				PublicCalendar publicUsers = new PublicCalendar(f);
				f.getContentPane().removeAll();
				f.getContentPane().add(publicUsers);
				f.repaint();
				f.validate();
				f.setVisible(true);
			}
		});
		panel_4.add(btnNewButton_2, BorderLayout.CENTER);
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton_2.setForeground(Color.DARK_GRAY);
		btnNewButton_2.setFocusPainted(false);
		btnNewButton_2
				.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				Color.DARK_GRAY, null));
		btnNewButton_2.setBackground(new Color(255, 165, 0));

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(444, 40, 500, 500);
		lblNewLabel.setAutoscrolls(true);
		lblNewLabel.setIcon(new ImageIcon(WelcomePanel.class
				.getResource("/polyFive/ui/images/p5cicon.png")));
		add(lblNewLabel);

		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WelcomePanel welcomePanel = new WelcomePanel(f);
				f.getContentPane().removeAll();
				f.getContentPane().add(welcomePanel);
				f.repaint();
				f.revalidate();
				f.setVisible(true);
			}
		});
		button.setIcon(new ImageIcon(WelcomePanel.class
				.getResource("/polyFive/ui/images/p5cicon7575.png")));
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setBorder(null);
		button.setBounds(21, 21, 75, 75);
		add(button);

		final JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangeLanguage changeLanguage = new ChangeLanguage();
				if (comboBox.getSelectedIndex() == 1) {

					btnNewButton.setText(BUNDLE2
							.getString("WelcomePanel.btnNewButton.text"));
					btnNewButton_1.setText(BUNDLE2
							.getString("WelcomePanel.btnNewButton_1.text"));
					btnNewButton_2.setText(BUNDLE2
							.getString("WelcomePanel.btnNewButton_2.text"));
					changeLanguage.setChangeLanguage(1);
				} else if (comboBox.getSelectedIndex() == 0) {
					btnNewButton.setText(BUNDLE
							.getString("WelcomePanel.btnNewButton.text"));
					btnNewButton_1.setText(BUNDLE
							.getString("WelcomePanel.btnNewButton_1.text"));
					btnNewButton_2.setText(BUNDLE
							.getString("WelcomePanel.btnNewButton_2.text"));

					changeLanguage.setChangeLanguage(0);
				}
				f.setStoreLanguage(changeLanguage);
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "English",
				"Malay" }));
		comboBox.setForeground(Color.BLACK);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.setBorder(null);
		comboBox.setBounds(1019, 21, 300, 35);
		add(comboBox);

		super.setLayout();

	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
		}
	}
}
