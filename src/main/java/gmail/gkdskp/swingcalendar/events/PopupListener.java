package gmail.gkdskp.swingcalendar.events;

import gmail.gkdskp.swingcalendar.SwingCalendar;


public class PopupListener implements NewEventListener {
  SwingCalendar swingCalendar;

  public PopupListener(SwingCalendar swingCalendar) {
	this.swingCalendar = swingCalendar;
  }

  @Override
  public void add(String title, String location) {
	String date = swingCalendar.yyyy + "-" + (swingCalendar.mm + 1) + "-" +
				  (swingCalendar.dd);
	swingCalendar.getCalendar().addEvent(title, date, location);
	swingCalendar.getEvents();
	swingCalendar.setEventsByDate();
  }
}