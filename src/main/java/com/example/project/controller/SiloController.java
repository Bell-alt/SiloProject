package com.example.project.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.project.dto.SiloFile;
import com.example.project.mapper.SIloMapper;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import reactor.netty.http.server.HttpServerRequest;

@Controller
@RequiredArgsConstructor
public class SiloController {

    private final SIloMapper sIloMapper;
    
    @GetMapping("/")
    public String indexS(Model model,SiloFile file){
        model.addAttribute("files", file);
        return "index";
    }
    
    @GetMapping("/menu/silo-map")
    public String siloMap(Model model, HttpServletRequest request){
        
       List<SiloFile> silos = sIloMapper.fildAllSilos();
       model.addAttribute("silos", silos);


        if(request.getHeader("HX-Request") != null) {
            return "fragments/file-map :: content";
        }
        return "index";
    } 

  

    } 