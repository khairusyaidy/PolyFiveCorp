package polyfive.entities.dao;

import polyfive.entities.EventAttributes;
import polyfive.ui.master.MainFrame;
import polyfive.ui.master.MasterPanel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class EventDetailsDao extends MasterPanel{
	private static MainFrame f = null;

	public static ArrayList <EventAttributes> RetrieveAll() {
		EventAttributes event = null;
		ArrayList <EventAttributes> EventsList = new ArrayList<>();
		Statement stmt = null;
        String searchQuery = "select * from events";

        try {
            // connect to DB
            currentCon = DBConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            while (rs.next()) {
            
           //     String memberId = rs.getString("member_id");
                String eventName = rs.getString("eventName");
                String eventDate = rs.getString("eventDate");
                String eventAdd = rs.getString("eventAdd");
                String eventDes = rs.getString("eventDes");
                event = new EventAttributes();
                event.setEventName(eventName);
                event.setEventDate(eventDate);
                event.setEventAddress(eventAdd);
                event.setDescription(eventDes);
             //   member.setPassword(password);
                EventsList.add(event);
            }
        } catch (Exception e) {
         e.printStackTrace();
        }

return EventsList;



	/*	
		StoreEventsNonDB event1 = new StoreEventsNonDB();
		StoreEventsNonDB event2 = new StoreEventsNonDB();
		StoreEventsNonDB event3 = new StoreEventsNonDB();
		StoreEventsNonDB event4 = new StoreEventsNonDB();

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
*/
		
	}

	static Connection currentCon = null;
	static ResultSet rs = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs1 = null;
	static PreparedStatement pstmt1 = null;

	// added in another comment
	// added in another comment to test conflict2
	public static EventAttributes insertEventDetails(EventAttributes addEvent) {
		Statement stmt = null;
		String eventName = addEvent.getEventName();
		String eventDate = addEvent.getEventDate();
		String eventAdd = addEvent.getEventAddress();
		String eventDes = addEvent.getDescription();
		// get the last member ID 
		try {
			
			currentCon = DBConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			String getMax = "select Max(idEvent) from Events";
			rs1 = stmt.executeQuery(getMax);
			rs1.next();
			int maxId = rs1.getInt(1);
			int nextId = maxId + 1;
			
            // query for inserting into the table

           
            String query = "insert into Events(idEvent,eventName,eventDate,eventAdd,eventDes) values('"+nextId+"','"+eventName+"','"+eventDate+"','"+eventAdd+"','"+eventDes+"')";
            
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
	
	public static int getMax(){


			Statement stmt = null;
			try {
				stmt = currentCon.createStatement();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			String getMax = "select count(idEvent) from Events";
			ResultSet rs1 = null;
			try {
				rs1 = stmt.executeQuery(getMax);
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			try {
				rs1.next();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			int maxId = 0;
			try {
				maxId = rs1.getInt(1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int nextId = maxId ;

		return nextId;
	}
}
