package gmail.gkdskp.swingcalendar.utils;

import java.util.Calendar;

public class Month {
	Calendar cal;

	public Month() { cal = Calendar.getInstance(); }

	public Month(int mm, int yyyy) {
		this();
		cal.set(yyyy, mm, 1);
	}

	public void setMonth(int mm, int yyyy) { cal.set(yyyy, mm, 1); }

	public int getFirstDayOfMonth() { return cal.get(Calendar.DAY_OF_WEEK) - 1; }

	public int getMaxNumOfDays() {
		return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
}
