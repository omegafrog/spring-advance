package hello.advance.app.v2;

import hello.advance.trace.TraceStatus;
import hello.advance.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
// 문제 : 비즈니스 로직에 필요 없는 것들이 너무 많이 포함된다.
// traceId가 파라미터로 넘어가야 해서 관련 의존 코드를 모두 바꿔야함
@Service
@RequiredArgsConstructor
public class OrderServiceV2 {

    private final OrderRepositoryV2 orderRepositoryV2;
    private final HelloTraceV2 trace;

    public void orderItem(TraceStatus prevStatus, String itemId){
        TraceStatus status = null;
        try {
            status = trace.beginSync(prevStatus.getTraceId(), "OrderController.request()");
            orderRepositoryV2.save(status, itemId);
            trace.end(status);
        }catch (RuntimeException e){
            trace.exception(status, e);
            throw e;
        }
    }
}
