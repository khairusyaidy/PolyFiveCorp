package polyfive.ui.adminpages;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import polyfive.ui.master.*;
import polyfive.ui.master.MasterPanel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserSetting extends MasterPanel {
	private JTextField txtSearch;
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
		
		txtSearch = new JTextField();
		txtSearch.setText("Search");
		txtSearch.setBounds(932, 148, 148, 25);
		add(txtSearch);
		txtSearch.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(1090, 149, 89, 23);
		add(btnSearch);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(991, 207, 89, 23);
		add(btnEdit);
		
		JButton btnEdit_1 = new JButton("Edit");
		btnEdit_1.setBounds(991, 233, 89, 23);
		add(btnEdit_1);
		
		JList list = new JList();
		list.setFont(new Font("Tahoma", Font.PLAIN, 18));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Tinesh Kumar (Gold Member)", "", "", "", "Timothy Yeo (Silver Member)"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(277, 203, 804, 334);
		add(list);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(991, 568, 89, 23);
		add(btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(1090, 568, 89, 23);
		add(btnDelete);
		
		
		super.setLayout();
	}
}
