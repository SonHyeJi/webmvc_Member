package com.ssg.webmvc.dao;

import com.ssg.webmvc.domain.MemberVO;
import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class MemberDAO {

    public List<MemberVO> memberlistAll() throws Exception{
        String sql = "select * from mvc_member";

        @Cleanup Connection conn = ConnectionUtill.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        @Cleanup ResultSet rs = pstmt.executeQuery();

        List<MemberVO> memberlist = new ArrayList<>();

        while(rs.next()){
            MemberVO vo = MemberVO.builder().id(rs.getString("id"))
                    .password(rs.getString("password"))
                    .username(rs.getString("username"))
                    .email(rs.getString("email"))
                    .joindate(rs.getDate("joindate").toLocalDate()).build();
            memberlist.add(vo);
        }

        return memberlist;
    }

    public void register(MemberVO memberVO) throws Exception{
        String sql = "INSERT INTO mvc_member(id, password, username, email, joindate) VALUES (?,?,?,?,now())";

        @Cleanup Connection conn = ConnectionUtill.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, memberVO.getId());
        pstmt.setString(2, memberVO.getPassword());
        pstmt.setString(3,memberVO.getUsername());
        pstmt.setString(4, memberVO.getEmail());

        pstmt.executeUpdate();
    }

    public MemberVO listone(String id) throws Exception{

        String sql = "select * from mvc_member where id = ?";

        @Cleanup Connection conn = ConnectionUtill.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,id);
        @Cleanup ResultSet rs = pstmt.executeQuery();

        rs.next();
        MemberVO vo = MemberVO.builder().id(rs.getString("id"))
                .password(rs.getString("password"))
                .username(rs.getString("username"))
                .email(rs.getString("email"))
                .joindate(rs.getDate("joindate").toLocalDate()).build();

        return vo;

    }

    public int update(MemberVO memberVO) throws Exception{
        int ack=0;

        String sql = "update mvc_member set password=?, username=?, email=? where id = ?";

        @Cleanup Connection conn = ConnectionUtill.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1,memberVO.getPassword());
        pstmt.setString(2,memberVO.getUsername());
        pstmt.setString(3,memberVO.getEmail());
        pstmt.setString(4,memberVO.getId());

        ack = pstmt.executeUpdate();

        return ack;

    }

    public void delete(String id) throws Exception{
        String sql = "delete from mvc_member where id = ?";

        @Cleanup Connection conn = ConnectionUtill.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,id);

        pstmt.executeUpdate();

    }

    public MemberVO login(String id, String password) throws Exception {
        String sql = "select id, password, username, email from mvc_member where id =? and password= ?";

        MemberVO memberVO;

        @Cleanup Connection conn = ConnectionUtill.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,id);
        pstmt.setString(2,password);

        @Cleanup ResultSet rs = pstmt.executeQuery();

        rs.next();
        memberVO = MemberVO.builder()
                .id(rs.getString(1))
                .password(rs.getString(2))
                .email(rs.getString(3)).build();

        return memberVO;

    }


}
