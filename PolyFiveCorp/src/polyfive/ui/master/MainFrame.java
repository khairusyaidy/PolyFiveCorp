package polyfive.ui.master;

import polyfive.entities.Member;
import polyfive.ui.adminpages.*;
import polyfive.ui.images.*;
import polyfive.ui.memberpages.*;
import polyfive.ui.publicpages.*;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Frame;

import java.awt.event.*;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dialog.ModalExclusionType;

public class MainFrame extends JFrame {
	private JPanel contentPane;
	private JFrame myFrame;
	private static LoginPanel loginPanel;
	private static WelcomePanel welcomePanel;
	private static FirstTimeUsers firstTimeUsers;
	private static Register register;
	private static PublicCalendar publicCalendar;
	private static MemberCalendar memberCalendar;
	private static SearchEvents searchEvents;
	private static EventDetails eventDetails;
	private static EventDetailsRNR eventDetailsRNR;
	private static SeatAllocation seatAllocation;
	private static TicketsPurchase ticketsPurchase;
	private static AccountDetails accountDetails;
	private static paymentDetails paymentDetails;
	private static PaymentPanel paymentPanel;
	private static Member session;
	private static adminAddEvent adminAddEvent;
	private static AddEvent addEvent;
	private static AdminCalendar adminCalendar;

	public static Member getSession() {
		return session;
	}

	public static void setSession(Member session) {
		MainFrame.session = session;
	}

	public LoginPanel getLoginPanel() {
		return loginPanel;
	}

	public WelcomePanel getWelcomePanel() {
		return welcomePanel;
	}

	public FirstTimeUsers getFirstTimeUsers() {
		return firstTimeUsers;
	}

	public Register getRegister() {
		return register;
	}

	public PublicCalendar getPublicCalendar() {
		return publicCalendar;
	}

	public MemberCalendar getMemberCalendar() {
		return memberCalendar;
	}
	
	public AdminCalendar getAdminCalendar(){
		return adminCalendar;
	}

	public SearchEvents getSearchEvents() {
		return searchEvents;
	}

	public EventDetails getEventDetails() {
		return eventDetails;
	}

	public EventDetailsRNR getEventDetailsRNR() {
		return eventDetailsRNR;
	}

	public SeatAllocation getSeatAllocation() {
		return seatAllocation;
	}

	public TicketsPurchase getTicketsPurchase() {
		return ticketsPurchase;
	}

	public AccountDetails getAccountDetails() {
		return accountDetails;
	}

	public paymentDetails getPaymentDetails() {
		return paymentDetails;

	}

	public PaymentPanel getPaymentPanel() {
		return paymentPanel;
	}
	
	public adminAddEvent getAdminAddEvent() {
		return adminAddEvent;
	}
	
	public AdminCalendar adminCalendar() {
		return adminCalendar;
	}
	
	public AddEvent addEvent(){
		return addEvent;
	}
	

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					welcomePanel = new WelcomePanel(frame);
					
					/*
					
					 
					loginPanel = new LoginPanel(frame);
					firstTimeUsers = new FirstTimeUsers(frame);
					register = new Register(frame);
					publicCalendar = new PublicCalendar(frame);
					memberCalendar = new MemberCalendar(frame);
					searchEvents = new SearchEvents(frame);
					eventDetails = new EventDetails(frame);
					eventDetailsRNR = new EventDetailsRNR(frame);
					seatAllocation = new SeatAllocation(frame);
					ticketsPurchase = new TicketsPurchase(frame);
					accountDetails = new AccountDetails(frame);
					paymentDetails = new paymentDetails(frame);
					paymentPanel = new PaymentPanel(frame);
					adminAddEvent = new adminAddEvent(frame);
					adminCalendar = new adminCalendar(frame);
*/
					frame.setUndecorated(true);
					frame.setExtendedState(frame.MAXIMIZED_BOTH);
					frame.getContentPane().add(welcomePanel);
					welcomePanel.setVisible(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1274, 729);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));

	}

}
