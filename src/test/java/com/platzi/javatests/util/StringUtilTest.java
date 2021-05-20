package com.platzi.javatests.util;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilTest {

    @Test
    public void testRepeatTresVeces() {
        Assert.assertEquals("Hola PaolaHola PaolaHola Paola", StringUtil.repeat("Hola Paola", 3));
    }

    @Test
    public void testRepeatUnaVez() {
        Assert.assertEquals("Hola Paola", StringUtil.repeat("Hola Paola", 1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRepeatNegativo() {
        Assert.assertEquals("Hola Paola", StringUtil.repeat("Hola Paola", -1));
    }

    @Test
    public void testStringNotEmpty() {
        Assert.assertFalse(StringUtil.isEmpty("Hola Paola"));
    }

    @Test
    public void testStringIsEmpty() {
        Assert.assertTrue(StringUtil.isEmpty(""));
    }

    @Test
    public void testNullStringEmpty() {
        Assert.assertTrue(StringUtil.isEmpty(null));
    }

    @Test
    public void testStringEmptyIsEmpty() {
        Assert.assertTrue(StringUtil.isEmpty(" "));
    }

}

