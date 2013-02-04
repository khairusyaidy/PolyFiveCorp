//program name event.java
//purpose pass event detail into database
//name qing hui
//admin no 121997Q
//module group IS 1201
//last modified 4/2/2012

package polyfive.ui.memberpages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Event {

	private int eventId;
	private String eventName;
	private int rows;
	private int cols;

	public Event() {
		// TODO Auto-generated constructor stub
	}

	public int getEventId() {
		return eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public int getRows() {
		return rows;
	}

	public int getCols() {
		return cols;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public void setCols(int cols) {
		this.cols = cols;
	}

	public boolean save() {
		Connection con = null;
		boolean result = false;

		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:8888/poly5", "root", "");

			if (getEvent(eventId) != null) {
				// existing entry
				// update instead of inserting

				String sql = "UPDATE Event SET eventName=?, rows=?, cols=? WHERE eventId=?;";

				PreparedStatement preparedStatement = con.prepareStatement(sql);
				preparedStatement.setString(1, eventName);
				preparedStatement.setInt(2, rows);
				preparedStatement.setInt(3, cols);
				preparedStatement.setInt(4, eventId);
				result = preparedStatement.executeUpdate() > 0;
			} else {
				// new entry
				// insert

				String sql = "INSERT INTO Event VALUES(?, ?, ?, ?)";

				PreparedStatement preparedStatement = con.prepareStatement(sql);
				preparedStatement.setInt(1, eventId);
				preparedStatement.setString(2, eventName);
				preparedStatement.setInt(3, rows);
				preparedStatement.setInt(4, cols);
				result = preparedStatement.executeUpdate() > 0;
			}

		} catch (SQLException ex) {
			ex.printStackTrace();

		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// ignore
				}
			}
		}

		return result;
	}

	public static ArrayList<Event> getAllEvents() {
		// SELECT * FROM Event

		Connection con = null;
		ArrayList<Event> events = new ArrayList<Event>();

		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:8888/poly5", "root", "");

			String sql = "SELECT * FROM event;";

			PreparedStatement preparedStatement = con.prepareStatement(sql);
			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {
				Event event = new Event();
				event.cols = result.getInt("cols");
				event.eventId = result.getInt("eventId");
				event.eventName = result.getString("eventName");
				event.rows = result.getInt("rows");
				events.add(event);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();

		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// ignore
				}
			}
		}

		return events;
	}

	public static Event getEvent(int eventId) {
		// SELECT * FROM Event WHERE eventId=eventId

		Connection con = null;
		Event event = null;

		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:8888/poly5", "root", "");

			String sql = "SELECT * FROM event WHERE eventId=?;";

			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, eventId);
			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {
				event = new Event();
				event.cols = result.getInt("cols");
				event.eventId = result.getInt("eventId");
				event.eventName = result.getString("eventName");
				event.rows = result.getInt("rows");
				break; // only returns the first match
			}

		} catch (SQLException ex) {
			ex.printStackTrace();

		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// ignore
				}
			}
		}

		return event;

	}

}
