package com.github.spb.tget.uitests.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Collection;
import java.util.Random;

public class RandomUtils {

    private static long TICKS_AT_EPOCH = 621355968000000000L;

    private static Random random = new Random(System.currentTimeMillis() * 10000 + TICKS_AT_EPOCH);

    public static Boolean getRandomBoolean() {
        return random.nextBoolean();
    }

    public static Integer getRandomInteger() {
        return random.nextInt();
    }

    public static String getRandomString(int charactersCount) {
        return RandomStringUtils.randomAlphanumeric(charactersCount);
    }

    public static Object getRandomElement(Collection collection) {
        int i = random.nextInt(collection.size());
        return collection.toArray()[i];
    }
}
