package in.gkdskp.swingcalendar.utils;

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

	public boolean isCurrentMonth() {
		return (cal.get(Calendar.MONTH) == Month.getCurrentDate()[1]
				&& cal.get(Calendar.YEAR) == Month.getCurrentDate()[2]);
	}

	public static int[] getCurrentDate() {
		Calendar now = Calendar.getInstance();
		int[] today = new int[]{
			now.get(Calendar.DAY_OF_MONTH),
			now.get(Calendar.MONTH),
			now.get(Calendar.YEAR)
		};
	
		return today;
	}
}
