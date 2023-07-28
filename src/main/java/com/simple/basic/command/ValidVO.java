package com.simple.basic.command;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ValidVO {
	
	/*
	 * @NotNull = null 허용x (String, Integer, Double 등등)
	 * @NotEmpty = null 허용x, 공백허용x (String 적용)
	 * @NotBlank = null, 공백, whitespace 허용x (String 적용)
	 *
	 * @Pattern = 정규표현식에 일치하지않으면 err
	 * 
	 */
	
	//기본타입 보다는 래퍼타입으로 작성하는 것이 안전.
	@NotEmpty (message = "이름은 필수입니다.")
	private String name;
	
	@NotNull (message = "급여는 숫자로입력하세요.")
	private Integer salary; //int보다 Integer가 더 안전함.(Integer는 null값 허용)
	
	@Pattern(message = "000-0000-0000 형식이어야 합니다.", regexp= "[0-9]{3}-[0-9]{4}-[0-9]{4}")
	private String phone;
	
	@NotBlank(message = "공백일 수 없습니다.")
	@Email (message = "이메일형식이어야 합니다.") //이메일은 공백이 통과
	private String email;
	

}
