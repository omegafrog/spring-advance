package hello.advance.app.v0;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v0")
public class OrderControllerV0 {

    private final OrderServiceV0 orderServiceV0;

    @GetMapping("/request")
    public String request(String itemId) {
        orderServiceV0.orderItem(itemId);
        return "ok";
    }
}
