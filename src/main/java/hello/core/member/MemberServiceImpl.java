package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService {
	
//	private final MemberRepository memberRepository = new MemoryMemberRepository(); // DIP 위반. 추상화, 구체화에 의존 
	
	//추상화에만 의존, 구체화에 대한 의존은 AppConfig에서 설정한다.
	private final MemberRepository memberRepository;
	
	@Autowired
	public MemberServiceImpl(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	@Override
	public void join(Member member) {
		memberRepository.save(member);
	}

	@Override
	public Member findMember(Long memberId) {
		return memberRepository.findById(memberId);
	}
	
	//테스트 용도
	public MemberRepository getMemberRepository() {
		return memberRepository;
	}

}
