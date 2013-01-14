package polyfive.entities;

public class Member {
private String username;
private String creationDate;
private int rank;
private int telNo;
private String email;
private String pass_icNo;
private String firstName;
private String lastName;

public Member(){
	
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
