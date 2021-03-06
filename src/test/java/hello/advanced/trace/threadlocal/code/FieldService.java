package hello.advanced.trace.threadlocal.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FieldService {
    private String nameStore;

    public String logic(String name) {
        System.out.println(Thread.currentThread().getName());
        log.info("์ ์ฅ name={} -> nameStore={}", name, nameStore);
        nameStore = name;
        sleep(1000);
        log.info("์กฐํ nameStore={}", nameStore);
        return nameStore;
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
