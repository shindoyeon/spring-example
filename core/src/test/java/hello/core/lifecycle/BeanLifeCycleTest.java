package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    public void lifeCycleTest() {
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close();
    }

    @Configuration
    static class LifeCycleConfig {

        //빈 등록 초기화, 소멸(destroyMethod는 추론 기능이 있기 때문에 'close', 'shutdown' 이라는 이름을 자동 호출)
//        @Bean(initMethod = "init", destroyMethod = "close")
        @Bean
        public NetworkClient networkClient() {
            //생성자 함수 -> setUrl -> afterPropertiesSet -> destroy
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("htto://hello-spring.dev");
            return  networkClient;
        }
    }
}
