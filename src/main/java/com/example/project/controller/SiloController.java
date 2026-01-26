package com.example.project.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.config.MemberRole;
import com.example.project.dto.FIleAccessAllowDTO;
import com.example.project.dto.SecurityAllUserDTO;
import com.example.project.exception.UserResponse;
import com.example.project.mapper.SIloMapper;
import com.google.rpc.context.AttributeContext.Response;

import io.grpc.xds.shaded.io.envoyproxy.envoy.extensions.filters.network.http_connection_manager.v3.ResponseMapper;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import reactor.netty.http.server.HttpServerRequest;

@RestController
@RequestMapping("/api/files")
public class SiloController {

    //private final SIloMapper siloMapper;
    
    @GetMapping("/checkAcess")
    public ResponseEntity<UserResponse> getMethodName(@RequestParam String file_id, @AuthenticationPrincipal SecurityAllUserDTO userdetails) {
         
        try{
         if(userdetails == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                  .body(UserResponse.error("로그인이 필ㅇ한 서비스 입니다"));

         }
         String role = userdetails.getAuthorities().toString();
         boolean isAllowed = checkLogic(file_id, role);

        if(isAllowed){

            FIleAccessAllowDTO result = new FIleAccessAllowDTO(true,file_id, "접근이 허용되었습니다");
            return ResponseEntity.ok(UserResponse.successData("확인 성공", result));
        }else {

            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(UserResponse.error("해당파일에 접근할 권한이 없습니다"));  
        }



           
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(UserResponse.error("서버오류가 발생하였습니다"));
        }

    }
    
    private boolean checkLogic(String file_id, String role){

        if("secret_admin.py".equals(file_id)){
            return role.contains("ADMIN");
        }
        return true;

    }
    
  
        
    

  

    } 