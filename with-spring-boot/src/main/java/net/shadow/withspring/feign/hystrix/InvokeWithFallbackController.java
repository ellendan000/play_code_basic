package net.shadow.withspring.feign.hystrix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/invoke-with-callback")
public class InvokeWithFallbackController {
    @Autowired
    private InvokeClientWithFallback invokeClient;

    /**
     * 即使发生调用异常，也仍正常返回fallback值。无法看见调用失败表象。
     */
    @GetMapping("/failed")
    public String name() {
        return String.format("Hello > [%s]", invokeClient.nameFallbackString(""));
    }

    /**
     * HystrixRuntimeException：
     * cause引用FeignException
     * fallbackException.cause<AssertionError>.cause引用RuntimeException("There is some thing wrong.")
     */
    @GetMapping("/failed/throw-exception")
    public String nameFallbackException() {
        try {
            return String.format("Hello > [%s]", invokeClient.nameFallbackException(""));
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}