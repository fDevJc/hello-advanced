package hello.advanced.app.v5_jc;

import hello.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrderServiceV5JC {

    private final OrderRepositoryV5JC orderRepository;
    private final LogTrace trace;

    public void orderItem(String itemId) {
        TraceTemplateJC<Void> template = new TraceTemplateJC(trace);
        template.execute(() -> {
            orderRepository.save(itemId);
            return null;
        }, "OrderService.orderItem()");
    }
}
