package com.example.project.dto;

import com.example.project.config.MemberRole;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberDTO {

    private Integer memberIdx;

    private String memberId;

    private String memberName;

    private String memberPass;
    
    private MemberRole role;

}
