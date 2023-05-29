package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping
@RestController
public class FirstController {
    @GetMapping
    public String showHelloWorld() {
        return "Hello World";
    }
}