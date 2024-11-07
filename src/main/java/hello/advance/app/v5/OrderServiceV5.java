package hello.advance.app.v5;

import hello.advance.logtrace.LogTrace;
import hello.advance.trace.callback.LogTraceTemplate;
import hello.advance.trace.callback.TraceCallBack;
import hello.advance.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceV5 {

    private final OrderRepositoryV5 orderRepositoryV5;
    private final LogTraceTemplate template;

    public OrderServiceV5(OrderRepositoryV5 orderRepositoryV5, LogTrace trace) {
        this.orderRepositoryV5 = orderRepositoryV5;
        this.template = new LogTraceTemplate(trace);
    }

    public void orderItem(String itemId){
        template.execute("OrderService.orderItem()",
                new TraceCallBack<Void>() {
                    @Override
                    public Void call() {
                        orderRepositoryV5.save(itemId);
                        return null;
                    }
                });
    }
}
