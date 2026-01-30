package com.example.project.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.dto.LoginDTO;
import com.example.project.dto.MemberJoinDTO;
import com.example.project.exception.UserException;
import com.example.project.exception.UserResponse;
import com.example.project.service.MemberService;
import com.google.rpc.context.AttributeContext.Response;

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
    private final MemberService memberService;
    

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
      @PostMapping("/api/v1/auth/join")
      public ResponseEntity<String> join(@Valid @ModelAttribute MemberJoinDTO memberjoin){

        try {
              memberService.insertMember(memberjoin);

          return ResponseEntity.status(201).body("<div class='bg-emerald-50 border border-emerald-200 text-emerald-600 px-4 py-3 rounded-xl text-sm font-medium'>" +
            "회원가입에 성공했습니다! <a href='/auth/login' class='underline ml-2'>로그인하기</a>" +
            "</div>"
          );


        } catch (UserException e) {
           
          return ResponseEntity.status(200).body("<div class='bg-red-50 border border-red-200 text-red-600 px-4 py-3 rounded-xl text-sm font-medium'>" +
            e.getMessage() +
            "</div>"
          );
        } catch(Exception e){

          return ResponseEntity.status(200).body("<div class='bg-red-50 border border-red-200 text-red-600 px-4 py-3 rounded-xl text-sm font-medium'>" +
            "회원가입 중 서버 오류가 발생했습니다." +
            "</div>");
        }


      }

    


        } 
    

    