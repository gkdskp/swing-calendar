package gmail.gkdskp.swingcalendar.utils;

import gmail.gkdskp.swingcalendar.SwingCalendar;
import gmail.gkdskp.swingcalendar.events.*;
import java.util.Map;
import javax.swing.JPanel;


public class EventCollection {
  static CalendarChangeListener calendarChangeListener;
  static DayClickedAdapter dayClickedAdapter;
  static MonthChangeListener monthChangeListener;
  static YearChangeListener yearChangeListener;
  static PopupListener popupListener;
  static AddCalendarListener addCalendarListener;

  public static void bindEvents(SwingCalendar swingCalendar) {
	calendarChangeListener = new CalendarChangeListener(swingCalendar);
	dayClickedAdapter = new DayClickedAdapter(swingCalendar);
	monthChangeListener = new MonthChangeListener(swingCalendar);
	yearChangeListener = new YearChangeListener(swingCalendar);
	popupListener = new PopupListener(swingCalendar);
	addCalendarListener = new AddCalendarListener(swingCalendar);

	swingCalendar.frame.getTopPanel().addListener(monthChangeListener);
	swingCalendar.frame.getTopPanel().addListener(yearChangeListener);
	swingCalendar.frame.getTopPanel().addListener(calendarChangeListener);

	bindCalEvent(swingCalendar);

	swingCalendar.frame.getInfoPanel().setPopupListener(popupListener);
	swingCalendar.frame.getTopPanel().setAddCalendarListener(
		addCalendarListener);
  }

  public static void bindCalEvent(SwingCalendar swingCalendar) {
	swingCalendar.frame.getCal().addListener(dayClickedAdapter);
  }
}