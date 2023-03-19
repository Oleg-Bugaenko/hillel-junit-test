package ua.hillel.mathlibrary;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ParseArrayTest {
    private static ParseArray parseArray;

    @BeforeAll
    public static void init() {
        parseArray = new ParseArray();
    }

    @Test
    public void findValueAndSplitArray() {
        {
            int[] source = {4,5,2,7,8,34};
            int[] expected = {5,2,7,8,34};
            int[] actual = parseArray.parse(source);
            Assertions.assertArrayEquals(expected, actual);
        }
        {
            int[] source = {30,5,2,7,8,4,8};
            int[] expected = {8};
            int[] actual = parseArray.parse(source);
            Assertions.assertArrayEquals(expected, actual);
        }
        {
            int[] source = {30,4,2,7,8,4,8,15};
            int[] expected = {8,15};
            int[] actual = parseArray.parse(source);
            Assertions.assertArrayEquals(expected, actual);
        }
    }

    @Test
    public void findValueRuntimeException() {
        int[] source = {5,2,7,8,34};
        Assertions.assertThrows(RuntimeException.class, () ->parseArray.parse(source));
    }


    @Test
    public void findValueIntoArray() {
        {
            int[] source = {2,5,8,1,0,10,4};
            Assertions.assertTrue(parseArray.findNumber(source));
        }
        {
            int[] source = {2,5,8,0,10,4};
            Assertions.assertFalse(parseArray.findNumber(source));
        }
        {
            int[] source = {2,5,8,1,10};
            Assertions.assertFalse(parseArray.findNumber(source));
        }
    }
}
