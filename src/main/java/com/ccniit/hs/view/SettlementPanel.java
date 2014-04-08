package com.ccniit.hs.view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;

import com.ccniit.hs.controller.SettlementOperateController;
import com.ccniit.hs.view.i18n.Language;

@SuppressWarnings("serial")
public class SettlementPanel extends JPanel {
	private SettlementOperateController settlementOperateController;
	private JButton subButton;
	private JComboBox<String> typeComBox;
	private JLabel jLabel10;
	private JLabel jLabel11;
	private JLabel jLabel12;
	private JLabel sumLabel;
	private JLabel totalPledgeLabel;
	private JLabel remainPledgeLabel;
	private JLabel jLabel2;
	private JLabel numLabel;
	private JLabel jLabel7;
	private JLabel jLabel8;
	private JLabel typeSumLabel;
	private JPanel jPanel1;
	private JPanel jPanel2;
	private JPanel jPanel3;
	private JPanel jPanel4;
	private CustomJDatePickerImpl dateField;

	public SettlementPanel(SettlementOperateController settlementOperateController) {
		this.settlementOperateController = settlementOperateController;
		initComponents();
		initLayout();
	}

	private void initComponents() {
		jPanel1 = new JPanel();
		subButton = new JButton();
		jLabel2 = new JLabel();
		dateField = new CustomJDatePickerImpl(settlementOperateController);
		jPanel2 = new JPanel();
		jPanel3 = new JPanel();
		typeComBox = new JComboBox<String>();
		numLabel = new JLabel();
		jLabel7 = new JLabel();
		jLabel8 = new JLabel();
		typeSumLabel = new JLabel();
		jPanel4 = new JPanel();
		jLabel10 = new JLabel();
		jLabel11 = new JLabel();
		jLabel12 = new JLabel();
		sumLabel = new JLabel();
		totalPledgeLabel = new JLabel();
		remainPledgeLabel = new JLabel();
		SettlementPanelAcrtionListener spal = new SettlementPanelAcrtionListener();

		setBorder(BorderFactory.createTitledBorder(""));
		setPreferredSize(new Dimension(720, 400));

		jPanel1.setBorder(BorderFactory.createTitledBorder(""));
		jPanel1.setRequestFocusEnabled(false);

		subButton.setFont(new Font("Microsoft YaHei", 0, 18));
		subButton.setText(Language.getInstance().submitQuery());
		subButton.addActionListener(spal);
		
		jLabel2.setFont(new Font("KaiTi", 0, 18));
		jLabel2.setText(Language.getInstance().dateChoose());

		dateField.setFont(new Font("Microsoft YaHei", 0, 14));

		jPanel2.setBorder(BorderFactory.createTitledBorder(""));

		jPanel3.setBorder(BorderFactory.createTitledBorder(""));

		numLabel.setFont(new Font("Microsoft YaHei", 0, 24));

		jLabel7.setFont(new Font("KaiTi", 0, 18));
		jLabel7.setText(Language.getInstance().rooms());

		jLabel8.setFont(new Font("KaiTi", 0, 18));
		jLabel8.setText(Language.getInstance().typeIncome());

		typeSumLabel.setFont(new Font("Microsoft YaHei", 0, 24));

		jPanel4.setBorder(BorderFactory.createTitledBorder(""));

		jLabel10.setFont(new Font("KaiTi", 0, 24));
		jLabel10.setText(Language.getInstance().todayIncome());

		jLabel11.setFont(new Font("KaiTi", 0, 24));
		jLabel11.setText(Language.getInstance().totalPledge());

		jLabel12.setFont(new Font("KaiTi", 0, 24));
		jLabel12.setText(Language.getInstance().unReturnPledge());

		sumLabel.setFont(new Font("Microsoft YaHei", 0, 18));

		totalPledgeLabel.setFont(new Font("Microsoft YaHei", 0, 18));

		remainPledgeLabel.setFont(new Font("Microsoft YaHei", 0, 18));
		
		typeComBox.addActionListener(spal);

	}

