package net.shadow.withspring.feign;

import net.shadow.withspring.feign.target.InvalidIdException;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "invokeClient", url = "localhost:8989/api")
public interface InvokeClient {

    @GetMapping("/target/{id}")
    public String name(@PathVariable("id") String id) throws InvalidIdException;

}
