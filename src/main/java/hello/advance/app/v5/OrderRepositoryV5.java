package hello.advance.app.v5;

import hello.advance.logtrace.LogTrace;
import hello.advance.trace.callback.LogTraceTemplate;
import hello.advance.trace.callback.TraceCallBack;
import hello.advance.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository

public class OrderRepositoryV5 {

    private final LogTraceTemplate template;

    public OrderRepositoryV5(LogTrace trace) {
        this.template = new LogTraceTemplate(trace);
    }

    public void save(String itemId) {
        template.execute("OrderRepository.save()",
                new TraceCallBack<Void>() {
                    @Override
                    public Void call() {
                        if (itemId.equals("ex")) {
                            throw new IllegalStateException("예외 발생!");
                        }
                        sleep(1000);
                        return null;
                    }
                });
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
