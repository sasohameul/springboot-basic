package com.simple.basic;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.simple.basic.command.BuilderVO;
import com.simple.basic.command.BuilderVO.Builder;
import com.simple.basic.command.BuilderVO2;

@SpringBootTest //springBoot test class
public class JDBCTest {

	//빌더 패턴의 확인
	@Test
	public void testCode01() {
		
//		Builder b = BuilderVO.builder();	
//		b = b.age(10);
//		b = b.name("홍길동");
//		BuilderVO vo = b.build();
//		System.out.println(vo.toString());
		
		//vo는 setter가 없기때문에 객체불변성을 보장한다.
		BuilderVO vo = BuilderVO.builder().age(10).name("홍길동").build();
		
		System.out.println(vo.toString());
		
		BuilderVO2 vo2 = BuilderVO2.builder().name("이순").age(20).build();
		
		System.out.println(vo2.toString());
		
		
	
	}
	
	
	
}
