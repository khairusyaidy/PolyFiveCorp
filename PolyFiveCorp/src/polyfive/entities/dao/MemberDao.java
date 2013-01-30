package polyfive.entities.dao;

import polyfive.entities.EventAttributes;
import polyfive.entities.Member;
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

public class MemberDao extends MasterPanel {
	private static MainFrame f = null;

	static Connection currentCon = null;
	static ResultSet rs = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs1 = null;
	static PreparedStatement pstmt1 = null;

	public static ArrayList<Member> RetrieveAll() {
		Member users = null;
		Statement stmt = null;
		ArrayList<Member> allUsers = new ArrayList<>();
		String searchQuery = "select * from users";

		try {
			// connect to DB
			currentCon = DBConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery);
			while (rs.next()) {

				// String memberId = rs.getString("member_id");
				String userName = rs.getString("Username");
				String userPass = rs.getString("Password");
				int userTelNo = rs.getInt("telNo");
				String userFirstName = rs.getString("firstName");
				String userLastName = rs.getString("lastName");
				String userCreationDate = rs.getString("creationDate");
				int userRank = rs.getInt("rank");
				String userEmail = rs.getString("email");
				String userPass_IcNo = rs.getString("pass_IcNo");

				users = new Member();

				String rankName = users.setRankName(userRank);
				users.setUsername(userName);
				users.setPassword(userPass);
				users.setPhoneNumber(userTelNo);
				users.setFirstName(userFirstName);
				users.setLastName(userLastName);
				users.setCreationDate(userCreationDate);
				users.setRankName(rankName);
				users.setEmail(userEmail);
				users.setPass_icNo(userPass_IcNo);
				// member.setPassword(password);
				allUsers.add(users);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allUsers;

	}

	public static int getMax() {

		Statement stmt = null;
		try {
			stmt = currentCon.createStatement();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		String getMax = "select count(idUser) from Users";
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
		int nextId = maxId;

		return nextId;
	}

	public static String fullDate(String date) {
		String day = date.substring(8, 10);
		String month = date.substring(4, 7);
		String year = date.substring(24, 28);

		String fullDate = day + " " + month + " " + year;

		SimpleDateFormat dateFormat = new SimpleDateFormat("d MMM yyyy");

		return fullDate;
	}

	public static Member insertMemberDetails(Member addMember) {
		Statement stmt = null;
		String username = addMember.getUsername();
		String password = addMember.getPassword();
		int telNo = addMember.getPhoneNumber();
		String firstName = addMember.getFirstName();
		String lastName = addMember.getLastName();
		String fullDate = addMember.getCreationDate();
		int rank = addMember.getRank();
		String email = addMember.getEmail();
		String pass_icNo = addMember.getPass_icNo();
		String activated = addMember.getActivated();
		String activationNo = addMember.getActivationCode();

		// get the last member ID
		try {

			currentCon = DBConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			String getMax = "select Max(idUser) from Users";
			rs1 = stmt.executeQuery(getMax);
			rs1.next();
			int maxId = rs1.getInt(1);
			int nextId = maxId + 1;

			// query for inserting into the table

			String query = "insert into Users(idUser, Username, Password, telNo, firstName, lastName, creationDate, rank, email, pass_icNo,activated, activationNo) values('"
					+ nextId
					+ "','"
					+ username
					+ "','"
					+ password
					+ "','"
					+ telNo
					+ "','"
					+ firstName
					+ "','"
					+ lastName
					+ "','"
					+ fullDate
					+ "','"
					+ rank
					+ "','"
					+ email
					+ "','"
					+ pass_icNo 
					+ "','"
					+activated
					+ "','"
					+activationNo
					+ "')";
			pstmt = currentCon.prepareStatement(query);

			pstmt.executeUpdate();

		} catch (Exception ex) {

			System.out
					.println("Addition of Event failed: An Exception has occurred! "
							+ ex);
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
		return addMember;

	}

}
