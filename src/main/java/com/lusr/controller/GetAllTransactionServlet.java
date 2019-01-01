package com.lusr.controller;

import com.lusr.entity.Transaction;
import com.lusr.service.TransactionService;
import com.lusr.service.impl.TransactionServiceImpl;
import net.sf.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetAllTransactionServlet", urlPatterns = "/getAllTransaction")
public class GetAllTransactionServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(GetAllTransactionServlet.class);
    private TransactionService transactionService = new TransactionServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("获取所有订单");
        List<Transaction> transactionList = transactionService.getAllTransaction();
        response.getWriter().write(JSONArray.fromObject(transactionList).toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
