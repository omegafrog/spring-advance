package hello.advance.strategy;

import hello.advance.strategy.code.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;


@Slf4j
public class ContextTest {
    @Test
    void templateMethodV0(){
        logic1();
        logic2();
    }
    private void logic1(){

        long startTime = System.currentTimeMillis();
        //비즈니스 로직 실행
        log.info("비즈니스 로직1 실행");
        //비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }

    private void logic2(){

        long startTime = System.currentTimeMillis();
        //비즈니스 로직 실행
        log.info("비즈니스 로직2 실행");
        //비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }

    @Test
    void contextTest(){
        Context context = new Context();
        context.setStrategy(new LogicStrategy1());
        context.execute();
        context.setStrategy(new LogicStrategy2());
        context.execute();
    }
    @Test
    void contextTestV2(){
        Context context = new Context();
        context.setStrategy(() -> log.info("비즈니스 로직 1"));
        context.execute();

        context.setStrategy(() -> log.info("비즈니스 로직 2"));
        context.execute();
    }

    @Test
    void contextTestV3(){
        ContextV2 context = new ContextV2();
        context.execute(new LogicStrategy2());
        context.execute(new LogicStrategy1());
    }
}
