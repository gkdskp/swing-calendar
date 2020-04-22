package gmail.gkdskp.swingcalendar;

import gmail.gkdskp.swingcalendar.events.*;
import gmail.gkdskp.swingcalendar.models.*;
import gmail.gkdskp.swingcalendar.ui.*;
import gmail.gkdskp.swingcalendar.utils.*;
import java.util.*;

/*
Development of a Google Calendar Map And Api
Develop a calendar application similar to that of google calendar with the same basic features.
	Functional requirement:
		• Create new calendars for different parts of your life.
		• Hide your event details.
		• Add a Google Hangout to your event.
		• Add attachments.
		• Add specific meeting locations. Etc
	Implementation requirements:
		• Java applets / Java Swing
*/


public class SwingCalendar {
  private Month month;
  private ArrayList<CustomCalendar> calendars;
  private CustomCalendar calendar;
  public Frame frame;
  public int mm, yyyy, dd;

  SwingCalendar(int mm, int yyyy) {
	this.mm = mm;
	this.yyyy = yyyy;
	frame = new Frame("Calendar");
	calendars = new ArrayList<CustomCalendar>();
	addCalendar("Default");

	month = new Month();
	setMonth(mm, yyyy);
  }

  public void setMonth(int mm, int yyyy) {
	month.setMonth(mm, yyyy);
	this.mm = mm;
	this.yyyy = yyyy;
	frame.getCal().addDays(month.getFirstDayOfMonth(), month.getMaxNumOfDays());
	frame.getTopPanel().setCurrentMonth(mm);
	frame.getTopPanel().setCurrentYear(yyyy % 100);
	getEvents();
	EventCollection.bindCalEvent(this);
  }

  public void addCalendar(String name) {
	calendars.add(new CustomCalendar(name));
	frame.getTopPanel().setCalendarList(getCalendarList());
	setCalendar(calendars.size() - 1);
  }

  public void setCalendar(int index) {
	frame.getTopPanel().setCurrentCalendar(index);
	calendar = calendars.get(index);
	getEvents();
  }

  public void getEvents() {
	ArrayList<Integer> a = calendar.getDatewithEvents(mm, yyyy);
	frame.getCal().addEvents(a, calendar.getColor());
  }

  public void setEventsByDate() {
	frame.getInfoPanel().setEvents(calendar.getEventsByDate(dd, mm, yyyy));
  }

  public void setEventsByDate(int dd, int mm, int yyyy) {
	frame.getInfoPanel().setCurrentDate(dd + 1, mm + 1, yyyy);
	frame.getInfoPanel().setEvents(calendar.getEventsByDate(dd, mm, yyyy));
	frame.getCal().setSelectedDate(dd);
	this.dd = dd;
  }

  public ArrayList<CustomCalendar> getCalendars() { return calendars; }

  public CustomCalendar getCalendar() { return calendar; }

  public ArrayList<String> getCalendarList() {
	ArrayList<String> calendarList = new ArrayList<String>();

	for (CustomCalendar calendar : calendars) {
	  calendarList.add(calendar.getName());
	}

	return calendarList;
  }

  public static void main(String[] args) {
	Calendar now = Calendar.getInstance();
	SwingCalendar swingCalendar =
		new SwingCalendar(now.get(Calendar.MONTH), now.get(Calendar.YEAR));
	EventCollection.bindEvents(swingCalendar);
	swingCalendar.setEventsByDate(now.get(Calendar.DAY_OF_MONTH),
								  swingCalendar.mm, swingCalendar.yyyy);
  }
}