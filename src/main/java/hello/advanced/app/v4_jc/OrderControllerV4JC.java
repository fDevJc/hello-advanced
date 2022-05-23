package hello.advanced.app.v4_jc;

import hello.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class OrderControllerV4JC {

    private final OrderServiceV4JC orderService;
    private final LogTrace trace;

    @GetMapping("/v4_jc/request")
    public String request(String itemId) {
        AbstractClass abstractClass = new AbstractClass(trace) {
            @Override
            protected void call() {
                orderService.orderItem(itemId);
            }
        };
        abstractClass.execute("OrderController.request()");
        return "ok";
    }
}
