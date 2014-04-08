package com.ccniit.hs.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;

import com.ccniit.hs.controller.CheckInOperateController;
import com.ccniit.hs.view.i18n.Language;

@SuppressWarnings("serial")
public class CheckInPanel extends JPanel {
	private CheckInOperateController checkInOperateController;
	private JButton addButton;
	private JComboBox<String> numComBox;
	private JComboBox<String> typeComBox;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel6;
	private JLabel jLabel7;
	private JPanel jPanel1;
	private JPanel jPanel2;
	private JTextField nameField;
	private JTextField priceField;
	private JTextField timeField;
	private JTextField pledgeField;

	public CheckInPanel(CheckInOperateController checkInOperateController) {
		this.checkInOperateController = checkInOperateController;
		initComponents();
		initLayout();
	}

	private void initComponents() {

		AddPanelActionLisenter aal = new AddPanelActionLisenter();

		jPanel1 = new JPanel();
		jLabel1 = new JLabel();
		numComBox = new JComboBox<String>();
		jLabel2 = new JLabel();
		typeComBox = new JComboBox<String>();
		jPanel2 = new JPanel();
		jLabel4 = new JLabel();
		jLabel5 = new JLabel();
		jLabel6 = new JLabel();
		nameField = new JTextField();
		priceField = new JTextField();
		timeField = new JTextField();
		jLabel7 = new JLabel();
		pledgeField = new JTextField();
		addButton = new JButton();

		setBorder(BorderFactory.createTitledBorder(""));
		setPreferredSize(new Dimension(720, 400));
		setRequestFocusEnabled(false);

		jPanel1.setBorder(BorderFactory.createTitledBorder(""));
		jLabel1.setFont(new java.awt.Font("KaiTi", 0, 18));
		jLabel1.setText(Language.getInstance().roomNumber());

		jLabel2.setFont(new java.awt.Font("KaiTi", 0, 18));
		jLabel2.setText(Language.getInstance().roomType());

		jPanel2.setBorder(BorderFactory.createTitledBorder(""));

		jLabel4.setFont(new java.awt.Font("KaiTi", 0, 18));
		jLabel4.setText(Language.getInstance().customerName());

		nameField.setFont(new Font("Microsoft YaHei", 0, 15));
		jLabel5.setFont(new java.awt.Font("KaiTi", 0, 18));
		jLabel5.setText(Language.getInstance().price());

		jLabel6.setFont(new java.awt.Font("KaiTi", 0, 18));
		jLabel6.setText(Language.getInstance().checkInDate());
		timeField.setEditable(false);

		jLabel7.setFont(new java.awt.Font("KaiTi", 0, 18));
		jLabel7.setText(Language.getInstance().pledge());

		addButton.setFont(new java.awt.Font("Microsoft YaHei", 0, 18));
		addButton.setText(Language.getInstance().confirmCheckIn());
		addButton.addActionListener(aal);
		numComBox.addActionListener(aal);
	}

