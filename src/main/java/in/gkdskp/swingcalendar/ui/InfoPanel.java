package in.gkdskp.swingcalendar.ui;

import in.gkdskp.swingcalendar.events.*;
import in.gkdskp.swingcalendar.models.EventModel;

import java.awt.*;
import java.awt.event.*;
import java.net.URI;
import java.util.*;
import javax.swing.*;


public class InfoPanel extends JPanel {
  private JButton addEventButton;
  private JPanel popupPanel;
  private NewEventListener newEventListener;
  private RemoveEventListener removeEventListener;
  private JLabel currentDateLabel;

  private JTextField titleField;
  private JTextField locationField;

  private GridBagConstraints gbc;

  InfoPanel() {
	setLayout(new GridBagLayout());
	gbc = new GridBagConstraints();
	gbc.weightx = 1;
    gbc.fill = GridBagConstraints.VERTICAL;
	gbc.gridwidth = GridBagConstraints.REMAINDER;

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
	add(titleLabel, gbc);
	add(currentDateLabel, gbc);
  }

  public void setCurrentDate(int dd, int mm, int yyyy) {
	currentDateLabel.setText(dd + "-" + mm + "-" + yyyy);
  }

  public void setEvents(ArrayList<EventModel> events) {
	removeAll();
	setEvents();
	if (events.size() == 0) {
	  JLabel noEventsLabel = new JLabel("No events for the day");
	  noEventsLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
	  add(noEventsLabel, gbc);
	}

	for (EventModel event : events) {
	  JLabel nameLabel = new JLabel(event.getTitle());
	  JLabel swingLink =
		  new JLabel("<html><a href='#'>" + event.getLocation()
						  + "</a></html>");
	  swingLink.addMouseListener(
		  new MouseAdapter() {
			  public void mouseClicked(MouseEvent e) {
				  try{
					Desktop.getDesktop().browse(new URI("http://google.com/maps/search/" + event.getLocation()));
				  } catch(Exception ex) {
					  System.out.println("Your OS does not support this action");
				  }
			  }
		  }
	  );

	  JButton removeButton = new JButton("Remove");
	  removeButton.putClientProperty("id", event.id);
	  removeButton.addActionListener(removeEventListener);

	  JSeparator divider = new JSeparator();
	  divider.setForeground(Color.white);
	  divider.setBackground(Color.white);

	  nameLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
	  divider.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

	  add(nameLabel, gbc);
	  add(swingLink, gbc);
	  add(removeButton, gbc);
	}

	add(Box.createVerticalStrut(20));
	JButton newEventButton = new JButton("New Event");
	newEventButton.addActionListener(new ActionListener() {
	  public void actionPerformed(ActionEvent e) { showNewPopup(); }
	});
	add(newEventButton, gbc);

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

  public void setEventRemoveListener(RemoveEventListener removeEventListener) {
	this.removeEventListener = removeEventListener;
  }
}