package in.gkdskp.swingcalendar.events;

import in.gkdskp.swingcalendar.SwingCalendar;

import java.awt.event.*;
import javax.swing.JComboBox;


public class CalendarChangeListener implements ItemListener {
	SwingCalendar swingCalendar;

	public CalendarChangeListener(SwingCalendar swingCalendar) {
		this.swingCalendar = swingCalendar;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			JComboBox source = (JComboBox)e.getSource();
			swingCalendar.setCalendar(source.getSelectedIndex());
		}
	}
}