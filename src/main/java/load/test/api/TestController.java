package load.test.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/test")
@Slf4j
public class TestController {

    @GetMapping("/hello")
    public String hello() {
        double randomNum = Math.random();
        int value = (int)(randomNum * 10);
        try {
            log.info("Call hello-! before sleep: " + System.currentTimeMillis());
            Thread.sleep(value * 1000L);
            log.info("Call hello-! after sleep: " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Hello!";
    }

    @PostMapping("/echo")
    public Map<String, String> echo(@RequestBody Map<String, String> request) {
        double randomNum = Math.random();
        int value = (int)(randomNum * 10);
        try {
            Thread.sleep(value * 1000L);
            log.info("Call echo method-!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return request;
    }
}
