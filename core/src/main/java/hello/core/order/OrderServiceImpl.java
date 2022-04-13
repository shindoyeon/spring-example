package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor    //생성자 함수 만들어 줌(기존 생성자 함수 주석 처리)
public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    //필드 주입
    /*@Autowired private MemberRepository memberRepository;
    @Autowired private DiscountPolicy discountPolicy;*/

/*    private MemberRepository memberRepository;
    private DiscountPolicy discountPolicy;*/

    /*//수정자 주입(setter 주입) - 선택, 변경 가능성이 있는 의존관계에서 사용
    @Autowired
    public void setMemberRepository(MemberRepository memberRepository) {
        System.out.println("memberRepository = " + memberRepository);
        this.memberRepository = memberRepository;
    }

    //수정자 주입(setter 주입)
    @Autowired
    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
        System.out.println("discountPolicy = " + discountPolicy);
        this.discountPolicy = discountPolicy;
    }*/

    //이 생성자 함수에 의존성 주입이 필요함 ->  @Autowired를 통해 자동의존관계주입(생성자가 하나인 경우 생략 가능!)
    //@Autowired 는 1. 타입 매칭, 2. 타입 매칭의 결과가 2개 이상일 때 필드명, 파라미터명으로 빈 이름 매칭
   @Autowired
    //생성자 주입
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
       System.out.println("1. OrderServiceImpl.OrderServiceImpl");
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice) ;
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
