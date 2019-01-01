package com.lusr.controller;

import com.lusr.service.RoomService;
import com.lusr.service.impl.RoomServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 添加房间
 *
 * @author chgl16
 * @date
 * @version
 */

@WebServlet(name = "AddRoomServlet", urlPatterns = "/addRoom")
public class AddRoomServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(AddRoomServlet.class);
    private RoomService roomService = new RoomServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf8");
        Integer id = Integer.parseInt(request.getParameter("id"));
        String type = request.getParameter("type");
        float price = Float.parseFloat(request.getParameter("price"));

        log.info("添加一个房间: id=" + id + ", type=" + type + ", price=" + price);
        roomService.addRoom(id, type, price);

        response.getWriter().write("success");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
