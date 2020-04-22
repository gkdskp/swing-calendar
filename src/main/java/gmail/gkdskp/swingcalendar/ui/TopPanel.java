package gmail.gkdskp.swingcalendar.ui;

import gmail.gkdskp.swingcalendar.events.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class TopPanel extends JPanel {
  private NewCalendarListener newCalendarListener;

  private JComboBox calendarSelect, monthSelect, yearSelect;
  private JLabel calendarsLabel, monthLabel, yearLabel;
  private JPanel popupPanel;
  private JTextField nameField;
  private JButton newCalendarButton;

  TopPanel() {
	String[] monthList =
		new String[] {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
					  "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
	ArrayList<String> yearList = new ArrayList<String>();
	for (int i = 2000; i < 2040; i++) {
	  yearList.add(Integer.toString(i));
	}

	setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
	setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));

	calendarsLabel = new JLabel("Calendar: ");
	monthLabel = new JLabel("Month: ");
	yearLabel = new JLabel("Year:  ");

	newCalendarButton = new JButton("New");
	newCalendarButton.addActionListener(new ActionListener() {
	  public void actionPerformed(ActionEvent e) { showNewPopup(); }
	});

	calendarSelect = new JComboBox();
	monthSelect = new JComboBox(monthList);
	yearSelect = new JComboBox(yearList.toArray());

	calendarsLabel.setAlignmentX(JLabel.LEFT_ALIGNMENT);
	monthLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);

	add(Box.createHorizontalStrut(10));
	add(calendarsLabel);
	add(calendarSelect);
	add(newCalendarButton);

	add(Box.createHorizontalGlue());

	add(monthLabel);
	add(monthSelect);
	add(Box.createHorizontalStrut(10));
	add(yearLabel);
	add(yearSelect);
	add(Box.createHorizontalGlue());

	popupPanel = new JPanel();
	popupPanel.setLayout(new BoxLayout(popupPanel, BoxLayout.Y_AXIS));
	popupPanel.add(new JLabel("Name"));
	nameField = new JTextField();
	popupPanel.add(nameField);
  }

  public void setAddCalendarListener(NewCalendarListener newCalendarListener) {
	this.newCalendarListener = newCalendarListener;
  }

  public void showNewPopup() {
	int result = JOptionPane.showConfirmDialog(
		null, popupPanel, "Enter calendar details", JOptionPane.OK_CANCEL_OPTION);

	if (result == JOptionPane.OK_OPTION) {
	  newCalendarListener.add(nameField.getText());
	}
  }

  public void setCalendarList(ArrayList<String> calendarList) {
	this.calendarSelect.removeAllItems();

	for (String calendarName : calendarList) {
	  this.calendarSelect.addItem(calendarName);
	}
  }

  public void setCurrentCalendar(int index) {
	calendarSelect.setSelectedIndex(index);
  }

  public int getCurrentCalendarIndex() {
	return calendarSelect.getSelectedIndex();
  }

  public void setCurrentMonth(int index) {
	monthSelect.setSelectedIndex(index);
  }

  public void setCurrentYear(int index) { yearSelect.setSelectedIndex(index); }

  public void addListener(MonthChangeListener e) { monthSelect.addActionListener(e); }

  public void addListener(YearChangeListener e) { yearSelect.addActionListener(e); }

  public void addListener(CalendarChangeListener e) {
	calendarSelect.addItemListener(e);
  }
}

class WeeksPanel extends JPanel {
  WeeksPanel() {
	String[] weekList =
		new String[] {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

	setLayout(new GridLayout(0, 7, 1, 1));
	setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));
	setBorder(BorderFactory.createEmptyBorder(30, 0, 20, 0));

	for (String week : weekList) {
	  add(new JLabel(week, SwingConstants.CENTER));
	}
  }
}
