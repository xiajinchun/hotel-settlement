package com.ccniit.hs.dao.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import com.ccniit.hs.dao.QueryPanelOperateDao;
import com.ccniit.hs.model.RoomInfo;

public class TextQueryPanelOperateDaoImpl implements QueryPanelOperateDao {

	@Override
	public ArrayList<RoomInfo> selectRoomInfoListByDate(String date) {
		String str = null;
		ArrayList<RoomInfo> roomInfos = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader("classes/data/" + date + ".txt"));
			roomInfos = new ArrayList<RoomInfo>();
			while ((str = br.readLine()) != null) {
				RoomInfo roomInfo = new RoomInfo();
				String[] infoArray = str.split(";");
				roomInfo.setRoomNumber(infoArray[0]);
				roomInfo.setCustomerName(infoArray[1]);
				roomInfo.setRoomType(infoArray[2]);
				roomInfo.setPrice(Double.parseDouble(infoArray[3]));
				roomInfo.setPledge(Double.parseDouble(infoArray[4]));
				roomInfo.setInDate(infoArray[5]);
				roomInfo.setOutDate(infoArray[6]);
				roomInfos.add(roomInfo);
			}
			br.close();
		} catch (Exception e) {
		}
		return roomInfos;
	}
}
