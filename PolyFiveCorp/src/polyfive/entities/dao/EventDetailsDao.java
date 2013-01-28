package polyfive.entities.dao;

import polyfive.entities.EventAttributes;
import polyfive.ui.master.MainFrame;
import polyfive.ui.master.MasterPanel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;



public class EventDetailsDao extends MasterPanel{
	private static MainFrame f = null;
	
	static Connection currentCon = null;
	static ResultSet rs = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs1 = null;
	static PreparedStatement pstmt1 = null;
	static String date1 = null;

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
            
            
            	int eventId = rs.getInt("IdEvent");
                String eventName = rs.getString("eventName");
                String eventDate = rs.getString("eventDate");
                String eventAdd = rs.getString("eventAdd");
                String eventDes = rs.getString("eventDes");
                float eventPrice = rs.getFloat("eventPrice");
                String eventType = rs.getString("eventType");
                int eventNoOfTickets = rs.getInt("eventNoOfTickets");
                String eventMapFileName = rs.getString("eventMapFileName");
                
                event = new EventAttributes();
                event.setEventId(eventId);
                event.setEventName(eventName);
                event.setEventDate(eventDate);
                event.setEventAddress(eventAdd);
                event.setDescription(eventDes);
                event.setEventPrice(eventPrice);
                event.setEventType(eventType);
                event.setEventNoOfTickets(eventNoOfTickets);
                event.setMapFileName(eventMapFileName);
                EventsList.add(event);
            }
        } catch (Exception e) {
         e.printStackTrace();
        }

return EventsList;

		
	}



	// added in another comment
	// added in another comment to test conflict2
	public static EventAttributes insertEventDetails(EventAttributes addEvent) {
		Statement stmt = null;
		String eventName = addEvent.getEventName();
		String eventDate = addEvent.getEventDate();
		String eventAdd = addEvent.getEventAddress();
		String eventDes = addEvent.getDescription();
		float eventPrice = addEvent.getEventPrice();
		String eventType = addEvent.getEventType();
		int eventNoOfTickets = addEvent.getEventNoOfTickets();
		String eventMapFileName = addEvent.getMapFileName();
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

           
            String query = "insert into Events(idEvent, eventName, eventDate, eventAdd, eventDes, eventPrice, eventType, eventNoOfTickets,eventMapFileName) values('"+nextId+"','"+eventName+"','"+eventDate+"','"+eventAdd+"','"+eventDes+"','"+eventPrice+"','"+eventType+"','"+eventNoOfTickets+"','"+eventMapFileName+"')";   
            pstmt = currentCon.prepareStatement(query);

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
	
	
	
	
	
	
	
	
	
	public static EventAttributes insertEventDetails2(EventAttributes addEvent) {
		Statement stmt = null;
		String eventName = addEvent.getEventName();
		String eventDate = addEvent.getEventDate();
		String eventAdd = addEvent.getEventAddress();
		String eventDes = addEvent.getDescription();
		String eventType = addEvent.getEventType();
		String eventMapFileName = addEvent.getMapFileName();
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

           
            String query = "insert into Events(idEvent, eventName, eventDate, eventAdd, eventDes, eventType, eventMapFileName) values('"+nextId+"','"+eventName+"','"+eventDate+"','"+eventAdd+"','"+eventDes+"','"+eventType+"','"+eventMapFileName+"')";   
            pstmt = currentCon.prepareStatement(query);

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
	
	
	
	public static int getMaxByDate(String date){


		Statement stmt = null;
		try {
			stmt = currentCon.createStatement();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		String getMax = "select count(idEvent) from Events where eventDate='"+date+"'";
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
	
	
	
	public static String fullDate(String date){
		String day = date.substring(8, 10);
		String month = date.substring(4, 7);
		String year = date.substring(24,28);
		
		String fullDate = day +" " + month+ " " + year ;
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("d MMM yyyy");

		return fullDate;
	}
	
	public static ArrayList <EventAttributes> RetrieveAllByDate(String date) {
		
		
		EventAttributes event = null;
		ArrayList <EventAttributes> EventsList = new ArrayList<>();
		Statement stmt = null;
        String searchQuery = "select * from events where eventDate ='" +date+"'";

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

}
}