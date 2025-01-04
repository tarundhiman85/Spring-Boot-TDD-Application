package com.tarunspringboottldd.springboottldd;

import com.tarunspringboottldd.springboottldd.Constants.MessageConstants;
import com.tarunspringboottldd.springboottldd.Helpers.StringHelpers;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThrows;
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
    public void testAddCustomDelimiterShouldReturnSum() {
        StringHelpers calculator = new StringHelpers();
        assertEquals(3, calculator.Add("//;\n1;2"));
    }
    @Test
    public void testAddNegativeNumbersShouldThrowException() {
        StringHelpers calculator = new StringHelpers();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> calculator.Add("1,-2,3,-4"));
        assertEquals("Negatives not allowed: -2, -4", exception.getMessage());
    }
    @Test
    public void testAddNumbersGreaterThan1000ShouldBeIgnored() {
        StringHelpers calculator = new StringHelpers();
        assertEquals(2, calculator.Add("2,1001"));
    }
    @Test
    public void testAddDelimitersOfAnyLengthShouldReturnSum() {
        StringHelpers calculator = new StringHelpers();
        assertEquals(6, calculator.Add("//[***]\n1***2***3"));
    }

}
