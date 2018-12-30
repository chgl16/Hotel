package com.lusr.service.impl;

import com.lusr.dao.RoomDao;
import com.lusr.dao.impl.RoomDaoImpl;
import com.lusr.entity.Room;
import com.lusr.service.RoomService;

import java.util.List;

public class RoomServiceImpl implements RoomService {
    private RoomDao roomDao = new RoomDaoImpl();

    @Override
    public List<Room> getFreeRoom() {
        return roomDao.selectFreeRoom();
    }
}
