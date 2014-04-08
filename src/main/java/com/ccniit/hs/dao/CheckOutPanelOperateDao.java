package com.ccniit.hs.dao;

import java.util.Map;

import com.ccniit.hs.model.RoomInfo;

public interface CheckOutPanelOperateDao {
	public Map<String, RoomInfo> selectUnCheckOutRoomInfoByDate(String date);

	public Map<String, RoomInfo> selectAllRoomInfoByDate(String date);
	
	public boolean updateUnCheckOutRoomInfo(String roomNumber, String date, String outDate);

}