	private void initLayout() {
		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(
						GroupLayout.Alignment.TRAILING,
						jPanel1Layout.createSequentialGroup().addContainerGap(99, Short.MAX_VALUE)
								.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addComponent(numComBox, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
								.addGap(52, 52, 52).addComponent(jLabel2).addGap(18, 18, 18)
								.addComponent(typeComBox, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
								.addGap(72, 72, 72)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(
						jPanel1Layout
								.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										jPanel1Layout
												.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addGroup(
														jPanel1Layout
																.createSequentialGroup()
																.addComponent(typeComBox, GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
												.addGroup(
														jPanel1Layout
																.createSequentialGroup()
																.addComponent(numComBox, GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
								.addGap(0, 2, Short.MAX_VALUE))
				.addGroup(
						jPanel1Layout
								.createSequentialGroup()
								.addGroup(
										jPanel1Layout
												.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)).addContainerGap()));

		jPanel1Layout.linkSize(SwingConstants.VERTICAL, new java.awt.Component[] { numComBox, typeComBox });

		GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout
				.setHorizontalGroup(jPanel2Layout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel2Layout
										.createSequentialGroup()
										.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(
												jPanel2Layout
														.createParallelGroup(GroupLayout.Alignment.LEADING)
														.addGroup(
																GroupLayout.Alignment.TRAILING,
																jPanel2Layout
																		.createSequentialGroup()
																		.addGroup(
																				jPanel2Layout
																						.createParallelGroup(
																								GroupLayout.Alignment.TRAILING,
																								false)
																						.addComponent(jLabel5,
																								GroupLayout.Alignment.LEADING,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(jLabel4,
																								GroupLayout.Alignment.LEADING,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(jLabel6))
																		.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				jPanel2Layout
																						.createParallelGroup(
																								GroupLayout.Alignment.LEADING)
																						.addComponent(nameField,
																								GroupLayout.PREFERRED_SIZE, 168,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(timeField,
																								GroupLayout.PREFERRED_SIZE, 168,
																								GroupLayout.PREFERRED_SIZE)
																						.addGroup(
																								jPanel2Layout
																										.createSequentialGroup()
																										.addComponent(
																												priceField,
																												GroupLayout.PREFERRED_SIZE,
																												92,
																												GroupLayout.PREFERRED_SIZE)
																										.addGap(46, 46, 46)
																										.addComponent(
																												jLabel7,
																												GroupLayout.PREFERRED_SIZE,
																												103,
																												GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												pledgeField,
																												GroupLayout.PREFERRED_SIZE,
																												93,
																												GroupLayout.PREFERRED_SIZE)))
																		.addGap(91, 91, 91))
														.addGroup(
																GroupLayout.Alignment.TRAILING,
																jPanel2Layout
																		.createSequentialGroup()
																		.addComponent(addButton, GroupLayout.PREFERRED_SIZE, 147,
																				GroupLayout.PREFERRED_SIZE).addGap(237, 237, 237)))));

		jPanel2Layout.linkSize(SwingConstants.HORIZONTAL, new java.awt.Component[] { priceField, pledgeField });

		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
				jPanel2Layout
						.createSequentialGroup()
						.addGap(28, 28, 28)
						.addGroup(
								jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
										.addComponent(nameField, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
						.addGap(32, 32, 32)
						.addGroup(
								jPanel2Layout
										.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addGroup(
												jPanel2Layout
														.createParallelGroup(GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 35,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(priceField, GroupLayout.PREFERRED_SIZE, 35,
																GroupLayout.PREFERRED_SIZE))
										.addComponent(jLabel7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE).addComponent(pledgeField))
						.addGap(31, 31, 31)
						.addGroup(
								jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
										.addComponent(timeField, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
						.addGap(30, 30, 30).addComponent(addButton).addGap(4, 4, 4)));

		jPanel2Layout.linkSize(SwingConstants.VERTICAL, new java.awt.Component[] { jLabel4, jLabel5, jLabel6, jLabel7, nameField,
				priceField, timeField, pledgeField });

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(
								layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(jPanel2, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)));
	}

	private class AddPanelActionLisenter implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == numComBox) {
				String item = (String) numComBox.getSelectedItem();
				getCheckInOperateController().setPriceFieldText(item);
			}
			if (e.getSource() == addButton) {
				String num, type, name, price, pledge, time;
				num = (String) numComBox.getSelectedItem();
				type = (String) typeComBox.getSelectedItem();
				name = nameField.getText();
				price = priceField.getText();
				pledge = pledgeField.getText();
				time = timeField.getText();

				if (getNumComBox().getSelectedItem() == null || getTypeComBox().getSelectedItem() == null) {
					JOptionPane.showMessageDialog(getCheckInOperateController().getOperatePanel(), Language.getInstance()
							.inputRoomNumber(), Language.getInstance().error(), JOptionPane.ERROR_MESSAGE);
				} else if (name.isEmpty()) {
					JOptionPane.showMessageDialog(getCheckInOperateController().getOperatePanel(), Language.getInstance()
							.inputCustomerName(), Language.getInstance().error(), JOptionPane.ERROR_MESSAGE);
					nameField.grabFocus();
				} else if (price.isEmpty()) {
					JOptionPane.showMessageDialog(getCheckInOperateController().getOperatePanel(), Language.getInstance()
							.inputPrice(), Language.getInstance().error(), JOptionPane.ERROR_MESSAGE);
					priceField.grabFocus();
				} else if (pledge.isEmpty()) {
					JOptionPane.showMessageDialog(getCheckInOperateController().getOperatePanel(), Language.getInstance()
							.inputPledge(), Language.getInstance().error(), JOptionPane.ERROR_MESSAGE);
					pledgeField.grabFocus();
				} else {
					if (getCheckInOperateController().addNewRoomInfo(num, type, name, price, pledge, time))
						JOptionPane.showMessageDialog(getCheckInOperateController().getOperatePanel(), Language.getInstance()
								.checkInSucceed(), Language.getInstance().succeed(), JOptionPane.INFORMATION_MESSAGE);
					else
						JOptionPane.showMessageDialog(getCheckInOperateController().getOperatePanel(), Language.getInstance()
								.checkInFail(), Language.getInstance().fail(), JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

	public JComboBox<String> getNumComBox() {
		return numComBox;
	}

	public JComboBox<String> getTypeComBox() {
		return typeComBox;
	}

	public CheckInOperateController getCheckInOperateController() {
		return checkInOperateController;
	}

	public JTextField getPriceField() {
		return priceField;
	}

	public JTextField getTimeField() {
		return timeField;
	}
}
