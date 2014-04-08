package com.ccniit.hs.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;

import com.ccniit.hs.controller.QueryOperateController;
import com.ccniit.hs.view.i18n.Language;

@SuppressWarnings("serial")
public class QueryPanel extends JPanel {
	private final QueryOperateController queryOperateController;
	private JButton subButton;
	private JLabel jLabel2;
	private JPanel jPanel1;
	private JPanel jPanel2;
	private JScrollPane jScrollPane1;
	private JTable queryTable;
	private CustomJDatePickerImpl dateField;
	private DefaultTableModel queryModel;
	Vector<String> head = new Vector<String>();

	public QueryPanel(QueryOperateController queryOperateController) {
		this.queryOperateController = queryOperateController;
		initComponents();
		initLayout();
	}

	private void initComponents() {

		head.add(Language.getInstance().roomNumber());
		head.add(Language.getInstance().customerName());
		head.add(Language.getInstance().roomType());
		head.add(Language.getInstance().price());
		head.add(Language.getInstance().pledge());
		head.add(Language.getInstance().checkInDate());
		head.add(Language.getInstance().checkoutTime());

		jPanel1 = new JPanel();
		subButton = new JButton();
		jLabel2 = new JLabel();
		dateField = new CustomJDatePickerImpl(queryOperateController);
		jPanel2 = new JPanel();
		jScrollPane1 = new JScrollPane();
		queryTable = new JTable();
		queryModel = new DefaultTableModel(head, 0);

		queryTable.setFont(new Font("Microsoft YaHei", 0, 14));
		queryTable.setModel(queryModel);
		queryTable.setAutoCreateRowSorter(true);
		queryTable.setRowHeight(20);
		queryTable.setEnabled(false);
		jScrollPane1.setViewportView(queryTable);

		setBorder(BorderFactory.createTitledBorder(""));
		setPreferredSize(new java.awt.Dimension(720, 400));

		jPanel1.setBorder(BorderFactory.createTitledBorder(""));
		jPanel1.setRequestFocusEnabled(false);

		subButton.setFont(new java.awt.Font("Microsoft YaHei", 0, 18));
		subButton.setText(Language.getInstance().submitQuery());
		subButton.addActionListener(new QueryPanelActionPerformed());

		jLabel2.setFont(new java.awt.Font("KaiTi", 0, 18));
		jLabel2.setText(Language.getInstance().dateChoose());

		dateField.setFont(new java.awt.Font("Microsoft YaHei", 0, 16));
	}

	private void initLayout() {
		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
				jPanel1Layout.createSequentialGroup().addGap(118, 118, 118).addComponent(jLabel2).addGap(18, 18, 18)
						.addComponent(dateField, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE).addGap(71, 71, 71)
						.addComponent(subButton, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(38, Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
				jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(dateField)
						.addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(subButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		jPanel2.setBorder(BorderFactory.createTitledBorder(""));

		jScrollPane1.setViewportView(queryTable);

		GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
				GroupLayout.Alignment.TRAILING,
				jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(jScrollPane1).addContainerGap()));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(
				jScrollPane1, GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE));

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
				GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(
								layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
										.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)).addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
	}

	private class QueryPanelActionPerformed implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == subButton) {
				getQueryOperateController().showRoomList(dateField.getJFormattedTextField().getText());
			}
		}
	}

	public QueryOperateController getQueryOperateController() {
		return queryOperateController;
	}

	public DefaultTableModel getQueryModel() {
		return queryModel;
	}

	public CustomJDatePickerImpl getDateField() {
		return dateField;
	}

}
