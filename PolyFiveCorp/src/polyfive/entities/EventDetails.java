package polyfive.entities;

public class EventDetails {
	String EventName;
	String EventDate;
	
	public String getEventName() {
		return EventName;
	}
	public void setEventName(String eventName) {
		EventName = eventName;
	}
	public String getEventDate() {
		return EventDate;
	}
	public void setEventDate(String eventDate) {
		EventDate = eventDate;
	}
	
	public EventDetails(){
		
	}
	
	public EventDetails(String eventName, String eventDate){
		EventName = eventName;
		EventDate = eventDate;
	}

	
}
