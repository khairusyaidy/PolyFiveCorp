package polyfive.entities.dao;

import polyfive.entities.EventDetails;

import java.util.ArrayList;

public class EventDetailsDao {

	public static ArrayList<EventDetails> RetrieveAll() {
		ArrayList<EventDetails> eventDetails = new ArrayList<>();
		EventDetails event1 = new EventDetails();
		EventDetails event2 = new EventDetails();
		EventDetails event3 = new EventDetails();
		EventDetails event4 = new EventDetails();

		event1.setEventName("Rock and Roll");
		event1.setEventDate("15 Jan 2012");
		eventDetails.add(event1);

		event2.setEventName("Disney");
		event2.setEventDate("16 Jan 2012");
		eventDetails.add(event2);

		event3.setEventName("Event 3");
		event3.setEventDate("17 Jan 2012");
		eventDetails.add(event3);

		event4.setEventName("Event 4");
		event4.setEventDate("18 Jan 2012");
		eventDetails.add(event4);

		return eventDetails;
	}
}
