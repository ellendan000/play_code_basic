package net.shadow.withspring.feign.simple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/invoke")
public class InvokeController {
    @Autowired
    private InvokeClient invokeClient;

    @GetMapping("/success")
    public String success() {
        try {
            return invokeClient.name("ok");
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @GetMapping("/failed")
    public String failed() {
        try {
            return invokeClient.name("");
        } catch (Exception e) {
            return e.getMessage();
        }
    }

}