	private void initLayout() {
		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
				jPanel1Layout.createSequentialGroup().addGap(118, 118, 118).addComponent(jLabel2).addGap(18, 18, 18)
						.addComponent(dateField, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE).addGap(71, 71, 71)
						.addComponent(subButton, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
				jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(dateField)
						.addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(subButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
				jPanel3Layout
						.createSequentialGroup()
						.addGap(106, 106, 106)
						.addGroup(
								jPanel3Layout
										.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addGroup(
												jPanel3Layout.createSequentialGroup()
														.addComponent(typeComBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addComponent(jLabel8, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE))
						.addGap(30, 30, 30)
						.addGroup(
								jPanel3Layout
										.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addGroup(
												jPanel3Layout
														.createSequentialGroup()
														.addComponent(numLabel, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addGap(18, 18, 18)
														.addComponent(jLabel7, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGroup(
												jPanel3Layout
														.createSequentialGroup()
														.addComponent(typeSumLabel, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGap(62, 62, 62)))
						.addGap(89, 89, 89)));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
				jPanel3Layout
						.createSequentialGroup()
						.addGroup(
								jPanel3Layout
										.createParallelGroup(GroupLayout.Alignment.TRAILING)
										.addComponent(typeComBox)
										.addComponent(numLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(jLabel7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE))
						.addGap(7, 7, 7)
						.addGroup(
								jPanel3Layout
										.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(jLabel8, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(typeSumLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE))));
		GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
		jPanel4.setLayout(jPanel4Layout);
		jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
				jPanel4Layout
						.createSequentialGroup()
						.addGap(172, 172, 172)
						.addGroup(
								jPanel4Layout
										.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addGroup(
												jPanel4Layout
														.createSequentialGroup()
														.addGroup(
																jPanel4Layout
																		.createParallelGroup(GroupLayout.Alignment.LEADING)
																		.addComponent(jLabel11, GroupLayout.DEFAULT_SIZE,
																				GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																		.addComponent(jLabel12, GroupLayout.Alignment.TRAILING,
																				GroupLayout.PREFERRED_SIZE, 120,
																				GroupLayout.PREFERRED_SIZE))
														.addGap(40, 40, 40)
														.addGroup(
																jPanel4Layout
																		.createParallelGroup(GroupLayout.Alignment.LEADING)
																		.addComponent(totalPledgeLabel,
																				GroupLayout.PREFERRED_SIZE, 99,
																				GroupLayout.PREFERRED_SIZE)
																		.addGroup(
																				jPanel4Layout
																						.createSequentialGroup()
																						.addGap(1, 1, 1)
																						.addComponent(remainPledgeLabel,
																								GroupLayout.PREFERRED_SIZE, 99,
																								GroupLayout.PREFERRED_SIZE))))
										.addGroup(
												GroupLayout.Alignment.TRAILING,
												jPanel4Layout
														.createSequentialGroup()
														.addComponent(jLabel10)
														.addGap(41, 41, 41)
														.addComponent(sumLabel, GroupLayout.PREFERRED_SIZE, 99,
																GroupLayout.PREFERRED_SIZE))).addGap(131, 131, 131)));

		jPanel4Layout.linkSize(SwingConstants.HORIZONTAL, new Component[] { jLabel10, jLabel11, jLabel12, sumLabel,
				totalPledgeLabel, remainPledgeLabel });

		jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
				GroupLayout.Alignment.TRAILING,
				jPanel4Layout
						.createSequentialGroup()
						.addGroup(
								jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jLabel10)
										.addComponent(sumLabel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(
								jPanel4Layout
										.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(jLabel11, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
										.addComponent(totalPledgeLabel, GroupLayout.PREFERRED_SIZE, 31,
												GroupLayout.PREFERRED_SIZE))
						.addGroup(
								jPanel4Layout
										.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addGroup(
												jPanel4Layout
														.createSequentialGroup()
														.addGap(8, 8, 8)
														.addComponent(jLabel12, GroupLayout.PREFERRED_SIZE, 39,
																GroupLayout.PREFERRED_SIZE))
										.addGroup(
												jPanel4Layout
														.createSequentialGroup()
														.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
														.addComponent(remainPledgeLabel, GroupLayout.PREFERRED_SIZE, 37,
																GroupLayout.PREFERRED_SIZE)))));

		jPanel4Layout.linkSize(SwingConstants.VERTICAL, new Component[] { jLabel10, jLabel11, jLabel12, sumLabel,
				totalPledgeLabel, remainPledgeLabel });

		GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
				GroupLayout.Alignment.TRAILING,
				jPanel2Layout
						.createSequentialGroup()
						.addContainerGap()
						.addGroup(
								jPanel2Layout
										.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(jPanel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)).addContainerGap()));
		jPanel2Layout
				.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
						jPanel2Layout
								.createSequentialGroup()
								.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)));

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(
								layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)).addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
	}

	private class SettlementPanelAcrtionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String type = (String) getTypeComBox().getSelectedItem();
			String date  = (String)getDateField().getJFormattedTextField().getText();
			if (e.getSource() == typeComBox) {
				getSettlementOperateController().updateSelectedRoomTypeInfo(type);

			}
			if (e.getSource() == subButton) {
				getSettlementOperateController().updateSelectedDateInfo(date);
			}
		}

	}

	public CustomJDatePickerImpl getDateField() {
		return dateField;
	}

	public JComboBox<String> getTypeComBox() {
		return typeComBox;
	}

	public JLabel getSumLabel() {
		return sumLabel;
	}

	public JLabel getTotalPledgeLabel() {
		return totalPledgeLabel;
	}

	public JLabel getRemainPledgeLabel() {
		return remainPledgeLabel;
	}

	public JLabel getNumLabel() {
		return numLabel;
	}

	public JLabel getTypeSumLabel() {
		return typeSumLabel;
	}

	public SettlementOperateController getSettlementOperateController() {
		return settlementOperateController;
	}

}
