package gmail.gkdskp.swingcalendar.models;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class EventModel {
	private String title, location;
	SimpleDateFormat  ft;
	private Date date;
	Calendar cal;

	public EventModel(String title, String date, String loc) {
		cal = Calendar.getInstance();
		try{
			ft = new SimpleDateFormat("yyyy-MM-dd");
			this.date = ft.parse(date);
		} catch(Exception e) {
			System.out.println(e);
		}
		
		this.title = title;
		this.location = loc;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public int getMonth() {
		cal.setTime(date);
		return cal.get(Calendar.MONTH);
	}

	public int getDate() {
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_MONTH);
	}

	public int getYear() {
		cal.setTime(date);
		return cal.get(Calendar.YEAR);
	}

	public void setLocation(String loc) {
		this.location = loc;
	}

	public String getLocation() {
		return location;
	}
}