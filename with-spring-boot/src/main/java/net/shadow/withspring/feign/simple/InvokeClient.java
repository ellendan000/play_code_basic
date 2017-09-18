package net.shadow.withspring.feign.simple;

import net.shadow.withspring.feign.target.InvalidIdException;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "invokeClient", url = "localhost:8989/api")
public interface InvokeClient {

    //FeignException:
    //message:
    //status 400 reading InvokeClient01#name(String); content:
    //{"timestamp":1503656322499,
    // "status":400,
    // "error":"Bad Request",
    // "exception":"net.shadow.withspring.feign.target.InvalidIdException",
    // "message":"This id is invalid.",
    // "path":"/api/target/9"
    // }
    @GetMapping("/target/{id}")
    public String name(@PathVariable("id") String id) throws InvalidIdException;

}
