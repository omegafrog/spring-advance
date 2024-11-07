package hello.advance.app.v3;

import hello.advance.logtrace.LogTrace;
import hello.advance.trace.TraceStatus;
import hello.advance.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV3 {

    private final LogTrace trace;

    public void save(String itemId) {

        TraceStatus status = null;
        try {
            status = trace.begin( "OrderRepository.request()");
            doSave(itemId);
            trace.end(status);
        } catch (RuntimeException e) {
            trace.exception(status, e);
            throw e;
        }

    }

    private void doSave(String itemId) {
        if (itemId.equals("ex")) {
            throw new IllegalArgumentException("예외");
        }
        sleep(1000);
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
