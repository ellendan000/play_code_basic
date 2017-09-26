package net.shadow.withspring.feign.simple;

import net.shadow.withspring.feign.target.InvalidIdException;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "invokeClient", url = "localhost:8989/api")
public interface InvokeClient {

    /**
     * ##远端调用失败##
     * feign.hystrix.enabled=false时，FeignException
     * message:
     * status 400 reading InvokeClient01#name(String); content:
     * {"timestamp":1503656322499,
     * "status":400,
     * "error":"Bad Request",
     * "exception":"net.shadow.withspring.feign.target.InvalidIdException",
     * "message":"This id is invalid.",
     * "path":"/api/target/9"
     * }.
     * <p>
     * feign.hystrix.enabled=true时：HystrixRuntimeException
     * message:
     * InvokeClient#name(String) failed and no fallback available.
     * <p>
     * 这里声明InvalidIdException（RuntimeException）无用，并不会主动接收且封装远端的异常。
     * 顶多用做声明式异常，显式提醒、强制调用者强制处理异常。
     */
    @GetMapping("/target/{id}")
    public String name(@PathVariable("id") String id) throws InvalidIdException;

}
