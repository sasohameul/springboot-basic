package com.simple.basic.command;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberVO {
	
	@Pattern(message="영문자, 숫자 8자 이상입니다.", regexp="[a-zA-Z0-9]{8,}")
	@NotBlank (message="아이디 입력은 필수입니다.")
	private String id;
	
	@Pattern(message="비밀번호 영문자, 숫자, 특수문자 조합 8글자 이상입니다." ,regexp="^(?=.*[a-zA-Z])(?=.*\\d)(?=.*\\W).{8,}$")
	@NotBlank
	private String pw;

}
