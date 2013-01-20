package polyfive.entities.dao;

import polyfive.entities.EventDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;



public class EventDetailsDao {

	static Connection currentCon = null;
	static ResultSet rs = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs1 = null;
	static PreparedStatement pstmt1 = null;

	// added in another comment
	// added in another comment to test conflict2
	public static EventDetails insertEventDetails(EventDetails eventDetails) {
		
		Statement stmt = null;

		// get the last member ID 
		try {
			
            // query for inserting into the table
			currentCon = DBConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            String query = "insert into Event(houseKeeping,facilities,staff,overall) values(?,?,?,?)";
            pstmt = currentCon.prepareStatement(query);
            // inserting values
            
         
            pstmt.setString(1,eventDetails.getEventName());
            pstmt.setString(2,eventDetails.getEventDate());
            pstmt.setString(3, eventDetails.getEventAddress());  
            pstmt.setString(4,eventDetails.getDescription());
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
		return eventDetails;

	}
}
