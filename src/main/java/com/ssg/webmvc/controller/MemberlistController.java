package com.ssg.webmvc.controller;

import com.ssg.webmvc.dto.MemberDTO;
import com.ssg.webmvc.service.MemberService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Log4j2
@WebServlet(name="memberListController" ,urlPatterns = "/member/list")
public class MemberlistController extends HttpServlet {

    private MemberService memberService = MemberService.INSTANCE;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        log.info("list called");

        try{
            List<MemberDTO> memberDTOList = memberService.memberListAll();
            request.setAttribute("memberdtoList",memberDTOList );
            request.getRequestDispatcher("/WEB-INF/member/list.jsp")
                    .forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
