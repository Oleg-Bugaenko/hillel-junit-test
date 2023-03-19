package ua.hillel.mathlibrary;

import java.util.Arrays;

public class ParseArray {

    public int[] parse(int[] source) throws RuntimeException {
        int index = -1;
        for (int i = source.length - 1; i >= 0; i--) {
            if (source[i] == 4) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            throw new RuntimeException();
        }
        return Arrays.copyOfRange(source, index + 1, source.length);
    }

    public boolean findNumber(int[] source) {
        boolean num1 = false;
        boolean num4 = false;
        for (int i = 0; i < source.length; i++) {
            if (source[i] == 1) num1 = true;
            if (source[i] == 4) num4 = true;
            if (num1 && num4) return true;
        }
        return false;
    }
}
