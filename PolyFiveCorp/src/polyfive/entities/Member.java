package polyfive.entities;

public class Member {
public static Member user ;
private String username;

public Member(){
	
}

public static Member getMember(){
	Member user = new Member();
	return user;
}


public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public Member getMember1(){
	return user;
}

public static void main(String [] args){
	
}

}
