package com.ssg.webmvc.controller;

import com.ssg.webmvc.dto.MemberDTO;
import com.ssg.webmvc.service.MemberService;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.time.format.DateTimeFormatter;


@WebServlet(name = "modMemberController", urlPatterns = "/member/mod")
public class modMemberController extends HttpServlet {

    private MemberService memberService= MemberService.INSTANCE;
    private final DateTimeFormatter DATEFORMATER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try{
            String id = request.getParameter("id");
            MemberDTO memberDTO = memberService.listone(id);
            request.setAttribute("id",memberDTO);
            request.getRequestDispatcher("/WEB-INF/member/mod.jsp").forward(request,response);

        }catch (Exception e){
            throw new ServletException("오류 발생");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try{
            MemberDTO memberDTO = MemberDTO.builder()
                    .id(request.getParameter("id"))
                    .password(request.getParameter("password"))
                    .username(request.getParameter("username"))
                    .email(request.getParameter("email")).build();

            memberService.update(memberDTO);
            response.sendRedirect("/member/list");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
