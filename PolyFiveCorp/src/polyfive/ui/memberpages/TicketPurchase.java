package polyfive.ui.memberpages;

public class TicketPurchase {
	private String eventID;
	private  float ticketPrice;
	private int maxNumTickets;
	private int ticketsLeft; 
	
	public TicketPurchase(){
		
	}

	public String getEventID() {
		return eventID;
	}

	public void setEventID(String eventID) {
		this.eventID = eventID;
	}



	public float getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(float ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public int getMaxNumTickets() {
		return maxNumTickets;
	}

	public void setMaxNumTickets(int maxNumTickets) {
		this.maxNumTickets = maxNumTickets;
	}

	public int getTicketsLeft() {
		return ticketsLeft;
	}

	public void setTicketsLeft(int ticketsLeft) {
		this.ticketsLeft = ticketsLeft;
	}
	
}


