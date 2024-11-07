package hello.advance.app.trace.hellotrace;

import hello.advance.trace.TraceStatus;
import hello.advance.trace.hellotrace.HelloTraceV1;
import org.junit.jupiter.api.Test;


class HelloTraceV1Test {
    @Test
    void begin_end(){
        HelloTraceV1 helloTraceV1 = new HelloTraceV1();
        TraceStatus status = helloTraceV1.begin("hello");
        helloTraceV1.end(status);
    }
    @Test
    void begin_exception(){
        HelloTraceV1 helloTraceV1 = new HelloTraceV1();
        TraceStatus status = helloTraceV1.begin("hello");
        helloTraceV1.exception(status,new IllegalStateException());
    }
}