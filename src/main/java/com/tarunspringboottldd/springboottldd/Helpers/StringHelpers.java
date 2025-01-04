package com.tarunspringboottldd.springboottldd.Helpers;

import com.tarunspringboottldd.springboottldd.Constants.MessageConstants;

public class StringHelpers {
    public void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(MessageConstants.EMPTY_NAME_ERROR);
        }
    }
}
