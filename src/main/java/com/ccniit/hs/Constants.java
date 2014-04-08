package com.ccniit.hs;

import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;

public class Constants {
	public final static String TIME_FORMAT_STRING = "yyyy-MM-dd HH:mm:ss";
	public final static String DATE_FORMAT_STRING = "yyyy-MM-dd";

	public final static ImageIcon BUTTON_ICON = new ImageIcon("classes/image/button.png");
	public final static ImageIcon BUTTON_PRESSED_ICON = new ImageIcon("classes/image/buttonPressed.png");

	private final static SimpleDateFormat timeFormatter = new SimpleDateFormat(Constants.TIME_FORMAT_STRING);

	private final static SimpleDateFormat dateFormatter = new SimpleDateFormat(Constants.DATE_FORMAT_STRING);

	public static SimpleDateFormat getTimeFormatterInstance() {
		return timeFormatter;
	}
	

	public static SimpleDateFormat getDateFormatterInstance() {
		return dateFormatter;
	}
}
