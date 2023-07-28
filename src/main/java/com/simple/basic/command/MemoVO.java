package com.simple.basic.command;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemoVO {
	
	private int mno;
	
	@NotBlank(message="메모를 입력해주세요")
	private String memo;
	
	@Pattern(message="연락처는 000-0000-0000 11자리입니다.",regexp="[0-9]{3}-[0-9]{4}-[0-9]{4}")
	private String phone;
	
	@Pattern(message="비밀번호는 4자리입니다.",regexp="[0-9]{4}")
	private String pw;
	
	
	private String secret;
	
	
	

}
