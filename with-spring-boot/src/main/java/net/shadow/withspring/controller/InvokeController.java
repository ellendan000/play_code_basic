package net.shadow.withspring.controller;

import net.shadow.withspring.feign.InvokeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/remote-invoke")
public class InvokeController {
    @Autowired
    private InvokeClient invokeClient;

    @GetMapping("/success")
    public String success() {
        return invokeClient.name("001");
    }

    @GetMapping("/failed")
    public String failed() {
        try {
            return invokeClient.name("1");
        } catch (Exception e) {
            return e.getMessage();
        }
    }

}