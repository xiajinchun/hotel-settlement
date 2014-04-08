package com.ccniit.hs.dao;

import java.util.Map;

import com.ccniit.hs.model.RoomEntity;
import com.ccniit.hs.model.RoomInfo;

public interface CheckInPanelOperateDao {
	public boolean insertNewRoomInfo(RoomInfo roomInfo,String date);

	public Map<String, RoomEntity> selectAllRoomList();

}
