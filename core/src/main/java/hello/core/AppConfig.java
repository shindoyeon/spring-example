package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig  {
    //역할
    @Bean //스프링컨테이너에 등록됨
    public MemberService memberService(){
        //이 반환된 객체를 스프링 컨테이너에 등록 -> 등록된 객체를 스프링 빈 객체라고 한다
        return new MemberServiceImpl(memberRepository());
    }

    //구현(나중에 변경할 일이 있을 경우 구현부만 수정하면 된다.)
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    //역할
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    //구현
    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }
}
