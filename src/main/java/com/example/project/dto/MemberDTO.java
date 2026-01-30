package com.example.project.dto;

import com.example.project.config.MemberRole;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberDTO {

    private Integer member_idx;

    private String member_id;

     private String member_pass;

     private String member_pass2;

    private String member_name;
    
    private MemberRole role;

}
