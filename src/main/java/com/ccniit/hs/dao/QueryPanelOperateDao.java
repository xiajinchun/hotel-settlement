package com.ccniit.hs.dao;

import java.util.ArrayList;

import com.ccniit.hs.model.RoomInfo;

public interface QueryPanelOperateDao {
	public ArrayList<RoomInfo> selectRoomInfoListByDate(String date);
}
