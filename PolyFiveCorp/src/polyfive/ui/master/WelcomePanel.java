package polyfive.ui.master;

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
import com.javaswingcomponents.clock.analog.JSCAnalogClock;

public class WelcomePanel extends MasterPanel {
	private final Action action = new SwingAction();
	private MainFrame f = null;

	/**
	 * Create the panel.
	 */

	public WelcomePanel() {
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

		JButton btnNewButton = new JButton("First time user\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FirstTimeUsers firstTimeUsers = f.getFirstTimeUsers();
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

		JButton btnNewButton_1 = new JButton("    Login\r\n    ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPanel loginPanel = f.getLoginPanel();
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

		JButton btnNewButton_2 = new JButton("  Public  ");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PublicCalendar publicUsers = f.getPublicCalendar();
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
				WelcomePanel welcomePanel = f.getWelcomePanel();
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

		super.setLayout();

	}

	public WelcomePanel(MainFrame frame) {
		this();
		f = frame;
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
