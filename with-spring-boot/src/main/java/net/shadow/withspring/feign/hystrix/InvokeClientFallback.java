package net.shadow.withspring.feign.hystrix;

import net.shadow.withspring.feign.InvokeClientWithFallback;
import org.springframework.stereotype.Component;

@Component
public class InvokeClientFallback implements InvokeClientWithFallback {
    @Override
    public String nameFallbackString(String id) {
        return "defaultName";
    }

    /**
     * fallback的时候获取不到hystrix、feign返回的exception，但强制throw可以让外层调用的地方
     * 获取hystirx封装好的exception
     */
    @Override
    public String nameFallbackException(String id) {
        throw new RuntimeException("There is some thing wrong.");
    }
}
