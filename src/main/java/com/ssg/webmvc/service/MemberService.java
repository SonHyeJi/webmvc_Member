package com.ssg.webmvc.service;

import com.ssg.webmvc.util.MemberMapperUtill;
import com.ssg.webmvc.dao.MemberDAO;
import com.ssg.webmvc.domain.MemberVO;
import com.ssg.webmvc.dto.MemberDTO;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public enum MemberService {
    INSTANCE;

    private MemberDAO memberDAO;
    private ModelMapper modelMapper;

    MemberService(){
        memberDAO = new MemberDAO();
        modelMapper = MemberMapperUtill.INSTANCE.get();
    }

    public List<MemberDTO> memberListAll() throws Exception{
        List<MemberVO> memberListAll = memberDAO.memberlistAll();

        List<MemberDTO> memberDTOList = memberListAll.stream().map(vo->modelMapper.map(vo, MemberDTO.class))
                .collect(Collectors.toList());
        log.info(memberDTOList);
        return memberDTOList;
    }

    public void register(MemberDTO memberDTO) throws Exception{

        MemberVO vo = modelMapper.map(memberDTO, MemberVO.class);
        log.info(vo);
        memberDAO.register(vo);
    }

    public MemberDTO listone(String id){
        MemberVO vo = null;

        try{
            vo = memberDAO.listone(id);

        }catch (Exception e){
            throw new RuntimeException(e);
        }
        MemberDTO memberDTO = modelMapper.map(vo, MemberDTO.class);

        return memberDTO;
    }

    public void update(MemberDTO memberDTO) throws Exception{
        log.info("update service");
        MemberVO memberVO = modelMapper.map(memberDTO,MemberVO.class);
        int chk = memberDAO.update(memberVO);
        log.info(chk);
    }

    public void delete(String id) throws Exception{
        log.info("delete service");
        memberDAO.delete(id);
    }

    public MemberDTO login(String id, String password) throws Exception{
        MemberVO memberVO = memberDAO.login(id,password);
        MemberDTO memberDTO = modelMapper.map(memberVO, MemberDTO.class);
        return memberDTO;
    }


}
