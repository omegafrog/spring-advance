package hello.advance.app.v2;

import hello.advance.trace.TraceStatus;
import hello.advance.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v2")
public class OrderControllerV2 {

    private final OrderServiceV2 orderServiceV2;
    private final HelloTraceV2 trace;

    @GetMapping("/request")
    public String request(String itemId) {
        TraceStatus status = null;
        try {
            status = trace.begin("OrderController.request()");
            orderServiceV2.orderItem(status, itemId);
            trace.end(status);
        }catch (RuntimeException e){
            trace.exception(status, e);
            throw e;
        }
        return "ok";
    }
}
