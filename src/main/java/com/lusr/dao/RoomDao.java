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
    /**
     * 为员工获取所有房间
     *
     * @return
     */
    public List<Room> selectAllRoom();

    /**
     * 获取所有空房
     *
     * @return
     */
    public List<Room> selectFreeRoom();

    /**
     * 取反房间状态
     *
     * @param id
     */
    public void reverseStatus(Integer id);

    /**
     * 添加房间
     *
     * @param room
     */
    public void insertRoom(Room room);
}
