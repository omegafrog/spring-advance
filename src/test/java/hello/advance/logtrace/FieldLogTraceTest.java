package hello.advance.logtrace;

import hello.advance.trace.TraceStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FieldLogTraceTest {

    FieldLogTrace trace = new FieldLogTrace();
    @Test
    void begin_end(){
        TraceStatus status1 = trace.begin("hi1");
        TraceStatus status2= trace.begin("hi2");
        trace.end(status2);
        trace.end(status1);
    }

    @Test
    void begin_exception(){
        FieldLogTrace trace = new FieldLogTrace();
        TraceStatus status = trace.begin("hi");
        trace.exception(status, new IllegalStateException());
    }

}