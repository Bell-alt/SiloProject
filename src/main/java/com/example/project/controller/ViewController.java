package com.example.project.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.project.dto.FileDTO;

@Controller
public class ViewController {
    
    @GetMapping("/")
    public String main(Model model){
         
   
       String filePath = "/home/bell/python_project";
       File directory = new File(filePath);

       if(!directory.exists()) directory.mkdirs();

       File[] listFiles = directory.listFiles();

         
        List<FileDTO> files = new ArrayList<>();
        

        if(listFiles != null){
            for(File file : listFiles){
                if(file.isFile()){
                    String fileName = file.getName();
                    String extension = fileName.substring(fileName.lastIndexOf(".")+1);
                }


            }

        }

        return "index";
    }


    @GetMapping("/auth/login")
    public String loginPage(){
        return "auth/login";
    }


}
