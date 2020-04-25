package in.gkdskp.swingcalendar.ui;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import javax.swing.border.Border;

import in.gkdskp.swingcalendar.events.DayClickedAdapter;


public class Cal extends JPanel {
	private ArrayList<JPanel> days;
	private int today;

	public Cal() {
		days = new ArrayList<JPanel>();
		setBorder(BorderFactory.createEmptyBorder(2, 0, 20, 0));
		setLayout(new GridLayout(0, 7, 1, 1));
		setPreferredSize(new Dimension(Integer.MAX_VALUE, 750));
	}

	public void setToday(int dd) {
		this.today = dd;
	}

	public void addDays(int startDay, int noOfDays, boolean isCurrentMonth) {
		System.out.println(today);
		removeAll();
		days.clear();
		for(int i = 0; i < startDay; i++) {
			JPanel filler = new JPanel();
			filler.setBackground(Color.lightGray);
			add(filler);
		}

		for(int i = 1; i <= noOfDays; i++) {
			JPanel day = new JPanel();

			day.setLayout(new GridBagLayout());
			GridBagConstraints gbc = new GridBagConstraints();
			// day.setBackground(Color.lightGray);
			
			JLabel dayLabel = new JLabel(Integer.toString(i));
			dayLabel.setFont(new Font("sans-serif", Font.PLAIN, 20));

			if(i == today && isCurrentMonth)
				dayLabel.setForeground(Color.red);
			else
				dayLabel.setForeground(Color.black);
			
			day.add(dayLabel, gbc);
			day.setToolTipText(Integer.toString(i));

			days.add(day);
			add(day);
		}

		int j;
		if(noOfDays + startDay > 35) {
			j = 42;
		} else {
			j = 35;
		}

		for(int i = 0; i < j-noOfDays-startDay; i++)
		{
			JPanel filler = new JPanel();
			filler.setBackground(Color.lightGray);
			add(filler);	
		}

		revalidate();
		repaint();
	}

	public void addEvents(ArrayList<Integer> dayList, Color color) {
		for(JPanel day: days)
			day.setBackground(Color.white);
			// day.setBackground(new Color(229,233,240));
		
		for(int day: dayList){
			days.get(day-1).setBackground(color);
		}
		revalidate();
	}

	public void addListener(DayClickedAdapter e) {
		for(JPanel day: days) {
			day.addMouseListener(e);
		}
	}

	public void setSelectedDate(int dd) {
		for(JPanel day: days) {
			day.setBorder(BorderFactory.createLineBorder(Color.white, 4));
		}
		days.get(dd).setBorder(BorderFactory.createLineBorder(Color.black, 4));
	}
}