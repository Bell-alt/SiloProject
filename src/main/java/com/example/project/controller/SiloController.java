package com.example.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.project.dto.SiloFile;

import jakarta.servlet.http.HttpServletRequest;
import reactor.netty.http.server.HttpServerRequest;

@Controller
public class SiloController {
    
    @GetMapping("/")
    public String indexS(Model model,SiloFile file){
        model.addAttribute("files", file);
        return "index";
    }
    
    @GetMapping("/menu/silo-map")
    public String siloMap(Model model, HttpServletRequest request){

        if(request.getHeader("HX-Request")) != null {
            return "/fragments/file-map :: content";
        }

    } 