/* 
 * Program Name : MasterPanel.java
 * Purpose : Master Panel
 * 
 * Authour: Muhammad Khairyl Rusyaidy
 * Admin No: 120258L
 * Module Group : IS1201
 * Last Modified: 29/1/2013
 * 
 */
package polyfive.ui.master;

import polyfive.ui.*;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Cursor;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

public class MasterPanel extends JPanel {

	protected MainFrame f = null;

	/**
	 * Create the panel.
	 */
	public MasterPanel() {
		// setLayout();
	}

	public void setLayout() {

		setSize(new Dimension(1366, 768));

		setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setOpaque(false);
		panel.setBounds(21, 21, 383, 75);
		add(panel);

		JLabel label = new JLabel("PolyFive Corp");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(255, 165, 0));
		label.setFont(new Font("Segoe Script", Font.PLAIN, 32));
		label.setBounds(67, 11, 288, 53);
		panel.add(label);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setIcon(new ImageIcon(MasterPanel.class
				.getResource("/polyFive/ui/images/p5cbg.png")));
		lblNewLabel.setBounds(0, 0, 1366, 768);
		add(lblNewLabel);
	}

	public MasterPanel(MainFrame frame) {
		this();
		f = frame;
		// TODO Auto-generated constructor stub
	}
}
