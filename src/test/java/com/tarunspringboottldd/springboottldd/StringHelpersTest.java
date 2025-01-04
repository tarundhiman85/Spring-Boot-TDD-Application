package com.tarunspringboottldd.springboottldd;

import com.tarunspringboottldd.springboottldd.Helpers.StringHelpers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringHelpersTest {
    @Test
    public void testAdd_EmptyString_ShouldReturnZero() {
        StringHelpers calculator = new StringHelpers();
        assertEquals(0, calculator.Add(""));
    }
}
