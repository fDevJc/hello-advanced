package hello.advanced.app.v4_jc;

import hello.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class OrderRepositoryV4JC {
    private final LogTrace trace;

    public void save(String itemId) {
        AbstractClass abstractClass = new AbstractClass(trace) {
            @Override
            protected void call() {
                sleep(1000);
            }
        };
        abstractClass.execute("OrderRepository.save()");
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
