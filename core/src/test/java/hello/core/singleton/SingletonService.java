package hello.core.singleton;

import org.apache.logging.log4j.status.StatusConsoleListener;

public class SingletonService {
    //객체를 하나만 만들 수 있도록 private static 으로 접근자 설정
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){
        return instance;
    }

    private SingletonService(){
    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }


}
