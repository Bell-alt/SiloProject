package com.example.project.dto;

import com.example.project.config.MemberRole;
import com.google.firebase.database.annotations.NotNull;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MemberJoinDTO {

    	
	private Integer member_idx;
	
	@NotBlank(message="아이디를 입력해주세요")
	@Size(min=4, max=20, message="아이디는 영어 대소문자와 숫자만 사용가능하며 4~20글자여야합니다")
	@Pattern(regexp = "^[a-zA-Z0-9]{4,20}$")
	private String member_id;
	
	@NotBlank(message="이름을 입력해주세요")
	private String member_name;
	
	@NotBlank(message="비밀번호를 입력해주세요")
	@Size(min=8, max=30, message="비밀번호는 영문, 숫자,특수문자를 모두 포함하여 8자 이상 입력해야 합니다 ")
	@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[!@#$%^&*()_+=-]).{8,}$")
	private String member_pass;

	private MemberRole role;
	
	//private boolean deleted;
	//private LocalDateTime deletedAt;

}
