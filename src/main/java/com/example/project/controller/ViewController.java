package com.example.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    
    @GetMapping("/")
    public String main(Model model){
        
        return "index";
    }


    @GetMapping("/auth/login")
    public String loginPage(){
        return "auth/login";
    }


}
