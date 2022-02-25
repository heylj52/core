package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
		basePackages = "hello.core",//default는 ComponentScan을 붙은 클래스 패키지 위치. 생략가능 하도록 최상단에 설정파일을 둠
		excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
	)
public class AutoAppConfig {

//	@Bean(name = "memoryMemberRepository")
//	public MemberRepository memberRepository() { //수동 빈이 자동 빈을 오버라이딩한다. 하지만 스프링 부트에서는 에러나도록 바뀌었다. spring.main.allow-bean-definition-overriding=false 
//		return new MemoryMemberRepository();
//	}
	
}
