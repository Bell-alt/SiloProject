package com.example.project.dto;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class LoginDTO {
    
    @NotBlank(message="아이디를 입력해주세요")
    private String memberID;

    @NotBlank(message = "비밀번호를 입력해주세요")
    private String memberPass;

}
