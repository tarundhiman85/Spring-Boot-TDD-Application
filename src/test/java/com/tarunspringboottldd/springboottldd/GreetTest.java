package com.tarunspringboottldd.springboottldd;

import static org.junit.Assert.assertEquals;

import com.tarunspringboottldd.springboottldd.Controller.GreetController;
import org.junit.Test;


public class GreetTest {

    @Test
    public void testSayHello() {
        GreetController greetController = new GreetController();
        String result = greetController.sayHello("John");
        assertEquals("Hello, John Welcome to Spring Boot", result);
    }
}
