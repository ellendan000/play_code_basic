package net.shadow.withspring.controller;

import net.shadow.withspring.feign.InvokeClientWithFallback;
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
    public String nameFallbackString() {
        return String.format("Hello > [%s]", invokeClient.nameFallbackString("2"));
    }

    /**
     * HystrixRuntimeException：
     * cause引用FeignException;
     * fallbackException."java.lang.Exception: Throwable caught while executing",
     * cause引用RuntimeException("There is some thing wrong.")
     */
    @GetMapping("/failed/throw-exception")
    public String nameFallbackException() {
        try {
            return String.format("Hello > [%s]", invokeClient.nameFallbackException("2"));
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}