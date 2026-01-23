package com.example.project.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.dto.LoginDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;

@Controller
@RequiredArgsConstructor
public class UserRestController {

    private final AuthenticationManager authenticationManager;
    

    @PostMapping("/api/v1/auth/login")
    public String loginProcess(@Valid LoginDTO userLogin, Model model, HttpServletResponse response, HttpServletRequest request){

        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLogin.getMember_id(), userLogin.getMember_pass()));
      

             SecurityContext securityContext = SecurityContextHolder.getContext();
             securityContext.setAuthentication(authentication);
             HttpSession session = request.getSession(true);

             session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, securityContext);

             response.setHeader("HX-Redirect", "/");
         
             return "success";
       
           } catch(AuthenticationException e){
               
             model.addAttribute("loginError", "아이디 혹은 비밀번호가 올바르지 않습니다");
             return "fragments/auth-errors :: login-failed";
           }
    

    


        } 
    }

    