package net.shadow.withspring.feign.simple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/invoke")
public class InvokeController {
    @Autowired
    private InvokeClient invokeClient;

    @GetMapping("/{id}")
    public String name(@PathVariable("id") String id) {
        try {
            return invokeClient.name(id);
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}