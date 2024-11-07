package hello.advance.template;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateCallbackTest {
    @Test
    void templateCallBackTestV1(){
        TimeLogTemplate template = new TimeLogTemplate();

        template.execute(new Callback() {
            @Override
            public void call() {
                log.info("비즈니스 로직1 실행");
            }
        });
    }
    @Test
    void templateCallBackTestV2(){
        TimeLogTemplate template = new TimeLogTemplate();

        template.execute(() -> log.info("비즈니스 로직1 실행"));
    }
}
