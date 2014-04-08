package com.ccniit.hs.controller;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;

import com.ccniit.hs.dao.CheckOutPanelOperateDao;
import com.ccniit.hs.dao.impl.TextCheckOutPanelOperateDaoImpl;
import com.ccniit.hs.model.RoomInfo;
import com.ccniit.hs.view.CheckOutPanel;

public class CheckOutOperateController extends OperateController {
	private static OperateController instance = null;
	private CheckOutPanelOperateDao checkOutPanelOperateDao;
	private CheckOutPanel checkOutPanel = null;
	private Map<String, RoomInfo> roomInfos = null;

	private CheckOutOperateController(CheckOutPanelOperateDao checkOutPanelOperateDao) {
		this.checkOutPanelOperateDao = checkOutPanelOperateDao;
	}

	@Override
	public void initPanelData() {
		this.checkOutPanel = new CheckOutPanel(this);
		String date = this.checkOutPanel.getDateSelect().getJFormattedTextField().getText();
		updateRoomNumberOptions(date);
	}

	public RoomInfo queryUnCheckOutRoomInfoByKey(String key) {
		return this.roomInfos.get(key);
	}

	public void updateRoomNumberOptions(String date) {
		roomInfos = this.checkOutPanelOperateDao.selectUnCheckOutRoomInfoByDate(date);
		if (roomInfos != null) {
			Vector<String> numbers = new Vector<String>();
			for (Entry<String, RoomInfo> roomInfo : roomInfos.entrySet()) {
				String type = roomInfo.getKey();
				numbers.add(type);
			}
			this.checkOutPanel.getNumComBox().setModel(new DefaultComboBoxModel<String>(numbers));
		}else
			this.checkOutPanel.getNumComBox().setModel(new DefaultComboBoxModel<String>());
	}

	public boolean checkOut(String roomNumber, String date, String outDate) {
		return this.checkOutPanelOperateDao.updateUnCheckOutRoomInfo(roomNumber, date, outDate);
	}

	@Override
	public JPanel getOperatePanel() {
		return checkOutPanel;
	}

	public static OperateController getInstance() {
		if (CheckOutOperateController.instance == null)
			CheckOutOperateController.instance = new CheckOutOperateController(new TextCheckOutPanelOperateDaoImpl());
		return CheckOutOperateController.instance;
	}

}