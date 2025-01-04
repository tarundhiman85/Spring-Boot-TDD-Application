package com.tarunspringboottldd.springboottldd.Helpers;

import com.tarunspringboottldd.springboottldd.Constants.MessageConstants;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
            String message = String.format(
                    MessageConstants.NEGATIVES_NOT_ALLOWED_FORMAT,
                    String.join(", ", negatives)
            );
            throw new IllegalArgumentException(message);
        }

        return Arrays.stream(parts)
                .mapToInt(Integer::parseInt)
                .filter(num -> num <= 1000)
                .sum();
    }


    private String extractDelimiter(String numbers) {
        if (numbers.startsWith("//[")) {
            int delimiterEnd = numbers.indexOf("]\n");
            String delimiterSection = numbers.substring(2, delimiterEnd + 1); // Extract everything inside `//[...]`

            // Split multiple delimiters and escape them using Pattern.quote
            String[] delimiters = delimiterSection.split("]\\[");
            return Arrays.stream(delimiters)
                    .map(delimiter -> delimiter.replace("[", "").replace("]", "")) // Remove enclosing brackets
                    .map(Pattern::quote) // Escape special regex characters
                    .collect(Collectors.joining("|")); // Combine with OR (`|`)
        } else if (numbers.startsWith("//")) {
            int delimiterIndex = numbers.indexOf("\n");
            String rawDelimiter = numbers.substring(2, delimiterIndex);
            return Pattern.quote(rawDelimiter); // Single delimiter case
        }
        return "[,\n]"; // Default delimiters: comma and newline
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
