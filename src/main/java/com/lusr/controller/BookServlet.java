package com.lusr.controller;

import com.lusr.service.TransactionService;
import com.lusr.service.impl.TransactionServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BookServlet", urlPatterns = "/book")
public class BookServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(BookServlet.class);
    private TransactionService transactionService = new TransactionServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int room_id = Integer.parseInt(request.getParameter("room_id"));
        int days = Integer.parseInt(request.getParameter("days"));
        float money = Float.parseFloat(request.getParameter("money"));
        String phone = request.getParameter("phone");
        String identity = request.getParameter("identity");

        log.info("room_id: " + room_id + ", money: " + money + ", phone: " + phone + ", identity: " + identity);
        transactionService.createBookTransaction(room_id, days, money, phone, identity);

        response.getWriter().write("{\"flag\": \"success\"}");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
