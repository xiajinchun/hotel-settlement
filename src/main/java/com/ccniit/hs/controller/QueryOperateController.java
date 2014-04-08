package com.ccniit.hs.controller;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import com.ccniit.hs.dao.QueryPanelOperateDao;
import com.ccniit.hs.dao.impl.TextQueryPanelOperateDaoImpl;
import com.ccniit.hs.model.RoomInfo;
import com.ccniit.hs.view.QueryPanel;

public class QueryOperateController extends OperateController {
	private static OperateController instance = null;

	private final QueryPanelOperateDao queryOperateDao;
	private QueryPanel queryPanel = null;

	private QueryOperateController(QueryPanelOperateDao queryOperateDao) {
		this.queryOperateDao = queryOperateDao;
	}

	@Override
	public void initPanelData() {
		this.queryPanel = new QueryPanel(this);
		showRoomList(this.queryPanel.getDateField().getJFormattedTextField().getText());
	}

	public void showRoomList(String date) {
		ArrayList<RoomInfo> roomList = this.queryOperateDao.selectRoomInfoListByDate(date);
		DefaultTableModel queryModel = this.queryPanel.getQueryModel();
		int num = this.queryPanel.getQueryModel().getRowCount();
		for (int i = 0; i < num; i++)
			queryModel.removeRow(0);
		if (roomList != null) {
			for (RoomInfo room : roomList) {
				Vector<String> veclist = new Vector<String>();
				veclist.add(room.getRoomNumber());
				veclist.add(room.getCustomerName());
				veclist.add(room.getRoomType());
				veclist.add(room.getPrice() + "");
				veclist.add(room.getPledge() + "");
				veclist.add(room.getInDate().substring(5, 19));
				String str = room.getOutDate();
				if (str.equals("-----"))
					veclist.add("-----");
				else
					veclist.add(room.getOutDate().substring(5, 19));
				queryModel.addRow(veclist);
			}
		}
	}

	@Override
	public JPanel getOperatePanel() {
		return queryPanel;
	}

	public static OperateController getInstance() {
		if (QueryOperateController.instance == null)
			QueryOperateController.instance = new QueryOperateController(new TextQueryPanelOperateDaoImpl());
		return QueryOperateController.instance;
	}
}