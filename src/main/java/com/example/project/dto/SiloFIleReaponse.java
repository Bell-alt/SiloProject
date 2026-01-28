package com.example.project.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SiloFIleReaponse {

    private String user_name;
    private String user_phone;
    private Long file_idx;
    private String content;
    private String file_type;
    private int requiredLevel;
    private boolean hasAccess;

}
