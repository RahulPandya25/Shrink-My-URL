package com.shrinkmyurl.Utils;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomStringUtil {

    public static String generateWithLength(int length, boolean useLetters, boolean useNumbers) {
        return RandomStringUtils.random(length, useLetters, useNumbers);
    }
}
