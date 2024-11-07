package hello.advance.app.v3;

import hello.advance.logtrace.FieldLogTrace;
import hello.advance.logtrace.LogTrace;
import hello.advance.trace.TraceStatus;
import hello.advance.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 동시성 문제 발생. 여러 스레드에서 threadHolder를 접근해 수정함.
@RestController
@RequiredArgsConstructor
@RequestMapping("/v3")
public class OrderControllerV3 {

    private final OrderServiceV3 orderServiceV3;
    private final LogTrace trace;

    @GetMapping("/request")
    public String request(String itemId) {
        TraceStatus status = null;
        try {
            status = trace.begin("OrderController.request()");
            orderServiceV3.orderItem(itemId);
            trace.end(status);
        }catch (RuntimeException e){
            trace.exception(status, e);
            throw e;
        }
        return "ok";
    }
}
