package hello.advance.app.v4;

import hello.advance.logtrace.LogTrace;
import hello.advance.trace.TraceStatus;
import hello.advance.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/v4")
public class OrderControllerV4{

    private final OrderServiceV4 orderServiceV4;
    private final LogTrace trace;

    @GetMapping("/request")
    public String request(String itemId) {
        AbstractTemplate<String> template = new AbstractTemplate<>(trace) {
            @Override
            protected String call() {
                orderServiceV4.orderItem(itemId);
                return "ok";
            }

        };
        return template.execute("OrderController.request()");
    }
}
