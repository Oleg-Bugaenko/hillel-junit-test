package ua.hillel.mathlibrary;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import ua.hillel.mathlibrary.SimpleMathLibrary;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SimpleMathLibraryTest {
    private static SimpleMathLibrary mathLibrary;

    @BeforeAll
    public static void init() {
        mathLibrary = new SimpleMathLibrary();
    }


    @Test
    public void addTest() {
        double expected = 3;
        double actual = mathLibrary.add(1, 2);
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void minusTest() {
        double expected = 12;
        double actual = mathLibrary.minus(2, -10);
        Assertions.assertEquals(actual, expected);
    }


}
