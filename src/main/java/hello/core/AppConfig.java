package hello.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

//스프링 컨테이너로 등록된 객체 = 스프링 빈 
@Configuration
public class AppConfig {

	//AppConfig에서 구현 객체를 생성 
	//생성자로 의존성 주입 -> 생성자 주입 injection / DI(Dependency Injection) 의존관계주
	@Bean
	public MemberService memberService() {
		return new MemberServiceImpl(memberRepository());
	}

	@Bean
	public OrderService orderService() {
		return new OrderServiceImpl(memberRepository(), discountPolicy());
	}

	@Bean
	public MemberRepository memberRepository() {
		return new MemoryMemberRepository();// 메모리든 DB든 추후 수정 시 여기만 바꾸면 된다.
	}
	
	@Bean
	public DiscountPolicy discountPolicy() {
		//return new FixDiscountPolicy();// 정액이든 정률이든 추후 수정 시 여기만 바꾸면 된다.
		return new RateDiscountPolicy();
	}
	
}
