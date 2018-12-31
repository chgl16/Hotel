package com.lusr.service.impl;

import com.lusr.dao.RoomDao;
import com.lusr.dao.impl.RoomDaoImpl;
import com.lusr.entity.Room;
import com.lusr.service.RoomService;
import java.util.List;

/**
 * 房间业务实现
 *
 * @author chgl16
 * @date
 * @version
 */

public class RoomServiceImpl implements RoomService {
    private RoomDao roomDao = new RoomDaoImpl();

    @Override
    public List<Room> getFreeRoom() {
        return roomDao.selectFreeRoom();
    }

    @Override
    public List<Room> getAllRoom() {
        return roomDao.selectAllRoom();
    }

    @Override
    public void reverseStatus(Integer id) {
        roomDao.reverseStatus(id);
    }

    @Override
    public void addRoom(Integer id, String type, float price) {
        Room room = new Room();
        room.setId(id);
        room.setType(type);
        room.setPrice(price);
        room.setStatus(0);

        roomDao.insertRoom(room);
    }
}
