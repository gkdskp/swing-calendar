package gmail.gkdskp.swingcalendar.ui;

import gmail.gkdskp.swingcalendar.events.NewEventListener;
import gmail.gkdskp.swingcalendar.models.EventModel;
import grep.SwingLink;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class InfoPanel extends JPanel {
  private JButton addEventButton;
  private JPanel popupPanel;
  private NewEventListener newEventListener;
  private JLabel currentDateLabel;

  private JTextField titleField;
  private JTextField locationField;

  InfoPanel() {
	setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

	addEventButton = new JButton("Add");
	popupPanel = new JPanel();
	popupPanel.setLayout(new BoxLayout(popupPanel, BoxLayout.Y_AXIS));
	popupPanel.add(new JLabel("Title"));
	titleField = new JTextField();
	popupPanel.add(titleField);
	popupPanel.add(new JLabel("Location"));
	locationField = new JTextField();
	popupPanel.add(locationField);

	currentDateLabel = new JLabel();
  }

  public void setPopupListener(NewEventListener newEventListener) {
	this.newEventListener = newEventListener;
  }

  public void setEvents() {
	JLabel titleLabel = new JLabel("<html><h1>Events</h1></html>");
	add(titleLabel);
	add(currentDateLabel);
  }

  public void setCurrentDate(int dd, int mm, int yyyy) {
	currentDateLabel.setText(dd + "-" + mm + "-" + yyyy);
  }

  public void setEvents(ArrayList<EventModel> events) {
	removeAll();
	setEvents();
	if (events.size() == 0) {
	  add(new JLabel("No events for the day"));
	}

	for (EventModel event : events) {
	  JLabel nameLabel = new JLabel(event.getTitle());
	  SwingLink swingLink =
		  new SwingLink("See location", "http://www.google.com/maps/search/" +
											event.getLocation());
	  nameLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
	  swingLink.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));

	  add(nameLabel);
	  add(swingLink);
	}

	add(Box.createVerticalStrut(20));
	JButton newEventButton = new JButton("New Event");
	newEventButton.addActionListener(new ActionListener() {
	  public void actionPerformed(ActionEvent e) { showNewPopup(); }
	});
	add(newEventButton);

	revalidate();
	repaint();
  }

  public void showNewPopup() {
	int result = JOptionPane.showConfirmDialog(
		null, popupPanel, "Enter event details", JOptionPane.OK_CANCEL_OPTION);

	if (result == JOptionPane.OK_OPTION) {
	  newEventListener.add(titleField.getText(), locationField.getText());
	}
  }
}