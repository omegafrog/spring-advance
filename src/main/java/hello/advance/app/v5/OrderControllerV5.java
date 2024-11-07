package hello.advance.app.v5;

import hello.advance.logtrace.LogTrace;
import hello.advance.trace.callback.LogTraceTemplate;
import hello.advance.trace.callback.TraceCallBack;
import hello.advance.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/v4")
public class OrderControllerV5 {

    private final OrderServiceV5 orderServiceV5;
    private final LogTrace trace;

    @GetMapping("/request")
    public String request(String itemId) {
        LogTraceTemplate template = new LogTraceTemplate(trace);
        return template.execute("OrderController.request()",
                new TraceCallBack<String>() {
                    @Override
                    public String call() {
                        orderServiceV5.orderItem(itemId);
                        return "ok";
                    }
                });
    }
}
