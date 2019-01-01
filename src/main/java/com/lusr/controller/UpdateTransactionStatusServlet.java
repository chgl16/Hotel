package com.lusr.controller;

import com.lusr.service.TransactionService;
import com.lusr.service.impl.TransactionServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateTransactionStatusServlet", urlPatterns = "/updateTransactionStatus")
public class UpdateTransactionStatusServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(UpdateTransactionStatusServlet.class);
    private TransactionService transactionService = new TransactionServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        log.info("让订单号为:" + id + "的订单失效");
        transactionService.updateStatusZero(id);
        response.getWriter().write("{\"flag\": \"success\"}");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
