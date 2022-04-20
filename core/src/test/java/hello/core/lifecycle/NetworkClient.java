package hello.core.lifecycle;

import javax. annotation.PostConstruct;
import javax.annotation.PreDestroy;

//InitializingBean, DisposableBean: 인터페이스를 사용하는 초기화, 종료 방법(스프링 초기, 현재는 거의 사용하지 않음)
public class NetworkClient {

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
    }

    public void setUrl(String url) {
        System.out.println("NetworkClient.setUrl");
        this.url = url;
    }

    //서비스 시작 시 호출
    public void connect() {
        System.out.println("connect: " + url);
    }

    public void call(String message) {
        System.out.println("call: " + url + "message = " + message);
    }

    //서비스 종료 시 호출
    public void disconnect() {
        System.out.println("close: " + url);
    }

    //애노테이션 사용하여 빈 등록 초기화, 최근 스프링에서 가장 권장하는 방법
    @PostConstruct
    public void init() throws Exception {
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메시지");
    }

    @PreDestroy
    public void close() throws Exception {
        System.out.println("NetworkClient.close");
        disconnect();
    }
}
