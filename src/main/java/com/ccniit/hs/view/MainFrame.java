package com.ccniit.hs.view;

import java.io.File;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;

import com.ccniit.hs.Constants;
import com.ccniit.hs.controller.CheckInOperateController;
import com.ccniit.hs.controller.CheckOutOperateController;
import com.ccniit.hs.controller.MainController;
import com.ccniit.hs.controller.QueryOperateController;
import com.ccniit.hs.controller.SettlementOperateController;
import com.ccniit.hs.view.i18n.Language;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	private JButton queryButton, checkInButton, settlementButton, checkOutButton, exitButton;
	private JPanel buttonPanel;
	private JPanel operatePanel;
	private JLabel operateInfo;
	private ActionListener al = new MainFrameActionPerformed();

	public MainFrame(MainController mainController) {
		initComponents();
		initLayout();
		this.setSize(750, 670);
		this.setVisible(true);
		File file = new File("data/room.txt");
		this.setTitle("Java Hotel Settlement Application By Charles Hsia");
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}

	private void initComponents() {

		buttonPanel = new JPanel();
		operateInfo = new JLabel();
		operatePanel = new JPanel();

		buttonPanel.setBorder(BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION, new Font("Microsoft YaHei", 0, 14)));
		buttonPanel.setLayout(new GridLayout(1, 5, 30, 30));

		queryButton = new JButton(Language.getInstance().query());
		queryButton.setFont(new Font("Microsoft YaHei", 0, 18));
		queryButton.setHorizontalTextPosition(SwingConstants.CENTER);
		queryButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		queryButton.addActionListener(al);
		buttonPanel.add(queryButton);

		checkInButton = new JButton(Language.getInstance().checkin());
		checkInButton.setFont(new Font("Microsoft YaHei", 0, 18));
		checkInButton.setHorizontalTextPosition(SwingConstants.CENTER);
		checkInButton.setVerticalTextPosition(SwingConstants.BOTTOM);

		checkInButton.addActionListener(al);
		buttonPanel.add(checkInButton);

		checkOutButton = new JButton(Language.getInstance().checkout());
		checkOutButton.setFont(new Font("Microsoft YaHei", 0, 18));
		checkOutButton.setHorizontalTextPosition(SwingConstants.CENTER);
		checkOutButton.setVerticalTextPosition(SwingConstants.BOTTOM);

		checkOutButton.addActionListener(al);
		buttonPanel.add(checkOutButton);

		settlementButton = new JButton(Language.getInstance().settlement());
		settlementButton.setFont(new Font("Microsoft YaHei", 0, 18));
		settlementButton.setHorizontalTextPosition(SwingConstants.CENTER);
		settlementButton.setVerticalTextPosition(SwingConstants.BOTTOM);

		settlementButton.addActionListener(al);
		buttonPanel.add(settlementButton);

		exitButton = new JButton(Language.getInstance().exit());
		exitButton.setFont(new Font("Microsoft YaHei", 0, 18));
		exitButton.setHorizontalTextPosition(SwingConstants.CENTER);
		exitButton.setVerticalTextPosition(SwingConstants.BOTTOM);

		exitButton.addActionListener(al);
		buttonPanel.add(exitButton);
		operateInfo.setFont(new Font("KaiTi", 0, 36));
		operateInfo.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
		operateInfo.setText(Language.getInstance().queryRoomInfo());

		this.addWindowListener(new MainFrameWindowListener());

		this.setButtonIcon(queryButton);

	}

	private void initLayout() {
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGroup(
										layout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addContainerGap()
																.addGroup(
																		layout.createParallelGroup(GroupLayout.Alignment.LEADING)
																				.addComponent(buttonPanel,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																				.addComponent(operatePanel,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
												.addGroup(
														layout.createSequentialGroup().addGap(200, 200, 200)
																.addComponent(operateInfo).addGap(0, 600, Short.MAX_VALUE)))
								.addContainerGap())
				.addGroup(
						GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addGap(0, 0, Short.MAX_VALUE)
								.addComponent(AutoShowTimePanel.getInstance(), GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addGap(280, 280, 280)));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(buttonPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(operateInfo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(operatePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(AutoShowTimePanel.getInstance(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.DEFAULT_SIZE).addContainerGap()));
	}

	public void setOperatePanel(JPanel panel) {
		this.operatePanel.removeAll();
		this.operatePanel.add(panel);
		this.operatePanel.validate();
	}

	public void showExitDialog() {
		if (JOptionPane.showConfirmDialog(this, Language.getInstance().confirmExit(), Language.getInstance().prompt(),
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			System.exit(0);
		} else {
		}
	}

	private class MainFrameActionPerformed implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			MainFrame.this.setButtonIcon((JButton) e.getSource());
			if (e.getSource() == checkInButton) {
				operateInfo.setText(Language.getInstance().checkinRoomInfo());
				MainController.getInstance().setOperateController(CheckInOperateController.getInstance());
			}
			if (e.getSource() == settlementButton) {
				operateInfo.setText(Language.getInstance().querySettlementInfo());
				MainController.getInstance().setOperateController(SettlementOperateController.getInstance());
			}
			if (e.getSource() == exitButton) {
				MainController.getInstance().exit();
			}
			if (e.getSource() == queryButton) {
				MainController.getInstance().setOperateController(QueryOperateController.getInstance());
			}
			if (e.getSource() == checkOutButton) {
				operateInfo.setText(Language.getInstance().checkoutRoomInfo());
				MainController.getInstance().setOperateController(CheckOutOperateController.getInstance());

			}
		}

	}

	private class MainFrameWindowListener implements WindowListener {

		@Override
		public void windowOpened(WindowEvent e) {
		}

		@Override
		public void windowClosing(WindowEvent e) {
			MainController.getInstance().exit();
		}

		@Override
		public void windowClosed(WindowEvent e) {
		}

		@Override
		public void windowIconified(WindowEvent e) {
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
		}

		@Override
		public void windowActivated(WindowEvent e) {
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
		}
	}

	private void setButtonIcon(JButton button) {
		queryButton.setIcon(Constants.BUTTON_ICON);
		checkInButton.setIcon(Constants.BUTTON_ICON);
		settlementButton.setIcon(Constants.BUTTON_ICON);
		checkOutButton.setIcon(Constants.BUTTON_ICON);
		exitButton.setIcon(Constants.BUTTON_ICON);

		button.setIcon(Constants.BUTTON_PRESSED_ICON);
	}
}
