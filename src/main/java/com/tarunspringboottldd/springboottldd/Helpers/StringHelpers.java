package com.tarunspringboottldd.springboottldd.Helpers;

import com.tarunspringboottldd.springboottldd.Constants.MessageConstants;
import java.util.*;

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

        String delimiter = extractDelimiter(numbers);
        if (numbers.startsWith("//")) {
            numbers = numbers.substring(numbers.indexOf("\n") + 1);
        }

        String[] parts = numbers.split(delimiter);
        List<String> negatives = findNegatives(parts);
        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed: " + String.join(", ", negatives));
        }

        return Arrays.stream(parts)
                .mapToInt(Integer::parseInt)
                .filter(num -> num <= 1000)
                .sum();
    }


    private String extractDelimiter(String numbers) {
        if (numbers.startsWith("//")) {
            int delimiterIndex = numbers.indexOf("\n");
            return numbers.substring(2, delimiterIndex);
        }
        return "[,\n]";
    }

    private List<String> findNegatives(String[] parts) {
        List<String> negatives = new ArrayList<>();
        for (String part : parts) {
            int num = Integer.parseInt(part);
            if (num < 0) {
                negatives.add(part);
            }
        }
        return negatives;
    }


}
