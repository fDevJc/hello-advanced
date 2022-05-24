package hello.advanced.app.v5_jc;

import hello.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class OrderControllerV5JC {

    private final OrderServiceV5JC orderService;
    private final LogTrace trace;

    @GetMapping("/v5jc/request")
    public String request(String itemId) {
        TraceTemplateJC<String> template = new TraceTemplateJC(trace);

        return template.execute(() -> {
            orderService.orderItem(itemId);
            return "ok";
        }, "OrderController.request()");
    }
}
