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
    @Test
    public void testAddSingleNumberShouldReturnThatNumber() {
        StringHelpers calculator = new StringHelpers();
        assertEquals(5, calculator.Add("5"));
    }
    @Test
    public void testAddTwoNumbersShouldReturnTheirSum() {
        StringHelpers calculator = new StringHelpers();
        assertEquals(3, calculator.Add("1,2"));
    }
    @Test
    public void testAddUnknownAmountOfNumbersShouldReturnTheirSum() {
        StringHelpers calculator = new StringHelpers();
        assertEquals(10, calculator.Add("1,2,3,4"));
    }
    @Test
    public void testAddNewLinesAndCommasShouldReturnSum() {
        StringHelpers calculator = new StringHelpers();
        assertEquals(6, calculator.Add("1\n2,3"));
    }
    @Test
    public void testAdd_CustomDelimiter_ShouldReturnSum() {
        StringHelpers calculator = new StringHelpers();
        assertEquals(3, calculator.Add("//;\n1;2"));
    }

}
