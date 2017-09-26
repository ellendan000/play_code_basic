package net.shadow.withspring.feign.hystrix;

import org.springframework.stereotype.Component;

@Component
public class InvokeClientFallback implements InvokeClientWithFallback {
    @Override
    public String nameFallbackString(String id) {
        return "defaultName";
    }

    @Override
    public String nameFallbackException(String id) {
        throw new RuntimeException("There is some thing wrong.");
    }
}
