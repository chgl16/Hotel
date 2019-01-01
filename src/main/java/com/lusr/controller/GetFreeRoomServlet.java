package com.lusr.controller;

import com.lusr.entity.Room;
import com.lusr.service.RoomService;
import com.lusr.service.impl.RoomServiceImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetFreeRoomServlet", urlPatterns = "/getFreeRoom")
public class GetFreeRoomServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(GetFreeRoomServlet.class);
    private RoomService roomService = new RoomServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("获取所有可定房间");
        List<Room> roomList = roomService.getFreeRoom();
        response.setCharacterEncoding("utf8");
        response.getWriter().write(JSONArray.fromObject(roomList).toString());
    }
}
