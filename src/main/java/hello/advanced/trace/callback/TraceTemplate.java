package hello.advanced.trace.callback;

import hello.advanced.app.v5_jc.Callback;
import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TraceTemplate {
    private final LogTrace trace;

    public <T> T execute(Callback<T> callback, String message) {
        TraceStatus status = null;
        try{
            status = trace.begin(message);
            T result = callback.call();
            trace.end(status);
            return result;
        }catch (Exception e){
            trace.exception(status, e);
            throw e;
        }
    }
}
