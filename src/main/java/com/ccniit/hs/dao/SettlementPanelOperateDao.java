package com.ccniit.hs.dao;

import java.util.Map;

import com.ccniit.hs.model.RoomInfo;

public interface SettlementPanelOperateDao {

	Map<String, RoomInfo> selectRoomInfoByDateKeyAsRoomType(String date);
}
