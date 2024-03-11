package com.ssg.webmvc.controller;

import com.ssg.webmvc.dto.MemberDTO;
import com.ssg.webmvc.service.MemberService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
@Log4j2
public class loginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log.info("log get");
        request.getRequestDispatcher("/WEB-INF/member/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log.info("login called");

        String id = request.getParameter("id");
        String password = request.getParameter("password");

        try{
            MemberDTO memberDTO = MemberService.INSTANCE.login(id,password);
            HttpSession session = request.getSession();

            session.setAttribute("loginInfo",memberDTO);
            response.sendRedirect("/member/list");

        }catch (Exception e){
            response.sendRedirect("/login?result=error");
        }

    }
}
