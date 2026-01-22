package com.example.project.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class SecurityAllUserDTO implements UserDetails {

    private final MemberDTO member;

    public SecurityAllUserDTO(MemberDTO member){
        this.member = member;
    }

	
	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of(new SimpleGrantedAuthority("ROLE_" + member.getRole().name()));
    }


    @Override
    public String getPassword() {
        
        return member.getMemberPass();
    }


    @Override
    public String getUsername() {

        return member.getMemberId();
    }
    

    public int getLevel(){
        return member.getRole().getLevel();
    }

    public String getDisplayName(){
        return member.getMemberName();
    }

    @Override
    public boolean isAccountNonExpired() {
    
        return true;
    }


    @Override
    public boolean isAccountNonLocked() {
        
        return true;
    }


    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }


    @Override
    public boolean isEnabled() {
        
        return true;
    }
    
    

		 

}
