package com.lusr.dao;

import com.lusr.entity.Room;

import java.util.List;

/**
 * 房间数据表相关操作
 *
 * @author chgl16
 * @date 2018-12-30 17:28
 * @version 1.0
 */
public interface RoomDao {
    public List<Room> selectFreeRoom();
}
