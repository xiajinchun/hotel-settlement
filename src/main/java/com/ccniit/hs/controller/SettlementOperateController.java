package com.ccniit.hs.controller;

import java.util.Map;
import java.util.Vector;
import java.util.Map.Entry;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;

import com.ccniit.hs.dao.SettlementPanelOperateDao;
import com.ccniit.hs.dao.impl.TextSettlementPanelOperateDaoImpl;
import com.ccniit.hs.model.RoomInfo;
import com.ccniit.hs.view.SettlementPanel;

public class SettlementOperateController extends OperateController {
	private static OperateController instance = null;

	private final SettlementPanelOperateDao settlementOperateDao;
	private SettlementPanel settlementPanel = null;

	private Map<String, RoomInfo> roomInfos = null;

	private SettlementOperateController(SettlementPanelOperateDao settlementOperateDao) {
		this.settlementOperateDao = settlementOperateDao;
	}

	@Override
	public void initPanelData() {
		this.settlementPanel = new SettlementPanel(this);
		String date = this.settlementPanel.getDateField().getJFormattedTextField().getText();
		this.roomInfos = this.settlementOperateDao.selectRoomInfoByDateKeyAsRoomType(date);
		updateRoomTypeOption(date);
		updateSelectedDateInfo(date);
	}

	public void updateRoomTypeOption(String date) {
		Vector<String> types = new Vector<String>();
		if (roomInfos != null) {
			for (Entry<String, RoomInfo> roomInfo : roomInfos.entrySet()) {
				String type = roomInfo.getValue().getRoomType();
				if (!(types.contains(type)))
					types.add(type);
			}
		}
		this.settlementPanel.getTypeComBox().setModel(new DefaultComboBoxModel<String>(types));
	}

	public void updateSelectedRoomTypeInfo(String type) {
		int i = 0;
		double unitPrice = 0.0;
		if (roomInfos != null) {
			for (Entry<String, RoomInfo> roomInfo : roomInfos.entrySet()) {
				if (roomInfo.getValue().getRoomType().endsWith(type)) {
					i++;
					unitPrice += roomInfo.getValue().getPrice();
				}
			}
		}
		this.settlementPanel.getNumLabel().setText(i + "");
		this.settlementPanel.getTypeSumLabel().setText(unitPrice + "");
	}

	public void updateSelectedDateInfo(String date) {
		this.roomInfos = this.settlementOperateDao.selectRoomInfoByDateKeyAsRoomType(date);
		double totalPrice = 0.0, totalPledge = 0.0, remainPledge = 0.0;
		if (roomInfos != null) {
			for (Entry<String, RoomInfo> roomInfo : roomInfos.entrySet()) {
				totalPrice += roomInfo.getValue().getPrice();
				totalPledge += roomInfo.getValue().getPledge();
				if (roomInfo.getValue().getOutDate().endsWith("-----")) {
					remainPledge += roomInfo.getValue().getPledge();
				}
			}
		}
		this.settlementPanel.getRemainPledgeLabel().setText(remainPledge + "");
		this.settlementPanel.getTotalPledgeLabel().setText(totalPledge + "");
		this.settlementPanel.getSumLabel().setText(totalPrice + "");
	}

	@Override
	public JPanel getOperatePanel() {
		return settlementPanel;
	}

	public static OperateController getInstance() {
		if (SettlementOperateController.instance == null)
			SettlementOperateController.instance = new SettlementOperateController(new TextSettlementPanelOperateDaoImpl());
		return SettlementOperateController.instance;
	}

}