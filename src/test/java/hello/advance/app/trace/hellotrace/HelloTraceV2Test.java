package hello.advance.app.trace.hellotrace;

import hello.advance.trace.TraceStatus;
import hello.advance.trace.hellotrace.HelloTraceV2;
import org.junit.jupiter.api.Test;

class HelloTraceV2Test {
    @Test
    void begin_end(){
        HelloTraceV2 helloTraceV1 = new HelloTraceV2();
        TraceStatus status = helloTraceV1.begin("hello");
        helloTraceV1.end(status);
    }
    @Test
    void begin_exception(){
        HelloTraceV2 helloTraceV1 = new HelloTraceV2();
        TraceStatus status = helloTraceV1.begin("hello");
        helloTraceV1.exception(status,new IllegalStateException());
    }

    @Test
    void begin_sync(){
        HelloTraceV2 helloTraceV2 = new HelloTraceV2();
        TraceStatus status1 = helloTraceV2.begin("hello1");
        TraceStatus status2 = helloTraceV2.beginSync(status1.getTraceId(), "hello2");
        helloTraceV2.end(status2);
        helloTraceV2.end(status1);
    }
    @Test
    void begin_sync_exception(){
        HelloTraceV2 helloTraceV2 = new HelloTraceV2();
        TraceStatus status1 = helloTraceV2.begin("hello1");
        TraceStatus status2 = helloTraceV2.beginSync(status1.getTraceId(), "hello2");
        helloTraceV2.exception(status2, new IllegalStateException());
        helloTraceV2.end(status1);
    }
}