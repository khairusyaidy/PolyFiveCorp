package polyfive.entities.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SeatDAO {
	static Connection con = null;
	static Statement stmt = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;
	private String eventName;
	private int seat;
	private double price;

	public String getEventName() {
		return eventName;
	}

	public int getSeat() {
		return seat;
	}

	public double getPrice() {
		return price;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public static void addSeat(SeatDAO seatDAO) {

		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:8888/poly5", "root", "");
			stmt = con.createStatement();
			String sqlStr;
			sqlStr = "insert into withoutSeat (eventName,seat,price) values(?,?,?)";
			pstmt = con.prepareStatement(sqlStr);

			double price = seatDAO.getPrice();
			int seats = seatDAO.getSeat();
			String eventName = seatDAO.getEventName();

			pstmt.setString(1, eventName);
			pstmt.setInt(2, seats);
			pstmt.setDouble(3, price);
			pstmt.executeUpdate();
		}

		catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public static SeatDAO retrieveAll(int eventId) {
		// s
		// select * from xx where evnetid = eventid
		// select * from xx
		SeatDAO seat = new SeatDAO();
		try {
			// connect to DB
			String searchQuery = "select * from withoutSeat";
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:8888/poly5", "root", "");
			stmt = con.createStatement();
			rs = stmt.executeQuery(searchQuery);
			while (rs.next()) {
				//
				seat.setEventName("eventName");
				seat.setSeat(Integer.parseInt("seat"));
				seat.setPrice(Double.parseDouble("price"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return seat;
	}
}