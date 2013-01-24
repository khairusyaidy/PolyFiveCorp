package polyfive.entities;

public class EventAttributes {
	
	private String tfEventName;
	private String tfEventDate;
	private String tfEventAddress;
	private String txtDescription;
	private float eventPrice;
	private String eventType;
	private int eventNoOfTickets;
	

	public int getEventNoOfTickets() {
		return eventNoOfTickets;
	}

	public void setEventNoOfTickets(int eventNoOfTickets) {
		this.eventNoOfTickets = eventNoOfTickets;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public float getEventPrice() {
		return eventPrice;
	}

	public void setEventPrice(float eventPrice) {
		this.eventPrice = eventPrice;
	}

	public String getEventName() {
		return tfEventName;
	}

	public void setEventName(String eventName) {
		tfEventName = eventName;
	}

	public String getEventDate() {
		return tfEventDate;
	}

	public void setEventDate(String eventDate) {
		tfEventDate = eventDate;
	}
	
	public String getEventAddress(){
		return tfEventAddress;
	}
	
	public void setEventAddress(String eventAddress){
		tfEventAddress = eventAddress;
	}
	
	public String getDescription(){
		return txtDescription;
	}
	
	public void setDescription(String description){
		txtDescription = description;
	}

	public EventAttributes() {

	}

	public EventAttributes(String eventName, String eventDate, String eventAddress, String description) {
		tfEventName = eventName;
		tfEventDate = eventDate;
		tfEventAddress = eventAddress;
		txtDescription = description;
		}

}
