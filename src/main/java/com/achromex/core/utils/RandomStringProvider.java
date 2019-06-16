package com.achromex.core.utils;

import org.apache.commons.text.RandomStringGenerator;

import static org.apache.commons.text.CharacterPredicates.DIGITS;
import static org.apache.commons.text.CharacterPredicates.LETTERS;

public class RandomStringProvider {

    private RandomStringGenerator alphaNumericGenerator = new RandomStringGenerator.Builder()
        .withinRange('0', 'z')
        .filteredBy(LETTERS, DIGITS)
        .build();

    private RandomStringGenerator numericGenerator = new RandomStringGenerator.Builder()
        .withinRange('0', '9')
        .filteredBy(DIGITS)
        .build();

    public String getRandomNumeric(int length) {
        return this.numericGenerator.generate(length);
    }

    public String getRandomAlphaNumeric(int length) {
        return alphaNumericGenerator.generate(length);
    }
}
