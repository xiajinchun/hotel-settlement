package com.ccniit.hs.controller;

import java.util.Calendar;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;

import com.ccniit.hs.Constants;
import com.ccniit.hs.dao.CheckInPanelOperateDao;
import com.ccniit.hs.dao.impl.TextCheckInPanelOperateDaoImpl;
import com.ccniit.hs.model.RoomEntity;
import com.ccniit.hs.model.RoomInfo;
import com.ccniit.hs.view.CheckInPanel;

public class CheckInOperateController extends OperateController {
	private static OperateController instance = null;
	private Map<String, RoomEntity> rooms = null;

	private final CheckInPanelOperateDao checkInOperateDao;
	private CheckInPanel addPanel = null;

	private CheckInOperateController(CheckInPanelOperateDao checkInOperateDao) {
		this.checkInOperateDao = checkInOperateDao;
	}

	@Override
	public void initPanelData() {
		this.addPanel = new CheckInPanel(this);
		rooms = this.checkInOperateDao.selectAllRoomList();
		if (rooms != null) {
			this.addPanel.getNumComBox().setModel(new DefaultComboBoxModel<String>(getRoomNumbers(rooms)));
			this.addPanel.getTypeComBox().setModel(new DefaultComboBoxModel<String>(getRoomTypes(rooms)));
		} else {
			this.addPanel.getNumComBox().setModel(new DefaultComboBoxModel<String>());
			this.addPanel.getTypeComBox().setModel(new DefaultComboBoxModel<String>());
		}
		this.addPanel.getTimeField().setText(Constants.getTimeFormatterInstance().format(Calendar.getInstance().getTime()));
		this.setPriceFieldText((String) this.addPanel.getNumComBox().getSelectedItem());
	}

	public void setPriceFieldText(String item) {
		if (rooms != null)
			this.addPanel.getPriceField().setText(rooms.get(item).getPrice() + "");
	}

	public boolean addNewRoomInfo(String num, String type, String name, String price, String pledge, String time) {
		RoomInfo roomInfo = new RoomInfo();
		roomInfo.setRoomNumber(num);
		roomInfo.setRoomType(type);
		roomInfo.setCustomerName(name);
		roomInfo.setPrice(Double.parseDouble(price));
		roomInfo.setPledge(Double.parseDouble(pledge));
		roomInfo.setInDate(time);
		return this.checkInOperateDao.insertNewRoomInfo(roomInfo,
				Constants.getDateFormatterInstance().format(Calendar.getInstance().getTime()));
	}

	private String[] getRoomNumbers(Map<String, RoomEntity> rooms) {
		String[] roomNumbers = new String[rooms.size()];
		int i = 0;
		for (Entry<String, RoomEntity> room : rooms.entrySet()) {
			roomNumbers[i++] = room.getValue().getRoomNumber();
		}
		return roomNumbers;
	}

	private Vector<String> getRoomTypes(Map<String, RoomEntity> rooms) {
		Vector<String> types = new Vector<String>();
		for (Entry<String, RoomEntity> room : rooms.entrySet()) {
			String type = room.getValue().getRoomType();
			if (!(types.contains(type)))
				types.add(type);
		}
		return types;
	}

	@Override
	public JPanel getOperatePanel() {
		return addPanel;
	}

	public static OperateController getInstance() {
		if (CheckInOperateController.instance == null)
			CheckInOperateController.instance = new CheckInOperateController(new TextCheckInPanelOperateDaoImpl());
		return CheckInOperateController.instance;
	}

}