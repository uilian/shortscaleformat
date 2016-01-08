package com.uilian.crossover.format;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test suite for NumberShortScaleFormatter.
 *
 *
 * Each test was planned to cover a determined magnitude
 * for both positive and negative case.
 *
 * @author uilian.
 *
 * @see com.uilian.crossover.format.NumberShortScaleFormatter
 *
 */
public class NumberShortScaleFormatterTest {

    Integer valUnderMillion, valMillion, valAboveMillion, valBillion, valAboveBillion;
    Double valTrillion, valAboveTrillion, valGreaterThanTrillion;

    @Before
    public void prepareValues(){
        valUnderMillion = 1000;
        valMillion = 1000_000;
        valAboveMillion = 1500_000;
        valBillion = 1000_000_000;
        valAboveBillion = 1500_000_000;
        valTrillion = 1000_000_000_000.0;
        valAboveTrillion = 1500_000_000_000.0;
        valGreaterThanTrillion = 1000_000_000_000_000.0;
    }


    /**
     * Test for values under one million, both positive and negative.
     * @throws Exception
     */
    @Test
    public void testFormatUnderMillion() throws Exception {
        assertEquals(NumberShortScaleFormatter.format(valUnderMillion), "1000");
        assertEquals(NumberShortScaleFormatter.format(-valUnderMillion), "-1000");
    }


    /**
     * Test for values in millions, without hundreds of thousands,
     * both positive and negative.
     *
     * @throws Exception
     */
    @Test
    public void testFormatMillion() throws Exception {
        assertEquals(NumberShortScaleFormatter.format(valMillion),"1M");
        assertEquals(NumberShortScaleFormatter.format(-valMillion),"-1M");
    }

    /**
     * Test for values in millions, with hundreds of thousands,
     * both positive and negative.
     *
     * @throws Exception
     */
    @Test
    public void testFormatMillionAndHalf() throws Exception {
        assertEquals(NumberShortScaleFormatter.format(valAboveMillion),"1.5M");
        assertEquals(NumberShortScaleFormatter.format(-valAboveMillion),"-1.5M");
    }


    /**
     * Test for values in billions, without hundreds of millions,
     * both positive and negative.
     *
     * @throws Exception
     */
    @Test
    public void testFormatBillion() throws Exception {
        assertEquals(NumberShortScaleFormatter.format(valBillion),"1B");
        assertEquals(NumberShortScaleFormatter.format(-valBillion),"-1B");
    }


    /**
     * Test for values in billions, with hundreds of millions,
     * both positive and negative.
     *
     * @throws Exception
     */
    @Test
    public void testFormatBillionAndHalf() throws Exception {
        assertEquals(NumberShortScaleFormatter.format(valAboveBillion),"1.5B");
        assertEquals(NumberShortScaleFormatter.format(-valAboveBillion),"-1.5B");
    }


    /**
     * Test for values in trillions, without hundreds of billions,
     * both positive and negative.
     *
     * @throws Exception
     */
    @Test
    public void testFormatTrillion() throws Exception {
        assertEquals(NumberShortScaleFormatter.format(valTrillion),"1T");
        assertEquals(NumberShortScaleFormatter.format(-valTrillion),"-1T");
    }


    /**
     * Test for values in trillions, with hundreds of billions,
     * both positive and negative.
     *
     * @throws Exception
     */
    @Test
    public void testFormatTrillionAndHalf() throws Exception {
        assertEquals(NumberShortScaleFormatter.format(valAboveTrillion),"1.5T");
        assertEquals(NumberShortScaleFormatter.format(-valAboveTrillion),"-1.5T");
    }


    /**
     * Test for values greater than trillions, both positive and negative.
     *
     * @throws Exception
     */
    @Test(expected=NumberShortScaleFormatterException.class)
    public void testFormatGreaterThanTrillion() throws Exception {
        NumberShortScaleFormatter.format(valGreaterThanTrillion);
        NumberShortScaleFormatter.format(-valGreaterThanTrillion);
    }
}