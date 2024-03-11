package com.ssg.webmvc.controller;

import com.ssg.webmvc.domain.MemberVO;
import com.ssg.webmvc.dto.MemberDTO;
import com.ssg.webmvc.service.MemberService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

@Log4j2
@WebServlet(name="registerController", urlPatterns = "/member/register")
public class RegisterController extends HttpServlet {

    private MemberService memberService = MemberService.INSTANCE;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/member/register.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String username = request.getParameter("username");
        String email = request.getParameter("email");

        MemberDTO member = new MemberDTO();
        member.setId(id);
        member.setPassword(password);
        member.setUsername(username);
        member.setEmail(email);
        member.setJoindate(LocalDate.now());

        try {
            log.info(member);
            memberService.register(member);
            response.sendRedirect("/member/list");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
