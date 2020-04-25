package in.gkdskp.swingcalendar.events;

import java.awt.event.*;

import javax.swing.JButton;

import in.gkdskp.swingcalendar.SwingCalendar;
import in.gkdskp.swingcalendar.models.EventModel;

public class RemoveEventListener implements ActionListener {
	private EventModel event;
	SwingCalendar swingCalendar;

	public RemoveEventListener(SwingCalendar swingCalendar) {
		this.swingCalendar = swingCalendar;
	}
	
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		int id = (Integer)button.getClientProperty("id");
		swingCalendar.getCalendar().removeEvent(id);
		swingCalendar.getEvents();
		swingCalendar.setEventsByDate();
	}
}