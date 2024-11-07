package hello.advance;

import hello.advance.logtrace.FieldLogTrace;
import hello.advance.logtrace.LogTrace;
import hello.advance.logtrace.ThreadLocalLogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {

    @Bean
    public LogTrace logTrace() {
//        return new FieldLogTrace();
        return new ThreadLocalLogTrace();
    }
}
