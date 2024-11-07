package hello.advance.strategy.code;

public class LogicStrategy1 implements Strategy {
    @Override
    public void call() {
        System.out.println("비즈니스 로직1 실행");
    }
}
