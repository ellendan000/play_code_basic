package net.shadow.withspring.feign.target;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/target")
public class TargetController {

    @GetMapping("/{id}")
    public String name(@PathVariable String id) {
        boolean flag = Optional.of(id)
                .orElse("")
                .length() > 0;

        if (flag) {
            return "EllenDan";
        } else {
            throw new InvalidIdException();
        }
    }
}
