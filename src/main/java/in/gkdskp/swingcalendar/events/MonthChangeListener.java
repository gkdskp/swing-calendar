package in.gkdskp.swingcalendar.events;

import in.gkdskp.swingcalendar.SwingCalendar;
import java.awt.event.*;
import javax.swing.*;


public class MonthChangeListener implements ActionListener {
	SwingCalendar swingCalendar;

	public MonthChangeListener(SwingCalendar swingCalendar) {
		this.swingCalendar = swingCalendar;
	}

	public void actionPerformed(ActionEvent e) {
		JComboBox source = (JComboBox)e.getSource();

		swingCalendar.setMonth(source.getSelectedIndex(), swingCalendar.yyyy);
		swingCalendar.frame.getCal().setSelectedDate(swingCalendar.dd);
	}
}