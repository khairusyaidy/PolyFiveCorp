package polyfive.entities;

public class Member {
private String username;
private String password;
private String creationDate;
private int rank;
private int telNo;
private String email;
private String pass_icNo;
private String firstName;
private String lastName;
private String rankName;

public Member(){
	
}



public String getPassword() {
	return password;
}



public void setPassword(String password) {
	this.password = password;
}



public String setRankName(int rank) {
	switch (rank){
	case 0: this.rankName = "Guest";
	break;
	case 1: this.rankName = "Basic Member";
	break;
	case 2: this.rankName = "Bronze Member";
	break;
	case 3: this.rankName = "Silver Member";
	break;
	case 4: this.rankName = "Gold Member";
	break;
	case 5: this.rankName = "Admin";
	break;
	}
	return rankName;
}



public void setRankName(String rankName) {
	this.rankName = rankName;
}



public String getFirstName() {
	return firstName;
}



public void setFirstName(String firstName) {
	this.firstName = firstName;
}



public String getLastName() {
	return lastName;
}



public void setLastName(String lastName) {
	this.lastName = lastName;
}



public String getCreationDate() {
	return creationDate;
}



public void setCreationDate(String creationDate) {
	this.creationDate = creationDate;
}



public int getRank() {
	return rank;
}



public void setRank(int rank) {
	this.rank = rank;
}



public int getPhoneNumber() {
	return telNo;
}



public void setPhoneNumber(int phoneNumber) {
	this.telNo = phoneNumber;
}



public String getEmail() {
	return email;
}



public void setEmail(String email) {
	this.email = email;
}



public String getPass_icNo() {
	return pass_icNo;
}



public void setPass_icNo(String pass_icNo) {
	this.pass_icNo = pass_icNo;
}



public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

}
