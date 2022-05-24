package hello.advanced.app.v5_jc;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TraceTemplateJC<T> {
    private final LogTrace trace;

    public T execute(Callback<T> callback, String message) {
        TraceStatus status = null;
        try{
            status = trace.begin(message);
            T t = callback.call();
            trace.end(status);
            return t;
        }catch (Exception e){
            trace.exception(status, e);
            throw e;
        }
    }
}
