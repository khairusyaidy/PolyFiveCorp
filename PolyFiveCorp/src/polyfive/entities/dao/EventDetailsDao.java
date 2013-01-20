package polyfive.entities.dao;

import polyfive.entities.StoreEvents;
import polyfive.ui.master.MainFrame;
import polyfive.ui.master.MasterPanel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;



public class EventDetailsDao extends MasterPanel{
	private static MainFrame f = null;
	public static ArrayList<StoreEvents> RetrieveAll() {
		ArrayList<StoreEvents> eventDetails = new ArrayList<>();
		
		StoreEvents event1 = new StoreEvents();
		StoreEvents event2 = new StoreEvents();
		StoreEvents event3 = new StoreEvents();
		StoreEvents event4 = new StoreEvents();

		event1.setEventName("Rock and Roll");
		event1.setEventDate("15 Jan 2012");
		eventDetails.add(event1);

		event2.setEventName("Disney");
		event2.setEventDate("16 Jan 2012");
		eventDetails.add(event2);

		event3.setEventName("Event 3");
		event3.setEventDate("17 Jan 2012");
		eventDetails.add(event3);

		event4.setEventName("Event 4");
		event4.setEventDate("18 Jan 2012");
		eventDetails.add(event4);

		return eventDetails;
	}

	static Connection currentCon = null;
	static ResultSet rs = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs1 = null;
	static PreparedStatement pstmt1 = null;

	// added in another comment
	// added in another comment to test conflict2
	public static StoreEvents insertEventDetails(StoreEvents addEvent) {
		Statement stmt = null;
		String eventName = addEvent.getEventName();
		String eventDate = addEvent.getEventDate();
		String eventAdd = addEvent.getEventAddress();
		String eventDes = addEvent.getDescription();
		// get the last member ID 
		try {
			
            // query for inserting into the table
			currentCon = DBConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            String query = "insert into Events(idEvents,eventName,eventDate,eventAdd,eventDes) values('0','"+eventName+"','"+eventDate+"','"+eventAdd+"','"+eventDes+"')";
            pstmt = currentCon.prepareStatement(query);
            // inserting values
            
         
     /*       pstmt.setString(1,addEvent.getEventName());
            pstmt.setString(2,addEvent.getEventDate());
            pstmt.setString(3, addEvent.getEventAddress());  
            pstmt.setString(4,addEvent.getDescription());
       */
            pstmt.executeUpdate();
            
		} catch (Exception ex) {

			System.out.println("Addition of Event failed: An Exception has occurred! " + ex);
		}

		// exception handling
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;
			}

			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}

				currentCon = null;
			}
		}
		return addEvent;

	}
}
