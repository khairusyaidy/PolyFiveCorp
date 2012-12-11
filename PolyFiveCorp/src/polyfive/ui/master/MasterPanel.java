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

	private MainFrame f = null;
	/**
	 * Create the panel.
	 */
	public MasterPanel() {
	}
	public void setLayout(){

		setSize(new Dimension(1366, 768));

		setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Language", "English", "Mandrin", "Malay", "Tamil"}));
		comboBox.setForeground(Color.BLACK);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.setBorder(null);
		comboBox.setBounds(1035, 11, 300, 35);
		add(comboBox);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setOpaque(false);
		panel.setBounds(21, 21, 297, 75);
		add(panel);
		
		JLabel label = new JLabel("PolyFive Corp");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(255, 165, 0));
		label.setFont(new Font("Tahoma", Font.PLAIN, 32));
		label.setBounds(85, 11, 191, 53);
		panel.add(label);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setIcon(new ImageIcon(MasterPanel.class.getResource("/polyFive/ui/images/p5cbg.png")));
		lblNewLabel.setBounds(0, 0, 1366, 768);
		add(lblNewLabel);
	}
	
	public MasterPanel(MainFrame frame) {
		this();
		f = frame;
		// TODO Auto-generated constructor stub
	}
}


