package com.example.project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FIleAccessAllowDTO {

    private boolean allowed;
    private String file_id;
    private String message;


}
