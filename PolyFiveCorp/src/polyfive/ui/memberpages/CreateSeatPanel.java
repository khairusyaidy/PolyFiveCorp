//program name CreateSeatPanel.java
//purpose ui for create table
//name qing hui
//admin no 121997Q
//module group IS 1201
//last modified 4/2/2012
package polyfive.ui.memberpages;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import polyfive.entities.EventAttributes;
import polyfive.entities.Member;
import polyfive.ui.adminpages.AdminCalendar;
import polyfive.ui.master.MainFrame;
import polyfive.ui.master.MasterPanel;
import polyfive.ui.publicpages.PublicCalendar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class CreateSeatPanel extends MasterPanel {
	private JTextField rowTextField;
	private JTextField columnTextField;
	private JPanel seatSelectorPanel;
	private JTextField setPrice;
	private JTextField setavailable;
	private JTable myTableReference;
	private JTextField firstRow;
	private JTextField firstCol;
	private JTextField secondRow;
	private JTextField secondCol;
	private MainFrame f = null;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel storeEventName;
	private int checksum = 0 ;
	private int y2;
	private int x2;
	private int x;
	private int y;
	private	JScrollPane scrollPane;
	int available = 1 ;
	int z;
	int i;
	double price;
	
	public CreateSeatPanel(MainFrame frame) {
		f = frame;
		setLayout(null);
		
		EventAttributes eventAttributes = new EventAttributes ();
		eventAttributes = f.getStoreEvents();
		final int eventId = eventAttributes.getEventId();
		String name = eventAttributes.getEventName();
		System.out.println(eventId);
		
		storeEventName = new JLabel(name);
		storeEventName.setFont(new Font("Tahoma", Font.PLAIN, 25));
		storeEventName.setBounds(906, 107, 369, 49);
		add(storeEventName);
		
		rowTextField = new JTextField();
		rowTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rowTextField.setBounds(925, 214, 89, 31);
		add(rowTextField);
		rowTextField.setColumns(10);
		rowTextField.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent e){
				String value = rowTextField.getText();
				
				if((e.getKeyChar() >= '0' && e.getKeyChar()<='9'|| e.getKeyChar()==KeyEvent.VK_BACK_SPACE)){
					rowTextField.setEditable(true);
				}
				else{
					//rowTextField.setEditable(false);
					rowTextField.setText("");
					JOptionPane.showMessageDialog(null," Enter number only ");
					}
			}
		});
		
		columnTextField = new JTextField();
		columnTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		columnTextField.setBounds(1213, 214, 89, 31);
		add(columnTextField);
		columnTextField.setColumns(10);
		columnTextField.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent e){
				String value = columnTextField.getText();
				
				if((e.getKeyChar() >= '0' && e.getKeyChar()<='9'|| e.getKeyChar()==KeyEvent.VK_BACK_SPACE)){
					columnTextField.setEditable(true);
				}
				else{
				//	columnTextField.setEditable(false);
					columnTextField.setText("");
					JOptionPane.showMessageDialog(null," Enter number only ");
					}
			}
		});

		
		seatSelectorPanel = new JPanel();
		seatSelectorPanel.setBounds(45, 126, 675, 462);
		add(seatSelectorPanel);
		
		JLabel lblNewLabel_1 = new JLabel("Seating plan will be shown here");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 38));
		seatSelectorPanel.add(lblNewLabel_1);
		
		JButton btnShowSeats = new JButton("Create");
		btnShowSeats.setBackground(new Color(255, 165, 0));
		btnShowSeats.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnShowSeats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int rows = 0;
				int cols = 0;
				try{
					rows = Integer.parseInt(rowTextField.getText());
					cols = Integer.parseInt(columnTextField.getText());
					if(rows>26 || cols>26){
						JOptionPane.showMessageDialog(null," Row must be less than 26 and column not more than 26");
					}
					else if(rows <= 0 || cols <= 0){
						JOptionPane.showMessageDialog(null," Row must be more than 0 and col must also be more than 0");
					}
					else{
						CreateSeatLayout(rows, cols, eventId);
		
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} 
		});
		btnShowSeats.setBounds(857, 251, 106, 31);
		add(btnShowSeats);
		this.revalidate();
		this.repaint();
		
		setPrice = new JTextField();
		setPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		setPrice.setBounds(848, 555, 86, 31);
		add(setPrice);
		setPrice.setColumns(10);
		setPrice.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent e){
				String value = rowTextField.getText();
				int l = value.length();
				if((e.getKeyChar() >= '0' && e.getKeyChar()<='9'|| e.getKeyChar()==KeyEvent.VK_BACK_SPACE || e.getKeyChar()==KeyEvent.VK_PERIOD)){
					setPrice.setEditable(true);
				}
				else{
					setPrice.setEditable(false);
					setPrice.setText("");
					JOptionPane.showMessageDialog(null," Enter number only ");
					}
			}
		});
		
		
		JButton btnNewButton = new JButton("save");
		btnNewButton.setBackground(new Color(255, 165, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = Integer.parseInt(firstRow.getText());	
				int col =  Integer.parseInt(firstCol.getText());
				if(0 != Double.parseDouble(setPrice.getText())){
					price = Double.parseDouble(setPrice.getText());
				}
				else{
					price = 0;
				}
		//		available = Integer.parseInt(setavailable.getText());
				if(checksum < Integer.parseInt(firstRow.getText())){
					if(Integer.parseInt(rowTextField.getText())>= Integer.parseInt(firstRow.getText())){
						x =  Integer.parseInt(firstRow.getText());
					}
					
					else{
						firstRow.setEditable(false);
						firstRow.setText("");
						JOptionPane.showMessageDialog(null," Enter number that is less than Row");
					}	
				}
				
				else{
					firstRow.setEditable(false);
					firstRow.setText("");
					JOptionPane.showMessageDialog(null," Enter number that is more than 0");
					}
				
				if(checksum < Integer.parseInt(firstCol.getText())){
					if(Integer.parseInt(columnTextField.getText())>= Integer.parseInt(firstCol.getText())){
					y =  Integer.parseInt(firstCol.getText());
					}
					
					else{
						firstCol.setEditable(false);
						firstCol.setText("");
						JOptionPane.showMessageDialog(null," Enter number that is less than Column");
						
					}	
				}
				
				else{
					firstCol.setEditable(false);
					firstCol.setText("");
					JOptionPane.showMessageDialog(null," Enter number that is more than 0");
					}
				
				if(checksum < Integer.parseInt(secondCol.getText())){
					if(Integer.parseInt(columnTextField.getText())>= Integer.parseInt(secondCol.getText())){
						y2 =  Integer.parseInt(secondCol.getText());
					}
					
					else{
						secondCol.setEditable(false);
						secondCol.setText("");
						JOptionPane.showMessageDialog(null," Enter number that is less than Column");
						
					}	
				}
				
				else{
					secondCol.setEditable(false);
					secondCol.setText("");
					JOptionPane.showMessageDialog(null," Enter number that is more than 0");
					}
				
				if(checksum < Integer.parseInt(secondRow.getText())){
					if(Integer.parseInt(rowTextField.getText())>= Integer.parseInt(secondRow.getText())){
						x2 =  Integer.parseInt(secondRow.getText());
					}
					
					else{
						secondRow.setEditable(false);
						secondRow.setText("");
						JOptionPane.showMessageDialog(null," Enter number that is less than Row");
						
					}	
				}
				
				else{
					secondRow.setEditable(false);
					secondRow.setText("");
					JOptionPane.showMessageDialog(null," Enter number that is more than 0");
					}
				
			
				
				((MyTableModel)myTableReference.getModel()).setPricing(x,y,x2,y2,price,available, eventId);
				
				//update table
				myTableReference.updateUI();
			}
		});
		btnNewButton.setBounds(857, 620, 106, 29);
		add(btnNewButton);
		
		firstRow = new JTextField();
		firstRow.setFont(new Font("Tahoma", Font.PLAIN, 15));
		firstRow.setBounds(925, 383, 86, 32);
		add(firstRow);
		firstRow.setColumns(10);
		firstRow.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent e){
				String value = firstRow.getText();
				int l = value.length();
				if((e.getKeyChar() >= '0' && e.getKeyChar()<='9'|| e.getKeyChar()==KeyEvent.VK_BACK_SPACE||e.getKeyChar()<Integer.parseInt(rowTextField.getText()))){
					firstRow.setEditable(true);
				}
				
				else{
					//firstRow.setEditable(false);
					firstRow.setText("");
					JOptionPane.showMessageDialog(null," Enter number only and not more than the row");
					}
			}
		});
		
		firstCol = new JTextField();
		firstCol.setFont(new Font("Tahoma", Font.PLAIN, 15));
		firstCol.setBounds(1213, 384, 89, 31);
		add(firstCol);
		firstCol.setColumns(10);
		firstCol.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent e){
				String value = firstCol.getText();
				int l = value.length();
				if((e.getKeyChar() >= '0' && e.getKeyChar()<='9'|| e.getKeyChar()==KeyEvent.VK_BACK_SPACE||e.getKeyChar()<Integer.parseInt(columnTextField.getText()))){
					firstCol.setEditable(true);
				}
				
				else{
					//firstCol.setEditable(false);
					firstCol.setText("");
					JOptionPane.showMessageDialog(null," Enter number only and not more than the column");
					}
			}
		});
		
		secondRow = new JTextField();
		secondRow.setFont(new Font("Tahoma", Font.PLAIN, 15));
		secondRow.setBounds(925, 437, 86, 31);
		add(secondRow);
		secondRow.setColumns(10);
		secondRow.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent e){
				String value = secondRow.getText();
				int l = value.length();
				if((e.getKeyChar() >= '0' && e.getKeyChar()<='9'|| e.getKeyChar()==KeyEvent.VK_BACK_SPACE||e.getKeyChar()<Integer.parseInt(rowTextField.getText()))){
					secondRow.setEditable(true);
				}
				
				else{
					//secondRow.setEditable(false);
					secondRow.setText("");
					JOptionPane.showMessageDialog(null," Enter number only ");
					}
			}
		});
		
		secondCol = new JTextField();
		secondCol.setFont(new Font("Tahoma", Font.PLAIN, 15));
		secondCol.setBounds(1213, 437, 86, 31);
		add(secondCol);
		secondCol.setColumns(10);
		secondCol.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent e){
				String value = secondCol.getText();
				int l = value.length();
				if((e.getKeyChar() >= '0' && e.getKeyChar()<='9'|| e.getKeyChar()==KeyEvent.VK_BACK_SPACE||e.getKeyChar()<Integer.parseInt(columnTextField.getText()))){
					secondCol.setEditable(true);
				}
				
				else{
					//secondCol.setEditable(false);
					secondCol.setText("");
					JOptionPane.showMessageDialog(null," Enter number only ");
					}
			}
		});
		
	JButton NextPage = new JButton("Next");
	NextPage.setBackground(new Color(255, 165, 0));
	NextPage.setFont(new Font("Tahoma", Font.PLAIN, 18));
		NextPage.addActionListener(new ActionListener() {
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
		NextPage.setBounds(857, 685, 106, 29);
		add(NextPage); 
	
		
		JLabel lblRow = new JLabel("Number of rows");
		lblRow.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRow.setBounds(778, 216, 149, 23);
		add(lblRow);
		
		JLabel lblColumn = new JLabel("Number of column");
		lblColumn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblColumn.setBounds(1027, 210, 163, 31);
		add(lblColumn);
		
		JLabel lblNewLabel_2 = new JLabel("Starting row");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(778, 384, 113, 31);
		add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Starting column");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(1027, 383, 148, 32);
		add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Ending row");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(778, 433, 113, 31);
		add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Ending column");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(1027, 433, 143, 31);
		add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Price");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(778, 553, 53, 35);
		add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Seat availability");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(778, 507, 143, 23);
		add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("$");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_8.setBounds(830, 554, 18, 31);
		add(lblNewLabel_8);
		
		JLabel lblFromRowFrom = new JLabel("Seat Allocation (Starting row,Starting column) to (Ending row,Starting column)");
		lblFromRowFrom.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFromRowFrom.setBounds(730, 320, 593, 29);
		add(lblFromRowFrom);
		
		JLabel lblNewLabel = new JLabel("Create Seat plan");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(730, 171, 158, 23);
		add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("delete selected seat");
		btnNewButton_1.setBackground(new Color(255, 165, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int selectedRow = myTableReference.getSelectedRow();
				int selectedColumn = myTableReference.getSelectedColumn();
				double price = 0;
				int available = 1;
				((MyTableModel)myTableReference.getModel()).setPricing(selectedRow,selectedColumn,selectedRow,selectedColumn,price,available, eventId);
;
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.setBounds(1082, 620, 193, 29);
		add(btnNewButton_1);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"available","unavailable"}));
		comboBox.setSelectedIndex(0);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String z = (String)comboBox.getSelectedItem();
				if("available"==z){
					 available = 1;
					 setPrice.setVisible(true);
					 setPrice.setEditable(true);
					 lblNewLabel_6.setVisible(true);
					 lblNewLabel_8.setVisible(true);
				}
				else{
					available = 0;
					setPrice.setVisible(false);
					setPrice.setEditable(false);
					lblNewLabel_6.setVisible(false);
					lblNewLabel_8.setVisible(false);
					setPrice.setText("0");
					
			   }
				
			}
			
		});
		comboBox.setBounds(940, 512, 113, 20);
		add(comboBox);
		this.revalidate();
		this.repaint(); 
		
		super.setLayout();
	
	
	}
	private void CreateSeatLayout(int rows , int cols, int eventId) throws Exception{
		seatSelectorPanel.removeAll();
		myTableReference = new JTable(new MyTableModel(rows, cols));
		seatSelectorPanel.add(myTableReference);
		scrollPane = myTableReference.createScrollPaneForTable(myTableReference);
		seatSelectorPanel.setLayout( new BorderLayout());
		seatSelectorPanel.add( scrollPane, BorderLayout.CENTER );
		if (myTableReference.getTableHeader().isVisible() != false) {
			myTableReference.getTableHeader().setVisible(false);
			myTableReference.getTableHeader().setPreferredSize(false ? null : new Dimension(-1, 0));
			 }
		this.revalidate();
		this.repaint();
	}
}