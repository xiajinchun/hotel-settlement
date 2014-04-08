package com.ccniit.hs.view;

import java.awt.*;
import java.util.Calendar;

import javax.swing.*;

import com.ccniit.hs.Constants;

@SuppressWarnings("serial")
public class AutoShowTimePanel extends JPanel {
	private final static AutoShowTimePanel instance = new AutoShowTimePanel();
	private JLabel displayArea;

	public AutoShowTimePanel() {

		displayArea = new JLabel();
		displayArea.setFont(new Font("KaiTi", 0, 17));

		this.add(displayArea);
		this.setSize(new Dimension(300, 70));

		Thread thread = new Thread(new AutoShowTimeRunnable());
		thread.start();
	}

	public static AutoShowTimePanel getInstance() {
		return instance;
	}

	private class AutoShowTimeRunnable implements Runnable {
		public void run() {
			while (true) {
				displayArea.setText(Constants.getTimeFormatterInstance().format(Calendar.getInstance().getTime()));
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					displayArea.setText("Error!!!");
				}
			}
		}
	}

}