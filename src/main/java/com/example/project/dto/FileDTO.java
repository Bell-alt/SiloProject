package com.example.project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FileDTO {

    private Long file_id;
    private String file_name;
    private String content;
    private String file_type;
    private int required_level;
    private String hasAccess;


}
