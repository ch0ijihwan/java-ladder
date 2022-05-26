package model.util;

import java.util.Random;

public class RandomUtil {

    private static final Random random = new Random();

    public static boolean value() {
        return random.nextBoolean();
    }

    private RandomUtil() {
    }
}
