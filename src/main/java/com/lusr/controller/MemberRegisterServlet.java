package com.lusr.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户注册
 *
 * @author chgl16
 * @date 2018-12-24 16:56
 * @version 1.0
 */

@WebServlet(urlPatterns = "/register" )
public class MemberRegisterServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(MemberRegisterServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String phone = request.getParameter("phone");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        log.info("获取到的前端的参数: phone = " + phone  + ", username = " + username + ", password = " + password);

        // 调用业务处理



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
