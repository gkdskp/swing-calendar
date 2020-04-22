package gmail.gkdskp.swingcalendar.events;

import gmail.gkdskp.swingcalendar.SwingCalendar;
import java.awt.event.*;
import javax.swing.JComboBox;


public class YearChangeListener implements ActionListener {
  SwingCalendar swingCalendar;

  public YearChangeListener(SwingCalendar swingCalendar) {
	this.swingCalendar = swingCalendar;
  }

  public void actionPerformed(ActionEvent e) {
	JComboBox source = (JComboBox)e.getSource();
	swingCalendar.setMonth(
		swingCalendar.mm,
		Integer.parseInt(source.getSelectedItem().toString()));
  }
}