package com.example.project.dto;

import com.example.project.config.MemberRole;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberDTO {

    private Integer memberIdx;

    private String memberId;

    private String memberPass;

    private String memberEmail;

    private String memberAddress;
    
    private MemberRole role;

}
