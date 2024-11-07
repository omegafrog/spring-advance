package hello.advance.app.v1;

import hello.advance.trace.TraceStatus;
import hello.advance.trace.hellotrace.HelloTraceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV1 {

    private final OrderRepositoryV1 orderRepositoryV1;
    private final HelloTraceV1 trace;

    public void orderItem(String itemId){
        TraceStatus status = null;
        try {
            status = trace.begin("OrderController.request()");
            orderRepositoryV1.save(itemId);
            trace.end(status);
        }catch (RuntimeException e){
            trace.exception(status, e);
            throw e;
        }
    }
}
