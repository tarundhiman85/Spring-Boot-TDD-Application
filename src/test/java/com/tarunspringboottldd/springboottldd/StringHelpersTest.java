package com.tarunspringboottldd.springboottldd;

import com.tarunspringboottldd.springboottldd.Constants.MessageConstants;
import com.tarunspringboottldd.springboottldd.Helpers.StringHelpers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringHelpersTest {
    @Test
    public void testAddEmptyStringShouldReturnZero() {
        StringHelpers calculator = new StringHelpers();
        assertEquals(0, calculator.Add(MessageConstants.EMPTY_STRING));
    }
}
