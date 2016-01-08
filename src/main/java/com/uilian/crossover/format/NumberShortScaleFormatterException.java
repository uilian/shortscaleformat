package com.uilian.crossover.format;

/**
 * @author uilian.
 */
public class NumberShortScaleFormatterException extends Exception {

    private static String errorMessage = "\nMax value exceeded (<= 1e+15).";

    public NumberShortScaleFormatterException() {
        super(errorMessage);
    }

    public NumberShortScaleFormatterException(String message) {
        super(message + errorMessage);
    }

}
