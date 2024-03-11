package com.ssg.webmvc.controller;

import com.ssg.webmvc.dto.MemberDTO;
import com.ssg.webmvc.service.MemberService;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name="listoneController", urlPatterns = "/member/listone")
public class MemberListOneController extends HttpServlet {

    private MemberService memberService = MemberService.INSTANCE;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try{
            String id = request.getParameter("id");
            MemberDTO memberDTO = MemberService.INSTANCE.listone(id);

            request.setAttribute("id",id);
            request.setAttribute("memberDTO",memberDTO);
            request.getRequestDispatcher("/WEB-INF/member/listone.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
