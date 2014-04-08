package com.ccniit.hs.view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;

import com.ccniit.hs.Constants;
import com.ccniit.hs.controller.CheckOutOperateController;
import com.ccniit.hs.model.RoomInfo;
import com.ccniit.hs.view.i18n.Language;

@SuppressWarnings("serial")
public class CheckOutPanel extends JPanel {
	private CheckOutOperateController checkOutOperateController;
	private JButton sureButton;
	private JButton checkOutButton;
	private JButton cancelButton;
	private JComboBox<String> numComBox;
	private JLabel time_inLabel;
	private JLabel priceLabel;
	private JLabel jLabel12;
	private JLabel jLabel13;
	private JLabel jLabel14;
	private JLabel typeLabel;
	private JLabel time_outLabel;
	private JLabel pledgeLabel;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel6;
	private JLabel jLabel7;
	private JLabel numLabel;
	private JLabel nameLabel;
	private JPanel jPanel1;
	private JPanel infoPanel;
	private CustomJDatePickerImpl dateSelect;

	public CheckOutPanel(CheckOutOperateController checkOutOperateController) {
		this.checkOutOperateController = checkOutOperateController;
		initComponents();
		initLayout();
	}

	private void initComponents() {

		jPanel1 = new JPanel();
		sureButton = new JButton();
		jLabel2 = new JLabel();
		dateSelect = new CustomJDatePickerImpl(checkOutOperateController);
		jLabel3 = new JLabel();
		numComBox = new JComboBox<String>();
		infoPanel = new JPanel();
		jLabel4 = new JLabel();
		jLabel5 = new JLabel();
		jLabel6 = new JLabel();
		jLabel7 = new JLabel();
		numLabel = new JLabel();
		nameLabel = new JLabel();
		time_inLabel = new JLabel();
		priceLabel = new JLabel();
		jLabel12 = new JLabel();
		jLabel13 = new JLabel();
		jLabel14 = new JLabel();
		typeLabel = new JLabel();
		time_outLabel = new JLabel();
		pledgeLabel = new JLabel();
		checkOutButton = new JButton();
		cancelButton = new JButton();
		CheckOutPanelActionListener coal = new CheckOutPanelActionListener();

		setBorder(BorderFactory.createTitledBorder(""));
		setPreferredSize(new Dimension(720, 400));
		infoPanel.setVisible(false);

		jPanel1.setBorder(BorderFactory.createTitledBorder(""));
		jPanel1.setRequestFocusEnabled(false);

		sureButton.setFont(new Font("Microsoft YaHei", 0, 18));
		sureButton.setText(Language.getInstance().submit());
		sureButton.addActionListener(coal);

		jLabel2.setFont(new Font("KaiTi", 0, 18));
		jLabel2.setText(Language.getInstance().dateChoose());

		dateSelect.setFont(new Font("Microsoft YaHei", 0, 14));

		jLabel3.setFont(new Font("KaiTi", 0, 18));
		jLabel3.setText(Language.getInstance().roomNumber());

		infoPanel.setBorder(BorderFactory.createTitledBorder(""));

		jLabel4.setFont(new Font("KaiTi", 0, 18));
		jLabel4.setText(Language.getInstance().roomNumber());

		jLabel5.setFont(new Font("KaiTi", 0, 18));
		jLabel5.setText(Language.getInstance().customerName());

		jLabel6.setFont(new Font("KaiTi", 0, 18));
		jLabel6.setText(Language.getInstance().checkInDate());

		jLabel7.setFont(new Font("KaiTi", 0, 18));
		jLabel7.setText(Language.getInstance().pledge());

		numLabel.setFont(new Font("Microsoft YaHei", 0, 14));

		nameLabel.setFont(new Font("Microsoft YaHei", 0, 14));

		time_inLabel.setFont(new Font("Microsoft YaHei", 0, 14)); // NOI18

		priceLabel.setFont(new Font("Microsoft YaHei", 0, 14));

		jLabel12.setFont(new Font("KaiTi", 0, 18));
		jLabel12.setText(Language.getInstance().roomType());

		jLabel13.setFont(new Font("KaiTi", 0, 18));
		jLabel13.setText(Language.getInstance().checkoutTime());

		jLabel14.setFont(new Font("KaiTi", 0, 18));
		jLabel14.setText(Language.getInstance().returnPledge());

		typeLabel.setFont(new Font("Microsoft YaHei", 0, 14));

		time_outLabel.setFont(new Font("Microsoft YaHei", 0, 14));

		pledgeLabel.setFont(new Font("Microsoft YaHei", 0, 14));

		checkOutButton.setFont(new Font("Microsoft YaHei", 0, 18));
		checkOutButton.setText(Language.getInstance().checkout());
		checkOutButton.addActionListener(coal);

		cancelButton.setFont(new Font("Microsoft YaHei", 0, 18));
		cancelButton.setText(Language.getInstance().cancel());
		cancelButton.addActionListener(coal);

	}

