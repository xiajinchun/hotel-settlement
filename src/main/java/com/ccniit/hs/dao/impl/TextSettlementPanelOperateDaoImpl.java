package com.ccniit.hs.dao.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedHashMap;
import java.util.Map;

import com.ccniit.hs.dao.SettlementPanelOperateDao;
import com.ccniit.hs.model.RoomInfo;

public class TextSettlementPanelOperateDaoImpl implements SettlementPanelOperateDao {
	@Override
	public Map<String, RoomInfo> selectRoomInfoByDateKeyAsRoomType(String date) {
		String str = null;
		Map<String, RoomInfo> roomInfos = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader("classes/data/" + date + ".txt"));
			roomInfos = new LinkedHashMap<String, RoomInfo>();
			while ((str = br.readLine()) != null) {
				String[] infoArray = str.split(";");
				RoomInfo roomInfo = new RoomInfo();
				roomInfo.setRoomNumber(infoArray[0]);
				roomInfo.setCustomerName(infoArray[1]);
				roomInfo.setRoomType(infoArray[2]);
				roomInfo.setPrice(Double.parseDouble(infoArray[3]));
				roomInfo.setPledge(Double.parseDouble(infoArray[4]));
				roomInfo.setInDate(infoArray[5]);
				roomInfo.setOutDate(infoArray[6]);
				roomInfos.put(roomInfo.getRoomType(), roomInfo);
			}
			br.close();
		} catch (Exception e) {
		}
		return roomInfos;
	}
}
