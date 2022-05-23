package hello.advanced.app.v4_jc;

import hello.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrderServiceV4JC {

    private final OrderRepositoryV4JC orderRepository;
    private final LogTrace trace;

    public void orderItem(String itemId) {
        AbstractClass abstractClass = new AbstractClass(trace) {
            @Override
            protected void call() {
                orderRepository.save(itemId);
            }
        };
        abstractClass.execute("OrderService.orderItem()");
    }
}
