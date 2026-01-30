package com.example.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.project.config.AuthUtils;
import com.example.project.config.MemberRole;
import com.example.project.dto.MemberJoinDTO;
import com.example.project.mapper.Membermapper;

@Service
public class MemberService {

    @Autowired
    private Membermapper membermapper;
    
    //@Autowired
    //private BCryptPasswordEncoder passwordEncoder;
    
    @Autowired
    private AuthUtils authUtils;

    @Transactional(rollbackFor=com.example.project.exception.UserException.class)
    private void insertMember(MemberJoinDTO memberJoin){
        
        memberJoin.setMember_pass(authUtils.encodedPassword(memberJoin.getMember_pass()));
        memberJoin.setRole(MemberRole.USER);
        membermapper.insertMember(memberJoin); 
       
    }


}
