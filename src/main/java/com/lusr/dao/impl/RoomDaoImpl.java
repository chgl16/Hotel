package com.lusr.dao.impl;

import com.lusr.dao.RoomDao;
import com.lusr.entity.Room;
import com.lusr.util.EMUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class RoomDaoImpl implements RoomDao {
    private EntityManager em = EMUtil.getEM();

    @Override
    public List<Room> selectFreeRoom() {
        // room表名需要大写
        Query query = em.createQuery("SELECT r FROM Room r WHERE r.status = 0");
//        query.setParameter("status", new Integer(0));
        List<Room> rooms = query.getResultList();
        return rooms;
    }
}
