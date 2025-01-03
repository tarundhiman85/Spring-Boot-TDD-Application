package com.tarunspringboottldd.springboottldd;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.tarunspringboottldd.springboottldd.Controller.GreetController;
import org.junit.Test;


public class GreetTest {

    @Test
    public void testSayHello() {
        GreetController greetController = new GreetController();
        String result = greetController.sayHello("John");
        assertEquals("Hello, John Welcome to Spring Boot", result);
    }
    @Test
    public void testSayHelloWithEmptyName() {
        GreetController greetController = new GreetController();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            greetController.sayHello("");
        });
        assertEquals("Name cannot be empty", exception.getMessage());
    }
}
