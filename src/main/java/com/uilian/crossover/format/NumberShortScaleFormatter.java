package com.uilian.crossover.format;

/**
 * Number formatter that converts numeric types and returns
 * a truncated "prettified" string using short scale
 * numbers.
 *
 * @author uilian.
 *
 * @see "https://en.wikipedia.org/wiki/Long_and_short_scales"
 */
public class NumberShortScaleFormatter {

    /**
     * This method returns a prettified version of numbers greater than 6 digits and support millions, billions
     * and trillions.
     *
     * @param input  The number to be formatted.
     * @return
     *        If the number is equal or greater than 1E+6, a string short scale formatted string
     *        representing the number.
     *        If the number is equal or bigger than 1E+15, it will return an exception.
     *        Otherwise a string representation of the number itself will be returned.
     *
     * @throws NumberShortScaleFormatterException
     *
     */
    public static String format(Number input) throws NumberShortScaleFormatterException{
        String result;
        int magnitude = getMagnitude(input.longValue());

        switch (magnitude){
            case 1 : //
                result = "" + input;
                break;
            case 2 :
                result = normalize(input.doubleValue(), 1E+6);
                break;
            case 3 :
                result = normalize(input.doubleValue(), 1E+9);
                break;
            case 4 :
                result = normalize(input.doubleValue(), 1E+12);
                break;
            default:
                throw new NumberShortScaleFormatterException();
        }

        result += getSuffix(magnitude);

        return result;
    }

    /**
     * Utility method to find out the magnitude in terms of
     * multiples of 1000.
     *
     * @param val
     *      Number to be formatted.
     *
     * @return  An int containing how many times
     *          val can be divided by 1000.
     */
    private static Integer getMagnitude(long val){
        String strVal = String.valueOf(val);
        int magnitude = (strVal.length()-1)/3;
        return magnitude;
    }


    /**
     * Based on how many times a number was multiplied by 1000,
     * returns the corresponding suffix.
     *
     * @param index
     *          Index to discover suffix, represents
     *          how many times a number can be divided
     *          by 1000.
     * @return
     *          Corresponding suffix.
     */
    private static String getSuffix(int index){
        String result;
        switch (index){
            case 2 : // million
                result = "M";
                break;
            case 3 : // billion
                result = "B";
                break;
            case 4 : // trillion
                result = "T";
                break;
            default: // anything else
                result = "";
        }
        return result;
    }


    /**
     *  Transforms number to string following this rule:
     *      - if second digit is different from zero,
     *        returns the first digit plus '.' plus the second digit.
     *      - otherwise, just the first digit.
     *
     * @param val
     *         Number to be converted.
     * @param divisor
     *         Number from the same order of 'val',
     *         used to normalize 'val'.
     * @return
     */
    private static String normalize(double val, double divisor){
        double res = val/(divisor!=0?divisor:1);
        String result = String.format("%.1f",res);
        if (res > 0)
            result = (result.charAt(2) == '0')?result.substring(0,1):result;
        else
            result = (result.charAt(3) == '0')?result.substring(0,2):result;
        result = result.replace(',','.');
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

