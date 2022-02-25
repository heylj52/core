package hello.core.discount;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;

@Component
@Primary //빈이 여러개 등록될 때 우선순위를 가진다. @Quilify, @Autowired에 이름을 등록해서 사용해도 된다.
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy {

	private int discountPercent = 10;
	
	@Override
	public int discount(Member member, int price) {
		if(member.getGrade() == Grade.VIP) {
			return price * discountPercent / 100;
		}else {
			return 0;
		}
	}
		
	
	
}
