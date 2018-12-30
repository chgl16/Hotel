package com.lusr.controller;

import com.lusr.entity.Member;
import com.lusr.service.RegisterService;
import com.lusr.service.impl.RegisterServiceImpl;
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

@WebServlet(urlPatterns = "/member/register" )
public class MemberRegisterServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(MemberRegisterServlet.class);
    private RegisterService registerService = new RegisterServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String phone = request.getParameter("phone");
        String identity = request.getParameter("identity");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Member member = new Member(phone, username, identity, password);
        log.info("获取到前端的参数: " + member.toString());

        // 调用业务处理
        boolean flag = registerService.MemberRegister(member);
        response.getWriter().write(String.valueOf(flag));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
