package gmail.gkdskp.swingcalendar.utils;

import java.awt.*;
import java.util.Random;

public class RandomColor {
  public static Color[] colors =
	  new Color[] {new Color(191, 97, 106), new Color(208, 135, 112),
				   new Color(235, 203, 139), new Color(163, 190, 140),
				   new Color(180, 142, 173)};

  public static Color generateRandom() {
	Random rand = new Random();
	return colors[rand.nextInt(colors.length)];
  }
}