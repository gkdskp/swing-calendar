package in.gkdskp.swingcalendar.models;

import in.gkdskp.swingcalendar.models.EventModel;
import in.gkdskp.swingcalendar.utils.RandomColor;

import java.awt.*;
import java.util.*;


public class CustomCalendar {
  private String name;
  private ArrayList<EventModel> events;
  private Color color;

  public CustomCalendar(String name) {
	this.name = name;
	this.events = new ArrayList<EventModel>();
	this.color = RandomColor.generateRandom();
  }

  public String getName() { return name; }

  public Color getColor() { return color; }

  public void addEvent(String title, String date, String loc) {
	EventModel event = new EventModel(title, date, loc);
	event.id = events.size();
	events.add(event);
  }

  public ArrayList<EventModel> getEvents() { return events; }

  public ArrayList<EventModel> getEventsByDate(int dd, int mm, int yyyy) {
	ArrayList<EventModel> eventsInDate = new ArrayList<EventModel>();

	for (EventModel event : events) {
	  if (event.getMonth() == mm && event.getYear() == yyyy &&
		  event.getDate() == dd) {
		eventsInDate.add(event);
	  }
	}

	return eventsInDate;
  }

  public ArrayList<Integer> getDatewithEvents(int mm, int yyyy) {
	ArrayList<Integer> dates = new ArrayList<Integer>();

	for (EventModel event : events) {
	  if (event.getMonth() == mm && event.getYear() == yyyy) {
		dates.add(event.getDate());
	  }
	}
	return dates;
  }

  public void removeEvent(int id) {
	  try {
		  events.remove(id);

		  for(int i = id; i < events.size(); i++)
			  events.get(i).id--;
			  
	  } catch(Exception e) {
		  e.printStackTrace();
	  }
  }
}