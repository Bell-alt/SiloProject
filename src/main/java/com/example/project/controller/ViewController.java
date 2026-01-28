package com.example.project.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.project.dto.FileDTO;

@Controller
public class ViewController {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @GetMapping("/")
    public String main(Model model){

        String sql = "select user_name, user_phone from user";

        List<Map<String,Object>> files = jdbcTemplate.queryForList(sql);
         
        model.addAttribute("files", files);

        return "index";
     
      
   
    }


    @GetMapping("/auth/login")
    public String loginPage(){
        return "auth/login";
    }


}
