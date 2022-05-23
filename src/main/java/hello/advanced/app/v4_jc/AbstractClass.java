package hello.advanced.app.v4_jc;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractClass {
    private final LogTrace trace;

    public void execute(String message) {
        TraceStatus status = null;
        try{
            status = trace.begin(message);
            call();
            trace.end(status);
        }catch (Exception e){
            trace.exception(status, e);
            throw e;
        }
    }
    protected  abstract void call();
}
