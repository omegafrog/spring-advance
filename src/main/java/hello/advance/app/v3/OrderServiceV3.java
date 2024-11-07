package hello.advance.app.v3;

import hello.advance.logtrace.LogTrace;
import hello.advance.trace.TraceStatus;
import hello.advance.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
// 문제 : 비즈니스 로직에 필요 없는 것들이 너무 많이 포함된다.
// traceId가 파라미터로 넘어가야 해서 관련 의존 코드를 모두 바꿔야함
@Service
@RequiredArgsConstructor
public class OrderServiceV3 {

    private final OrderRepositoryV3 orderRepositoryV3;
    private final LogTrace trace;

    public void orderItem( String itemId){
        TraceStatus status = null;
        try {
            status = trace.begin("OrderService.request()");
            orderRepositoryV3.save( itemId);
            trace.end(status);
        }catch (RuntimeException e){
            trace.exception(status, e);
            throw e;
        }
    }
}
