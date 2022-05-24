package hello.advanced.app.v5;

import hello.advanced.trace.callback.TraceTemplate;
import hello.advanced.trace.logtrace.LogTrace;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderControllerV5 {

    private final OrderServiceV5 orderService;
    private final TraceTemplate template;

    public OrderControllerV5(OrderServiceV5 orderService, LogTrace trace) {
        this.orderService = orderService;
        /*
            스프링 빈으로 등록해줘도 되지만
            이렇게 할경우 테스트하기 편해진다.
            컨트롤러, 서비스, 레파지토리에서 인스턴스가 3개가 생성되지만, 메모리 성능상 영향이 적다
         */
        this.template = new TraceTemplate(trace);
    }

    @GetMapping("/v5/request")
    public String request(String itemId) {
        return template.execute(() -> {
            orderService.orderItem(itemId);
            return "ok";
        }, "OrderController.request()");
    }
}
