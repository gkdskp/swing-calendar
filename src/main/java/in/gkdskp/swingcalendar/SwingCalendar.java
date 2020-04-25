package in.gkdskp.swingcalendar;

import in.gkdskp.swingcalendar.events.*;
import in.gkdskp.swingcalendar.models.*;
import in.gkdskp.swingcalendar.ui.*;
import in.gkdskp.swingcalendar.utils.*;

import java.util.*;


public class SwingCalendar {
  private Month month;
  private ArrayList<CustomCalendar> calendars;
  private CustomCalendar calendar;
  public Frame frame;
  public int mm, yyyy, dd;

  SwingCalendar(int dd, int mm, int yyyy) {
	this.mm = mm;
	this.yyyy = yyyy;
	this.dd = dd;

	frame = new Frame("Calendar", dd);
	calendars = new ArrayList<CustomCalendar>();
	addCalendar("Default");

	month = new Month();
	setMonth(mm, yyyy);
  }

  public void setMonth(int mm, int yyyy) {
	month.setMonth(mm, yyyy);
	this.mm = mm;
	this.yyyy = yyyy;
	frame.getCal().addDays(month.getFirstDayOfMonth(), 
							month.getMaxNumOfDays(), month.isCurrentMonth());
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
	frame.getInfoPanel().setCurrentDate(dd, mm + 1, yyyy);
	frame.getInfoPanel().setEvents(calendar.getEventsByDate(dd, mm, yyyy));
	frame.getCal().setSelectedDate(dd - 1);
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
	int[] currentDate = Month.getCurrentDate();
	SwingCalendar swingCalendar =
		new SwingCalendar(currentDate[0], currentDate[1],
						currentDate[2]);
	EventCollection.bindEvents(swingCalendar);
	swingCalendar.setEventsByDate(swingCalendar.dd,
								  swingCalendar.mm, swingCalendar.yyyy);
  }
}