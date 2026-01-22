package com.example.project.controller;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.project.config.MemberRole;
import com.example.project.dto.SecurityAllUserDTO;
import com.example.project.mapper.SIloMapper;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import reactor.netty.http.server.HttpServerRequest;

@Controller
@RequiredArgsConstructor
public class SiloController {

    private final SIloMapper siloMapper;
    
    @GetMapping("/")
    public String indexS(Model model){
        
        //int userLevel = MemberRole.getLevel();

        return "index";
    
    
    
    @GetMapping("/menu/silo-map")
    public String siloMap(Model model, @AuthenticationPrincipal SecurityAllUserDTO users){
        

        /*
       List<SiloFile> silos = siloMapper.findAllSilos();
       model.addAttribute("silos", silos);


        if(request.getHeader("HX-Request") != null) {
            return "fragments/file-map :: content";
        }
            */

        int userLevel = users.getLevel();
        return "index";
    } 

  

    } 