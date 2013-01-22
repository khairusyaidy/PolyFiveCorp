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
import java.util.ArrayList;

public class MemberDao extends MasterPanel {
	private static MainFrame f= null;
	
	static Connection currentCon = null;
	static ResultSet rs = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs1 = null;
	static PreparedStatement pstmt1 = null;
	
	public static ArrayList<Member> RetrieveAll(){
		Member users = null;
		Statement stmt = null;
		ArrayList <Member> allUsers = new ArrayList<>();
		String searchQuery = "select * from users";
		
		
		
        try {
            // connect to DB
            currentCon = DBConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            while (rs.next()) {
            
           //     String memberId = rs.getString("member_id");
                String userName = rs.getString("Username");
                String userPass= rs.getString("Password");
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
             //   member.setPassword(password);
                allUsers.add(users);
            }
        } catch (Exception e) {
         e.printStackTrace();
        }
        return allUsers;
		
	}
	
	public static int getMax(){


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
		int nextId = maxId ;

	return nextId;
}

}
