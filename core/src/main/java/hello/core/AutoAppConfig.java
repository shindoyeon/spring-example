package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "hello.core.member",
        basePackageClasses = AutoAppConfig.class,  //AutoAppConfig의 패키지인 hello.core를 탐색 시작 위치로 지정
        //만약 basePackages, basePackageClasses 를 지정하지 않으면 @ComponentScan이 붙은 설정  정보 클래스의 패키지가 시작 위치가 된다.(hello.core)
        excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
/*    //기존에 있던 빈이랑 동일한 이름으로 빈 등록함 -> 수동 빈 등록이 우선권을 가짐(오버라이딩 됨)
    @Bean(name = "memoryMemberRepository")
    MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }*/
}
