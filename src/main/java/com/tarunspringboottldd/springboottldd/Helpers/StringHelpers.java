package com.tarunspringboottldd.springboottldd.Helpers;

import com.tarunspringboottldd.springboottldd.Constants.MessageConstants;

public class StringHelpers {
    public void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(MessageConstants.EMPTY_NAME_ERROR);
        }
    }
    public int Add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        String[] parts = numbers.split("[,\n]");
        int sum = 0;
        for (String part : parts) {
            sum += Integer.parseInt(part);
        }
        return sum;
    }

}
