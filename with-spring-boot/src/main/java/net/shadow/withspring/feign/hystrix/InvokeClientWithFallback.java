package net.shadow.withspring.feign.hystrix;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "invokeClientWithCallback", url = "localhost:8989/api",
        fallback = InvokeClientFallback.class)
public interface InvokeClientWithFallback {

    @GetMapping("/target/{id}")
    public String nameFallbackString(@PathVariable("id") String id);

    @GetMapping("/target/{id}")
    public String nameFallbackException(@PathVariable("id") String id);

}

