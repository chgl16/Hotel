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
        // 清除存储，到数据库取检索
        em.clear();
        // room表名需要大写
        Query query = em.createQuery("SELECT r FROM Room r WHERE r.status = 0");
        List<Room> rooms = query.getResultList();
        return rooms;
    }

    @Override
    public List<Room> selectAllRoom() {
        // 清除存储，到数据库取检索
        em.clear();
        // room表名需要大写
        Query query = em.createQuery("SELECT r FROM Room r ");
        List<Room> rooms = query.getResultList();
        return rooms;
    }

    @Override
    public void reverseStatus(Integer id) {
        em.getTransaction().begin();;
        Room r = em.find(Room.class, id);
        int status = r.getStatus() == 0? 1 : 0;
        r.setStatus(status);
        em.getTransaction().commit();
    }

    @Override
    public void insertRoom(Room room) {
        em.getTransaction().begin();
        em.persist(room);
        em.getTransaction().commit();
    }
}
