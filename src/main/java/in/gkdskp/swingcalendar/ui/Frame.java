package in.gkdskp.swingcalendar.ui;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;


public class Frame extends JFrame {
	private TopPanel topPanel;
	private Cal cal;
	private InfoPanel infoPanel;
	private WeeksPanel weeksPanel;

	public Frame(String name, int dd) {
		try {
			// Workaround for KDE
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
		} catch(Exception e) {
			try{
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch(Exception e2) {
				System.out.println(e2);
			}
		}


		topPanel = new TopPanel();
		weeksPanel = new WeeksPanel();
		cal = new Cal();
		cal.setToday(dd);
		infoPanel = new InfoPanel();

		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		add(topPanel);
		add(weeksPanel);
		add(cal);
		add(infoPanel);
	}

	public TopPanel getTopPanel() {
		return topPanel;
	}

	public Cal getCal() {
		return cal;
	}

	public InfoPanel getInfoPanel() {
		return infoPanel;
	}
}

