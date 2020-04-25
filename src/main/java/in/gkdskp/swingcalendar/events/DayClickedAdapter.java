package in.gkdskp.swingcalendar.events;

import in.gkdskp.swingcalendar.SwingCalendar;
import java.awt.event.*;
import javax.swing.*;


public class DayClickedAdapter extends MouseAdapter {
	SwingCalendar swingCalendar;

	public DayClickedAdapter(SwingCalendar swingCalendar) {
		this.swingCalendar = swingCalendar;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		JPanel day = (JPanel)e.getSource();
		swingCalendar.setEventsByDate(Integer.parseInt(day.getToolTipText()),
									swingCalendar.mm, swingCalendar.yyyy);
	}
}