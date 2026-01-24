package com.example.project.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.project.dto.MemberDTO;
import com.example.project.dto.SecurityAllUserDTO;
import com.example.project.mapper.Membermapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService implements UserDetailsService {

    private final Membermapper membermapper;

    @Override
    public UserDetails loadUserByUsername(String member_id) throws UsernameNotFoundException {
         

        Optional<MemberDTO> opMember = membermapper.getAllUsersDetail(member_id);
        if(opMember.isPresent()){
            MemberDTO member = opMember.get();
            return new SecurityAllUserDTO(member);
        }
         throw new UsernameNotFoundException("no information"+  member_id);

 
    }
}   