package com.lusr.service;

import com.lusr.entity.Room;

import java.util.List;

/**
 * 房间业务
 *
 * @author chgl16
 * @date 2018-12-31
 * @version 1.0
 */

public interface RoomService {
    /**
     * 获取空房间
     *
     * @return
     */
    public List<Room> getFreeRoom();

    /**
     * 获取所有房间
     *
     * @return
     */
    public List<Room> getAllRoom();

    /**
     * 取反房间状态
     *
     * @param id
     */
    public void reverseStatus(Integer id);

    /**
     * 添加房间
     *
     * @param id
     * @param type
     * @param price
     */
    public void addRoom(Integer id, String type, float price);
}
