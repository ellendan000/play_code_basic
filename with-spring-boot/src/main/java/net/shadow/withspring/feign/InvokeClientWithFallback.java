package net.shadow.withspring.feign;

import net.shadow.withspring.feign.hystrix.InvokeClientFallbackFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "invokeClientWithCallback", url = "localhost:8001",
//        fallback = InvokeClientFallback.class)
        fallbackFactory = InvokeClientFallbackFactory.class)
public interface InvokeClientWithFallback {

    @GetMapping("/user/{id}/username")
    public String nameFallbackString(@PathVariable("id") String id);

    @GetMapping("/user/{id}/username")
    public String nameFallbackException(@PathVariable("id") String id);

}

