package hello.advance.trace.template;

import hello.advance.logtrace.LogTrace;
import hello.advance.trace.TraceStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public abstract class AbstractTemplate<T> {
    private final LogTrace trace;
    public T execute(String message){
        TraceStatus status = null;
        try {
            status = trace.begin(message);
            T result = call();
            trace.end(status);
            return result;
        }catch (RuntimeException e){
            trace.exception(status, e);
            throw e;
        }
    }
    protected abstract T call();
}
