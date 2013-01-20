package polyfive.ui.memberpages;

import polyfive.entities.Member;
import polyfive.ui.adminpages.*;
import polyfive.ui.images.*;
import polyfive.ui.master.*;
import polyfive.ui.publicpages.*;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Dimension;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Cursor;

public class SeatAllocation extends MasterPanel {
	private MainFrame f = null;
	private JTextField txtStage;

	/**
	 * Create the panel.
	 */
	public SeatAllocation(MainFrame frame) {
		f = frame;
		setSize(new Dimension(1366, 768));
		setForeground(Color.BLACK);
		setBorder(new LineBorder(new Color(0, 0, 0), 0));
		setBackground(Color.WHITE);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setEnabled(false);
		panel.setOpaque(false);
		panel.setLayout(null);
		panel.setForeground(Color.WHITE);
		panel.setBorder(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(58, 97, 1222, 538);
		add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(140, 184, 982, 288);
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(10, 10, 0, 0));

		JButton btnNewButton_1 = new JButton("A1");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel_1.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("B1");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel_1.add(btnNewButton_2);

		JButton btnNewButton = new JButton("C1");
		panel_1.add(btnNewButton);

		JButton btnCr_27 = new JButton("D1");
		panel_1.add(btnCr_27);

		JButton btnCr = new JButton("E1");
		panel_1.add(btnCr);

		JButton btnCr_9 = new JButton("F1");
		panel_1.add(btnCr_9);

		JButton btnCr_18 = new JButton("G1");
		panel_1.add(btnCr_18);

		JButton btnH = new JButton("H1");
		panel_1.add(btnH);

		JButton btnI = new JButton("I1");
		panel_1.add(btnI);

		JButton btnJ = new JButton("J1");
		panel_1.add(btnJ);

		JButton btnCr_1 = new JButton("A2\r\n");
		panel_1.add(btnCr_1);

		JButton btnCr_10 = new JButton("B2");
		panel_1.add(btnCr_10);

		JButton btnCr_19 = new JButton("C2");
		panel_1.add(btnCr_19);

		JButton btnD = new JButton("D2");
		panel_1.add(btnD);

		JButton btnE = new JButton("E2");
		panel_1.add(btnE);

		JButton btnF = new JButton("F2");
		panel_1.add(btnF);

		JButton btnG = new JButton("G2");
		panel_1.add(btnG);

		JButton btnH_1 = new JButton("H2");
		panel_1.add(btnH_1);

		JButton btnI_1 = new JButton("I2");
		panel_1.add(btnI_1);

		JButton btnJ_1 = new JButton("J2");
		panel_1.add(btnJ_1);

		JButton btnA = new JButton("A3");
		panel_1.add(btnA);

		JButton btnCr_2 = new JButton("B3");
		panel_1.add(btnCr_2);

		JButton btnCr_11 = new JButton("C3");
		panel_1.add(btnCr_11);

		JButton btnCr_20 = new JButton("D3");
		panel_1.add(btnCr_20);

		JButton btnE_1 = new JButton("E3");
		panel_1.add(btnE_1);

		JButton btnF_1 = new JButton("F3");
		panel_1.add(btnF_1);

		JButton btnG_1 = new JButton("G3");
		panel_1.add(btnG_1);

		JButton btnH_2 = new JButton("H3");
		panel_1.add(btnH_2);

		JButton btnI_2 = new JButton("I3");
		panel_1.add(btnI_2);

		JButton btnJ_2 = new JButton("J3");
		panel_1.add(btnJ_2);

		JButton btnA_1 = new JButton("A4");
		panel_1.add(btnA_1);

		JButton btnB = new JButton("B4");
		panel_1.add(btnB);

		JButton btnCr_3 = new JButton("C4");
		panel_1.add(btnCr_3);

		JButton btnCr_12 = new JButton("D4");
		panel_1.add(btnCr_12);

		JButton btnCr_21 = new JButton("E4");
		panel_1.add(btnCr_21);

		JButton btnF_2 = new JButton("F4");
		panel_1.add(btnF_2);

		JButton btnG_2 = new JButton("G4");
		panel_1.add(btnG_2);

		JButton btnH_3 = new JButton("H4");
		panel_1.add(btnH_3);

		JButton btnI_3 = new JButton("I4");
		panel_1.add(btnI_3);

		JButton btnJ_3 = new JButton("J4");
		panel_1.add(btnJ_3);

		JButton btnA_2 = new JButton("A5");
		panel_1.add(btnA_2);

		JButton btnB_1 = new JButton("B5");
		panel_1.add(btnB_1);

		JButton btnC = new JButton("C5");
		panel_1.add(btnC);

		JButton btnCr_4 = new JButton("D5");
		panel_1.add(btnCr_4);

		JButton btnCr_13 = new JButton("E5");
		panel_1.add(btnCr_13);

		JButton btnCr_22 = new JButton("F5");
		panel_1.add(btnCr_22);

		JButton btnG_3 = new JButton("G5");
		panel_1.add(btnG_3);

		JButton btnH_4 = new JButton("H5");
		panel_1.add(btnH_4);

		JButton btnI_4 = new JButton("I5");
		panel_1.add(btnI_4);

		JButton btnJ_4 = new JButton("J5");
		panel_1.add(btnJ_4);

		JButton btnA_3 = new JButton("A6");
		panel_1.add(btnA_3);

		JButton btnB_2 = new JButton("B6");
		panel_1.add(btnB_2);

		JButton btnC_1 = new JButton("C6");
		panel_1.add(btnC_1);

		JButton btnD_1 = new JButton("D6");
		panel_1.add(btnD_1);

		JButton btnCr_5 = new JButton("E6");
		panel_1.add(btnCr_5);

		JButton btnCr_14 = new JButton("F6");
		panel_1.add(btnCr_14);

		JButton btnCr_23 = new JButton("G6");
		panel_1.add(btnCr_23);

		JButton btnH_5 = new JButton("H6");
		panel_1.add(btnH_5);

		JButton btnI_5 = new JButton("I6");
		panel_1.add(btnI_5);

		JButton btnJ_5 = new JButton("J6");
		panel_1.add(btnJ_5);

		JButton btnA_4 = new JButton("A7");
		panel_1.add(btnA_4);

		JButton btnB_3 = new JButton("B7");
		panel_1.add(btnB_3);

		JButton btnC_2 = new JButton("C7");
		panel_1.add(btnC_2);

		JButton btnD_2 = new JButton("D7");
		panel_1.add(btnD_2);

		JButton btnE_2 = new JButton("E7");
		panel_1.add(btnE_2);

		JButton btnCr_6 = new JButton("F7");
		panel_1.add(btnCr_6);

		JButton btnCr_15 = new JButton("G7");
		panel_1.add(btnCr_15);

		JButton btnCr_24 = new JButton("H7");
		panel_1.add(btnCr_24);

		JButton btnI_6 = new JButton("I7");
		panel_1.add(btnI_6);

		JButton btnJ_6 = new JButton("J7");
		panel_1.add(btnJ_6);

		JButton btnA_5 = new JButton("A8");
		panel_1.add(btnA_5);

		JButton btnB_4 = new JButton("B8");
		panel_1.add(btnB_4);

		JButton btnC_3 = new JButton("C8");
		panel_1.add(btnC_3);

		JButton btnD_3 = new JButton("D8");
		panel_1.add(btnD_3);

		JButton btnE_3 = new JButton("E8");
		panel_1.add(btnE_3);

		JButton btnF_3 = new JButton("F8");
		panel_1.add(btnF_3);

		JButton btnCr_7 = new JButton("G8");
		panel_1.add(btnCr_7);

		JButton btnCr_16 = new JButton("H8");
		panel_1.add(btnCr_16);

		JButton btnCr_25 = new JButton("I8");
		panel_1.add(btnCr_25);

		JButton btnJ_7 = new JButton("J8");
		panel_1.add(btnJ_7);

		JButton btnA_6 = new JButton("A9");
		panel_1.add(btnA_6);

		JButton btnB_5 = new JButton("B9");
		panel_1.add(btnB_5);

		JButton btnC_4 = new JButton("C9");
		panel_1.add(btnC_4);

		JButton btnD_4 = new JButton("D9");
		panel_1.add(btnD_4);

		JButton btnE_4 = new JButton("E9");
		panel_1.add(btnE_4);

		JButton btnF_4 = new JButton("F9");
		panel_1.add(btnF_4);

		JButton btnG_4 = new JButton("G9");
		panel_1.add(btnG_4);

		JButton btnH_6 = new JButton("H9");
		panel_1.add(btnH_6);

		JButton btnCr_8 = new JButton("I9");
		panel_1.add(btnCr_8);

		JButton btnCr_17 = new JButton("J9");
		panel_1.add(btnCr_17);

		JButton btnCr_26 = new JButton("A10");
		panel_1.add(btnCr_26);

		JButton btnB_6 = new JButton("B10");
		panel_1.add(btnB_6);

		JButton btnC_5 = new JButton("C10");
		panel_1.add(btnC_5);

		JButton btnD_5 = new JButton("D10");
		panel_1.add(btnD_5);

		JButton btnE_5 = new JButton("E10");
		panel_1.add(btnE_5);

		JButton btnF_5 = new JButton("F10");
		panel_1.add(btnF_5);

		JButton btnG_5 = new JButton("G10");
		panel_1.add(btnG_5);

		JButton btnH_7 = new JButton("H10");
		panel_1.add(btnH_7);

		JButton btnI_7 = new JButton("I10");
		panel_1.add(btnI_7);

		JButton btnJ_8 = new JButton("J10");
		panel_1.add(btnJ_8);

		txtStage = new JTextField();
		txtStage.setEnabled(false);
		txtStage.setHorizontalAlignment(SwingConstants.CENTER);
		txtStage.setFont(new Font("Tahoma", Font.PLAIN, 50));
		txtStage.setText("STAGE");
		txtStage.setBounds(446, 20, 372, 72);
		panel.add(txtStage);
		txtStage.setColumns(10);

		JButton button = new JButton("Cancel");
		button.setFocusPainted(false);
		button.setBorder(null);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchEvents searchEvents = new SearchEvents(f);
				f.getContentPane().removeAll();
				f.getContentPane().add(searchEvents);
				f.repaint();
				f.revalidate();
				f.setVisible(true);
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.PLAIN, 30));
		button.setBackground(new Color(255, 165, 0));
		button.setBounds(21, 664, 150, 75);
		add(button);

		JButton button_1 = new JButton("");
		button_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Member user = new Member();
				user = f.getSession();
				if(user.getRank() <= 4 ){
				MemberCalendar memberCalendar = new MemberCalendar(f);
				f.getContentPane().removeAll();
				f.getContentPane().add(memberCalendar);
				f.repaint();
				f.revalidate();
				f.setVisible(true);
				}
				else {
					AdminCalendar adminCalendar = new AdminCalendar(f);
					f.getContentPane().removeAll();
					f.getContentPane().add(adminCalendar);
					f.repaint();
					f.revalidate();
					f.setVisible(true);
				}
			}
		});
		button_1.setIcon(new ImageIcon(SeatAllocation.class
				.getResource("/polyFive/ui/images/p5cicon7575.png")));
		button_1.setBorder(null);
		button_1.setBounds(21, 23, 75, 75);
		add(button_1);

		JButton btnProceedToPayment = new JButton("Proceed to Payment");
		btnProceedToPayment.setCursor(Cursor
				.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnProceedToPayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paymentDetails paymentDetails =  new paymentDetails(f);
				f.getContentPane().removeAll();
				f.getContentPane().add(paymentDetails);
				f.repaint();
				f.revalidate();
				f.setVisible(true);
			}
		});
		btnProceedToPayment.setBorder(null);
		btnProceedToPayment.setFocusPainted(false);
		btnProceedToPayment.setForeground(Color.WHITE);
		btnProceedToPayment.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnProceedToPayment.setBackground(new Color(255, 165, 0));
		btnProceedToPayment.setBounds(1115, 664, 230, 75);
		add(btnProceedToPayment);

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
