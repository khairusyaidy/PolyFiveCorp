
package polyfive.entities.dao;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import polyfive.ui.memberpages.Event;

public class Seat {

	private double price;
	private int status;
	private int row;
	private int col;
	private int eventId;
	
	public static final int SEAT_FREE = 1;
	public static final int SEAT_UNAVAILABLE = 0;
	
	static Connection currentCon = null;
	static ResultSet rs = null;
	
	public Seat() {
		// TODO Auto-generated constructor stub
	}
	
	public double getPrice() {
		return price;
	}

	public int getStatus() {
		return status;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public int getEventId() {
		return eventId;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	
	
	
	public boolean save(int eventId) {
		
		Statement stmt = null;
		boolean result = false;
		
		try {
            currentCon = DBConnectionManager.getConnection();
            stmt = currentCon.createStatement();
			
			if (getSeat(eventId, row, col) != null) {
				//existing entry
				//update instead of inserting
				
				String sql = "UPDATE Seat SET price=?, status=? WHERE eventId=? AND row=? AND col=?;";

				PreparedStatement preparedStatement = currentCon.prepareStatement(sql); 
				preparedStatement.setDouble(1, price);
				preparedStatement.setInt(2, status);
				preparedStatement.setInt(3, eventId);
				preparedStatement.setInt(4, row);
				preparedStatement.setInt(5, col);
				result = preparedStatement.executeUpdate() > 0;
			} else {
				//new entry
				//insert
				
				String sql = "INSERT INTO Seat VALUES(?, ?, ?, ?, ?)";

				PreparedStatement preparedStatement = currentCon.prepareStatement(sql); 
				preparedStatement.setDouble(1, price);
				preparedStatement.setInt(2, status);
				preparedStatement.setInt(3, row);
				preparedStatement.setInt(4, col);
				preparedStatement.setInt(5, eventId);
				result = preparedStatement.executeUpdate() > 0;
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
/*			
		} finally {
			if (currentCon != null) {
				try {
			//		currentCon.close();
				} catch (SQLException e) {
					//ignore
				}
			}*/
		}
		
		return result;
	}
	
	public static ArrayList<Seat> getAllSeats(int eventId){
		
		Connection con = null;
		ArrayList<Seat> seats = new ArrayList<Seat>();
		
		try {
		       currentCon = DBConnectionManager.getConnection();
			
			String sql = "SELECT * FROM seat WHERE eventId=?;";
			
			PreparedStatement preparedStatement = currentCon.prepareStatement(sql); 
			preparedStatement.setInt(1, eventId);
			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {
				Seat seat = new Seat();
				seat.col = result.getInt("col");
				seat.eventId = result.getInt("eventId");
				seat.price = result.getDouble("price");
				seat.row = result.getInt("row");
				seat.status = result.getInt("status");
				seats.add(seat);
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
/*			
		} finally {
			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (SQLException e) {
					//ignore
				}
			}*/
		}
		
		return seats;
	}
	
	public static Seat getSeat(int eventId, int row, int col) {
		//SELECT * FROM Seat WHERE eventId = eventId AND row = row AND col = col
		
		Connection con = null;
		Seat seat = null;
		
		try {
			currentCon = DBConnectionManager.getConnection();
			
			String sql = "SELECT * FROM seat WHERE eventId=? AND row=? AND col=?;";
			
			PreparedStatement preparedStatement = currentCon.prepareStatement(sql); 
			preparedStatement.setInt(1, eventId);
			preparedStatement.setInt(2, row);
			preparedStatement.setInt(3, col);
			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {
				seat = new Seat();
				seat.col = result.getInt("col");
				seat.eventId = result.getInt("eventId");
				seat.price = result.getDouble("price");
				seat.row = result.getInt("row");
				seat.status = result.getInt("status");
				break; // only returns the first match
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
	/*		
		} finally {
			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (SQLException e) {
					//ignore
				}
			}*/
		}
		
		return seat;
	}
}
