package com.ccniit.hs.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import com.ccniit.hs.dao.CheckInPanelOperateDao;
import com.ccniit.hs.model.RoomEntity;
import com.ccniit.hs.model.RoomInfo;

public class TextCheckInPanelOperateDaoImpl implements CheckInPanelOperateDao {

	@Override
	public boolean insertNewRoomInfo(RoomInfo roomInfo, String date) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("classes/data/" + date + ".txt", true));
			bw.write(roomInfo.getRoomNumber() + ";" + roomInfo.getCustomerName() + ";" + roomInfo.getRoomType() + ";"
					+ roomInfo.getPrice() + ";" + roomInfo.getPledge() + ";" + roomInfo.getInDate() + ";" + "-----");
			bw.newLine();
			bw.flush();
			bw.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}

	@Override
	public Map<String, RoomEntity> selectAllRoomList() {
		String str;
		Map<String, RoomEntity> rooms = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader("classes/data/room.txt"));
			rooms = new LinkedHashMap<String, RoomEntity>();
			while ((str = br.readLine()) != null) {
				RoomEntity room = new RoomEntity();
				String[] roomArray = str.split(";");
				room.setRoomNumber(roomArray[0]);
				room.setRoomType(roomArray[1]);
				room.setPrice(Double.parseDouble(roomArray[2]));
				rooms.put(room.getRoomNumber(), room);
			}
			br.close();
		} catch (IOException e) {
		}
		return rooms;
	}

}
