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

@WebServlet(name = "ReverseRoomStatusServlet", urlPatterns = "/reverseRoomStatus")
public class ReverseRoomStatusServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(ReverseRoomStatusServlet.class);
    private RoomService roomService = new RoomServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        log.info("取反房间" + id + "的状态");
        roomService.reverseStatus(id);
        response.getWriter().write("{\"flag\": \"true\"}");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
