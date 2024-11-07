package hello.advance.trace.callback;


import hello.advance.logtrace.LogTrace;
import hello.advance.trace.TraceStatus;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class LogTraceTemplate {
    private final LogTrace trace;

    public <T> T execute(String message, TraceCallBack<T> traceCallBack) {
        TraceStatus status = null;
        try {
            status = trace.begin(message);
            T result = traceCallBack.call();
            trace.end(status);
            return result;
        }catch (RuntimeException e){
            trace.exception(status, e);
            throw e;
        }
    }
}
