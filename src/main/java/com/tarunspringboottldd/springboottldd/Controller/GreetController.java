package com.tarunspringboottldd.springboottldd.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greet")
public class GreetController {

        @RequestMapping("/hello/{name}")
        public String sayHello(@PathVariable String name) {
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("Name cannot be empty");
            }
            return "Hello, " + name + " Welcome to Spring Boot";
        }
}
