package com.ssg.webmvc.controller;

import com.ssg.webmvc.service.MemberService;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name="delMemberController", urlPatterns = "/member/delete")
public class delMemberController extends HttpServlet {

    private MemberService memberService = MemberService.INSTANCE;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try{
            String id = request.getParameter("id");
            memberService.delete(id);
            response.sendRedirect("/member/list");
        }catch (Exception e){
            throw new ServletException("member delete error");
        }
    }
}
