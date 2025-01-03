package com.tarunspringboottldd.springboottldd.Controller;
import com.tarunspringboottldd.springboottldd.Helpers.Helpers;
import com.tarunspringboottldd.springboottldd.Constants.MessageConstants;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greet")
public class GreetController {

        @RequestMapping("/hello/{name}")
        public String sayHello(@PathVariable String name) {
            new Helpers().validateName(name);
            return String.format(MessageConstants.GREETING_MESSAGE, name);
        }

}
