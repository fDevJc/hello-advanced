package hello.advanced.trace.logtrace;

import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

class ThreadLocalLogTraceTest {
    ThreadLocalLogTrace trace = new ThreadLocalLogTrace();

    @Test
    void begin_end() {
        TraceStatus status = trace.begin("hello");
        TraceStatus status1 = trace.begin("helooooooo");
        trace.end(status1);
        trace.end(status);
    }

    @Test
    void begin_exception() {
        TraceStatus status = trace.begin("hello");
        TraceStatus status1 = trace.begin("helooooooo");
        trace.exception(status1, new IllegalStateException());
        trace.exception(status, new IllegalStateException());
    }

}