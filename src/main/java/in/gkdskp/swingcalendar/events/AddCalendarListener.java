package in.gkdskp.swingcalendar.events;

import in.gkdskp.swingcalendar.SwingCalendar;


public class AddCalendarListener implements NewCalendarListener {
	SwingCalendar swingCalendar;

	public AddCalendarListener(SwingCalendar swingCalendar) {
		this.swingCalendar = swingCalendar;
	}

	@Override
	public void add(String name) {
		swingCalendar.addCalendar(name);
	}
}