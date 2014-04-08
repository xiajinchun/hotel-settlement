package com.ccniit.hs.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.ccniit.hs.dao.CheckOutPanelOperateDao;
import com.ccniit.hs.model.RoomInfo;

public class TextCheckOutPanelOperateDaoImpl implements CheckOutPanelOperateDao {

	@Override
	public Map<String, RoomInfo> selectUnCheckOutRoomInfoByDate(String date) {
		String str = null;
		Map<String, RoomInfo> roomInfos = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader("classes/data/" + date + ".txt"));
			roomInfos = new LinkedHashMap<String, RoomInfo>();
			while ((str = br.readLine()) != null) {
				String[] infoArray = str.split(";");
				if (infoArray[6].equals("-----")) {
					RoomInfo roomInfo = new RoomInfo();
					roomInfo.setRoomNumber(infoArray[0]);
					roomInfo.setCustomerName(infoArray[1]);
					roomInfo.setRoomType(infoArray[2]);
					roomInfo.setPrice(Double.parseDouble(infoArray[3]));
					roomInfo.setPledge(Double.parseDouble(infoArray[4]));
					roomInfo.setInDate(infoArray[5]);
					roomInfo.setOutDate(infoArray[6]);
					roomInfos.put(roomInfo.getRoomNumber(), roomInfo);
				}
			}
			br.close();
		} catch (Exception e) {
		}
		return roomInfos;
	}

	@Override
	public Map<String, RoomInfo> selectAllRoomInfoByDate(String date) {
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
				roomInfos.put(roomInfo.getRoomNumber(), roomInfo);
			}
			br.close();
		} catch (Exception e) {
		}
		return roomInfos;
	}

	@Override
	public boolean updateUnCheckOutRoomInfo(String number, String date, String outDate) {
		Map<String, RoomInfo> roomInfos = this.selectAllRoomInfoByDate(date);
		boolean isDo = true;
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("classes/data/" + date + ".txt", false));
			for (Entry<String, RoomInfo> roomInfo : roomInfos.entrySet()) {
				if (roomInfo.getKey().equals(number)) {
					bw.write(roomInfo.getValue().getRoomNumber() + ";" + roomInfo.getValue().getCustomerName() + ";"
							+ roomInfo.getValue().getRoomType() + ";" + roomInfo.getValue().getPrice() + ";"
							+ roomInfo.getValue().getPledge() + ";" + roomInfo.getValue().getInDate() + ";" + outDate);
					bw.newLine();
				}
				if (!(roomInfo.getKey().equals(number))) {
					bw.write(roomInfo.getValue().getRoomNumber() + ";" + roomInfo.getValue().getCustomerName() + ";"
							+ roomInfo.getValue().getRoomType() + ";" + roomInfo.getValue().getPrice() + ";"
							+ roomInfo.getValue().getPledge() + ";" + roomInfo.getValue().getInDate() + ";"
							+ roomInfo.getValue().getOutDate());
					bw.newLine();
				}
			}
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
			isDo = false;
		}
		return isDo;
	}

}