	private void initLayout() {
		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(
						jPanel1Layout.createSequentialGroup().addGap(35, 35, 35).addComponent(jLabel2)
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(dateSelect, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
								.addGap(28, 28, 28).addComponent(jLabel3)
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(numComBox, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
								.addComponent(sureButton, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
								.addGap(21, 21, 21)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
				jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(dateSelect)
						.addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(numComBox).addComponent(sureButton, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)));

		GroupLayout infoPanelLayout = new GroupLayout(infoPanel);
		infoPanel.setLayout(infoPanelLayout);
		infoPanelLayout
				.setHorizontalGroup(infoPanelLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								infoPanelLayout
										.createSequentialGroup()
										.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(
												infoPanelLayout
														.createParallelGroup(GroupLayout.Alignment.LEADING)
														.addGroup(
																infoPanelLayout
																		.createParallelGroup(GroupLayout.Alignment.TRAILING,
																				false)
																		.addComponent(jLabel6, GroupLayout.Alignment.LEADING,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																		.addComponent(jLabel5, GroupLayout.Alignment.LEADING,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																		.addComponent(jLabel4, GroupLayout.Alignment.LEADING))
														.addComponent(jLabel7, GroupLayout.Alignment.TRAILING,
																GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												infoPanelLayout
														.createParallelGroup(GroupLayout.Alignment.LEADING, false)
														.addGroup(
																infoPanelLayout
																		.createSequentialGroup()
																		.addGroup(
																				infoPanelLayout
																						.createParallelGroup(
																								GroupLayout.Alignment.TRAILING,
																								false)
																						.addComponent(time_inLabel,
																								GroupLayout.Alignment.LEADING,
																								GroupLayout.DEFAULT_SIZE, 162,
																								Short.MAX_VALUE)
																						.addComponent(numLabel,
																								GroupLayout.Alignment.LEADING,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(priceLabel,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE))
																		.addGap(23, 23, 23)
																		.addGroup(
																				infoPanelLayout
																						.createParallelGroup(
																								GroupLayout.Alignment.TRAILING,
																								false)
																						.addComponent(jLabel13,
																								GroupLayout.Alignment.LEADING,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(jLabel12,
																								GroupLayout.Alignment.LEADING,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(jLabel14,
																								GroupLayout.PREFERRED_SIZE, 90,
																								GroupLayout.PREFERRED_SIZE)))
														.addComponent(nameLabel, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												infoPanelLayout
														.createParallelGroup(GroupLayout.Alignment.LEADING)
														.addComponent(pledgeLabel, GroupLayout.PREFERRED_SIZE, 156,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(typeLabel, GroupLayout.Alignment.TRAILING,
																GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
														.addComponent(time_outLabel, GroupLayout.Alignment.TRAILING,
																GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
										.addGap(37, 37, 37))
						.addGroup(
								infoPanelLayout
										.createSequentialGroup()
										.addGap(124, 124, 124)
										.addGroup(
												infoPanelLayout
														.createParallelGroup(GroupLayout.Alignment.LEADING)
														.addGroup(
																GroupLayout.Alignment.TRAILING,
																infoPanelLayout
																		.createSequentialGroup()
																		.addComponent(checkOutButton, GroupLayout.PREFERRED_SIZE,
																				108, GroupLayout.PREFERRED_SIZE)
																		.addGap(300, 300, 300))
														.addComponent(cancelButton, GroupLayout.Alignment.TRAILING,
																GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
										.addContainerGap()));

		infoPanelLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] { typeLabel, time_outLabel, pledgeLabel });

		infoPanelLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] { checkOutButton, cancelButton });

		infoPanelLayout.setVerticalGroup(infoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(
						infoPanelLayout
								.createSequentialGroup()
								.addGap(33, 33, 33)
								.addGroup(
										infoPanelLayout
												.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addGroup(
														infoPanelLayout
																.createSequentialGroup()
																.addGroup(
																		infoPanelLayout
																				.createParallelGroup(
																						GroupLayout.Alignment.BASELINE)
																				.addComponent(jLabel4,
																						GroupLayout.PREFERRED_SIZE, 40,
																						GroupLayout.PREFERRED_SIZE)
																				.addComponent(numLabel,
																						GroupLayout.PREFERRED_SIZE, 40,
																						GroupLayout.PREFERRED_SIZE))
																.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(
																		infoPanelLayout
																				.createParallelGroup(
																						GroupLayout.Alignment.BASELINE)
																				.addComponent(jLabel5,
																						GroupLayout.PREFERRED_SIZE, 39,
																						GroupLayout.PREFERRED_SIZE)
																				.addComponent(nameLabel,
																						GroupLayout.PREFERRED_SIZE, 39,
																						GroupLayout.PREFERRED_SIZE)))
												.addGroup(
														infoPanelLayout
																.createParallelGroup(GroupLayout.Alignment.BASELINE)
																.addComponent(jLabel12, GroupLayout.PREFERRED_SIZE, 40,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(typeLabel, GroupLayout.PREFERRED_SIZE, 40,
																		GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										infoPanelLayout
												.createParallelGroup(GroupLayout.Alignment.LEADING, false)
												.addGroup(
														infoPanelLayout
																.createParallelGroup(GroupLayout.Alignment.BASELINE)
																.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 26,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(time_inLabel, GroupLayout.DEFAULT_SIZE, 40,
																		Short.MAX_VALUE))
												.addGroup(
														infoPanelLayout
																.createParallelGroup(GroupLayout.Alignment.BASELINE)
																.addComponent(jLabel13, GroupLayout.DEFAULT_SIZE,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(time_outLabel, GroupLayout.PREFERRED_SIZE, 40,
																		GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										infoPanelLayout
												.createParallelGroup(GroupLayout.Alignment.LEADING, false)
												.addGroup(
														infoPanelLayout
																.createParallelGroup(GroupLayout.Alignment.BASELINE)
																.addComponent(jLabel7, GroupLayout.DEFAULT_SIZE,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(priceLabel, GroupLayout.DEFAULT_SIZE,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
												.addGroup(
														infoPanelLayout
																.createParallelGroup(GroupLayout.Alignment.BASELINE)
																.addComponent(jLabel14, GroupLayout.DEFAULT_SIZE, 40,
																		Short.MAX_VALUE)
																.addComponent(pledgeLabel, GroupLayout.PREFERRED_SIZE, 40,
																		GroupLayout.PREFERRED_SIZE)))
								.addGap(18, 18, 18)
								.addGroup(
										infoPanelLayout
												.createParallelGroup(GroupLayout.Alignment.LEADING, false)
												.addComponent(checkOutButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 37,
														GroupLayout.PREFERRED_SIZE)).addContainerGap(14, Short.MAX_VALUE)));

		infoPanelLayout.linkSize(SwingConstants.VERTICAL, new Component[] { time_inLabel, priceLabel, jLabel12, jLabel13,
				jLabel14, typeLabel, time_outLabel, pledgeLabel, jLabel4, jLabel5, jLabel6, jLabel7, numLabel, nameLabel });

		infoPanelLayout.linkSize(SwingConstants.VERTICAL, new Component[] { checkOutButton, cancelButton });

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
				GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(
								layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
										.addComponent(infoPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)).addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(infoPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
	}

	private class CheckOutPanelActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == sureButton) {
				String number = (String) numComBox.getSelectedItem();
				String date = dateSelect.getJFormattedTextField().getText();
				if (number == null) {
					JOptionPane.showMessageDialog(CheckOutPanel.this, Language.getInstance().inputRoomNumber(), Language
							.getInstance().error(), JOptionPane.ERROR_MESSAGE);
					numComBox.grabFocus();
				} else if (date.isEmpty()) {
					JOptionPane.showMessageDialog(CheckOutPanel.this, Language.getInstance().inputCheckInDate(), Language
							.getInstance().error(), JOptionPane.ERROR_MESSAGE);
				} else {
					RoomInfo roomInfo = getCheckOutOperateController().queryUnCheckOutRoomInfoByKey(number);
					if (roomInfo.getRoomNumber() == null) {
						JOptionPane.showMessageDialog(CheckOutPanel.this, Language.getInstance().noRoomInfoOrCheckout(), Language
								.getInstance().error(), JOptionPane.ERROR_MESSAGE);
						dateSelect.grabFocus();
					} else {
						numLabel.setText(roomInfo.getRoomNumber());
						typeLabel.setText(roomInfo.getRoomType());
						nameLabel.setText(roomInfo.getCustomerName());
						time_inLabel.setText(roomInfo.getInDate());
						time_outLabel.setText(Constants.getTimeFormatterInstance().format(Calendar.getInstance().getTime()));
						priceLabel.setText(roomInfo.getPrice() + "");
						pledgeLabel.setText(roomInfo.getPledge() + "");

						infoPanel.setVisible(true);
					}
				}
			}
			if (e.getSource() == checkOutButton) {
				String date = dateSelect.getJFormattedTextField().getText();
				if (JOptionPane.showConfirmDialog(CheckOutPanel.this, Language.getInstance().roomNumber() + numLabel.getText()
						+ "\n" + Language.getInstance().checkInDate() + time_inLabel.getText() + "\n"
						+ Language.getInstance().price() + priceLabel.getText() + "\n" + Language.getInstance().pledge()
						+ pledgeLabel.getText() + "", Language.getInstance().prompt(), JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					try {
						if (getCheckOutOperateController().checkOut(numLabel.getText(), date, time_outLabel.getText())) {
							JOptionPane.showMessageDialog(CheckOutPanel.this, Language.getInstance().checkOutSucceed(), Language
									.getInstance().succeed(), JOptionPane.INFORMATION_MESSAGE);
							getCheckOutOperateController().updateRoomNumberOptions(date);
							infoPanel.setVisible(false);
						} else {
							JOptionPane.showMessageDialog(CheckOutPanel.this, Language.getInstance().checkInFail(), Language
									.getInstance().fail(), JOptionPane.ERROR_MESSAGE);
						}
					} catch (Exception ex) {
					}
				}
			}
			if (e.getSource() == cancelButton) {
				if (JOptionPane.showConfirmDialog(CheckOutPanel.this, Language.getInstance().confirmCancel(), Language
						.getInstance().prompt(), JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					infoPanel.setVisible(false);
				}
			}
		}

	}

	public CheckOutOperateController getCheckOutOperateController() {
		return checkOutOperateController;
	}

	public JComboBox<String> getNumComBox() {
		return numComBox;
	}

	public CustomJDatePickerImpl getDateSelect() {
		return dateSelect;
	}

}
