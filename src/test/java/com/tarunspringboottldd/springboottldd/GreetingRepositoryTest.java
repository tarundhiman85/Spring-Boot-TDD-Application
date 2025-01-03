package com.tarunspringboottldd.springboottldd;

import com.tarunspringboottldd.springboottldd.Constants.MessageConstants;
import com.tarunspringboottldd.springboottldd.Models.Greeting;
import com.tarunspringboottldd.springboottldd.Repository.GreetingRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class GreetingRepositoryTest {

    @Autowired
    private GreetingRepository greetingRepository;

    @Test
    public void testSaveAndRetrieveGreeting() {
        // Arrange
        Greeting greeting = new Greeting();
        greeting.setMessage(MessageConstants.HELLO_DATABASE);

        // Act
        Greeting savedGreeting = greetingRepository.save(greeting);
        Greeting retrievedGreeting = greetingRepository.findById(savedGreeting.getId()).orElse(null);

        // Assert
        assertNotNull(retrievedGreeting);
        assertEquals(MessageConstants.HELLO_DATABASE, retrievedGreeting.getMessage());
    }
}

